package shubhamagarwal1.com.opengl_retry;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class MyOpenGLRenderer_Cube_Textured implements GLSurfaceView.Renderer
{
    private Cube_Textured cube;
    private static float rotangle = 0;
    private static float rotspeed = -1.5f;
    private Context context;
    public float xcoord=0.05f, ycoord=0.0f;
    float Scale=1.0f;
    public MyOpenGLRenderer_Cube_Textured(Context context)
    {
        this.context = context;
        cube = new Cube_Textured();
    }

    public void setscale(float scale_got)
    {
        Scale = scale_got;
    }

    public void setcoords(float x,float y)
    {
        float xval = ((x-2)/954)*2-1;
        float yval = -(((y-24)/1176)*2-1);


        xcoord = xval;
        ycoord = yval;
    }
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glClearColor(0.5f, 0.0f, 0.0f, 1.0f);
        gl.glClearDepthf(1.0f);
        gl.glEnable(GL10.GL_DEPTH_TEST);
        gl.glDepthFunc(GL10.GL_LEQUAL);
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
        gl.glShadeModel(GL10.GL_SMOOTH);
        gl.glDisable(GL10.GL_DITHER);

        cube.loadTexture(gl, context);
        gl.glEnable(GL10.GL_TEXTURE_2D);
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
//        gl.glTranslatef(0.05f, 0.0f, -6.5f);
        gl.glTranslatef(xcoord, ycoord, -6.5f);
        gl.glScalef(0.8f*Scale, 0.8f*Scale, 0.8f*Scale);
        gl.glRotatef(rotangle, 1.0f, 1.0f, 1.0f);
        cube.draw(gl);

        rotangle += rotspeed;
    }
}

