package ro.pub.cs.systems.eim.practicaltest01var03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PracticalTest01Var03MainActivity extends AppCompatActivity {

    Button plus;
    Button minus;
    Button nextActivity;
    EditText sus;
    EditText jos;
    TextView rezultat;

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
    }
}