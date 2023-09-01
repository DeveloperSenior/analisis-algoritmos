package co.com.tdea.dominio;

import co.com.tdea.dto.Aerolinea;
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

    public Vuelos insertar(Vuelo newVuelo, Pasajeros pasajeros){

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

    public Vuelo buscar(String codigo){
        Vuelo aux = this.inicio;
        Vuelo nodoEncontrado = null;
        if (this.inicio == null){
            System.out.println("No existen vuelos creados");
        }else{
            while (aux != null){
                if (aux.getCodigo().equalsIgnoreCase(codigo)){
                    nodoEncontrado = aux;
                    break;
                }
                aux = aux.getLiga();
            }
        }
        return nodoEncontrado;
    }

    public Vuelos actualizar(Vuelo vuelo){
        Vuelo aux = this.inicio;
        Vuelo nodoEncontrado = null;
        if (this.inicio == null){
            System.out.println("No existen vuelos creados");
        }else{
            while (aux != null){
                if (aux.getCodigo().equalsIgnoreCase(vuelo.getCodigo())){
                    nodoEncontrado = aux;
                    break;
                }
                aux = aux.getLiga();
            }
        }
        if (nodoEncontrado == null){
            System.out.println("No existe el vuelo que desea eliminar");
        }else{
            nodoEncontrado.setHorario(vuelo.getHorario());
            nodoEncontrado.setTipoAvion(vuelo.getTipoAvion());
        }
        return this;
    }

}
