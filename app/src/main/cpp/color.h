//
// Created by Jesson on 2022/6/29.
//

#ifndef OPENGLDEMO_COLOR_H
#define OPENGLDEMO_COLOR_H

#ifdef __cplusplus
extern "C" {
#endif

JNIEXPORT void JNICALL surfaceCreated(JNIEnv *, jobject, jint);

JNIEXPORT void JNICALL surfaceChanged(JNIEnv *, jobject, jint, jint);

JNIEXPORT void JNICALL onDrawFrame(JNIEnv *, jobject);

JNIEXPORT void JNICALL drawColor(JNIEnv *, jobject, jobject, jint);

JNIEXPORT void JNICALL drawBitmap(JNIEnv *, jobject, jobject, jobject);

#ifdef __cplusplus
}
#endif



#endif //OPENGLDEMO_COLOR_H
