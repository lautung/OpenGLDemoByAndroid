package com.opensource.opengl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class NativeWindowActivity extends AppCompatActivity{



    /**
     * 根容器
     */
    private ViewGroup mRootLayer;

    private Button mBtnColor, mBtnBitmap;

    private SurfaceView mSurfaceView;

    NativeTools nativeTools;

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        Log.i("tag","onPostCreate");
        // TODO: 2022/6/29 为啥不掉用？？
//        nativeTools = new NativeTools();
//        mRootLayer = (ViewGroup) findViewById(R.id.root_layer);
//        mBtnColor = (Button) findViewById(R.id.btn_draw_color);
//        mBtnBitmap = (Button) findViewById(R.id.btn_draw_bitmap);
//        mSurfaceView = new SurfaceView(this);
//        mRootLayer.addView(mSurfaceView);
//        mSurfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
//            @Override
//            public void surfaceCreated(SurfaceHolder holder) {
//                Log.i("tag","surfaceCreated");
//                mBtnColor.setEnabled(true);
//                mBtnBitmap.setEnabled(true);
//            }
//
//            @Override
//            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
//
//            }
//
//            @Override
//            public void surfaceDestroyed(SurfaceHolder holder) {
//
//            }
//        });
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nativewindow_activity);
        Log.i("tag","onCreate");
        nativeTools = new NativeTools();
        mRootLayer = (ViewGroup) findViewById(R.id.root_layer);
        mBtnColor = (Button) findViewById(R.id.btn_draw_color);
        mBtnBitmap = (Button) findViewById(R.id.btn_draw_bitmap);
        mSurfaceView = new SurfaceView(this);
        mRootLayer.addView(mSurfaceView);
        mSurfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                Log.i("tag","surfaceCreated");
                mBtnColor.setEnabled(true);
                mBtnBitmap.setEnabled(true);
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
    }

    public void onDrawColorClick(View view) {
        nativeTools.drawColor(mSurfaceView.getHolder().getSurface(), Color.RED);
    }

    public void onDrawBitmapClick(View view) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.main, options);
        nativeTools.drawBitmap(mSurfaceView.getHolder().getSurface(), bitmap);
    }

}
