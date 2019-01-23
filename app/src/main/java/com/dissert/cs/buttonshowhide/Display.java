package com.dissert.cs.buttonshowhide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        VideoView mVideoView;

        mVideoView = findViewById(R.id.videoView);

        Intent intent = getIntent();

        String videoPath = intent.getStringExtra("videoPath");
        Uri uri = Uri.parse(videoPath);
        mVideoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        mVideoView.setMediaController(mediaController);
        mediaController.setAnchorView(mVideoView);
    }
}
