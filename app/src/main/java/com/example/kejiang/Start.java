package com.example.kejiang;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Start extends AppCompatActivity {

    VideoView myVideo;
    private MediaController media_control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        myVideo = (VideoView) findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
        media_control = new MediaController(this);
        myVideo.setMediaController(media_control);
        myVideo.setVideoURI(uri);
        myVideo.start();
        Button button = (Button) findViewById(R.id.next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Start.this, dosth.class);
                startActivity(intent);
            }
        });
    }
}
