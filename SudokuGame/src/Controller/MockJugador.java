package Controller;

public class MockJugador extends Jugador{

    private static String nom;

    public String getNom()
    {
        return nom;
    }

    public static boolean setNom(String nickName)
    {
        nom = nickName;
        return true;
    }
}
