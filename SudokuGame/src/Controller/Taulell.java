package Controller;

public class Taulell{

    static final int MAX_FILES_COLUMNES = 9;
    protected Casella[][] sudoku = new Casella[MAX_FILES_COLUMNES][MAX_FILES_COLUMNES];
    protected Casella[][] sudoku_resp = new Casella[MAX_FILES_COLUMNES][MAX_FILES_COLUMNES];

    public Taulell() {
        for (int fila = 0; fila < 9; fila++){
            for (int col = 0; col < 9; col++){
                sudoku[fila][col] = new Casella(Model.CarregaSudoku.assignaSubEspais(fila, col), -1, true);
                sudoku_resp[fila][col] = new Casella(Model.CarregaSudoku.assignaSubEspais(fila, col), -1, false);
            }
        }
    }
    // 18,21,25,31,32,32,34,38
    public Casella[][] getSudoku() {
         return sudoku;
    }
    public Casella[][] getSudoku_resp() {
        return sudoku_resp;
    }

    public int getValorCasella(int fila, int columna){
        return sudoku[fila][columna].getValor();
    }
    public void setValorCasella(int fila, int columna, int valor){ sudoku[fila][columna].setValor(valor); }
    public void setValorCasellaResposta(int fila, int columna, int valor){ sudoku_resp[fila][columna].setValorResposta(valor); }

    public void setValorIncorrecteCasella(int fila, int columna){ sudoku[fila][columna].setValorIncorrecte();}
    public void setValorCorrecteCasella(int fila, int columna){ sudoku[fila][columna].setValorCorrecte();}

    public void setSudoku(Casella[][] sudoku){
        this.sudoku = sudoku;
    }

    public boolean isEmpty(){

        boolean empty = true;

        for (int fila = 0; fila < 9; fila++){
            for (int col = 0; col < 9; col++){
                if (!sudoku[fila][col].equals("")) {
                    empty =  false;
                }
            }
        }
        return empty;
    }

    public void setSudoku_resp(Casella[][] sudoku_resp){
        this.sudoku_resp = sudoku_resp;
    }

    public boolean valorsTaulellsIguals(){
        for (int fila = 0; fila < 9 ; fila++){
            for (int col = 0; col < 9; col++){
                if (sudoku[fila][col].getValor() != sudoku_resp[fila][col].getValor())
                    return false;
            }
        }
        return true;
    }
    /*COMPARA ELS VALORS DE CADA POSICIÓ EL SUDOKU DE L'USUARI
    * AMB EL SUDOKU DE LA RESPOSTA PER COMPROVAR SI L'USUARI
    * HA GUANYAT LA PARTIDA HO HA COMPLETAT EL SUDOKU DE MANERA
    * INCORRECTA. */

}
