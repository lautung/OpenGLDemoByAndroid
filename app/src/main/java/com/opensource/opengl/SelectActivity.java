package com.opensource.opengl;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.io.IOException;

public class SelectActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "SelectActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        findViewById(R.id.btn_filter).setOnClickListener(this);
        findViewById(R.id.btn_vary).setOnClickListener(this);
        findViewById(R.id.btn_camera).setOnClickListener(this);
        findViewById(R.id.btn_camera_demo).setOnClickListener(this);
        try {
            Bitmap bitmap = BitmapFactory.decodeStream(getResources().getAssets().open("picture.png"));
            ((ImageView)findViewById(R.id.iv_01)).setImageBitmap(bitmap);
        } catch (IOException e) {
            Log.e(TAG, "onCreate: " + e.getMessage());
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_filter:
                startActivity(new Intent(SelectActivity.this,ImageFilterActivity.class));
                break;
            case R.id.btn_vary:
                startActivity(new Intent(SelectActivity.this,VaryActivity.class));
                break;
        }
    }
}
