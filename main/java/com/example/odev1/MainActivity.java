package com.example.odev1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public Button btnGonder;
    public EditText etEmail;
    public  EditText etSifre;
    public  TextView uyari;
    String iletim,iletim2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnGonder=findViewById(R.id.btnGiris);
        etEmail=findViewById(R.id.etEmail);
        etSifre=findViewById(R.id.etSifre);
        uyari=findViewById(R.id.tvUyeOl);

        btnGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                iletim=etEmail.getText().toString().trim();//email
                iletim2=etSifre.getText().toString().trim();//şifre
                boolean durum;

                Intent gonder= new Intent(MainActivity.this,MainActivity2.class);

                gonder.putExtra("email",iletim);
                gonder.putExtra("password",iletim2);
                if(iletim.equals("admin@bilgi.edu.tr") && iletim2.equals("1234")){
                    durum=true;
                    gonder.putExtra("durum",durum);
                    startActivity(gonder);

                }
                else
                {   durum=false;
                    gonder.putExtra("durum",durum);
                    startActivity(gonder);

                }
            }
        });

        uyari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast=Toast.makeText(getApplicationContext(),"Yapım Aşamasında",Toast.LENGTH_LONG);
                toast.show();
            }
        });

    }
}