package co.com.tdea.dominio;

import co.com.tdea.dto.Aerolinea;

public class Aerolineas {

    public Aerolinea inicio;

    public Aerolineas() {
        this.inicio = null;
    }

    Aerolineas insertarCabeza(Aerolinea newAerolinea, Vuelos vuelos ){
        Aerolinea aerolinea = new Aerolinea(newAerolinea.getCodigo(),newAerolinea.getNombre());
        aerolinea.setLiga(this.inicio);
        aerolinea.setLigaVuelos(vuelos.inicio);
        this.inicio = aerolinea;
        return this;
    }

    public Aerolineas add(Aerolinea newAerolinea, Vuelos vuelos){

        Aerolinea aux = this.inicio;
        if (this.inicio == null){
            return insertarCabeza(newAerolinea,vuelos);
        }

        while(aux.getLiga() != null){
            aux = aux.getLiga();
        }
        newAerolinea.setLigaVuelos(vuelos.inicio);
        aux.setLiga(newAerolinea);

        return this;

    }

    public void show(){
        Aerolinea aux = this.inicio;
        if (this.inicio == null){
            System.out.println("No existen aerolineas creadas");
        }else{
            System.out.println("--------------Lista------------------");
                while (aux != null){
                    System.out.println("\n");
                    System.out.println("|------------------------------|");
                    System.out.println("| Codigo: "+ aux.getCodigo());
                    System.out.println("| Nombre: "+ aux.getNombre());
                    System.out.println("| Liga: "+ aux.getLiga());
                    System.out.println("|------------------------------|");
                    aux = aux.getLiga();
                }
            System.out.println("\n--------------------------------");
        }

    }

}
