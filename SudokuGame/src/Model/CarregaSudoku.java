package Model;

import Controller.Casella;
import Controller.Taulell;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class CarregaSudoku {

    static final int MAX_FILES_COLUMNES = 9;

    public static Taulell startPartida(int numeroAleatori) throws FileNotFoundException {

        String s = ("./src/model/sudoku" +numeroAleatori + ".txt");
        String sr = ("./src/model/sudoku_resp" +numeroAleatori + ".txt");

        Taulell t = new Taulell();
        String strSudoku = llegirFitxer(s);
        boolean errorFitxers = (Objects.equals(strSudoku, "ERROR: File not exists") || Objects.equals(strSudoku, "ERROR: File empty"));

        if (!errorFitxers)
            t.setSudoku(convertirStringATaulell(strSudoku));

        String sudokuResposta = llegirFitxer(sr);
        errorFitxers = (Objects.equals(sudokuResposta, "ERROR: File not exists") || Objects.equals(sudokuResposta, "ERROR: File empty"));
        if (!errorFitxers)
            t.setSudoku_resp(convertirStringATaulell(sudokuResposta));

        return t;
    }

    public static Casella[][] convertirStringATaulell(String line){

        if (line.length() != 81)
            return null;

        char[] sudoku_array = line.toCharArray();

        //int[][] matriu_sudo = new int [9][9];
        int cont = 0;
        Casella[][] convertirSudoku = new Casella[MAX_FILES_COLUMNES][MAX_FILES_COLUMNES];
        Casella convertirACasella;
        for (int fila = 0; fila <9; fila++){
            for (int columna = 0; columna <9 ;columna++) {
                //matriu_sudo[fila][columna] = sudoku_array[cont]; //MATRIU EN INTEGERS
                if (sudoku_array[cont] == 'x'){
                    convertirACasella = new Casella(assignaSubEspais(fila, columna), -1, true);
                }
                else
                    convertirACasella = new Casella(assignaSubEspais(fila, columna), Character.getNumericValue(sudoku_array[cont]), false);
                convertirSudoku[fila][columna] = convertirACasella;
                cont++;
            }
        }
        return convertirSudoku;
    }

    public static String llegirFitxer(String ruta) throws FileNotFoundException {
        File fitxer1 = new File(String.valueOf(ruta));
        String line1 = " ";
        Scanner s1 = null;
        if (!fitxer1.exists() || !fitxer1.isFile()){
            return "ERROR: File not exists";
        }

        s1 = new Scanner(fitxer1);
        while (s1.hasNextLine()) {
            line1 = s1.nextLine(); 	// Guardem la linea en un String
        }
        if (line1.equals("") || line1.equals(" "))
            return "ERROR: File empty";

        s1.close();


        return line1;
    }

    public static int assignaSubEspais(int fila, int columna){

        if(fila >= 0 && columna >= 0){
            if(fila < 3 && columna < 3)
                return 0;
            if (fila < 3 && columna < 6)
                return 1;
            if (fila < 3 && columna <= 8)
                return 2;
            if (fila < 6 && columna < 3)
                return 3;
            if (fila < 6 && columna < 6)
                return 4;
            if (fila < 6 && columna <= 8)
                return 5;
            if (fila < 9 && columna < 3)
                return 6;
            if (fila < 9 && columna < 6)
                return 7;
            if (fila < 9 && columna <= 8)
                return 8;
        }
        return -1;
    }
}
