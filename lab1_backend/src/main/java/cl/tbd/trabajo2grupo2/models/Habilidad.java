package cl.tbd.trabajo2grupo2.models;

import javax.persistence.*;

@Entity
@Table(name ="habilidad")
public class Habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_habilidad;
    private String nombre_habilidad;

    //Constructor
    public Habilidad(Long id_habilidad, String nombre_habilidad){
        this.id_habilidad = id_habilidad;
        this.nombre_habilidad = nombre_habilidad;
    }

    //Getters
    public Long getId_habilidad(){
        return id_habilidad;
    }

    public String getNombre_habilidad(){
        return nombre_habilidad;
    }

    //Setters
    public void setId_habilidad(Long id_habilidad){
        this.id_habilidad = id_habilidad;
    }

    public void setNombre_habilidad(String nombre_habilidad){
        this.nombre_habilidad = nombre_habilidad;
    }

    //TOSTRING
    @Override
    public String toString() {
        return "Habilidad [id_habilidad=" + id_habilidad + ", nombre_habilidad=" + nombre_habilidad + "]";
    }

    
}
