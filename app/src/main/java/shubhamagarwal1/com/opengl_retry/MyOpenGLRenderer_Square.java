package shubhamagarwal1.com.opengl_retry;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class MyOpenGLRenderer_Square implements GLSurfaceView.Renderer
{
    Square square;
//    Context context;

    private float angleSquare = 0.0f;
    private float speedSquare = -0.4f;

    float[] pos_got={1.0f, 1.0f, 0.4f, 1.0f};
    int object_chosen = 1;

    public MyOpenGLRenderer_Square(Context context)
    {
//        this.context = context;
        square = new Square();

    }
    // handling the radio buttons
    public void chose_square(int a)
    {
        object_chosen = a;
    }

    public void chose_background(int b)
    {
        object_chosen = b;
    }
    public void color_chosen(float[] got_color)
    {
        pos_got = got_color;
    }
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glClearColor(0.0f, 1.0f, 0.0f, 1.0f);  // background screen color
        gl.glClearDepthf(1.0f);
        gl.glEnable(GL10.GL_DEPTH_TEST);
        gl.glDepthFunc(GL10.GL_LEQUAL);
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
        gl.glShadeModel(GL10.GL_SMOOTH);
        gl.glDisable(GL10.GL_DITHER);

    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        if (height == 0) height = 1;   // To prevent divide by zero
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

        float a = pos_got[0];
        float b = pos_got[1];
        float c = pos_got[2];
        float d = pos_got[3];
//        float val = a*2-1;

        float val = a;

        if(object_chosen ==2)
        {
            gl.glClearColor(pos_got[1], pos_got[2], pos_got[3], pos_got[0]);
        }
        else if(object_chosen == 1)
        {
            square.setcolor(pos_got);
        }

        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        gl.glLoadIdentity();
//        gl.glScalef(val,val,val);
        gl.glTranslatef(0.0f, 0.0f, -6.0f);
        gl.glRotatef(1.0f, 1.0f, 1.0f, 1.0f);
        gl.glScalef(val,val,val);
        square.draw(gl);
//        val += speedSquare;
        angleSquare += speedSquare;

    }

}

