package cwk4;
import java.io.*;
import java.util.*;
public class Battle {
    private String Enemy;
    private int BattleNo;
    private int enStrength;
    private int losses;
    private int gains;
    private BattleType type;
    public Battle(int no,BattleType battleType, String en, int enS, int Lo, int Ga){
        BattleNo = no;
        type = battleType;
        Enemy = en;
        enStrength = enS;
        losses = Lo;
        gains = Ga;
    }
    public int getNumber(){
        return BattleNo;
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
    public BattleType getType(){
        return type;
    }
    public String toString(){
        String s ="";
        s = s + "\nBattle number: " +BattleNo + "\nBattle type: " + type + "\nEnemy: " + Enemy
                + "\nEnemy Strength: " + enStrength  + "\nLosses: " + losses + "\nGains: " +gains + "\n";
        return s;
    }
}