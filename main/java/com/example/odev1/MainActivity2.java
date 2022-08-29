package com.example.odev1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    TextView mesaj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mesaj=findViewById(R.id.tvMesaj);

        ImageView iv =findViewById(R.id.imageView2);
        iv.getLayoutParams().height=345;
        iv.getLayoutParams().width=345;


        Intent al=getIntent();

        String gelenMail=al.getStringExtra("email");
        String gelenSifre=al.getStringExtra("password");
        boolean durum=al.getBooleanExtra("durum",false);

        if(durum)
        {
            iv.setImageResource(R.drawable.basarili);
            mesaj.setText("Giriş Başarılı.");
        }
        else
        {

            iv.setImageResource(R.drawable.basarisiz);
            mesaj.setText("Giriş Başarısız. Lütfen tekrar deneyin.");
            Handler handler =new Handler();
            Intent don= new Intent(MainActivity2.this,MainActivity.class);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(don);
                }
            },3000);

        }

    }
}