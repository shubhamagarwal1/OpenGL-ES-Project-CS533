package shubhamagarwal1.com.opengl_retry;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class PyramidActivity extends AppCompatActivity implements View.OnTouchListener{
    MyOpenGLRenderer_Pyramid myrenderer;
    private GLSurfaceView glView_Pyramid;
    float x,y;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pyramid);

        glView_Pyramid = (GLSurfaceView) findViewById(R.id.GLView_Cube_Tex);
        myrenderer = new MyOpenGLRenderer_Pyramid(this);
        glView_Pyramid.setRenderer(myrenderer);

        glView_Pyramid.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent)
            {
                Log.d("touch listener", motionEvent.getX() + "");
                switch(motionEvent.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                    {
//                        Log.d("touch in activity","touch_down");

                        x = motionEvent.getX();
                        y = motionEvent.getY();
                        break;
                    }
                    case MotionEvent.ACTION_UP:
                    {
//                        Log.d("touch in activity","touch_up");
                        x = motionEvent.getX();
                        y = motionEvent.getY();
//                        break;
                        break;
                    }
                    case MotionEvent.ACTION_MOVE:
                    {
//                        Log.d("touch in activity","touch_move");
                        x = motionEvent.getX();
                        y = motionEvent.getY();
//                        break;
                        break;
                    }

                }

//                myrenderer.setcoords(x,y);
                return true;
            }
        });


    }

    @Override
    protected void onPause() {
        super.onPause();
        glView_Pyramid.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        glView_Pyramid.onResume();
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
