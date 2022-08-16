package com.opensource.opengl;

import android.Manifest;
import android.content.pm.PackageManager;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class CameraSurfaceActivity extends AppCompatActivity {
   private static final int PERMISSION_CODE = 100;
   private GLSurfaceView mGLSurfaceView;

   @Override
   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      applyPermission();
   }

   private void applyPermission() {
      if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
         ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, PERMISSION_CODE);
      } else {
         setupView();
      }
   }

   private void setupView() {
      //实例化一个GLSurfaceView
      mGLSurfaceView = new GLSurfaceView(this);
      mGLSurfaceView.setEGLContextClientVersion(3);
      mGLSurfaceView.setRenderer(new CameraSurfaceRenderer(mGLSurfaceView));
      setContentView(mGLSurfaceView);
   }

   @Override
   public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
      super.onRequestPermissionsResult(requestCode, permissions, grantResults);
      if (requestCode == PERMISSION_CODE && grantResults != null && grantResults.length > 0) {
         if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            setupView();
         }
      }
   }
}
