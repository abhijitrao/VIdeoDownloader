package com.vedio.snaptubsoupratooz.whatsapp_feature;

import android.app.Activity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.vedio.snaptubsoupratooz.R;


public class WhatsappStatusView extends Activity {

    String path;
    VideoView vv_video;
    String format;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whatsapp_video_view);
        vv_video = findViewById(R.id.vv_video);
        initializeAd();
        init();
    }

    private void initializeAd() {
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    private void init() {
        format = getIntent().getStringExtra("format");
        path = getIntent().getStringExtra("path");
        if (format.equals(".mp4")) {
            vv_video.setVideoPath(path);
            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(vv_video);
            vv_video.setMediaController(mediaController);
            vv_video.start();
        }

    }
}
