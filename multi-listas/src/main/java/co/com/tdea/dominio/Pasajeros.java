package co.com.tdea.dominio;

import co.com.tdea.dto.Pasajero;

public class Pasajeros {

    public Pasajero inicio;

    public Pasajeros() {
        this(null);
    }

    public Pasajeros(Pasajero inicio){
        this.inicio = inicio;
    }

    public Pasajeros insertarCabeza(Pasajero newPasajero){
        Pasajero pasajero = new Pasajero(newPasajero.getId(),newPasajero.getNombre(),newPasajero.getEdad());
        pasajero.setLiga(this.inicio);
        this.inicio = pasajero;
        return this;
    }

    public Pasajeros add(Pasajero newPasajero){

        Pasajero aux = this.inicio;

        if(this.inicio == null){
            return insertarCabeza(newPasajero);
        }
        while(aux.getLiga() != null){
            aux = aux.getLiga();
        }
        aux.setLiga(newPasajero);
        return this;

    }

}
