package test;
import com.jaume.penjat.Puntuacio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PuntuacioTest {
    private Puntuacio puntuacio;

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void getParaulaSecretaDificultat(int dificultat) {
        Puntuacio puntuacio = new Puntuacio();
        puntuacio.getParaulaSecretaDificultat(dificultat);
        int vides = 0;
        switch (dificultat) {
            case 1:
                dificultat = 1;
                vides = 5;
                break;
            case 2:
                dificultat = 2;
                vides = 4;
                break;
            case 3:
                dificultat = 3;
                vides = 3;
                break;
            default:
                break;
        }
        Assertions.assertEquals(dificultat, puntuacio.getDificultat());
    }
    @Test
    public void getIntentsNivel1(){
        Puntuacio puntuacio = new Puntuacio();
        puntuacio.getParaulaSecretaDificultat(1);
        Assertions.assertTrue(puntuacio.getIntents()==5, "Fallo de intentos");
    }
    @Test
    public void getIntentsNivel2() {
        Puntuacio puntuacio = new Puntuacio();
        puntuacio.getParaulaSecretaDificultat(2);
        Assertions.assertTrue(puntuacio.getIntents() == 4, "Fallo de intentos");
    }
    @Test
    public void getIntentsNivel3(){
        Puntuacio puntuacio=new Puntuacio();
        puntuacio.getParaulaSecretaDificultat(3);
        Assertions.assertTrue(puntuacio.getIntents()==3, "Fallo de intentos");
    }

    @Test
    void comprobarPuntuacion(){
        String paraulaSecreta = this.puntuacio.getParaulaSecretaDificultat(1);
        assertNotEquals( 0, this.puntuacio.calcularPuntuacio(new String[]{paraulaSecreta},0));
    }

    @Test
    void comprobarPuntuacionAlta(){
        String paraulaSecreta = this.puntuacio.getParaulaSecretaDificultat(1);
        assertNotEquals( 0, this.puntuacio.calcularPuntuacio(new String[]{paraulaSecreta},5));
    }

    /*Comprobar el tiempo */

    @Test
    public  void getTime(){
        this.puntuacio.getParaulaSecretaDificultat(1);
        puntuacio.calcularPuntuacio(new String[1],0);
        Assertions.assertNotNull(puntuacio.getTemps());
        System.out.println(puntuacio.getTemps());
    }



}
