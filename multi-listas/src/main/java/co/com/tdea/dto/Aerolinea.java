package co.com.tdea.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Aerolinea {
    /*atributos nodo*/
    String codigo;
    String nombre;

    /*ligas*/
    Aerolinea liga;
    Vuelo ligaVuelos;

    public Aerolinea(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ligaVuelos = null;
        this.liga = null;
    }
}
