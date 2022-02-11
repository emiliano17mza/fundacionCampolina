
package com.fundacioncampolina.demo.entidades;

import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "solicitud_transporte")
public class SolicitudTransporte{
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "solicitud_id")
    private String id;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "apellido", nullable = false)
    private String apellido;
    
    @Column(name = "cel", nullable = false)
    private String celular;
    
    @Column(name = "email", nullable = false)
    private String email;
    
    @OneToMany(mappedBy = "solicitud", cascade = CascadeType.ALL)
    private List<Pasajero> pasajeros = new ArrayList<>();

    public SolicitudTransporte() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(List<Pasajero> pasajeros) {
        this.pasajeros = pasajeros;
    }

    @Override
    public String toString() {
        return "SolicitudTransporte{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", celular=" + celular + ", email=" + email + ", pasajeros=" + pasajeros + '}';
    }
    
    
}
