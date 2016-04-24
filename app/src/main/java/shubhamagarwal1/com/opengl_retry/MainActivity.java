package shubhamagarwal1.com.opengl_retry;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.larswerkman.lobsterpicker.LobsterPicker;
import com.larswerkman.lobsterpicker.OnColorListener;
import com.larswerkman.lobsterpicker.adapters.BitmapColorAdapter;
import com.larswerkman.lobsterpicker.sliders.LobsterOpacitySlider;
import com.larswerkman.lobsterpicker.sliders.LobsterShadeSlider;

import javax.microedition.khronos.opengles.GL10;

import shubhamagarwal1.com.opengl_retry.R;

public class MainActivity extends Activity {

    private GLSurfaceView glView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
//        glView = new GLSurfaceView(this);
        setContentView(R.layout.activity_main);
        glView = (GLSurfaceView)findViewById(R.id.GLView);
        glView.setRenderer(new MyOpenGLRenderer_Cube_Textured(this));
//        this.setContentView(glView);

//        glView.setRenderer(new MyOpenGLRenderer_Cube_Textured(this));

    }


    @Override
    protected void onPause() {
        super.onPause();
        glView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        glView.onResume();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void Navigate_To_Triangle_Button(View view)
    {
        Intent to_Triangle = new Intent(this, TriangleActivity.class);
        startActivity(to_Triangle);
    }

    public void Navigate_To_Square_Button(View view)
    {
        Intent to_Square = new Intent(this, SquareActivity.class);
        startActivity(to_Square);
    }
    public void Navigate_To_Cube_Button(View view)
    {
        Intent to_Cube = new Intent(this, CubeActivity.class);
        startActivity(to_Cube);
    }

    public void Navigate_To_Textured_Cube_Button(View view)
    {
        Intent to_Texcube = new Intent(this, TextCubeActivity.class);
        startActivity(to_Texcube);
    }
//    public void Navigate_To_PhotoCube_Button(View view)
//    {
//        Intent to_PhotoCube = new Intent(this, PhotoCubeActivity.class);
//        startActivity(to_PhotoCube);
//    }


    public void Navigate_To_Pyramid_Button(View view)
    {
        Intent to_Pyramid = new Intent(this, PyramidActivity.class);
        startActivity(to_Pyramid);
    }



}
