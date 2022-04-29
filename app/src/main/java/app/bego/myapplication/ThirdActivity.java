package app.bego.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {
    private Button BtnSocial, BtnCorreo, BtnCam, BtnCall;
    private EditText Txtemail, Txtsocial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        //Botones
        BtnSocial = findViewById(R.id.socialbtn);
        BtnCorreo = findViewById(R.id.emailbtn);
        BtnCam = findViewById(R.id.cambtn);
        BtnCall = findViewById(R.id.callbtn);
        //Edit Text
        Txtemail = findViewById(R.id.emailtxt);
        Txtsocial = findViewById(R.id.socialtxt);

        BtnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iLlamada = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 911"));
                startActivity(iLlamada);
            }
        });

        BtnCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iCam = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(iCam);
            }
        });

        BtnSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = Txtsocial.getText().toString();
                if (url != null && !url.isEmpty()) {
                    Intent intentWeb = new Intent();
                    intentWeb.setAction(Intent.ACTION_VIEW);
                    intentWeb.setData(Uri.parse("http://" + url));
                    startActivity(intentWeb);
                }
            }
        });

        BtnCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = Txtemail.getText().toString();
                Intent iCorreoCompleto = new Intent(Intent.ACTION_SEND, Uri.parse("mailto: " + email));
                iCorreoCompleto.setType("plain/text");
                iCorreoCompleto.putExtra(Intent.EXTRA_SUBJECT, "Evaluación");
                iCorreoCompleto.putExtra(Intent.EXTRA_TEXT, "Comprobación de que la app funciona correctamente.");
                iCorreoCompleto.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
                startActivity(Intent.createChooser(iCorreoCompleto, "Elige cliente de correo"));
            }
        });
    }
}