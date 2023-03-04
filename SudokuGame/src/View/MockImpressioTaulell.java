package View;

import Controller.Taulell;

public class MockImpressioTaulell extends ImpressioTaulell{

    private String nom;
    private int fila;
    private int columna;
    private int valor;
    private int dificultat;
    public MockImpressioTaulell(){

    }



    public boolean setNom(String nom){ this.nom = nom;
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
    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setDificultat(int dificultat) {
        this.dificultat = dificultat;
    }

    public String escullNom() {
        if (setNom(nom)) //li pasem al set pq comprovi q el nom estigui correcte
            return nom;
        else
            return " ";    }
    public int escullFila() {
        return fila;
    }

    public int escullColumna() {
        return columna;
    }

    public int escullValor(int fila, int columna) {
        return valor;
    }

    @Override
    public int escullDificultat() {
        return dificultat;
    }
}
