package com.carlesramos.bicicletas.libreria;
import java.util.*;
public class Lib{

    /**
     * Metodo para crear menú
     * @param cabeceraMenu passamos un String con nombre menú
     * @param s vector con elementos del menu
     * @param opcionSalida String opcion de salida
     */
    public static void mosrtrarMenu(String cabeceraMenu, String [] s, String opcionSalida){
        System.out.println("\u001B[H\u001B[2J");
        for(int i=0; i<cabeceraMenu.length(); i++){
            System.out.print("*");
        }
        System.out.println();
        System.out.println(cabeceraMenu);
        for(int i=0; i<cabeceraMenu.length(); i++){
            System.out.print("*");
        }
        System.out.println();
        for(int i=0; i<s.length; i++){
            System.out.println((i+1)+"- "+s[i]);
        }
        for(int i=0; i<cabeceraMenu.length(); i++){
            System.out.print("*");
        }
        System.out.println();
        System.out.println("0- "+opcionSalida);
        System.out.print("ELIJA UNA OPCIÓN: ");
    }

    final static float PI = 3.1416f;
    //Sumar dos números.
    public static int suma (int a, int b){
        return a+b;
    }
    //Calcular area de un cercle.
    public static float area(float radio ){

        return PI*(radio*radio);
    }
    //Calcular Longitud de un cercle.
    public static float longitud(float radio){
        return 2*PI*radio;
    }
    //Calcular major/menor entre dos enters.
    public static int mayorMenor(int numA, int numB){
        if (numA>numB){
            return numA;
        }
        else{
            return numB;
        }
    }
    //Calcular major menor entre cuatre enters.
    public static int majorMenor(int numA,int numB,int numC,int numD){

        int resultat=0;
        //filtrem per a conseguir el major de cuatre valors introduits pel usuari.
        if (numA>numB && numA>numC && numA>numD){
            resultat=numA;
        }
        else if (numB>numA && numB>numC && numB>numD){
            resultat=numB;
        }
        else if (numC>numA && numC>numB && numC>numD){
            resultat=numC;
        }
        else if(numD>numA && numD>numB && numD>numC){
            resultat=numD;
        }
        //retornem el valor.
        return resultat;
    }
    //Repetir una lletra n voltes.
    public static void repetirLletra(char lletra,int num ) {
        //bucle per repetir la lletra.
        for(int i=0; i<num; i++){
            System.out.print(lletra);
        }
        System.out.println();
    }
    //Repetir una lletra n voltes n files.
    public static void repetirLletraFiles(int repeticions,int botsDeLinea,char lletra) {
        int contador=0;
        //bucle per fer els bot de linea.
        do{
            //bucle per imprimir les files de lletres.
            for(int i=0; i<repeticions; i++){
                System.out.print(lletra);
            }
            //Fem els bots de linea.
            System.out.println();
            contador++;
        }while(contador<botsDeLinea);
    }
    //calcular el factorial de un numero.
    public static int factorial(int numFact){
        int factorial=1;
        for (int i=1; i<=numFact; i++){
            factorial*=i;
        }
        return factorial;
    }
    //saber si un numero es capicua.
    public static void capICua(int numA,int numB,int numC, int numD){
        if (numA==numD && numB==numC){
            System.out.println("El numero es cap i cua!!");
        }
        else{
            System.out.println("El numero no es cap i cua...");
        }
    }
    //Calcular el sumatori de un enter.
    public static int sumatori(int num){
        int sumatoriR=0;
        for (int i=num; i>0; i--){
            sumatoriR+=i;
        }
        return sumatoriR;
    }
    //Imprimir taula de multiplicar de un enter.
    public static void tabla(int num){
        for (int i=0; i<=10; i++){
            System.out.println(num + "x" + i + "=" + num*i);
        }
    }
    //Generar un numero random compres entre dos enters.
    public static int random(int min, int max){
        int aleatori;
        Random rnd=new Random();
        aleatori=rnd.nextInt(max-min+1)+min;
        return aleatori;
    }
    //Imprimir notes convertint donant un real en suficient, be, etc...
    public static void notes(float nota){
        if (nota>=0 && nota<5){
            System.out.print("\u001B[31m INSUFICIENTE\u001B[0m");
        }
        else if (nota>=5 && nota<=6){
            System.out.print("\u001B[33m SUFICIENTE\u001B[0m");
        }
        else if (nota>=6 && nota<7){
            System.out.print("\u001B[34m BIEN\u001B[0m");
        }
        else if(nota>=7 && nota<9){
            System.out.print("\u001B[32m NOTABLE\u001B[0m");
        }
        else if (nota>=9 && nota<=10){
            System.out.print("\u001B[35m SOBRESALIENTE\u001B[0m");
        }
    }
    //Calcular el combinatori de m sobre n.
    public static int combinatorio(int numM,int numN){
        int combinatorioR;
        combinatorioR=Lib.factorial(numM)/((Lib.factorial(numM-numN)*Lib.factorial(numN)));
        return combinatorioR;
    }
    //Calcular el nif partint de un DNI
    public static void nif(int numeroDni){
        int calcularLletra;
        char[]lletres={'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        calcularLletra=numeroDni%23;
        System.out.println("El seu NIF es: " + numeroDni + lletres[calcularLletra]);
    }
    //barra de carrega.
    public static void barraCarrega(){

        for (int i = 0; i <14; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // this part is executed when an exception (in this example
                // InterruptedException) occurs
            }
            System.out.print("\u001B[44m ");
        }
        System.out.println("\u001B[0m");
    }
}
