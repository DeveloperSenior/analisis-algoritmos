package co.com.tdea;

import co.com.tdea.dominio.Aerolineas;
import co.com.tdea.dominio.Pasajeros;
import co.com.tdea.dominio.Vuelos;
import co.com.tdea.dto.Aerolinea;
import co.com.tdea.dto.Vuelo;
import co.com.tdea.helper.MaestroAerolinea;
import co.com.tdea.helper.MaestroVuelo;

import java.util.Scanner;

public class Main {
    static public Aerolineas aerolineas = new Aerolineas();

    public static void main(String[] args) {
        boolean exit = false;
        MaestroAerolinea maestro = new MaestroAerolinea(aerolineas);
        MaestroVuelo maestroVuelos = new MaestroVuelo(aerolineas);
        do
        {
            System.out.println("-------------------------");
            System.out.println("1: Maestro Aerolineas");
            System.out.println("2: Maestro Vuelos");
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
                      maestro.mostrarMenu();
                      break;
              }
        }
        while(!exit);
        System.out.println("---- Programa terminado ----");
    }


}
