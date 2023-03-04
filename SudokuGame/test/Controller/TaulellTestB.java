package Controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

//TAULELL MITG PLE
public class TaulellTestB {

    //ES IMPORTANT RECALCAR QUE EN UN SUBESPAI NO ES PODEN REPATIR NUMEROS PERÒ
    //EN AQUEST CAS NO ENS IMPORTA JA QUE NOMÉS ENS FIXEM EN SI EL MÈTODE FA LA SEVA FUNCIÓ
    @Test
    void TestValorsTaulellsIguals_B() {
        MockTaulell mockTaulell = new MockTaulell();
        mockTaulell.creaTaulellBuit();
        for (int i = 0; i<5; i++){
            for (int j = 0; j<5; j++){
                mockTaulell.setValorCasella(i, j, (int) (Math.random() * (10 - 1)) + 1);
                mockTaulell.setValorCasellaResposta(i, j,(int) (Math.random() * (10 - 1)) + 1);
            }
        }
        Assertions.assertFalse(mockTaulell.valorsTaulellsIguals());
    }

    @Test
    void TestValorsTaulellsIguals_B2() {
        MockTaulell mockTaulell = new MockTaulell();
        mockTaulell.creaTaulellBuit();
        for (int i = 0; i<5; i++){
            for (int j = 0; j<5; j++){
                mockTaulell.setValorCasella(i, j, i+2);
                mockTaulell.setValorCasellaResposta(i, j,i+2);
            }
        }
        assertTrue(mockTaulell.valorsTaulellsIguals());
    }

}
