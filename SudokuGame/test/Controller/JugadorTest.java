package Controller;

import View.ImpressioTaulell;
import View.MockImpressioTaulell;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class JugadorTest {

    @InjectMocks
    private Jugador jugador;
    @Mock
    Scanner sc;

    ImpressioTaulell vista = new MockImpressioTaulell();

    @Test
    void inicialitzaJugadorNormal() {

        vista.setNom("Miquel");
        jugador.inicialitzaJugador(vista);
        Assertions.assertEquals("Miquel", jugador.getNom());
    }

    @Test
    void inicialitzaJugadorNormal2() {
        vista.setNom("mamamamamma");
        jugador.inicialitzaJugador(vista);
        Assertions.assertTrue(jugador.isCorrecte()); //limit dreta valid
    }

    @Test
    void inicialitzaJugadorNomLlarg() {
        vista.setNom("aaaaaaaaaaaaaaaaaaaaaaa");
        jugador.inicialitzaJugador(vista);
        Assertions.assertFalse(jugador.isCorrecte()); //no valid
    }

    //LOOP TESTING (espais/numeros)

    @Test
    void inicialitzaJugadorNomBuit() {
        vista.setNom("");
        jugador.inicialitzaJugador(vista);
        Assertions.assertFalse(jugador.isCorrecte()); //no valid (evita loop testing)
    }

    @Test
    void inicialitzaJugador1Pasada() {
        vista.setNom(" Miquel");
        jugador.inicialitzaJugador(vista);
        Assertions.assertFalse(jugador.isCorrecte()); //1 pasada pel bucle
    }

    @Test
    void inicialitzaJugador1Pasada_v2() {
        vista.setNom("1234");
        jugador.inicialitzaJugador(vista);
        Assertions.assertFalse(jugador.isCorrecte()); //1 pasada pel bucle
    }

    @Test
    void inicialitzaJugador2Pasades() {
        vista.setNom("M iquel");
        jugador.inicialitzaJugador(vista);
        Assertions.assertFalse(jugador.isCorrecte()); //2 pasada pel bucle
    }

    @Test
    void inicialitzaJugador2Pasades_v2() {
        vista.setNom("M1iquel");
        jugador.inicialitzaJugador(vista);
        Assertions.assertFalse(jugador.isCorrecte()); //2 pasada pel bucle i limit esquerre no valid
    }

    @Test
    void inicialitzaJugador4Pasades() {
        vista.setNom("Miq uel");
        jugador.inicialitzaJugador(vista);
        Assertions.assertFalse(jugador.isCorrecte()); //4 pasada pel bucle
    }

    @Test
    void inicialitzaJugador4Pasades_v2() {
        vista.setNom("Miq4uel");
        jugador.inicialitzaJugador(vista);
        Assertions.assertFalse(jugador.isCorrecte()); //4 pasada pel bucle
    }


    @Test
    void inicialitzaJugadorN_Max_1Pasades() {
        vista.setNom("Mique l");
        jugador.inicialitzaJugador(vista);
        Assertions.assertFalse(jugador.isCorrecte()); //n-max-1 pasada pel bucle
    }

    @Test
    void inicialitzaJugadorN_Max_1Pasades_v2() {
        vista.setNom("Mique9l");
        jugador.inicialitzaJugador(vista);
        Assertions.assertFalse(jugador.isCorrecte()); //n-max-1 pasada pel bucle
    }

    @Test
    void inicialitzaJugadorN_MaxPasades() {
        vista.setNom("Miquel ");
        jugador.inicialitzaJugador(vista);
        Assertions.assertFalse(jugador.isCorrecte()); //n-max pasada pel bucle
    }

    @Test
    void inicialitzaJugadorN_MaxPasades_v2() {
        vista.setNom("Miquel7");
        jugador.inicialitzaJugador(vista);
        Assertions.assertFalse(jugador.isCorrecte()); //n-max pasada pel bucle*/
    }

    @Test
    void provaMockJugador(){
        MockJugador j = new MockJugador();
        j.setNom("Marc");
        Assertions.assertTrue(jugador.setNom(j.getNom()));
    }

    @Test
    void provaMockJugadorError(){
        MockJugador j = new MockJugador();
        j.setNom("Marc ");
        Assertions.assertFalse(jugador.setNom(j.getNom()));
    }
}