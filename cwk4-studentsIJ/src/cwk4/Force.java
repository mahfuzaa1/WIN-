package cwk4;

import java.util.ArrayList;
public class Force {

    private String reference;
    private String name;
    private String type;
    private int fee;
    private int Strength;
    private int warchest;
    public Force(String re, String na, int f, int str,String ty){

        reference = re;
        name = na;
        fee = f;
        Strength = str;
        type = ty;
        warchest = 1000;
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
    public void deductWarchest(int num){
        warchest -= num;
    }
    public void addWarchest(int num){
        warchest += num;
    }
    public int getWarchest(){return warchest; }
    public void activate(){
        warchest = warchest - fee;
    }
    public String toString(){
        String s = "";
        s += "\nReference : "+ reference +"\nname : " + name + "\nType:"
                + type +"\nFee : " + fee + "Strength: " + Strength;
        return s;
    }

}

