package com.opensource.opengl;

import android.content.Context;
import android.graphics.Bitmap;

public class GrayFilter extends BaseFilter {

    public GrayFilter(Context context, Bitmap bitmap) {
        super(context, bitmap);
    }

    @Override
    protected ShaderManager.Param getProgram(){
        return ShaderManager.getParam(ShaderManager.GRAY_SHADER);
    }
}

