package shubhamagarwal1.com.opengl_retry;

import android.util.Log;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;


public class Triangle
{
    private FloatBuffer vertexBuffer;
    private ByteBuffer indexBuffer;
    private FloatBuffer colorBuffer;
    int vertex;
    ByteBuffer vbb;
    ByteBuffer cbb;

    private float[] vertices = {
            0.0f,  1.0f, 0.0f,
            -1.0f, -1.0f, 0.0f,
            1.0f, -1.0f, 0.0f
    };

    private float[] colors_got = {
            1.0f, 0.0f, 0.0f, 1.0f,
            0.0f, 1.0f, 0.0f, 1.0f,
            0.0f, 0.0f, 1.0f, 1.0f
    };



    public int vertex_chooser(int a)
    {

        if(a > 0 && a < 4)
        {vertex = a;}

        else if(a<1)// || a > 3)
        {
            Log.d("value of vertex-less ", String.valueOf(a));
            vertex = 1;
        }
        else if(a>3)
        {
            Log.d("value of vertex-more ", String.valueOf(a));
            vertex = 3;
        }
        return vertex;
    }

    public void setcolor(float[] get_color)
    {

        if(vertex == 1)
        {
            colors_got[0] = get_color[1];
            colors_got[1] = get_color[2];
            colors_got[2] = get_color[3];
            colors_got[3] = get_color[0];
        }
        else if(vertex == 2)
        {
            colors_got[4] = get_color[1];
            colors_got[5] = get_color[2];
            colors_got[6] = get_color[3];
            colors_got[7] = get_color[0];
        }
        else if(vertex == 3)
        {
            colors_got[8] = get_color[1];
            colors_got[9] = get_color[2];
            colors_got[10] = get_color[3];
            colors_got[11] = get_color[0];
        }

        colorbufferfunc(colors_got);


    }

    private float[] colors = colors_got;
    private byte[] indices = { 0, 1, 2 };

    public void vertexbufferfunc()
    {
        vbb = ByteBuffer.allocateDirect(vertices.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        vertexBuffer = vbb.asFloatBuffer();
        vertexBuffer.put(vertices);
        vertexBuffer.position(0);
    }

    public void colorbufferfunc(float[] colorsdefined)
    {

        cbb = ByteBuffer.allocateDirect(colorsdefined.length * 4);
        cbb.order(ByteOrder.nativeOrder());
        colorBuffer = cbb.asFloatBuffer();
        colorBuffer.put(colorsdefined);
        colorBuffer.position(0);
    }

    public Triangle()
    {


        vertexbufferfunc();
        colorbufferfunc(colors);

        indexBuffer = ByteBuffer.allocateDirect(indices.length);
        indexBuffer.put(indices);
        indexBuffer.position(0);
    }
    public void draw(GL10 gl) {

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);


        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);          // Enable color-array (NEW)
        gl.glColorPointer(4, GL10.GL_FLOAT, 0, colorBuffer);


        gl.glDrawElements(GL10.GL_TRIANGLES, indices.length, GL10.GL_UNSIGNED_BYTE, indexBuffer);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
    }
}
