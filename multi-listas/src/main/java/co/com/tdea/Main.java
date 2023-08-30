package co.com.tdea;

import co.com.tdea.dominio.Aerolineas;
import co.com.tdea.dominio.Pasajeros;
import co.com.tdea.dominio.Vuelos;
import co.com.tdea.dto.Aerolinea;
import co.com.tdea.dto.Vuelo;

import java.util.Scanner;

public class Main {
    static public Aerolineas aerolineas = new Aerolineas();

    public static void main(String[] args) {
        boolean exit = false;
        do
        {
            System.out.println("-------------------------");
            System.out.println("1: Crear Aerolineas");
            System.out.println("2: Mostrar Aerolineas");
            System.out.println("3: Crear Vuelos a Aerolineas");
            System.out.println("4: Mostrar Vuelos x Aerolineas");
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
                      crearAerolineas();
                      break;
                  case 2:
                      mostrarAerolineas();
                      break;
                  case 3:
                      crearVuelos();
                      break;
                  case 4:
                      mostrarVuelosXAerolineas();
                      break;
              }
        }
        while(!exit);
        System.out.println("---- Programa terminado ----");
    }

    public static void crearAerolineas(){
        Vuelos vuelos =  new Vuelos();
        Scanner sc = new Scanner(System.in);
        System.out.println("------------ Maestro Aerolineas --------------");
        boolean exit = false;
        do {
            System.out.println("Ingrese código: ");
            String codigo = sc.nextLine();
            System.out.println("Ingrese Nombre: ");
            String nombre = sc.nextLine();
            Aerolinea aerolinea = new Aerolinea(codigo,nombre);
            aerolineas.add(aerolinea,vuelos);
            System.out.println("Desea crear otra Aerolinea? 1: Si, 0: No");
            int value = Integer.parseInt(sc.nextLine());
            exit = (value != 1);
        }while(!exit);

    }

    public static void mostrarVuelosXAerolineas(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese codigo de la aerolinea");
        String codigo = sc.nextLine();
        aerolineas.showVuelos(codigo);
    }

    public static void mostrarAerolineas(){
        aerolineas.show();
    }

    public static Vuelos crearVuelos(){
        Vuelos vuelos =  new Vuelos();
        Pasajeros pasajeros = new Pasajeros();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        System.out.println("------------ Creación Vuelos --------------");
        do{
            System.out.println("Ingrese código de la aerolinea: ");
            String codigoAerolinea = sc.nextLine();

            Aerolinea buscada = aerolineas.buscarAerolinea(codigoAerolinea);

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
                vuelos.add(vuelo, pasajeros);
                buscada.setLigaVuelos(vuelos.inicio);
                System.out.println("Desea crear otro vuelo? 1: Si, 0: No");
                exit = (sc.nextInt() != 1);
            }
        }while(!exit);

        return vuelos;
    }

}
