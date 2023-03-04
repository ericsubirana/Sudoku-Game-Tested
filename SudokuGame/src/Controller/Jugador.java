package Controller;

import View.ImpressioTaulell;

import java.util.Objects;
import java.util.Scanner;

public class Jugador {

    protected String nom;
    protected int errorsRestants;
    protected boolean correcte;
    private Scanner input = new Scanner(System.in);

    public Jugador() {}

    public static boolean setNom(String nom) {
        //HEM DE COMPROVAR QUE EL NOM ES CORRECTE!!
        if (nom.isEmpty() || nom.length() > 15){
            //return false;
        }
        else {
            int i = 0;
            char[] nomC = nom.toCharArray();
            for (char c : nomC){
                if(Character.isDigit(c)){
                    //return false;
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

    public boolean inicialitzaJugador(ImpressioTaulell vista){
        this.nom = vista.escullNom();
        if (!Objects.equals(this.nom, " ")){
            correcte = true;
            return true;
        }else{
            correcte = false;
            return false;
        }
    }

    public String getNom() {
        return nom;
    }

    public void setErrorsRestants(int errorsRestants) {
        this.errorsRestants = errorsRestants;
    }

    public int getErrorsRestants() {
        return errorsRestants;
    }

    public boolean isCorrecte() {
        return correcte;
    }


}

