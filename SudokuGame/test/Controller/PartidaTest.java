package Controller;

import View.ImpressioTaulell;
import View.MockImpressioTaulell;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.configuration.injection.scanner.MockScanner;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class PartidaTest {


    @Test
    void TestJugaPartida() throws InterruptedException {
        MockImpressioTaulell imprimir = new MockImpressioTaulell();
        Partida partida = new Partida();
        Taulell t = new MockTaulell();
        partida.setTaulell(t);
        imprimir.setNom("Miquel");
        imprimir.setFila(1);
        imprimir.setColumna(1);
        imprimir.setValor(2);
        imprimir.setDificultat(1);
        partida.jugaPartida(imprimir);
        //Assertions.assertEquals(resultat,1);
    }


    @Test
    void TestRealitzaJugada() {

        MockImpressioTaulell imprimir = new MockImpressioTaulell();
        Partida partida = new Partida();
        Taulell t = new MockTaulell();
        partida.setTaulell(t);
        imprimir.setNom("Miquel");
        imprimir.setFila(1);
        imprimir.setColumna(1);
        imprimir.setValor(2);
        imprimir.setDificultat(1);
        partida.realitzaJugada(imprimir);
        assertEquals(2, partida.getTaulell().getValorCasella(0,0));
    }

    /*@InjectMocks
    private Jugador jugador;
    @Mock
    Scanner sc;

    @Test
    void inicialitzaJugadorNormal() {
        Mockito.when(sc.nextLine()).thenReturn("Miquel");
        jugador.inicialitzaJugador();
        Assertions.assertEquals("Miquel", jugador.getNom());
        Assertions.assertTrue(jugador.isCorrecte()); //valid
    }*/


    @Test
    void TestValorValid() {
        /*CREEM UNA PARTIDA I LA PORTEM A L'ESTAT DESITJAT PER
         * PROVAR LA FUNCIÓ. CREEM UN TAULELL A TRAVÉS D'UN MOCK*/
        Partida p = new Partida();
        MockTaulell t = new MockTaulell();
        t.setValorCasella(1,1,1);
        p.setTaulell(t);

        // TOTS SÓN TRUE (1A PART DECISION COVERAGE)
        boolean res = p.valorValid(2,8,1);
        Assertions.assertTrue(res);

        //filaValida i subEspaiValid son FALSE, columnaValida es TRUE
        res = p.valorValid(1,2,1);
        Assertions.assertFalse(res);

        //filaValida i subEspaiValid son TRUE, columnaValida es FALSE
        res = p.valorValid(4,1,1);
        Assertions.assertFalse(res);
        /* AMB AQUEST TEST REALITZEM DECISION I CONDITION COVERAGE
         * DEL'S VALORS POSSIBLES QUE POT RETORNAR LA FUNCIÓ*/
    }

    @Test
    void TestFilaValida() {

        Partida p = new Partida();
        MockTaulell t = new MockTaulell();
        t.setValorCasella(1,1,1);
        p.setTaulell(t);

        //comprovem fila amb un valor
        boolean res = p.filaValida(1, 1);
        Assertions.assertFalse(res);

        res = p.filaValida(1,  2);
        Assertions.assertTrue(res);

        res = p.filaValida(1,9);
        Assertions.assertTrue(res);

        res = p.filaValida(1,1);
        Assertions.assertFalse(res);

        //comprovem fila amb dos valors
        t.setValorCasella(1,2,2);

        res = p.filaValida(1,  1);
        Assertions.assertFalse(res);

        res = p.filaValida(1, 2);
        Assertions.assertFalse(res); //Ara aquesta ha de ser false

        res = p.filaValida(1,9);
        Assertions.assertTrue(res);
    }

    @Test
    void TestColumnaValida() {
        Partida p = new Partida();
        MockTaulell t = new MockTaulell();
        t.setValorCasella(1,1,1);
        p.setTaulell(t);

        boolean res = p.columnaValida(1, 1);
        Assertions.assertFalse(res);

        res = p.columnaValida(1, 2);
        Assertions.assertTrue(res);

        res = p.columnaValida(1,9);
        Assertions.assertTrue(res);

        res = p.columnaValida(1,1);
        Assertions.assertFalse(res);
    }

    @Test
    void TestSubEspaiValid() {
        Partida p = new Partida();
        MockTaulell t = new MockTaulell();
        t.setValorCasella(1,1,1);
        p.setTaulell(t);

        // TESTS BÀSICS PER COMPROVAR EL FUNCIONAMENT CORRECTE
        boolean res = p.subEspaiValid(1, 2,2);
        Assertions.assertTrue(res);

        res = p.subEspaiValid(1, 2,1);
        Assertions.assertFalse(res);

        res = p.subEspaiValid(1,8,1);
        Assertions.assertTrue(res);

        res = p.subEspaiValid(4,1,1);
        Assertions.assertTrue(res);

        res = p.subEspaiValid(2,2,1);
        Assertions.assertFalse(res);
    }

    @Test
    void TestSudokuCompletFalse() {
        Partida p = new Partida();
        MockTaulell mockTaulell = new MockTaulell();
        mockTaulell.creaTaulellBuit();
        for (int i = 0; i<5; i++){
            for (int j = 0; j<5; j++){
                mockTaulell.setValorCasella(i, j, (int) (Math.random() * (10 - 1)) + 1);
            }
        }
        p.setTaulell(mockTaulell);
        p.sudokuComplet();
        assertFalse(p.partidaAcabada);
    }

    @Test
    void TestSudokuCompletTrue() {
        Partida p = new Partida();
        MockTaulell mockTaulell = new MockTaulell();
        mockTaulell.creaTaulellBuit();
        for (int i = 0; i<9; i++){
            for (int j = 0; j<9; j++){
                mockTaulell.setValorCasella(i, j, (int) (Math.random() * (10 - 1)) + 1);
            }
        }
        p.setTaulell(mockTaulell);
        p.sudokuComplet();
        assertTrue(p.partidaAcabada);
    }

    @Test
    void TestComprovaResultatIgual() {
        Partida p = new Partida();
        MockJugador mockJugador = new MockJugador();
        mockJugador.setNom("Miquel");
        MockTaulell mockTaulell = new MockTaulell();
        mockTaulell.creaTaulellBuit();
        for (int i = 0; i<9; i++){
            for (int j = 0; j<9; j++){
                mockTaulell.setValorCasella(i, j, j);
                mockTaulell.setValorCasellaResposta(i, j, j);
            }
        }
        p.setTaulell(mockTaulell);
        p.setJugador(mockJugador);
        Assertions.assertTrue(p.comprovaResultat());
    }

    @Test
    void TestcomprovaResultatDiferent() {
        Partida p = new Partida();
        MockJugador mockJugador = new MockJugador();
        mockJugador.setNom("Miquel");
        MockTaulell mockTaulell = new MockTaulell();
        mockTaulell.creaTaulellBuit();

        for (int i = 0; i<9; i++){
            for (int j = 0; j<9; j++){
                mockTaulell.setValorCasella(i, j, (int) (Math.random() * (10 - 1)) + 1);
                mockTaulell.setValorCasellaResposta(i, j, (int) (Math.random() * (10 - 1)) + 1);
            }
        }

        p.setTaulell(mockTaulell);
        p.setJugador(mockJugador);
        Assertions.assertFalse(p.comprovaResultat());
    }
}