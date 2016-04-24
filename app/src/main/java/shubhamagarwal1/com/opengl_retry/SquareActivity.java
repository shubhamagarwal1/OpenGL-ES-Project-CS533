package shubhamagarwal1.com.opengl_retry;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.larswerkman.lobsterpicker.OnColorListener;
import com.larswerkman.lobsterpicker.sliders.LobsterOpacitySlider;
import com.larswerkman.lobsterpicker.sliders.LobsterShadeSlider;

public class SquareActivity extends AppCompatActivity
{


    float[] color_val_gen = {0.0f, 0.0f, 0.0f, 0.0f};
    MyOpenGLRenderer_Square myrenderer;
    private GLSurfaceView glView_Square;

    boolean square_chosen;
    boolean background_chosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square);

        glView_Square = (GLSurfaceView) findViewById(R.id.GLView_Square);
        myrenderer = new MyOpenGLRenderer_Square(this);
        glView_Square.setRenderer(myrenderer);

        LobsterShadeSlider shadeSlider = (LobsterShadeSlider) findViewById(R.id.shadeslider);
        LobsterOpacitySlider opacitySlider = (LobsterOpacitySlider) findViewById(R.id.opacityslider);
        shadeSlider.addDecorator(opacitySlider);



        shadeSlider.addOnColorListener(new OnColorListener() {
            @Override
            public void onColorChanged(@ColorInt final int color) {
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
                if(square_chosen==true && background_chosen == false)
                {
                    Log.d("color change callback", "chose square");
                    myrenderer.chose_square(1);
                }
                else if ( background_chosen == true && square_chosen==false)
                {
                    Log.d("color change callback", "chose background");

                    myrenderer.chose_background(2);
                }

                myrenderer.color_chosen(color_val_gen);


            }

            @Override
            public void onColorSelected(@ColorInt int color) {
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
        glView_Square.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        glView_Square.onResume();


    }

    public void setSquare(View view)
    {
        Log.d("Radio Button Chosen ", " Square");
        square_chosen = true;
        background_chosen = false;
    }

    public void setBackground(View view)
    {
        Log.d("Radio Button Chosen ", " Background");
        background_chosen = true;
        square_chosen = false;

    }
}
