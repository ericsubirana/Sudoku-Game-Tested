package Controller;

import View.ImpressioTaulell;

public class Casella {

    private int subEspai;
    private int valor = -1;
    private boolean modificable;

    private boolean valorCorrecte;


    public Casella(int subEspai, int valor, boolean modificable){
        this.subEspai = subEspai;
        this.valor = valor;
        this.modificable = modificable;
        this.valorCorrecte = true;
    }

    public Casella(int valor, boolean modificable){
        this.valor = valor;
        this.modificable = modificable;
    }

    public int getValor(){ return valor;}
    public int getSubEspai(){ return subEspai;}
    public boolean getModificable(){ return modificable;}

    //setters
    public void setValor(int valor){ if(this.modificable) this.valor = valor;}

    public void setValorResposta(int valor) {this.valor = valor; }
    public void setValorIncorrecte() { this.valorCorrecte = false;}

    public void setValorCorrecte() {this.valorCorrecte = true;}

    @Override
    public String toString() {
        if(this.valor == -1)
            return " ";
        if(this.modificable && valorCorrecte)
            return ( ImpressioTaulell.ANSI_GREEN + this.valor + ImpressioTaulell.ANSI_RESET);

        else if(this.modificable && !valorCorrecte)
            return ( ImpressioTaulell.ANSI_RED + this.valor + ImpressioTaulell.ANSI_RESET);

        return ( ImpressioTaulell.ANSI_BLUE + this.valor + ImpressioTaulell.ANSI_RESET);
    }
}
