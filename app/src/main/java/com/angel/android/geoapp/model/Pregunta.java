package com.angel.android.geoapp.model;

/**
 * Created by AngeL on 19/05/2016.
 */
public class Pregunta {

    private  Integer idResTexto;
    private  boolean RespuestaVerdadera;

    public  Pregunta (Integer idResTexto ,boolean RespuestaVerdadera){
        this.idResTexto = idResTexto;
        this.RespuestaVerdadera = RespuestaVerdadera;
    }

    public void  setIdResTexto (Integer idResTexto) {
        this.idResTexto = idResTexto;
    }

    public Integer getIdResTexto (){
        return  this.idResTexto;
    }

    public void  setRespuestaVerdadera (boolean RespuestaVerdadera){
        this.RespuestaVerdadera = RespuestaVerdadera;
    }

    public boolean isRespuestaVerdadera(){
        return this.RespuestaVerdadera;
    }
}
