package shubhamagarwal1.com.opengl_retry;




import javax.microedition.khronos.egl.EGLConfig;
        import javax.microedition.khronos.opengles.GL10;
        import android.content.Context;
        import android.opengl.GLSurfaceView;
        import android.opengl.GLU;

public class MyOpenGLRenderer_Pyramid implements GLSurfaceView.Renderer {

    private Pyramid pyramid;

    private static float anglerot = 0;
    private static float speedrot = 2.0f;

    // Constructor
    public MyOpenGLRenderer_Pyramid(Context context) {
        pyramid = new Pyramid();
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
        gl.glTranslatef(0.5f, 0.0f, -6.0f);
        gl.glRotatef(anglerot, 0.1f, 1.0f, -0.1f);
        pyramid.draw(gl);




        anglerot += speedrot;
    }
}