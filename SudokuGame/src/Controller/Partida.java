package Controller;

import View.ImpressioTaulell;

import java.util.*;

public class Partida {

    protected Jugador jugador;

    protected Taulell taulell;
    protected int dificultat;

    protected boolean partidaAcabada = false;
    private Scanner scanner = new Scanner(System.in);

    public Partida() { }

    public void setTaulell(Taulell taulell) {this.taulell = taulell; }

    public void setJugador(Jugador jugador) {this.jugador = jugador; }


    public Taulell getTaulell() { return this.taulell; }
    public void jugaPartida(ImpressioTaulell vista) throws InterruptedException {
        jugador = new Jugador();
        if (jugador.inicialitzaJugador(vista)){
            initPartida(vista);
            do{
                realitzaJugada(vista);
                ImpressioTaulell.printTaulell(taulell.getSudoku());
                if(!partidaAcabada)
                    sudokuComplet();
            }while (!partidaAcabada);

            if (jugador.getErrorsRestants() <=0){
                System.out.println("\nNo has pogut superar aquest sudoku.\nLa solució correcte era: \n");
                Thread.sleep(3000L);
                ImpressioTaulell.printTaulell(taulell.getSudoku_resp());
            }
            comprovaResultat();
        }
        else
            jugaPartida(vista); //si el nom no és correcte el tornem a demanar
    }

    public void initPartida(ImpressioTaulell vista) throws InterruptedException {
        // Entrar variable per pantalla i teclat
        dificultat = vista.escullDificultat();
        Thread.sleep(3000L);
        jugador.setErrorsRestants(dificultat);

        System.out.println("El sudoku a resoldre es el següent: ");
        ImpressioTaulell.printTaulell(taulell.getSudoku());
    }

    public void realitzaJugada(ImpressioTaulell vista) {
        // LLEGIM UN VALOR PER TECLAT PER ESCOLLIR UNA FILA ON MODIFICAR EL VALOR

        int fila = vista.escullFila();
        int columna = vista.escullColumna();


        // RESTEM 1 AL VALOR DE FILA I COLUMNA PERQUE ELS NOSTRES ARRAYS COMENÇEN PER 0
        fila--;
        columna--;

        if (!taulell.getSudoku()[fila][columna].getModificable()) {
            System.out.println("Aquesta casella no es pot modificar");
            return;
        }

        //MIRAR SI EL NUMERO TRIAT JA ESTA AL SUBESPAI O FILA/COLUMNA I SI ES MODIFICABLE
        int valor = vista.escullValor(fila, columna);

        if (!valorValid(fila, columna, valor)){ //VALOR INTRODUIT INCORRECTE
            taulell.setValorIncorrecteCasella(fila,columna);
            taulell.setValorCasella(fila, columna, valor);
            jugador.setErrorsRestants(jugador.getErrorsRestants()-1);

            if (jugador.getErrorsRestants() <= 0){
                partidaAcabada = true;
            }
        }
        else{
            taulell.getSudoku()[fila][columna].setValor(valor);
            taulell.setValorCorrecteCasella(fila,columna);
            taulell.setValorCasella(fila, columna, valor); //EL PASSEM A CORRECTE
        }
    }

    public boolean valorValid(int fila, int columna, int valor) {
        return filaValida(fila, valor) && columnaValida(columna, valor)
                && subEspaiValid(fila, columna, valor);
    }

    public boolean filaValida(int fila, int valor) {

        List<Integer> valorsFila = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            valorsFila.add(taulell.getValorCasella(fila,i));
        }

        return !valorsFila.contains(valor);
    }

    public boolean columnaValida(int columna, int valor) {
        List<Integer> valorsColumna = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            valorsColumna.add(taulell.getValorCasella(i,columna));
        }
        return !valorsColumna.contains(valor);
    }

    public boolean subEspaiValid(int fila, int columna, int valor) {
        int subEspai = taulell.getSudoku()[fila][columna].getSubEspai();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (taulell.getSudoku()[i][j].getSubEspai() == subEspai
                        && taulell.getValorCasella(i,j) == valor) {
                    return false;
                }
            }
        }
        return true;
    }

    public void sudokuComplet(){
        for (int fila = 0; fila < 9; fila++){
            for (int columna = 0; columna < 9; columna++){
                if(taulell.getValorCasella(fila, columna) == -1){
                    partidaAcabada = false;
                    return;
                }

            }
        }
        partidaAcabada = true;
    }

    public boolean comprovaResultat() {
        if (taulell.valorsTaulellsIguals()) {
            System.out.println("Enhorabona " + jugador.getNom() + " has solucionat el Sudoku!");
            return true;
        } else {
            System.out.println("\n" + jugador.getNom() + " no has solucionat correctament el Sudoku aquesta vegada. ");
            return false;
        }
    }
}
