package Controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//TAULELL BUIT
//TAULELL AFEGINT-HI UN VALOR
class TaulellTestA {

    @Test
    void TestValorsTaulellsIguals_A() {
        MockTaulell mockTaulell = new MockTaulell();
        mockTaulell.creaTaulellBuit();
        assertTrue(mockTaulell.valorsTaulellsIguals());
    }

    @Test
    void TestValorsTaulellsIguals2_A() {
        MockTaulell mockTaulell = new MockTaulell();
        mockTaulell.creaTaulellBuit();
        mockTaulell.setValorCasella(1, 1, 5);
        assertFalse(mockTaulell.valorsTaulellsIguals());
    }

    @Test
    void TestValorsTaulellsIguals3_A() {
        MockTaulell mockTaulell = new MockTaulell();
        mockTaulell.creaTaulellBuit();
        mockTaulell.setValorCasella(1, 1, 5);
        mockTaulell.setValorCasellaResposta(1,1,5);
        assertTrue(mockTaulell.valorsTaulellsIguals());
    }

    @Test
    void TestValorsTaulellsIgualsLletres_A() {
        MockTaulell mockTaulell = new MockTaulell();
        mockTaulell.creaTaulellBuit();
        mockTaulell.setValorCasella(1, 1, 5);
        mockTaulell.setValorCasellaResposta(1,1,5);
        assertTrue(mockTaulell.valorsTaulellsIguals());
    }



}