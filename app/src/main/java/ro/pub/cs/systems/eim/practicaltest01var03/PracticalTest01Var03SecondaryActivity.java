package ro.pub.cs.systems.eim.practicaltest01var03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var03SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_secondary);

        Button correct = findViewById(R.id.button4);
        Button incorect = findViewById(R.id.button5);
        TextView tv = findViewById(R.id.textView);

        Intent intent = getIntent();
        if (intent.hasExtra("rez")) {
            tv.setText(intent.getStringExtra("rez"));
        }

        correct.setOnClickListener(l -> {
            setResult(RESULT_OK);
            finish();
        });

        incorect.setOnClickListener(l -> {
            setResult(RESULT_CANCELED);
            finish();
        });
    }
}