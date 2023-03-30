package cwk4;
import java.io.*;
import java.util.*;
public class Battle {
    private String type;
    private String Enemy;
    private int enStrength;
    private int losses;
    private int gains;
    private ArrayList<Force> ForceList;
    public Battle(String ty, String en, int enS, int Lo, int Ga){

        type = ty;
        Enemy = en;
        enStrength = enS;
        losses = Lo;
        gains = Ga;
        ForceList = new ArrayList<Force>();
    }
    public String getType(){
        return type;
    }
    public String getEnemy(){
        return Enemy;
    }
    public int getEnStrength(){
        return enStrength;
    }
    public int getLosses(){
        return losses;
    }
    public int getGains(){
        return gains;
    }
    public void enter(Force f){
        ForceList.add(f);
    }
}
