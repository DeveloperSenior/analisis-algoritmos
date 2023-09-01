package co.com.tdea.helper;

import co.com.tdea.dominio.Aerolineas;
import co.com.tdea.dominio.Pasajeros;
import co.com.tdea.dominio.Vuelos;
import co.com.tdea.dto.Aerolinea;
import co.com.tdea.dto.Vuelo;

import java.util.Scanner;

public class MaestroAerolinea extends MenuBase {

    Aerolineas aerolineas;

    public MaestroAerolinea(Aerolineas aerolineas){
        this.aerolineas = aerolineas;
    }

    @Override
    public void mostrarMenu() {

        boolean exit = false;
        do
        {
            System.out.println("----------Maestro Aerolineas---------------");
            System.out.println("1: Crear Aerolineas");
            System.out.println("2: Actualizar Aerolineas");
            System.out.println("3: Eliminar Aerolineas");
            System.out.println("4: Mostrar todas las Aerolineas");
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
                    ActualizarAerolineas();
                    break;
                case 3:
                    eliminarAerolineas();
                    break;
                case 4:
                    mostrarAerolineas();
                    break;
            }

        }while(!exit);

    }
    void crearAerolineas(){
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
            this. aerolineas = aerolineas.insertar(aerolinea,vuelos);
            System.out.println("Aerolinea creada con exito ");
            System.out.println("Desea crear otra Aerolinea? 1: Si, 0: No");
            int value = Integer.parseInt(sc.nextLine());
            exit = (value != 1);
        }while(!exit);

    }

    void ActualizarAerolineas(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese codigo de la aerolinea");
        String codigo = sc.nextLine();
        System.out.println("Ingrese el nuevo nombre de la aerolinea");
        String nombre = sc.nextLine();
        this. aerolineas = aerolineas.actualizar(new Aerolinea(codigo,nombre));
        System.out.println("Aerolinea actualizada con exito ");
    }
    void eliminarAerolineas(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese codigo de la aerolinea a eliminar");
        String codigo = sc.nextLine();
        this. aerolineas = aerolineas.eliminar(codigo);
        System.out.println("Aerolinea eliminada con exito ");
    }
    void mostrarAerolineas(){
        aerolineas.mostrarAerolineas();
    }

}
