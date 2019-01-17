package com.carlesramos.bicicletas.exercici06;
import com.carlesramos.bicicletas.libreria.Lib;
import java.util.Scanner;
public class Principal06 {
    static int contadorBicicleta;//contenedor objectes
    static Bicicleta biciAux = new Bicicleta();
    static Scanner lec = new Scanner(System.in);
    static  Bicicleta [] contenedorBici = new Bicicleta[100];
    public Principal06(){
        String [] menu1 = {"Añadir bicicleta...","Vender bicicleta...","Consultar bicicleta...","Mostrar estoc..."};
        int eleccionMenu1;
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
                    crearBicicleta();
                    break;
            }
        }while(eleccionMenu1!=0);

    }

    public static void crearBicicleta(){
        int ref;
        boolean condicion=true;
        String siONo;
        String dataFabricacio;
        do{
            System.out.print("Introduzca la referencia: ");
            ref=lec.nextInt();
            lec.nextLine();
            for(int i=0; i<contadorBicicleta; i++){
                if (ref==contenedorBici[i].getReferencia()){
                    System.out.println("\u001B[31mDato incorrecto.....\u001B[0m");
                    System.out.print("Pulse intro para continuar....");
                    lec.nextLine();
                }
            }
        }while(ref==biciAux.getReferencia());
        biciAux.setReferencia(ref);
        System.out.print("Introduzca la marca: ");
        biciAux.setMarca(lec.nextLine());
        System.out.print("Introduzca el modelo: ");
        biciAux.setModel(lec.nextLine());
        System.out.print("Introduzca el peso: ");
        biciAux.setPes(lec.nextFloat());
        lec.nextLine();
        System.out.print("Introduzca el tamaño de las ruedas: ");
        biciAux.setGrandariaRodes(lec.nextFloat());
        lec.nextLine();
        do {
            System.out.print("Tiene motor?: pulse \"s\" para si o \"n\" para no: ");
            siONo = lec.nextLine();
            if (siONo.equalsIgnoreCase("n")) {
                biciAux.setTeMotor(false);
                condicion = true;
            }
            else if(siONo.equalsIgnoreCase("s")) {
                biciAux.setTeMotor(true);
                condicion = true;
            }
            else if(siONo.charAt(0)!='s'|| siONo.charAt(0)!='S'
                    || siONo.charAt(0)!='n'|| siONo.charAt(0)!='N'){
                System.out.println("\n\u001B[31mDato incorrecto.....\u001B[0m");
                System.out.print("Pulse intro para continuar....");
                lec.nextLine();
                condicion=false;
            }
        }while (!condicion);
        do{
            System.out.print("Introduzca la fecha de babricación: ");
            dataFabricacio=lec.nextLine();
            biciAux.setDataFabricació(dataFabricacio);
            if(dataFabricacio.length()==10){
                biciAux.setDataFabricació(dataFabricacio);
                condicion = true;
            }
            else{
                System.out.println("\n\u001B[31mDato incorrecto.....\u001B[0m");
                System.out.println("Recuerde introducir la fecha en formato DD-MM-AAAA");
                System.out.print("Pulse intro para continuar....");
                lec.nextLine();
                condicion=false;
            }
        }while(!condicion);

    }

}