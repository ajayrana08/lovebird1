package com.dap.lovebirds.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import com.dap.lovebirds.R;

public class ImageViewActivity extends AppCompatActivity {

    private ImageView ivGetImage;

    String uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        ivGetImage = findViewById(R.id.iv_image);

        if (getIntent() != null) {
            uri = getIntent().getStringExtra("getimage");
        }


        ivGetImage.setImageDrawable(Drawable.createFromPath(uri));

    }
}
