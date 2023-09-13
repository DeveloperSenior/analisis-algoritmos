package co.com.tdea.helper;

import co.com.tdea.dominio.Aerolineas;
import co.com.tdea.dto.Aerolinea;

import java.util.Scanner;

public class MaestroPasajero extends MenuBase{

    Aerolineas aerolineas;

    public MaestroPasajero(Aerolineas aerolineas){
        this.aerolineas = aerolineas;
    }

    @Override
    public void mostrarMenu() {
        boolean exit = false;
        do
        {
            System.out.println("----------Maestro reservas---------------");
            System.out.println("1: Comprar pasaje");
            System.out.println("2: Mostrar reserva x Vuelos y Aerolineas");
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
                    comprarPasaje();
                    break;
                case 2:
                    mostrarReservasXAerolineas();
                    break;
            }

        }while(!exit);

    }

    void comprarPasaje(){
        boolean exit = false;
        do {
            aerolineas.mostrarAerolineasReserva();
            System.out.println("Ingrese el código de la aerolinea");
            Scanner sc = new Scanner(System.in);
            String codigoAerolinea = sc.nextLine();

            aerolineas.mostrarVuelosAerolineaReserva(codigoAerolinea);
            System.out.println("Que vuelo quieres reservar? ingresa el codigo");
            String codigoVuelo = sc.nextLine();


            System.out.println("Desea reservar otro vuelo? 1:Si 0: No");
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
            }
        }while (!exit);

    }

    void mostrarReservasXAerolineas(){
    }
}
