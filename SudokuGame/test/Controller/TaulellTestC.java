package Controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//TAULELL PLE
public class TaulellTestC{

    @Test
    void TestValorsTaulellsIguals_C() {
        MockTaulell mockTaulell = new MockTaulell();
        mockTaulell.creaTaulellBuit();
        for (int i = 0; i<9; i++){
            for (int j = 0; j<9; j++){
                mockTaulell.setValorCasella(i, j, (int) (Math.random() * (10 - 1)) + 1);
                mockTaulell.setValorCasellaResposta(i, j,(int) (Math.random() * (10 - 1)) + 1);
            }
        }
        Assertions.assertFalse(mockTaulell.valorsTaulellsIguals());
    }

}
