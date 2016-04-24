package shubhamagarwal1.com.opengl_retry;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;


public class Square
{
    private FloatBuffer vertexBuffer;
    public float[] color_get={1.0f, 1.0f, 0.4f, 1.0f};

    private float[] vertices = {
            -1.0f, -1.0f,  0.0f,
            1.0f, -1.0f,  0.0f,
            -1.0f,  1.0f,  0.0f,
            1.0f,  1.0f,  0.0f
    };

    public void setcolor(float[] color)
    {
        color_get[0] = color[1];
        color_get[1] = color[2];
        color_get[2] = color[3];
        color_get[3] = color[0];
    }

    public Square() {

        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        vertexBuffer = vbb.asFloatBuffer();
        vertexBuffer.put(vertices);
        vertexBuffer.position(0);
    }

    public void draw(GL10 gl) {

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);

        gl.glColor4f(color_get[0],color_get[1],color_get[2],color_get[3]);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, vertices.length / 3);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }
}

