package co.com.tdea.dominio;

import co.com.tdea.dto.Aerolinea;
import co.com.tdea.dto.Vuelo;

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

    public Aerolineas insertar(Aerolinea newAerolinea, Vuelos vuelos){

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

    public void mostrarAerolineas(){
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
                    System.out.println("| LigaVuelos: "+ aux.getLigaVuelos());
                    System.out.println("| Liga: "+ aux.getLiga());
                    System.out.println("|------------------------------|");
                    aux = aux.getLiga();
                }
            System.out.println("\n--------------------------------");
        }

    }

    public void mostrarVuelosAerolinea(String codigoAerolinea){
        Aerolinea auxAerolinea = this.inicio;
        Vuelo auxVuelos = auxAerolinea.getLigaVuelos();
        if (this.inicio == null){
            System.out.println("No existen aerolineas creadas");
        }else{
            System.out.println("--------------Lista Vuelos Aerolinea "+codigoAerolinea+"------------------");
            while (auxAerolinea != null) {
                if (auxAerolinea.getCodigo().equalsIgnoreCase(codigoAerolinea)) {
                    while (auxVuelos != null) {
                        System.out.println("\n");
                        System.out.println("|------------------------------|");
                        System.out.println("| Codigo: " + auxVuelos.getCodigo());
                        System.out.println("| Horario: " + auxVuelos.getHorario());
                        System.out.println("| Avion: " + auxVuelos.getTipoAvion());
                        System.out.println("| LigaPasajeros: " + auxVuelos.getLigaPasajero());
                        System.out.println("| Liga: " + auxVuelos.getLiga());
                        System.out.println("|------------------------------|");
                        auxVuelos = auxVuelos.getLiga();
                    }
                    break;
                }
                auxAerolinea = auxAerolinea.getLiga();
            }
            if (auxAerolinea == null){
                System.out.println("No existen la aerolineas ingresada");
            }
        }
            System.out.println("\n--------------------------------");
    }

    public Aerolinea buscar(String codigo){
        Aerolinea aux = this.inicio;
        Aerolinea nodoEncontrado = null;
        if (this.inicio == null){
            System.out.println("No existen aerolineas creadas");
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

    public Aerolineas eliminar(String codigo){

        Aerolinea aux = this.inicio;
        Aerolinea nodoEncontrado = null;
        Aerolinea nodoAnterior = this.inicio;
        if (this.inicio == null){
            System.out.println("No existen aerolineas creadas");
        }else{
            while (aux != null){
                if (aux.getCodigo().equalsIgnoreCase(codigo)){
                    nodoEncontrado = aux;
                    break;
                }
                nodoAnterior = aux;
                aux = aux.getLiga();
            }
        }

        if (nodoEncontrado == null){
            System.out.println("No existe la aerolineas que desea actualizar");
        }else{
            if(nodoEncontrado == this.inicio){
                this.inicio = nodoEncontrado.getLiga();
            }else {
                nodoAnterior.setLiga(nodoEncontrado.getLiga());
            }
            nodoEncontrado = null;
            System.gc();
        }

        return this;

    }

    public Aerolineas actualizar(Aerolinea aerolinea){

        Aerolinea aux = this.inicio;
        Aerolinea nodoEncontrado = null;
        if (this.inicio == null){
            System.out.println("No existen aerolineas creadas");
        }else{
            while (aux != null){
                if (aux.getCodigo().equalsIgnoreCase(aerolinea.getCodigo())){
                    nodoEncontrado = aux;
                    break;
                }
                aux = aux.getLiga();
            }
        }

        if (nodoEncontrado == null){
            System.out.println("No existe la aerolineas que desea eliminar");
        }else{
            nodoEncontrado.setNombre(aerolinea.getNombre());
        }

        return this;

    }

}
