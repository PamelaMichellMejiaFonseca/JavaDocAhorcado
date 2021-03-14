package com.jaume.penjat;

import java.awt.*;

/**
 * @autor Pamela Mejia Fonseca
 *  1ro Daw
 *  JavaDoc Ahorcado
 * @version 05/03/2021
 */

public class Penjat {
    /**
     *
     * @param args no da los parametros para ejecutar
     *             para que se almacen los datos
     */

    public static void main(String[] args) {
        Tauler tauler = new Tauler();
        Puntuacio puntuacio = new Puntuacio();
        float total = 0f;
        int partides = 0;
        String participant = "";
        boolean continuar = true;
        /**
         * makeQuestion pedimos al usurio que conteste una serie de preguntas
         * como son el nombre, dificultad con la que quiere juegar.
         */

        participant = Util.makeQuestion("Com te noms? ");

        while (continuar ){
            String dificultat = Util.makeQuestion("Selecciona la dificultat");
            while(!Util.isNumeric(dificultat)){
                dificultat = Util.makeQuestion("Selecciona la dificultat");
            }
            String paraula = puntuacio.getParaulaSecretaDificultat(Integer.parseInt(dificultat));
            tauler.inicialitzarPartida(paraula, puntuacio.getIntents());
            System.out.println(tauler.imprimir());
            while (!tauler.hasGuanyat() && tauler.getIntents() > 0) {
                System.out.println(tauler.imprimirVides());
                String letra = Util.makeQuestion("Indica la lletra");
                System.out.println(tauler.verificar(letra));
                System.out.println(tauler.imprimir());
            }
            /**
             * Con el el if indicamos en que estado del juego se encuentra el jugador,
             * llevando un control de las acciones si a ganado o no, con los metedos de
             * de la calse Tauler y Puntuacio
             */
            if (tauler.hasGuanyat()) {
                System.out.println("Ho has encertat");
            }else{
                System.out.println("Has perdut");
            }
            float p = puntuacio.calcularPuntuacio(tauler.getPalabraEndevinada(),tauler.getIntents());
            System.out.println("Has tardat "+puntuacio.getTemps() +" segons");
            System.out.println(participant+ " has aconseguit "+p +" punts");
            total += p;
            partides++;
            continuar = (Util.makeQuestion("Vols tornar a jugar? (si/no)").equals("si"));
        }
        /**
         * System.out.println(); nos imprime los resultados obtenidos al final del juego
         */

        System.out.println("");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Has aconseguit un total de  "+total +" punts amb "+partides+" partides.");
        System.out.println("-----------------------------------------------------------------------");
    }

}
