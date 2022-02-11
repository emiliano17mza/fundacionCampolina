package com.fundacioncampolina.demo.excepciones;

public class NoticiaException extends Exception{
    
    public NoticiaException(){
    }
    
    public NoticiaException(String msj_error){
        
        super(msj_error);
    }
}
