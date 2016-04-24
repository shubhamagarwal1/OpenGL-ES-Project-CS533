package shubhamagarwal1.com.opengl_retry;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.FloatMath;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class TextCubeActivity extends AppCompatActivity implements View.OnTouchListener
{
    MyOpenGLRenderer_Cube_Textured myrenderer;
    private GLSurfaceView glView_Cube_Tex;
    float x,y;
    float xdis,ydis,totaldis,totaldis_moved;
    int State;
    float Scale = 1.0f;
    final int TOUCH = 0;
    final int PINCH = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_cube);

        glView_Cube_Tex = (GLSurfaceView) findViewById(R.id.GLView_Cube_Tex);
        myrenderer = new MyOpenGLRenderer_Cube_Textured(this);
        glView_Cube_Tex.setRenderer(myrenderer);

        glView_Cube_Tex.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.d("touch listener", motionEvent.getX() + "");
                switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN: {
//                        Log.d("touch in activity","touch_down");

                        x = motionEvent.getX();
                        y = motionEvent.getY();
                        State = TOUCH;
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
//                        Log.d("touch in activity","touch_up");
                        x = motionEvent.getX();
                        y = motionEvent.getY();
//                        break;
                        break;
                    }

                    case MotionEvent.ACTION_POINTER_DOWN: {
//                        Log.d("touch in activity","touch_move");
//                        x = motionEvent.getX();
//                        y = motionEvent.getY();
                        State = PINCH;

                        xdis = motionEvent.getX(0) - motionEvent.getX(1);
                        ydis = motionEvent.getY(0) - motionEvent.getY(1);
                        totaldis = (int) ((float) Math.sqrt(xdis * xdis + ydis * ydis));
//                        break;
                        break;
                    }
                    case MotionEvent.ACTION_POINTER_UP: {
//                        Log.d("touch in activity","touch_move");
//                        x = motionEvent.getX();
//                        y = motionEvent.getY();
                        State = TOUCH;
//                        break;
                        break;
                    }
                    case MotionEvent.ACTION_MOVE: {
//                        Log.d("touch in activity","touch_move");
                        if(State == TOUCH)
                        {
                            x = motionEvent.getX();
                            y = motionEvent.getY();
                        }
//                        x = motionEvent.getX();
//                        y = motionEvent.getY();
                        if (State == PINCH) {
                            //Get the current distance
                            xdis = motionEvent.getX(0) - motionEvent.getX(1);
                            ydis = motionEvent.getY(0) - motionEvent.getY(1);
                            totaldis_moved = (int) ((float) Math.sqrt(xdis * xdis + ydis * ydis));
                            calc_scale();
//                        break;

                        }
                        break;
                    }


                }

                myrenderer.setcoords(x, y);
                myrenderer.setscale(Scale);
                return true;
            }
        });


    }

    @Override
    protected void onPause() {
        super.onPause();
        glView_Cube_Tex.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        glView_Cube_Tex.onResume();
    }

    public void calc_scale() {
        Scale = totaldis_moved / totaldis;
        if (Scale < 0.1) {
            Scale = 0.1f;
        }
//        return Scale;
    }
    public boolean onTouch(View v, MotionEvent e)
    {
        switch(e.getAction())
        {
            case MotionEvent.ACTION_DOWN:
            {
                Log.d("touch in activity","touch_down");
                break;
            }
            case MotionEvent.ACTION_UP:
            {
                Log.d("touch in activity","touch_up");
                break;
            }
            case MotionEvent.ACTION_MOVE:
            {
                Log.d("touch in activity","touch_move");
                break;
            }

        }
        return true;
    }
}
