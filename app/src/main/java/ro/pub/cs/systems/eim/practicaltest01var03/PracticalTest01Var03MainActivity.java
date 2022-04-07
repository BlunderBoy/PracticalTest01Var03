package ro.pub.cs.systems.eim.practicaltest01var03;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var03MainActivity extends AppCompatActivity {

    Button plus;
    Button minus;
    Button nextActivity;
    EditText sus;
    EditText jos;
    TextView rezultat;
    BroadcastReciever broadcastReciever;
    IntentFilter intentFilter;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_main);

        plus = findViewById(R.id.button2);
        minus = findViewById(R.id.button);
        nextActivity = findViewById(R.id.button3);
        sus = findViewById(R.id.editTextTextPersonName);
        jos = findViewById(R.id.editTextTextPersonName2);
        rezultat = findViewById(R.id.textView2);

        plus.setOnClickListener(l -> {
            if(sus.getText().equals("") || jos.getText().equals("")){
                Toast.makeText(this, "No value in field", Toast.LENGTH_LONG).show();
            } else {
                String string1 = String.valueOf(sus.getText());
                String string2 = String.valueOf(jos.getText());
                int termen1 = Integer.parseInt(string1);
                int termen2 = Integer.parseInt(string2);
                rezultat.setText(string1 + " + " + string2 + " = " + (termen1+termen2));
            }
            Intent service = new Intent(this, PracticalTest01Var03Service.class);
            service.putExtra("unu", Integer.parseInt(String.valueOf(sus.getText())));
            service.putExtra("doi", Integer.parseInt(String.valueOf(jos.getText())));
            startService(service);
        });

        minus.setOnClickListener(l -> {
            if(sus.getText().equals("") || jos.getText().equals("")){
                Toast.makeText(this, "No value in field", Toast.LENGTH_LONG).show();
            } else {
                String string1 = String.valueOf(sus.getText());
                String string2 = String.valueOf(jos.getText());
                int termen1 = Integer.parseInt(string1);
                int termen2 = Integer.parseInt(string2);
                rezultat.setText(string1 + " - " + string2 + " = " + (termen1-termen2));
            }

            Intent service = new Intent(this, PracticalTest01Var03Service.class);
            service.putExtra("unu", Integer.parseInt(String.valueOf(sus.getText())));
            service.putExtra("doi", Integer.parseInt(String.valueOf(jos.getText())));
            startService(service);
        });

        nextActivity.setOnClickListener(l -> {
            Intent intent = new Intent(this, PracticalTest01Var03SecondaryActivity.class);
            intent.putExtra("rez", rezultat.getText());
            startActivityForResult(intent, 8080);
        });

        intentFilter = new IntentFilter();
        intentFilter.addAction("adunare");
        intentFilter.addAction("scadere");

        broadcastReciever = new BroadcastReciever();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("sus", String.valueOf(sus.getText()));
        outState.putString("jos", String.valueOf(jos.getText()));
        outState.putString("rezultat", (String) rezultat.getText());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        String toast = "";
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState.containsKey("sus")){
            sus.setText(savedInstanceState.getString("sus"));
            toast += "sus";
        }
        if(savedInstanceState.containsKey("jos")){
            jos.setText(savedInstanceState.getString("jos"));
            toast += " jos";
        }
        if(savedInstanceState.containsKey("rezultat")){
            rezultat.setText(savedInstanceState.getString("rezultat"));
            toast += " rezultat";
        }
        Toast.makeText(this, "Restuarat " + toast, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 8080) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "CORECT!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "INCORECT!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        Intent service = new Intent(this, PracticalTest01Var03Service.class);
        stopService(service);
        super.onDestroy();
    }

    @Override
    protected void onPause() {

        unregisterReceiver(broadcastReciever);
        super.onPause();
    }

    @Override
    protected void onResume() {
        registerReceiver(broadcastReciever, intentFilter);
        super.onResume();
    }
}