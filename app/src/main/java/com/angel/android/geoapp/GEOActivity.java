package com.angel.android.geoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.angel.android.geoapp.model.Pregunta;

import org.w3c.dom.Text;

public class GEOActivity extends AppCompatActivity {

    private Button mBotonCierto;
    private Button mBotonFalso;
    private Button mBotonSiguiente;
    private TextView mTextoPregunta;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo);

        mBotonCierto = (Button) findViewById(R.id.boton_cierto);
        mBotonFalso = (Button) findViewById(R.id.boton_falso);
        mTextoPregunta = (TextView) findViewById(R.id.texto_pregunta);
        mBotonSiguiente = (Button) findViewById(R.id.boton_siguiente);


        mBotonCierto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificarRespuesta(true);
            }
        });

        mBotonFalso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificarRespuesta(false);
            }
        });

        mBotonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPreguntaActual = mPreguntaActual + 1;
                if (mPreguntaActual == mBancoDePreguntas.length){
                    mPreguntaActual = 0;

                }
                actualizarPregunta();
            }
        });
    }

    private Pregunta mBancoDePreguntas[] = {
            new Pregunta(R.string.texto_pregunta_1, false),
            new Pregunta(R.string.texto_pregunta_2, true),
            new Pregunta(R.string.texto_pregunta_3, true),
            new Pregunta(R.string.texto_pregunta_4, true),
            new Pregunta(R.string.texto_pregunta_5, false),

    };
    private int mPreguntaActual = 0;

    private  void actualizarPregunta(){
        int PreguntaActual = mBancoDePreguntas[mPreguntaActual].getIdResTexto();
        mTextoPregunta.setText(PreguntaActual);
    }
    private  void  verificarRespuesta(boolean botonOprimido) {
        boolean respuestaEsVerdadera = mBancoDePreguntas[mPreguntaActual].isRespuestaVerdadera();
        if (botonOprimido == respuestaEsVerdadera){
            Toast.makeText(GEOActivity.this, R.string.texto_correcto, Toast.LENGTH_SHORT)
                    .show();
        }
        else  {
            Toast.makeText(GEOActivity.this, R.string.texto_incorrecto, Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
