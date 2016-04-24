package shubhamagarwal1.com.opengl_retry;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.opengl.GLSurfaceView;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.larswerkman.lobsterpicker.OnColorListener;
import com.larswerkman.lobsterpicker.sliders.LobsterOpacitySlider;
import com.larswerkman.lobsterpicker.sliders.LobsterShadeSlider;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class TriangleActivity extends AppCompatActivity {


    private GLSurfaceView glView_Triangle;

    float[] color_val_gen = {0.0f, 0.0f, 0.0f, 0.0f};
    MyOpenGLRenderer_Triangle myrenderer;
    RadioButton vertexA;
    RadioButton vertexB;
    RadioButton vertexC;
    RadioGroup radioGroup;
    boolean vertex_A_chosen;
    boolean vertex_B_chosen;
    boolean vertex_C_chosen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        vertexA = (RadioButton) findViewById(R.id.vA_radio);
        vertexB = (RadioButton) findViewById(R.id.vB_radio);
        vertexC = (RadioButton) findViewById(R.id.vC_radio);
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);

        setContentView(R.layout.activity_triangle);
        glView_Triangle = (GLSurfaceView) findViewById(R.id.GLView_Triangle);
        myrenderer = new MyOpenGLRenderer_Triangle(this);
        glView_Triangle.setRenderer(myrenderer);


        LobsterShadeSlider shadeSlider = (LobsterShadeSlider) findViewById(R.id.shadeslider);
        LobsterOpacitySlider opacitySlider = (LobsterOpacitySlider) findViewById(R.id.opacityslider);
        shadeSlider.addDecorator(opacitySlider);

        shadeSlider.addOnColorListener(new OnColorListener()
        {
            @Override
            public void onColorChanged(@ColorInt final int color)
            {
                String hexColor = String.format("#%06X", (0xFFFFFFFF & color));

                int a = Integer.valueOf(hexColor.substring(1, 3), 16);
                int r = Integer.valueOf(hexColor.substring(3, 5), 16);
                int g = Integer.valueOf(hexColor.substring(5, 7), 16);
                int b = Integer.valueOf(hexColor.substring(7, 9), 16);
                double round_a = (double) Math.round(((float) a / 255) * 100) / 100;
                double round_r = (double) Math.round(((float) r / 255) * 100) / 100;
                double round_g = (double) Math.round(((float) g / 255) * 100) / 100;
                double round_b = (double) Math.round(((float) b / 255) * 100) / 100;
                float[] colorval = {(float) round_a, (float) round_r, (float) round_g, (float) round_b};
//                Log.d("vector_short", String.valueOf(colorval[0])+" "+String.valueOf(colorval[1])+" "+String.valueOf(colorval[2])+" "+String.valueOf(colorval[3]));
                color_val_gen = colorval;
                if (vertex_A_chosen == true && vertex_B_chosen == false && vertex_C_chosen == false)
                {
                    Log.d("color change callback", "vertexA");
                    myrenderer.vertex_chosen(1);
                }
                if (vertex_B_chosen == true && vertex_A_chosen == false && vertex_C_chosen == false)
                {
//                    Log.d("color change callback", "vertexB");

                    myrenderer.vertex_chosen(2);
                }
                if (vertex_C_chosen == true && vertex_B_chosen == false && vertex_A_chosen == false)
                {
                    Log.d("color change callback", "vertexC");

                    myrenderer.vertex_chosen(3);

                }
                myrenderer.color_chosen(color_val_gen);


            }

            @Override
            public void onColorSelected(@ColorInt int color)
            {
                String hexColor = String.format("#%06X", (0xFFFFFFFF & color));

                int a = Integer.valueOf(hexColor.substring(1, 3), 16);
                int r = Integer.valueOf(hexColor.substring(3, 5), 16);
                int g = Integer.valueOf(hexColor.substring(5, 7), 16);
                int b = Integer.valueOf(hexColor.substring(7, 9), 16);
                double round_a = (double) Math.round(((float) a / 255) * 100) / 100;
                double round_r = (double) Math.round(((float) r / 255) * 100) / 100;
                double round_g = (double) Math.round(((float) g / 255) * 100) / 100;
                double round_b = (double) Math.round(((float) b / 255) * 100) / 100;
                float[] colorval = {(float) round_a, (float) round_r, (float) round_g, (float) round_b};


            }


        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        glView_Triangle.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        glView_Triangle.onResume();


    }

    public void setVertexA(View view) {

        Log.d("Radio Button Chosen ", " A");
        vertex_A_chosen = true;
        vertex_B_chosen = false;
        vertex_C_chosen = false;

    }

    public void setVertexB(View view) {
        Log.d("Radio Button Chosen ", " B");

        vertex_A_chosen = false;
        vertex_B_chosen = true;
        vertex_C_chosen = false;

    }

    public void setVertexC(View view) {
        Log.d("Radio Button Chosen ", " C");
        vertex_A_chosen = false;
        vertex_B_chosen = false;
        vertex_C_chosen = true;


    }
}
