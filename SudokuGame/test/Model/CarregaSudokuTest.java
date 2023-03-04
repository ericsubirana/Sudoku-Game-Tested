package Model;

import Controller.Casella;
import Controller.MockTaulell;
import Controller.Partida;
import Controller.Taulell;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class CarregaSudokuTest {

    @Test
    void TestStartPartidaCorrecte() throws FileNotFoundException {
        Taulell result = CarregaSudoku.startPartida(1);
        Taulell t = new Taulell();
        assertEquals(result.isEmpty(), t.isEmpty());
    }
    @Test
    void TestStartPartidaError() throws FileNotFoundException {
        Taulell result = CarregaSudoku.startPartida(9);
        Taulell t = new Taulell();
        assertEquals(result.isEmpty(), t.isEmpty());

    }

    @Test
    void TestConvertirStringATaulellNormal() {
        Casella[][] sudokuCarregat = CarregaSudoku.convertirStringATaulell("5314627xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        MockTaulell mockTaulell = new MockTaulell();
        mockTaulell.creaTaulellBuit();
        mockTaulell.setValorCasella(0,0,5);
        mockTaulell.setValorCasella(0,1,3);
        mockTaulell.setValorCasella(0,2,1);
        mockTaulell.setValorCasella(0,3,4);
        mockTaulell.setValorCasella(0,4,6);
        mockTaulell.setValorCasella(0,5,2);
        mockTaulell.setValorCasella(0,6,7);

        for (int i = 0; i < 7; i++)
            Assertions.assertEquals(sudokuCarregat[0][i].getValor(), mockTaulell.getSudoku()[0][i].getValor());

    }

    @Test
    void TestConvertirStringATaulellNoComplet() { //falten numeros per tant no es crea el sudoku
        Casella[][] sudokuCarregat = CarregaSudoku.convertirStringATaulell("xx7xxxx6xx195xxxx98xxxx6x8xxx6xxx34xx8x3xx17xxx2xxx6x6xxxx28xxxx419xx5xxxx8xx79");
        Assertions.assertNull(sudokuCarregat);
    }

    // TESTS LLEGIR FITXER I CONVERTIR A STRING
    @Test
    void TestLlegirFitxer1() throws FileNotFoundException {
        String result = CarregaSudoku.llegirFitxer("src/Model/sudoku1.txt");
        assertNotEquals(result, "");
        assertEquals(result, "53xx7xxxx6xx195xxxx98xxxx6x8xxx6xxx34xx8x3xx17xxx2xxx6x6xxxx28xxxx419xx5xxxx8xx79");
        assertNotEquals(result, "53xx7xxxx6xx195xxxx98xxxx6x8xxx6xxx34xx8x3xx17xxx2xxx6x6xxxx28xxxx419xx5xxxx8xx79 ");
    }
    @Test
    void TestLlegirFitxer1resp() throws FileNotFoundException {
        String result = CarregaSudoku.llegirFitxer("src/Model/sudoku_resp1.txt");
        assertNotEquals(result, "");
        assertEquals(result, "534678912672195348198342567859761423426853791713924856961537284287419635345286179");
        assertNotEquals(result, "534678912672195348198342567859761423426853791713924856961537284287419635345286179 ");
    }

    @Test
    void TestLlegirFitxerNoExistent() throws FileNotFoundException {
        String result = CarregaSudoku.llegirFitxer("src/Model/sudoku_resp.txt");
        assertNotNull(result);
        assertEquals(result, "ERROR: File not exists");
    }

    @Test
    void TestLlegirFitxerBuit() throws FileNotFoundException {
        String result = CarregaSudoku.llegirFitxer("test/Model/testFitxerBuit.txt");
        assertNotNull(result);
        assertEquals(result, "ERROR: File empty");
    }

    @Test
    void TestAssignaSubEspais0() {
        int result = CarregaSudoku.assignaSubEspais(0,0);
        assertEquals(result, 0);

        int result2 = CarregaSudoku.assignaSubEspais(2,2);
        assertEquals(result, 0);
    }

    @Test
    void TestAssignaSubEspais1() {
        int result = CarregaSudoku.assignaSubEspais(0,3);
        assertEquals(result, 1);

        int result2 = CarregaSudoku.assignaSubEspais(2,5);
        assertEquals(result, 1);
    }
    @Test
    void TestAssignaSubEspais2() {
        int result = CarregaSudoku.assignaSubEspais(0,6);
        assertEquals(result, 2);

        int result2 = CarregaSudoku.assignaSubEspais(2,8);
        assertEquals(result, 2);
    }
    @Test
    void TestAssignaSubEspais3() {
        int result = CarregaSudoku.assignaSubEspais(3,0);
        assertEquals(result, 3);

        int result2 = CarregaSudoku.assignaSubEspais(5,2);
        assertEquals(result, 3);
    }
    @Test
    void TestAssignaSubEspais4() {
        int result = CarregaSudoku.assignaSubEspais(3,3);
        assertEquals(result, 4);

        int result2 = CarregaSudoku.assignaSubEspais(5,5);
        assertEquals(result, 4);
    }
    @Test
    void TestAssignaSubEspais5() {
        int result = CarregaSudoku.assignaSubEspais(3,6);
        assertEquals(result, 5);

        int result2 = CarregaSudoku.assignaSubEspais(5,8);
        assertEquals(result, 5);
    }
    @Test
    void TestAssignaSubEspais6() {
        int result = CarregaSudoku.assignaSubEspais(6,0);
        assertEquals(result, 6);

        int result2 = CarregaSudoku.assignaSubEspais(8,2);
        assertEquals(result, 6);
    }
    @Test
    void TestAssignaSubEspais7() {
        int result = CarregaSudoku.assignaSubEspais(6,3);
        assertEquals(result, 7);

        int result2 = CarregaSudoku.assignaSubEspais(8,5);
        assertEquals(result, 7);
    }
    @Test
    void TestAssignaSubEspais8() {
        int result = CarregaSudoku.assignaSubEspais(6,6);
        assertEquals(result, 8);

        int result2 = CarregaSudoku.assignaSubEspais(8,8);
        assertEquals(result, 8);
    }
    @Test
    void TestAssignaSubEspaisInvalid(){
        int result = CarregaSudoku.assignaSubEspais(-1,-1);
        assertEquals(result, -1);
    }


}