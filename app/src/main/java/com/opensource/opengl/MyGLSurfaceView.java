package com.opensource.opengl;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

import com.opensource.opengl.MyGlRenderer;

// 相当于 自定义控件而已，只不过此自定义控件要显示，Camera预览的画面（OpenGL的处理）
public class MyGLSurfaceView extends GLSurfaceView {

    // 假设你是 MyGLSurfaceView extends SurfaceView { 你需要自定义EGL，这个相当复杂

    // 布局一定会调用 两个参数的构造函数
    public MyGLSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    private void init() {

        // TODO 一：设置EGL版本
        // 2 代表是 OpenGLES 2.0
        setEGLContextClientVersion(2);

        // TODO 二：设置渲染器（工作原理 下面稍微说到了）
        // 注意：
        // EGL 开启一个 GLThread.start  run { Renderer.onSurfaceCreated ...onSurfaceChanged  onDrawFrame }
        // 如果这三个函数，不让GLThread调用，会崩溃，所以他内部的设计，必须通过GLThread调用来调用三个函数
        setRenderer(new MyGlRenderer(this)); // this 自定义渲染器 会回调回来做处理，所有传递this

        // TODO 三：设置渲染器模式
        // RENDERMODE_WHEN_DIRTY 按需渲染，有帧数据的时候，才会去渲染（ 效率高，麻烦，后面需要手动调用一次才行）
        // RENDERMODE_CONTINUOUSLY 每隔16毫秒，读取更新一次，（如果没有显示上一帧）
        setRenderMode(RENDERMODE_WHEN_DIRTY); // 手动模式 - 效率高，麻烦，后面需要手动调用一次才行
    }
}
