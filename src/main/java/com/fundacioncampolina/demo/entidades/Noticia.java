package com.fundacioncampolina.demo.entidades;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Noticia {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @Column(name = "titulo", nullable = false)
    private String titulo;
    
    @Column(name = "texto", nullable = false)
    private String texto;
    
    @Column(name = "texto_cortado", nullable = false)
    private String textoCortado;
    
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @Column(name = "alta", nullable = false)
    private Boolean alta;
    
    @Column(name = "imagen")
    private String imagen;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }    

    public String getTextoCortado() {
        return textoCortado;
    }

    public void setTextoCortado(String textoCortado) {
        this.textoCortado = textoCortado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Noticia{" + "id=" + id + ", titulo=" + titulo + ", texto=" + texto + ", textoCortado=" + textoCortado + ", fecha=" + fecha + ", alta=" + alta + ", imagen=" + imagen + '}';
    }
    
}
