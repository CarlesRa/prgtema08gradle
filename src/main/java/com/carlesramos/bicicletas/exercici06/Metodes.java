package com.carlesramos.bicicletas.exercici06;
import com.carlesramos.bicicletas.libreria.Lib;
import java.util.Arrays;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Metodes {
    static  int ref;
    static int puntero=0;
    static Bicicleta biciAux = new Bicicleta();
    static int contadorMontaña=0;
    static int contadorCarretera=0;
    static int contadorHibrida=0;
    static int contadorInfantil=0;
    public void crearBicicleta(){
        String [] menu={"Montaña","Carretera","Híbrida","Infantil"};
        String siONo;
        String dataFabricacio;
        int eleccionModelo;
        boolean condicion;
        do{
            condicion=false;
            System.out.print("Introduzca la referencia: ");
            ref=Principal06.lec.nextInt();
            Principal06.lec.nextLine();
            for(int i=0; i<puntero; i++){
                if (ref==Principal06.contenedorBici[i].getReferencia()){
                    System.out.println("\u001B[31mDato incorrecto.....\u001B[0m");
                    System.out.print("Pulse intro para continuar....");
                    Principal06.lec.nextLine();
                    condicion=true;
                }
            }
        }while(condicion);
        biciAux.setReferencia(ref);
        System.out.print("Introduzca la marca: ");
        biciAux.setMarca(Principal06.lec.nextLine());
        do {
            Lib.mosrtrarMenu("** SELECCIÓN DE MODELO **"
                    , menu, "");

            eleccionModelo = Principal06.lec.nextInt();
            Principal06.lec.nextLine();

            switch (eleccionModelo) {
                case 1:
                    biciAux.setModel(Bicicleta.Model.MONTAÑA);
                    contadorMontaña++;
                   // biciAux.setNombreExistencies(contadorMontaña);

                    break;
                case 2:
                    biciAux.setModel(Bicicleta.Model.CARRETERA);
                    contadorCarretera++;
                    //biciAux.setNombreExistencies(contadorCarretera);

                    break;
                case 3:
                    biciAux.setModel(Bicicleta.Model.HIBRIDA);
                    contadorHibrida++;
                   // biciAux.setNombreExistencies(contadorHibrida);

                    break;
                case 4:
                    biciAux.setModel(Bicicleta.Model.INFANTIL);
                    contadorInfantil++;
                   // biciAux.setNombreExistencies(contadorInfantil);

                    break;
                default:
                    System.out.println("\u001B[31mDato incorrecto.....\u001B[0m");
                    System.out.print("Pulse intro para continuar....");
                    Principal06.lec.nextLine();
            }
        }while ((eleccionModelo<0 || eleccionModelo>4));
        System.out.print("Introduzca el peso: ");
        biciAux.setPes(Principal06.lec.nextFloat());
        Principal06.lec.nextLine();
        System.out.print("Introduzca el tamaño de las ruedas: ");
        biciAux.setGrandariaRodes(Principal06.lec.nextFloat());
        Principal06.lec.nextLine();
        do {
            System.out.print("Tiene motor?: pulse \"s\" para si o \"n\" para no: ");
            siONo = Principal06.lec.nextLine();
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
                Principal06.lec.nextLine();
                condicion = false;
            }
        }while (!condicion);
        do{
            System.out.print("Introduzca la fecha de fabricación: ");
            dataFabricacio=Principal06.lec.nextLine();
            condicion = validarFecha(dataFabricacio);
            if(condicion){
                biciAux.setDataFabricacio(dataFabricacio);
                condicion = true;
            }
            else{
                System.out.println("\n\u001B[31mDato incorrecto.....\u001B[0m");
                System.out.println("Recuerde introducir la fecha en formato DD-MM-AAAA");
                System.out.print("Pulse intro para continuar....");
                Principal06.lec.nextLine();
                condicion = false;
            }
        }while(!condicion);
        System.out.print("Introduzca el precio: ");
        biciAux.setPreu(Principal06.lec.nextInt());
        Principal06.lec.nextLine();
        Principal06.contenedorBici[puntero]=biciAux;
        puntero++;

    }

    public void venderBicicleta(){
        int referencia;
        int contadorAux=0;
        System.out.print("Que referencia?: ");
        referencia= Principal06.lec.nextInt();
        Principal06.lec.nextLine();
        for(int i=0; i<puntero; i++){
            if(Principal06.contenedorBici[i].getReferencia()==referencia){
                contadorAux++;
                if (Principal06.contenedorBici[i].getModel() == Bicicleta.Model.CARRETERA) {
                    contadorCarretera--;
                }
                if (Principal06.contenedorBici[i].getModel() == Bicicleta.Model.MONTAÑA) {
                    contadorMontaña--;
                }
                if (Principal06.contenedorBici[i].getModel() == Bicicleta.Model.HIBRIDA) {
                    contadorHibrida--;
                }
                if (Principal06.contenedorBici[i].getModel() == Bicicleta.Model.INFANTIL) {
                    contadorInfantil--;
                }
                System.out.println("Bicicleta vendida con exito....");
                System.out.print("Pulse intro para continuar: ");
                Principal06.lec.nextLine();
                for(int x=i; x<puntero; x++){
                    Principal06.contenedorBici[x] = Principal06.contenedorBici[x+1];
                }
                puntero--;

            }
        }
        if(contadorAux==0){
            System.out.println("Ninguna bicicleta con esa referencia");
            System.out.print("Pulse intro para continuar: ");
            Principal06.lec.nextLine();
        }
    }

    public void consultarPorReferencia(){
        boolean condiciones=false;
        int i=0;
        System.out.print("Introduzca la referencia: ");
        ref=Principal06.lec.nextInt();
        Principal06.lec.nextLine();
        for(i=0; i<puntero; i++) {
            if (Principal06.contenedorBici[i].getReferencia() == ref) {
                if (Principal06.contenedorBici[i].getModel() == Bicicleta.Model.CARRETERA) {
                    System.out.println(Principal06.contenedorBici[i].toString() + " Existencias=" + contadorCarretera);
                }
                if (Principal06.contenedorBici[i].getModel() == Bicicleta.Model.MONTAÑA) {
                    System.out.println(Principal06.contenedorBici[i].toString() + " Existencias=" + contadorMontaña);
                }
                if (Principal06.contenedorBici[i].getModel() == Bicicleta.Model.HIBRIDA) {
                    System.out.println(Principal06.contenedorBici[i].toString() + " Existencias=" + contadorHibrida);
                }
                if (Principal06.contenedorBici[i].getModel() == Bicicleta.Model.INFANTIL) {
                    System.out.println(Principal06.contenedorBici[i].toString() + " Existencias=" + contadorInfantil);
                }
                condiciones=true;
            }
        }
        if(!condiciones){
            System.out.println("\u001B[31mNo hay existencias con esa referencia...\u001B[0m");
            i=puntero;
        }
    }

    public void consultarPorMarca() {
        int contador = 0;
        String marca;
        System.out.print("Introduzca la marca: ");
        marca = Principal06.lec.nextLine();
        for (int i = 0; i < puntero; i++) {
            if (Principal06.contenedorBici[i].getMarca().equalsIgnoreCase(marca)) {
                if (Principal06.contenedorBici[i].getModel() == Bicicleta.Model.CARRETERA) {
                    System.out.println(Principal06.contenedorBici[i].toString() + " Existencias=" + contadorCarretera);
                }
                if (Principal06.contenedorBici[i].getModel() == Bicicleta.Model.MONTAÑA) {
                    System.out.println(Principal06.contenedorBici[i].toString() + " Existencias=" + contadorMontaña);
                }
                if (Principal06.contenedorBici[i].getModel() == Bicicleta.Model.HIBRIDA) {
                    System.out.println(Principal06.contenedorBici[i].toString() + " Existencias=" + contadorHibrida);
                }
                if (Principal06.contenedorBici[i].getModel() == Bicicleta.Model.INFANTIL) {
                    System.out.println(Principal06.contenedorBici[i].toString() + " Existencias=" + contadorInfantil);
                }
                contador++;
            }
        }
        if(contador==0){
            System.out.println("\u001B[31mNo hay existencias con esta marca...\u001B[0m");
        }
    }

    public void consultarPorModelo() {
        String[] menu = {"Montaña", "Carretera", "Híbrida", "Infantil"};
        int eleccionModelo;
        int contador = 0;
        do {
            Lib.mosrtrarMenu("** SELECCIÓN DE MODELO **"
                    , menu, "");

            eleccionModelo = Principal06.lec.nextInt();
            Principal06.lec.nextLine();

            switch (eleccionModelo) {
                case 1:
                    for (int i = 0; i < puntero; i++) {
                        if (Principal06.contenedorBici[i].getModel() == Bicicleta.Model.MONTAÑA) {
                            System.out.println(Principal06.contenedorBici[i].toString() + " Existencias=" + contadorMontaña);
                            contador++;
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < puntero; i++) {
                        if (Principal06.contenedorBici[i].getModel() == Bicicleta.Model.CARRETERA) {
                            System.out.println(Principal06.contenedorBici[i].toString() + " Existencias=" + contadorCarretera);
                            contador++;
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < puntero; i++) {
                        if (Principal06.contenedorBici[i].getModel() == Bicicleta.Model.HIBRIDA) {
                            System.out.println(Principal06.contenedorBici[i].toString() + " Existencias=" + contadorHibrida);
                            contador++;
                        }
                    }
                    break;
                case 4:
                    for (int i = 0; i < puntero; i++) {
                        if (Principal06.contenedorBici[i].getModel() == Bicicleta.Model.INFANTIL) {
                            System.out.println(Principal06.contenedorBici[i].toString() + " Existencias=" + contadorInfantil);
                            contador++;
                        }
                    }
                    break;
                default:
                    System.out.println("\u001B[31mDato incorrecto.....\u001B[0m");
                    break;
            }

            if (contador == 0) {
                System.out.println("\u001B[31mNo hay existencias con este modelo...\u001B[0m");
            }
        }while(eleccionModelo<0 || eleccionModelo>4);
    }

    public void mostrarStock(){
        for(int i=0; i<puntero; i++){
            if(Principal06.contenedorBici[i].getModel()==Bicicleta.Model.CARRETERA) {
                System.out.println(Principal06.contenedorBici[i].toString()+" Existencias="+contadorCarretera);
            }
            if(Principal06.contenedorBici[i].getModel()==Bicicleta.Model.MONTAÑA) {
                System.out.println(Principal06.contenedorBici[i].toString()+" Existencias="+contadorMontaña);
            }
            if(Principal06.contenedorBici[i].getModel()==Bicicleta.Model.HIBRIDA) {
                System.out.println(Principal06.contenedorBici[i].toString()+" Existencias="+contadorHibrida);
            }
            if(Principal06.contenedorBici[i].getModel()==Bicicleta.Model.INFANTIL) {
                System.out.println(Principal06.contenedorBici[i].toString()+" Existencias="+contadorInfantil);
            }
        }
    }

    public void generarBicicletas(){
        String nom;
        String marca;
        String model;
        int selectorModel=1;
        int pes;
        float grandariaRodes;
        int preu;
        String dataFabricacio;
        String []marcas={"Ramirez","Rodenas","Guarde","Ramos","Moll","Pastor","Rossel"};
        String []dates={"15-08-1982","12-04-2000","25-06-2010","12-02-2004"};

        for(int i=0; i<17; i++){
            Bicicleta biciAux = new Bicicleta();
            marca=marcas[Lib.random(0, marcas.length-1)];
            dataFabricacio=dates[Lib.random(0,dates.length-1)];
            pes=Lib.random(20, 40);
            switch (selectorModel){
                case 1:
                    biciAux.setModel(Bicicleta.Model.MONTAÑA);
                    contadorMontaña++;
                    //biciAux.setNombreExistencies(contadorMontaña);

                    break;
                case 2:
                    biciAux.setModel((Bicicleta.Model.CARRETERA));
                    contadorCarretera++;
                   // biciAux.setNombreExistencies(contadorCarretera);
                    break;
                case 3:
                    biciAux.setModel(Bicicleta.Model.HIBRIDA);
                    contadorHibrida++;
                  //  biciAux.setNombreExistencies(contadorHibrida);
                    break;
                case 4:
                    biciAux.setModel((Bicicleta.Model.INFANTIL));
                    contadorInfantil++;
                    //biciAux.setNombreExistencies(contadorInfantil);
                    break;
            }
            grandariaRodes = Lib.random(10,50);
            selectorModel++;
            if(selectorModel==1 || selectorModel==3){
                biciAux.setTeMotor(true);
            }
            else{
                biciAux.setTeMotor(false);
            }
            preu = Lib.random(100,900);
            biciAux.setReferencia(i+1);
            biciAux.setMarca(marca);
            biciAux.setPes(pes);
            biciAux.setGrandariaRodes(grandariaRodes);
            biciAux.setDataFabricacio(dataFabricacio);
            biciAux.setPreu(preu);
            Principal06.contenedorBici[i]=biciAux;
            if(selectorModel==5){
                selectorModel=1;
            }
            puntero++;
        }
    }

    /**
     * Metode per validar dates.
     * @param fecha entra un string amb la data.
     * @return
     */
    public static boolean validarFecha(String fecha) {

        try {

            SimpleDateFormat formatoFecha;
            formatoFecha = new SimpleDateFormat("dd-MM-yyyy");

            formatoFecha.setLenient(false);

            formatoFecha.parse(fecha);

        } catch (ParseException e) {

            return false;

        }

        return true;

    }
}
