package co.com.tdea.dominio;

import co.com.tdea.dto.Vuelo;

public class Vuelos {

    public Vuelo inicio;

    public Vuelos() {
        this.inicio = null;
    }

    Vuelos insertarCabeza(Vuelo newVuelo, Pasajeros pasajeros ){
        Vuelo vuelo = new Vuelo(newVuelo.getCodigo(),newVuelo.getHorario(),newVuelo.getTipoAvion());
        vuelo.setLiga(this.inicio);
        vuelo.setLigaPasajero(pasajeros.inicio);
        this.inicio = vuelo;
        return this;
    }

    public Vuelos add(Vuelo newVuelo, Pasajeros pasajeros){

        Vuelo aux = this.inicio;

        if (this.inicio == null){
            return insertarCabeza(newVuelo,pasajeros);
        }

        while(aux.getLiga() != null){
            aux = aux.getLiga();
        }
        newVuelo.setLigaPasajero(pasajeros.inicio);
        aux.setLiga(newVuelo);

        return this;
    }
}
