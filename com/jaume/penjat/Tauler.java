package com.jaume.penjat;

public class Tauler {
    /**
     * Define los datos del private
     */

    private char[] paraulaSecreta;
    private String[] palabraEndevinada;
    private int intents;
    private int totalIntents;

    public char[] getParaulaSecreta() {
        return paraulaSecreta;
    }

    public int getIntents() {
        return intents;
    }

    public int getTotalIntents() {
        return totalIntents;
    }

    public String[] getPalabraEndevinada() {
        return palabraEndevinada;
    }

    public void setPalabraEndevinada(String[] palabraEndevinada) {
        this.palabraEndevinada = palabraEndevinada;
    }

    public void setIntents(int intents) {
        this.intents = intents;
    }

    public void setParaulaSecreta(char[] paraulaSecreta) {
        this.paraulaSecreta = paraulaSecreta;
    }

    public void setTotalIntents(int totalIntents) {
        this.totalIntents = totalIntents;
    }

    /**
     * Inicializacion del metodo constructor Tauler();
     */

    public Tauler() {
        paraulaSecreta = new char[0];
        palabraEndevinada = new String[0];
        intents = 0;
        totalIntents = 0;
    }

    /**
     *  Parametros
     * @param p nos incluira una palabra
     * @param i nos incluira el numero de intentos que tenemos
     */

    public void inicialitzarPartida(String p, int i){
        paraulaSecreta = new char[p.length()];
        for (int n = 0; n < p.length(); n++) {
            paraulaSecreta[n] = p.charAt(n) ;
        }
        palabraEndevinada = new String[p.length()];
        for (int n = 0; n < p.length(); n++) {
            if(p.charAt(n) == new Character(' ')){
                palabraEndevinada[n] = " " ;
            }
        }
        intents = i;
        totalIntents = i;

    }

    /**
     *  Metodo constructor imprimir()
     * @return resultados
     *
     */

    public String imprimir() {
        String result = "";
        for (int i = 0; i < palabraEndevinada.length; i++) {
            if (palabraEndevinada[i] == null) {
                result = result+"_";
            }else if(palabraEndevinada[i] == " "){
                result = result+" ";
            }else {
                result = result+palabraEndevinada[i];
            }
        }
        return result;
    }

    /**
     *  Verificacion de las letras
     * @param letra pondra la letra introducida por el usurio
     * @return respuesta de si la letra existe o no
     */

    public String verificar(String letra) {
        if(letra.length() > 1){
            return "Lletra incorrecte";
        }else{
            boolean exist = false;
            for (int i = 0; i < paraulaSecreta.length; i++) {
                if (paraulaSecreta[i] == letra.charAt(0)) {
                    exist = true;
                    palabraEndevinada[i] = letra;
                }
            }
            if(!exist){
                restarIntent();
            }
        }
        return"";
    }

    /**
     * Imprimir vidas nos da el numero de vidas que tiene el usuario en ese momento
     * @return numero de vidas
     */

    public String imprimirVides(){
        String message = String.format("Et queden %s vides de %s",intents, totalIntents);
        if(intents == 1) message = String.format("Et queda %s vida de %s",intents, totalIntents);
        return message;
    }

    /**
     * Metodo que nos sirve de las vidas los intentos
     */

    public void restarIntent() {
        this.intents--;
    }

    /**
     * hasGuanyat nos da si el usuario gano o pedido
     * @return
     */

    public boolean hasGuanyat() {
        boolean valor = true;
        for (int i = 0; i < palabraEndevinada.length; i++) {
            if (palabraEndevinada[i] == null) {
                return false;
            }
        }
        return valor;
    }

}
