package com.example.a503_16.a1001layout;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ToastView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_view);

        Button btntoast = (Button)findViewById(R.id.btntoast);
        btntoast.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(ToastView.this, "안녕하세요 토스트 입니다.", Toast.LENGTH_LONG).show();
            }
        });

        Button btnbasicalert = (Button)findViewById(R.id.btnbasicalert);
        btnbasicalert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //메소드 체이닝을 이용한 생성과 출력
                new AlertDialog.Builder(ToastView.this)
                        .setMessage("기본 대화상자")
                        .setTitle("대화상자")
                        .setIcon(R.drawable.clock)
                        .setPositiveButton("긍정", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int whitch) {
                                Toast.makeText(ToastView.this,"긍정을 눌렀습니다.", Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("부정", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int whitch) {
                                Toast.makeText(ToastView.this,"부정을 눌렀습니다.", Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNeutralButton("중립", null)
                        .setCancelable(false)
                        .show();
            }
        });

        Button btnasync = (Button)findViewById(R.id.btnasync);
        btnasync.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //대화상자 출력
                new AlertDialog.Builder(ToastView.this)
                        .setMessage("액티비티 종료")
                        .setTitle("대화상자")
                        .setIcon(R.drawable.clock)
                        .setPositiveButton("프로그램 종료", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int whitch) {
                                finish();
                            }
                        })
                        .show();

                //토스트 출력
                Toast.makeText(ToastView.this, "토스트 출력.", Toast.LENGTH_LONG).show();


            }
        });


    }
}
