package co.com.tdea.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Pasajero {
    /*atributos nodo*/
    String id;
    String nombre;
    int edad;

    /*ligas*/
    Pasajero liga;

    public Pasajero(String id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.liga = null;
    }
}
