package shubhamagarwal1.com.opengl_retry;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.larswerkman.lobsterpicker.OnColorListener;
import com.larswerkman.lobsterpicker.sliders.LobsterOpacitySlider;
import com.larswerkman.lobsterpicker.sliders.LobsterShadeSlider;

public class CubeActivity extends AppCompatActivity {



    float[] color_val_gen = {0.0f, 0.0f, 0.0f, 0.0f};
    MyOpenGLRenderer_Cube myrenderer;
    private GLSurfaceView glView_Cube;

    boolean fac1_chosen;
    boolean fac2_chosen;
    boolean fac3_chosen;
    boolean fac4_chosen;
    boolean fac5_chosen;
    boolean fac6_chosen;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cube);

        glView_Cube = (GLSurfaceView) findViewById(R.id.GLView_Cube);
        myrenderer = new MyOpenGLRenderer_Cube(this);
        glView_Cube.setRenderer(myrenderer);

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
                if (fac1_chosen == true)
                {
                    Log.d("color change callback", "chose face 1");
                    myrenderer.face1 = true;
                }else{myrenderer.face1 = false;}
                if (fac2_chosen == true)
                {
                    Log.d("color change callback", "chose face 2");

                    myrenderer.face2 = true;
                }else{myrenderer.face2 = false;}
                if (fac3_chosen == true)
                {
                    Log.d("color change callback", "chose face 3");
                    myrenderer.face3 = true;
                }else{myrenderer.face3 = false;}
                if (fac4_chosen == true)
                {
                    Log.d("color change callback", "chose face 4");

                    myrenderer.face4 = true;
                }else{myrenderer.face4 = false;}
                if (fac5_chosen == true)
                {
                    Log.d("color change callback", "chose face 5");
                    myrenderer.face5 = true;
                }else{myrenderer.face5 = false;}
                if (fac6_chosen == true)
                {
                    Log.d("color change callback", "chose face 6");

                    myrenderer.face6 = true;
                }else{myrenderer.face6 = false;}


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
        glView_Cube.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        glView_Cube.onResume();


    }

    public void setface1(View view)
    {
        Log.d("Radio Button Chosen ", "face 1");
        if(fac1_chosen==true)
        {
            fac1_chosen = false;
        }
        else
        {
            fac1_chosen = true;
        }
    }

    public void setface2(View view)
    {
        Log.d("Radio Button Chosen ", "face 2");
        if(fac2_chosen==true)
        {
            fac2_chosen = false;
        }
        else
        {
            fac2_chosen = true;
        }

    }
    public void setface3(View view)
    {
        Log.d("Radio Button Chosen ", "face 3");
        if(fac3_chosen==true)
        {
            fac3_chosen = false;
        }
        else
        {
            fac3_chosen = true;
        }
    }

    public void setface4(View view)
    {
        Log.d("Radio Button Chosen ", "face 4");
        if(fac4_chosen==true)
        {
            fac4_chosen = false;
        }
        else
        {
            fac4_chosen = true;
        }

    }
    public void setface5(View view)
    {
        Log.d("Radio Button Chosen ", " face 5");
        if(fac5_chosen==true)
        {
            fac5_chosen = false;
        }
        else
        {
            fac5_chosen = true;
        }
    }

    public void setface6(View view)
    {
        Log.d("Radio Button Chosen ", " face 6");
        if(fac6_chosen==true)
        {
            fac6_chosen = false;
        }
        else
        {
            fac6_chosen = true;
        }

    }


}

