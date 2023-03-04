import Controller.Partida;
import Controller.Taulell;
import Model.CarregaSudoku;
import View.ImpressioTaulell;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String [] arg) throws InterruptedException, FileNotFoundException {
        //comença partida
        Partida partida_actual = new Partida();
        ImpressioTaulell vista = new ImpressioTaulell();
        int numeroSudoku = (int) (Math.random() * (5 - 1)) + 1;
        Taulell t = CarregaSudoku.startPartida(numeroSudoku);
        if (t != null){
            partida_actual.setTaulell(t);
            partida_actual.jugaPartida(vista);
        }else {
            System.out.println("ERROR: No s'ha pogut obtenir el sudoku a partir d'un fitxer");
            return;
        }

        System.out.println("\nSi vols tornar a jugar, introdueix 'S'" +
                "\nSi no vols tornar a jugar, introdueix qualsevol altre caràcter.");
        Scanner scanner = new Scanner(System.in);
        String caracter = scanner.next();
        if (Objects.equals(caracter, "s") || Objects.equals(caracter, "S")){
            main(arg);
        }
    }
}