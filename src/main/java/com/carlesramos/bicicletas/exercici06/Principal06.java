package com.carlesramos.bicicletas.exercici06;
import com.carlesramos.bicicletas.libreria.Lib;
import java.util.Scanner;
import java.util.Arrays;
public class Principal06 {
    static int contadorBicicleta;//contenedor objectes
    static Scanner lec = new Scanner(System.in);
    static  Bicicleta [] contenedorBici = new Bicicleta[100];
    public Principal06(){
        Metodes m = new Metodes();
        String [] menu1 = {"Añadir bicicleta...","Vender bicicleta...","Consultar bicicleta...","Mostrar estoc..."};
        String [] menu2 = {"Consultar por referencia","Consultar por marca","Consultar por modelo","Mostrar stock"};
        int eleccionMenu1;
        int eleccionMenu2;
        m.generarBicicletas();
        do{
            Lib.mosrtrarMenu("** GESTIÓN DE BICICLETAS **",menu1,"Salir");
            eleccionMenu1 = lec.nextInt();
            lec.nextLine();
            if (eleccionMenu1<0 || eleccionMenu1>menu1.length){
                System.out.println("\u001B[31mDato incorrecto.....\u001B[0m");
                System.out.print("Pulse intro para continuar....");
                lec.nextLine();
            }
            switch (eleccionMenu1){
                case 0:
                    System.out.println("Saliendo de la aplicación....");
                    break;
                case 1:
                    m.crearBicicleta();
                    System.out.println("Bicicleta añadida con éxito pulse intro para continuar: ");
                    lec.nextLine();
                    break;
                case 2:
                    m.venderBicicleta();
                    break;
                case 3:
                    do{
                        Lib.mosrtrarMenu("** CONSULTA BICICLETA **",menu2,"Volver al menú principal");
                        eleccionMenu2=Principal06.lec.nextInt();
                        Principal06.lec.nextLine();
                        switch (eleccionMenu2){
                            case 0:
                                System.out.println("Saliendo de la aplicación....");
                                System.out.print("Intro para salir: ");
                                lec.nextLine();
                                break;
                            case 1:
                                m.consultarPorReferencia();
                                System.out.print("Pulse intro para continuar: ");
                                lec.nextLine();
                                break;
                            case 2:
                                m.consultarPorMarca();
                                System.out.print("Pulse intro para continuar: ");
                                lec.nextLine();
                                break;
                            case 3:
                                m.consultarPorModelo();
                                System.out.print("Pulse intro para continuar: ");
                                lec.nextLine();
                                break;
                            case 4:
                                m.mostrarStock();
                                System.out.print("Pulse intro para continuar: ");
                                lec.nextLine();
                            default:
                                System.out.println("\u001B[31mDato incorrecto.....\u001B[0m");
                                System.out.print("Pulse intro para continuar....");
                                lec.nextLine();
                        }
                    }while (eleccionMenu2<0 || eleccionMenu2>3);
                case 4:

            }
        }while(eleccionMenu1!=0);

    }



}