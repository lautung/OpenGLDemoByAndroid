cmake_minimum_required(VERSION 3.4.1)
##官方标准配置
set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -Wall")
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11 -fno-rtti -fno-exceptions -Wall")

add_library(
        opengl
        SHARED
        native-lib.cpp
        color.h)

target_link_libraries(
        opengl
        GLESv3
        android
        EGL
        jnigraphics
        m
        # GLESv3 native层也可以用 OpenGL，因为核心都是C层
        log)