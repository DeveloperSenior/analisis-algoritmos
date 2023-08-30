package co.com.tdea.dto;

import lombok.Data;

@Data
public class Vuelo {
    /*atributos nodo*/
    String codigo;
    String horario;
    String tipoAvion;

    /*ligas*/
    Vuelo liga;
    Pasajero ligaPasajero;

    public Vuelo(String codigo,String horario, String tipoAvion) {
        this.codigo = codigo;
        this.horario = horario;
        this.tipoAvion = tipoAvion;
        this.liga = null;
        this.ligaPasajero = null;
    }
}
