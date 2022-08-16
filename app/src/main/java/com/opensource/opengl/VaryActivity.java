package com.opensource.opengl;

import android.opengl.GLSurfaceView;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class VaryActivity extends AppCompatActivity {

    GLSurfaceView mGLSurfaceView;
    private VaryRenderer mFilterRenderer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_filter);
        mGLSurfaceView = findViewById(R.id.glsurfaceview);

        mGLSurfaceView.setEGLContextClientVersion(2);
        setSimpleRender();
    }




    private void setSimpleRender() {
        //图片
        mFilterRenderer = new VaryRenderer();
        mGLSurfaceView.setRenderer(mFilterRenderer);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFilterRenderer.onDestroy();
    }
}
