//冷色滤镜
precision mediump float;
varying vec2 vTextureCoord;
uniform sampler2D vTexture;
void main() {
    vec4 nColor = texture2D(vTexture, vTextureCoord);//进行纹理采样,拿到当前颜色
    vec4 deltaColor=nColor + vec4(0.0, 0.0, 0.3, 0.0); //冷就是多加点蓝
    gl_FragColor=deltaColor;
}