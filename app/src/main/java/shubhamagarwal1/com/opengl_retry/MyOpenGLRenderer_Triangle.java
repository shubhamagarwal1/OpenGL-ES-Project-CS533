package shubhamagarwal1.com.opengl_retry;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


public class MyOpenGLRenderer_Triangle implements GLSurfaceView.Renderer
{
    Triangle triangle;
    //    Context context;
    private float anglerotTriangle = 0.0f;
    private float speedrotTriangle = 0.5f;

    float[] pos_got={1.0f, 0.0f, 0.0f, 1.0f};
    int vertexchosen = 1;

    public MyOpenGLRenderer_Triangle(Context context)
    {
        triangle = new Triangle();

    }

    // Retrieving color and vertex chosen info from activity
    public void color_chosen(float[] got_color)
    {
        pos_got = got_color;
    }

    public void vertex_chosen(int a)
    {
        vertexchosen = a;

    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
//        gl.glClearColor(pos_got[0],pos_got[1],pos_got[2],pos_got[3]);

//        gl.glClearColor(color_got[0],color_got[1],color_got[2],color_got[3]);


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
    public void onDrawFrame(GL10 gl)
    {

        System.out.printf(String.valueOf(vertexchosen));
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        gl.glLoadIdentity();



        float a = pos_got[0];
        float b = pos_got[1];
        float c = pos_got[2];
        float d = pos_got[3];
        float val = a*2-1;

        gl.glTranslatef(val, 0.0f, -6.0f);
        gl.glRotatef(anglerotTriangle, 0.0f, 1.0f, 0.0f);

        triangle.vertex_chooser(vertexchosen);
        triangle.setcolor(pos_got);
        triangle.draw(gl);

        anglerotTriangle += speedrotTriangle;

    }



}
