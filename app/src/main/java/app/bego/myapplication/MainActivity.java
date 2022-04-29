package app.bego.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button Btn3;
    private TextView txt;
    private Switch btns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Btn3 = findViewById(R.id.btn3);
        txt = findViewById(R.id.estadotxt);
        btns = findViewById(R.id.switch1);

        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iThird = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(iThird);
            }
        });
    }

    public void onclick(View view) {
        if (view.getId() == R.id.switch1) {
            if (btns.isChecked()) {
                txt.setText("Estado: Encendiste el botón :D");
            } else {
                txt.setText("Estado: Apagaste el botón :C");
            }

        }
    }
}