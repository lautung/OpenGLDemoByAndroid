package com.opensource.opengl;

public class NativeTools {
    static {
        System.loadLibrary("opengl");
    }

    /**
     * 绘制指定颜色背景
     *
     * @param surface
     * @param color
     */
    public native void drawColor(Object surface, int color);

    /**
     * 绘制指定颜色背景
     *
     * @param surface
     * @param bitmap
     */
    public native void drawBitmap(Object surface, Object bitmap);

    public native void surfaceCreated(int color);

    public native void surfaceChanged(int width, int height);

    public native void onDrawFrame();

}
