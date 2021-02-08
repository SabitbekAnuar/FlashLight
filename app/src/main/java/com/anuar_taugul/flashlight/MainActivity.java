package com.anuar_taugul.flashlight;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView iv;
    private FlashClass flashClass;
    protected Button button_flash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init() {
        iv = findViewById(R.id.iv);
        button_flash = findViewById(R.id.button);
        flashClass = new FlashClass(this);

    }

    public void onClickFlash(View view) {
        if (flashClass.isFlash_status()) {
            flashClass.flashOff();
            button_flash.setText(R.string.textOn);
            button_flash.setTextColor(Color.WHITE);
            iv.setBackgroundResource(R.drawable.circle_white);
        }
        else {
            flashClass.flashOn();
            button_flash.setText(R.string.textOff);
            iv.setBackgroundResource(R.drawable.circle_red);
            button_flash.setTextColor(Color.RED);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (flashClass.isFlash_status()) {
            flashClass.flashOff();
        }
    }

}