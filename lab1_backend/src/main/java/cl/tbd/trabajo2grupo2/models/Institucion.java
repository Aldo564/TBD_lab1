package cl.tbd.trabajo2grupo2.models;

import javax.persistence.*;

@Entity
@Table(name ="institucion")
public class Institucion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_institucion;
    private String nombre_institucion;
    private String direccion;

    //Constructor
    public Institucion(Long id_institucion, String nombre_institucion, String direccion){
        this.id_institucion = id_institucion;
        this.nombre_institucion = nombre_institucion;
        this.direccion = direccion;
    }

    //Getters
    public Long getId_institucion(){
        return id_institucion;
    }

    public String getNombre_institucion(){
        return nombre_institucion;
    }

    public String getDireccion(){
        return direccion;
    }

    //Setters
    public void setId_institucion(Long id_institucion){
        this.id_institucion = id_institucion;
    }

    public void setNombre_institucion(String nombre_institucion){
        this.nombre_institucion = nombre_institucion;
    }

    public void setFecha_registro(String direccion){
        this.direccion = direccion;
    }

    //TOSTRING
    @Override
    public String toString() {
        return "Institucion [id_institucion=" + id_institucion + ", nombre_institucion=" + nombre_institucion
                + ", direccion=" + direccion + "]";
    }

    

    
}
