package cwk4;

public class Starship extends Force
{
    private int Photon;
    private int LaserCannons;
    public Starship(String re, String na, int las,int Pho)
    {
        super(re,na,las* 30,(5*Pho)+(10*las));
        Photon = Pho;
        LaserCannons = las;
        setBattleType(BattleType.SKIRMISH);
        setBattleType(BattleType.FIGHT);
    }
    public int getLaserCannons(){
        return LaserCannons;
    }
    public void setLaserCannons(int Laser){
        LaserCannons += Laser;
    }
    public int getPhoton(){
        return Photon;
    }
    public String toString(){
        String s = "";
        s = s + super.toString();
        s = s + "\nPhoton Torpedoes" + Photon + "\nLaser Cannons" + LaserCannons;
        return s;
    }
}

