package View;

import Controller.Casella;
import Controller.Jugador;
import Controller.Taulell;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.in;

public class ImpressioTaulell {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static final String ANSI_RESET = "\u001B[0m";

    protected Taulell taulell;

    public ImpressioTaulell(){ }

    public static void printLineaTaulell(){
        System.out.println("   --- --- ---    --- --- ---    --- --- --- ");
    }

    public static void printValorsTaulell(Casella[] linea, int numLinea){
        System.out.println( numLinea + " | "+linea[0]+" | "+linea[1]+" | "+linea[2]+" |  | "+linea[3]+" | "+linea[4]+" | "
                +linea[5]+" |  | "+linea[6]+" | "+linea[7]+" | "+linea[8]+" |");
    }

    public static void printTaulell(Casella[][] sudoku){
        if( sudoku == null)
            return;

        System.out.println("    1   2   3      4   5   6      7   8   9");
        printLineaTaulell();
        printValorsTaulell(sudoku[0], 1);
        printLineaTaulell();
        printValorsTaulell(sudoku[1], 2);
        printLineaTaulell();
        printValorsTaulell(sudoku[2], 3);

        System.out.println();
        printValorsTaulell(sudoku[3], 4);
        printLineaTaulell();
        printValorsTaulell(sudoku[4], 5);
        printLineaTaulell();
        printValorsTaulell(sudoku[5], 6);

        System.out.println();
        printValorsTaulell(sudoku[6], 7);
        printLineaTaulell();
        printValorsTaulell(sudoku[7], 8);
        printLineaTaulell();
        printValorsTaulell(sudoku[8], 9);
        printLineaTaulell();
    }

    static Scanner scanner = new Scanner(System.in);
    public static int introdueixValorEntre() {
        int valor = -1;
        do {
            try {
                valor = ask();
            } catch (InputMismatchException ime){
                System.out.println("¡Cuidado! Només pots insertar números. ");
                scanner.next();
            }
            if (valor < 1 || valor > 9)
                System.out.println("El valor ha d'estar entre: " + 1 + " i " + 9);

        } while (valor < 1 || valor > 9);

        return valor;

    }

    public static int ask() {
        return scanner.nextInt();
    }

    public boolean setNom(String nom) {
        //HEM DE COMPROVAR QUE EL NOM ES CORRECTE!!
        if (nom.isEmpty() || nom.length() > 15){
            return false;
        }
        else {
            int i = 0;
            char[] nomC = nom.toCharArray();
            for (char c : nomC){
                if(Character.isDigit(c)){
                    return false;
                }
            }

            while (( i < nom.length()))
            {
                if(nom.charAt(i) == ' ')
                {
                    System.out.println("ERROR: nom Invalid!!");
                    return false;
                }
                else
                {
                    i = i + 1;
                }
            }
        }

        return true;
    }

    public String escullNom(){
        System.out.println("Indica el teu nom: ");
        String nom1 = scanner.nextLine();

        if (Jugador.setNom(nom1)) //li pasem al set pq comprovi q el nom estigui correcte
            return nom1;
        else
            return " ";
    }
    public int escullFila(){
        System.out.println("Escull una fila on col·locar un valor: ");
        return introdueixValorEntre();
    }

    public int escullColumna(){
        System.out.println("Escull una columna on col·locar un valor: ");
        return introdueixValorEntre();
    }

    public int escullValor(int fila, int columna){
        System.out.println("Escull el valor que vols col·locar en la posició " + (fila+1) + ", " + (columna+1));
        return introdueixValorEntre();
    }

    public int escullDificultat(){
        int dificultat = -1;
        System.out.println("Escull el nivell de dificultat amb el que vols jugar:\n1) DIFICULTAT DIFÍCIL\n2) DIFICULTAT MITJANA\n3) DIFICULTAT FÀCIL\n");
        // indiquem dificultat
        Scanner sc = new Scanner(in);
        do {
            try {
                dificultat = introdueixValorEntre();
            } catch (InputMismatchException ime){
                System.out.println("¡Cuidado! Només pots insertar números ");
                sc.next();
            }
            if (dificultat < 1 || dificultat > 3)
                System.out.println("El valor ha d'estar entre: " + 1 + " i " + 3);

        } while (dificultat < 1 || dificultat > 3);

        System.out.println("Has escollit la dificultat: " + dificultat + ", per tant has de cometre menys de "
                + dificultat + " errors per a superar aquest sudoku. \n");

        return dificultat;
    }

}
