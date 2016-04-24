package shubhamagarwal1.com.opengl_retry;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


public class MyOpenGLRenderer_Cube implements GLSurfaceView.Renderer
{
    private Cube cube;
    private static float anglerotCube = 0;
    private static float speedrotCube = -1.5f;

    public boolean face1=true;
    public boolean face2=false;
    public boolean face3=false;
    public boolean face4=false;
    public boolean face5=false;
    public boolean face6=false;
    float[] pos_got={1.0f, 1.0f, 0.4f, 1.0f};


    public MyOpenGLRenderer_Cube(Context context)
    {
        cube = new Cube();
    }
    public void color_chosen(float[] got_color)
    {
        pos_got = got_color;
    }
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glClearDepthf(1.0f);
        gl.glEnable(GL10.GL_DEPTH_TEST);
        gl.glDepthFunc(GL10.GL_LEQUAL);
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
        gl.glShadeModel(GL10.GL_SMOOTH);
        gl.glDisable(GL10.GL_DITHER);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        if (height == 0) height = 1;
        float aspect = (float)width / height;

        gl.glViewport(0, 0, width, height);

        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        GLU.gluPerspective(gl, 45, aspect, 0.1f, 100.f);

        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);


        gl.glLoadIdentity();
        gl.glTranslatef(0.0f, 0.0f, -6.0f);
        gl.glScalef(0.8f, 0.8f, 0.8f);
        gl.glRotatef(anglerotCube, 1.0f, 1.0f, 1.0f);

        if(face1==true)
        {
            cube.setcolor(pos_got,0);
        }
        if(face2==true)
        {
            cube.setcolor(pos_got,1);
        }
        if(face3==true)
        {
            cube.setcolor(pos_got,2);
        }
        if(face4==true)
        {
            cube.setcolor(pos_got,3);
        }
        if(face5==true)
        {
            cube.setcolor(pos_got,4);
        }
        if(face6==true)
        {
            cube.setcolor(pos_got,5);
        }

        cube.draw(gl);

        anglerotCube += speedrotCube;
    }
}

