package com.mic.xsample.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mic.xsample.R;

public class HandleActivity extends AppCompatActivity {


    private  Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mTextView.setText("222");
        }
    };

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle);

        mTextView = findViewById(R.id.text);

        new Thread(new Runnable() {
            @Override
            public void run() {

                Message message = new Message();
                handler.sendMessage(message);
            }
        });
    }
}
