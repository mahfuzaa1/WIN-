package cwk4;

public class Starship extends Force
{
    private String reference;
    private String name;
    private String type;
    private int fee;
    private int Strength;
    private int warchest;
    private int Photon;
    private int LaserCannons;
    public Starship(String re, String na, int f, int str,String ty,int Pho,int Laser)
    {
        super(re,na,f = Laser*30,str = (5*Pho)+(10*Laser),ty);
        Photon = Pho;
        LaserCannons = Laser;
    }
    public String toString(){
        String s = "";
        s = s + super.toString();
        s = s + "\nPhoton Torpedoes" + Photon + "\nLaser Cannons" + LaserCannons;
        return s;
    }
}

