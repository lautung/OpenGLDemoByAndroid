package com.opensource.opengl;

import android.graphics.Color;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/***
 * 演示基本的opengl的 NDK的版本 在ndk层面 展示
 */
public class ColorActivity extends AppCompatActivity implements GLSurfaceView.Renderer{
    private GLSurfaceView mGLSurfaceView;
    NativeTools nativeTools;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nativeTools = new NativeTools();
        mGLSurfaceView = new GLSurfaceView(this);
        setContentView(mGLSurfaceView);
        //设置版本
        mGLSurfaceView.setEGLContextClientVersion(3);;
        mGLSurfaceView.setRenderer(this);
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        nativeTools.surfaceCreated(Color.BLUE);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        nativeTools.surfaceChanged(width,height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        nativeTools.onDrawFrame();
    }
}
