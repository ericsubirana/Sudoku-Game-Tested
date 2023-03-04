package Controller;

import java.util.ArrayList;
import java.util.List;

public class MockTaulell extends Taulell{
    //A PARTIR DE SETTERS CREAR EL TAULELL
    //private Casella[][] sudoku;

    public void creaTaulellBuit(){
        Casella[][] sudoku1 = new Casella[9][9];
        Casella[][] sudoku2 = new Casella[9][9];

        for (int fila = 0; fila < 9; fila++){
            for (int col = 0; col < 9; col++){
                sudoku1[fila][col] = new Casella(-1, true);
                sudoku2[fila][col] = new Casella(-1, false);
            }
        }

        this.sudoku = sudoku1;
        this.sudoku_resp = sudoku2;
    }

}
