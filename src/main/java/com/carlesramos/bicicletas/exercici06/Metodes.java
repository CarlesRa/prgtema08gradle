package com.carlesramos.bicicletas.exercici06;
import com.carlesramos.bicicletas.libreria.Lib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Metodes {
    static  int ref;
    static int puntero=0;
    static Bicicleta biciAux = new Bicicleta();

    public void crearBicicleta(){
        String [] menu={"Montaña","Carretera","Híbrida","Infantil"};
        int contadorMontaña=0;
        int contadorCarretera=0;
        int contadorHibrida=0;
        int contadorInfantil=0;
        boolean condicion=true;
        String siONo;
        String dataFabricacio;
        int eleccionModelo;
        do{
            System.out.print("Introduzca la referencia: ");
            ref=Principal06.lec.nextInt();
            Principal06.lec.nextLine();
            for(int i=0; i<Principal06.contadorBicicleta; i++){
                if (ref==Principal06.contenedorBici[i].getReferencia()){
                    System.out.println("\u001B[31mDato incorrecto.....\u001B[0m");
                    System.out.print("Pulse intro para continuar....");
                    Principal06.lec.nextLine();
                }
            }
        }while(ref==biciAux.getReferencia());
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
                    biciAux.setNombreExistencies(contadorMontaña);

                    break;
                case 2:
                    biciAux.setModel(Bicicleta.Model.CARRETERA);
                    contadorCarretera++;
                    biciAux.setNombreExistencies(contadorCarretera);

                    break;
                case 3:
                    biciAux.setModel(Bicicleta.Model.HIBRIDA);
                    contadorHibrida++;
                    biciAux.setNombreExistencies(contadorHibrida);

                    break;
                case 4:
                    biciAux.setModel(Bicicleta.Model.INFANTIL);
                    contadorInfantil++;
                    biciAux.setNombreExistencies(contadorInfantil);

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
        biciAux.toString();
        puntero++;

    }

    public void venderBicicleta(){
        int referencia;
        System.out.print("Que referencia?: ");
        ref = Principal06.lec.nextInt();
        Principal06.lec.nextLine();
        for(int i=0; i<puntero; i++){
            if(Principal06.contenedorBici[i].getReferencia()==ref&&
                    Principal06.contenedorBici[i].getNombreExistencies()>0){
                System.out.println("Bicicleta vendida con exito....");
                System.out.print("Pulse intro para continuar: ");
                Principal06.lec.nextLine();
                for(int x=1; x<puntero; x++){
                    Principal06.contenedorBici[x] = Principal06.contenedorBici[x+1];
                }
                puntero--;

            }
        }
    }

    public void consultarPorReferencia(){
        int contador=0;
        System.out.print("Introduzca la referencia: ");
        ref=Principal06.lec.nextInt();
        Principal06.lec.nextLine();
        for(int i=0; i<puntero; i++)
            if (Principal06.contenedorBici[i].getReferencia() == ref) {
                System.out.println(Principal06.contenedorBici[i].toString());
            }
        if(contador==0){
            System.out.println("\u001B[31mNo hay existencias con esa referencia...\u001B[0m");
        }
    }

    public void consultarPorMarca(){
        int contador=0;
        String marca;
        System.out.print("Introduzca la marca: ");
        marca=Principal06.lec.nextLine();
        for(int i=0; i<puntero; i++)
            if (Principal06.contenedorBici[i].getMarca().equalsIgnoreCase(marca)) {
                System.out.println(Principal06.contenedorBici[i].toString());
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
                    for (int i = 0; i < puntero; i++)
                        if (Principal06.contenedorBici[i].getModel() == Bicicleta.Model.MONTAÑA) {
                            System.out.println(Principal06.contenedorBici[i].toString());

                        }

                    break;
                case 2:
                    for (int i = 0; i < puntero; i++)
                        if (Principal06.contenedorBici[i].getModel() == Bicicleta.Model.CARRETERA) {
                            System.out.println(Principal06.contenedorBici[i].toString());

                        }
                    break;
                case 3:
                    for (int i = 0; i < puntero; i++)
                        if (Principal06.contenedorBici[i].getModel() == Bicicleta.Model.HIBRIDA) {
                            System.out.println(Principal06.contenedorBici[i].toString());

                        }
                    break;
                case 4:
                    for (int i = 0; i < puntero; i++)
                        if (Principal06.contenedorBici[i].getModel() == Bicicleta.Model.INFANTIL) {
                            System.out.println(Principal06.contenedorBici[i].toString());

                        }
                    break;
                default:
                    System.out.println("\u001B[31mDato incorrecto.....\u001B[0m");
                    System.out.print("Pulse intro para continuar....");
                    Principal06.lec.nextLine();
            }

            if (contador == 0) {
                System.out.println("\u001B[31mNo hay existencias con este modelo...\u001B[0m");
            }
        }while(eleccionModelo<0 || eleccionModelo>4);
    }

    public void mostrarStock(){
        for(int i=0; i<puntero; i++){
            System.out.println(Principal06.contenedorBici[i].toString());
            System.out.print("Pulse intro para continuar....");
            Principal06.lec.nextLine();
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
        String []noms={"Pepe","Juan","Maria","Paulina","Colet","Violet","Pam","Carlos"};
        String []marcas={"Ramirez","Rodenas","Guarde","Ramos","Moll","Pastor","Rossel"};
        String []dates={"15-08-1982","12-04-2000","25-06-2010","12-02-2004"};

        for(int i=0; i<50; i++){
            nom=noms[Lib.random(0, noms.length-1)];
            marca=marcas[Lib.random(0, marcas.length-1)];
            dataFabricacio=dates[Lib.random(0,dates.length-1)];
            pes=Lib.random(20, 40);
            switch (selectorModel){
                case 1:
                    biciAux.setModel(Bicicleta.Model.MONTAÑA);
                    break;
                case 2:
                    biciAux.setModel((Bicicleta.Model.CARRETERA));
                    break;
                case 3:
                    biciAux.setModel(Bicicleta.Model.HIBRIDA);
                    break;
                case 4:
                    biciAux.setModel((Bicicleta.Model.INFANTIL));
                    break;
            }
            grandariaRodes = Lib.random(10,50);
            if(selectorModel==1 || selectorModel==3){
                biciAux.setTeMotor(true);
            }
            else{
                biciAux.setTeMotor(false);
            }
            preu = Lib.random(100,900);
            biciAux.setReferencia(i);
            biciAux.setMarca(marca);
            biciAux.setPes(pes);
            biciAux.setGrandariaRodes(grandariaRodes);
            biciAux.setDataFabricacio(dataFabricacio);
            biciAux.setPreu(preu);
            if(selectorModel==4){
                selectorModel=1;
            }
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
