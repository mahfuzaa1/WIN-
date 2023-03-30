package cwk4;

public class Force {

    private String reference;
    private String name;
    private String type;
    private int fee;
    private int Strength;
    private int strikers;
    private int LaserCannons;
    private int Photon;
    private int warchest;

    public Force(String re, String na, int f, int str,String ty){

        reference = re;
        name = na;
        fee = f;
        Strength = str;
        type = ty;
    }
    public String getReference(){
        return reference;
    }
    public String getname(){
        return name;
    }
    public int getFee(){
        return fee;
    }
    public int getStrength(){
        return Strength;
    }
    public String getType(){
        return type;
    }
    public void setStrikers(int num){
        strikers = num;
    }
    public void setLaser(int laser){
        LaserCannons = laser;
    }
    public void setPhoton(int num){
        Photon = num;
    }
    public void setWarchest(int num) {
        warchest = num;
    }
    public void deductWarchest(int num){
        warchest -= num;
    }
    public void addWarchest(int num){
        warchest += num;
    }
}
