package co.com.tdea.helper;

import co.com.tdea.dominio.Aerolineas;
import co.com.tdea.dominio.Pasajeros;
import co.com.tdea.dominio.Vuelos;
import co.com.tdea.dto.Aerolinea;
import co.com.tdea.dto.Vuelo;

import java.util.Scanner;

public class MaestroVuelo extends MenuBase{
    
    Aerolineas aerolineas;

    public MaestroVuelo(Aerolineas aerolineas){
       this.aerolineas = aerolineas;
    }

    @Override
    public void mostrarMenu() {
        boolean exit = false;
        do
        {
            System.out.println("----------Maestro Vuelos---------------");
            System.out.println("1: Crear Vuelos x Aerolineas");
            System.out.println("2: Mostrar Vuelos x Aerolineas");
            System.out.println("0: Salir");
            System.out.println("-------------------------");

            Scanner sc = new Scanner(System.in);
            int itemMenu = -1 ;
            try{
                itemMenu = sc.nextInt();
            }catch(Exception nex){
                System.out.println("Opción invalida, Intente de nuevo");
                itemMenu = -1;
            }
            switch (itemMenu){
                case 0:
                    exit = true;
                    break;
                case 1:
                    crearVuelos();
                    break;
                case 2:
                    mostrarVuelosXAerolineas();
                    break;
            }

        }while(!exit);
    }

    void mostrarVuelosXAerolineas(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese codigo de la aerolinea");
        String codigo = sc.nextLine();
        aerolineas.mostrarVuelosAerolinea(codigo);
    }

    void crearVuelos(){
        Vuelos vuelos =  new Vuelos();
        Pasajeros pasajeros = new Pasajeros();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        System.out.println("------------ Creación Vuelos --------------");
        do{
            System.out.println("Ingrese código de la aerolinea: ");
            String codigoAerolinea = sc.nextLine();

            Aerolinea buscada = aerolineas.buscar(codigoAerolinea);

            if (buscada == null){
                System.out.println("La Aerolinea ingresada no existe");
            }else {

                System.out.println("Ingrese código: ");
                String codigo = sc.nextLine();
                System.out.println("Ingrese horario (dd/mm/yyyy hh24:mi): ");
                String horario = sc.nextLine();
                System.out.println("Tipo avión: ");
                String tipoAvion = sc.nextLine();
                Vuelo vuelo = new Vuelo(codigo, horario, tipoAvion);
                vuelos.insertar(vuelo, pasajeros);
                buscada.setLigaVuelos(vuelos.inicio);
                System.out.println("Desea crear otro vuelo? 1: Si, 0: No");
                exit = (sc.nextInt() != 1);
            }
        }while(!exit);
    }
}
