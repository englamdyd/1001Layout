package com.example.a503_16.a1001layout;

import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SoundVibTest extends AppCompatActivity {
    Button btnvibrate, btnsystemsound, btnusersound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_vib_test);

        //버튼 찾아오기
        btnvibrate = (Button)findViewById(R.id.btnvibrate);
        btnsystemsound = (Button)findViewById(R.id.btnsystemsound);
        btnusersound = (Button)findViewById(R.id.btnusersound);

        btnvibrate.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                //진동 만들기 - 1초 동안 진동
                Vibrator vib = (Vibrator)getSystemService(VIBRATOR_SERVICE);
                vib.vibrate(3000);
            }
        });

        btnsystemsound.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                Uri systemsound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                Ringtone ringtone = RingtoneManager.getRingtone(getApplicationContext(), systemsound);
                ringtone.play();
            }
        });

        btnusersound.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                MediaPlayer player = MediaPlayer.create(SoundVibTest.this, R.raw.mamamoo);
                player.start();
            }
        });

    }
}
