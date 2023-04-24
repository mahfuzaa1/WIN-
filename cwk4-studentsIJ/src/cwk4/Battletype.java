package cwk4;
import java.io.*;
import java.util.*;

public class Battle
{
    private String type;
    private String Enemy;
    private int BattleNo;
    private int enStrength;
    private int losses;
    private int gains;
    public Battle(int no,String ty, String en, int enS, int Lo, int Ga)
    {
        BattleNo = no;
        type = ty;
        Enemy = en;
        enStrength = enS;
        losses = Lo;
        gains = Ga;
    }
    public String getType()
    {
        return type;
    }
    public int getNumber()
    {
        return BattleNo;
    }
    public String getEnemy()
    {
        return Enemy;
    }
    public int getEnStrength()
    {
        return enStrength;
    }
    public int getLosses()
    {
        return losses;
    }
    public int getGains()
    {
        return gains;
    }

    private int getAllBattle()
    {
        return BattleNo;
    }

    private String getBattle()
    {
        return type;
    }

    public String toString()
    {
        String Battle ="";
        Battle = Battle + "\nBattle number: " +BattleNo + "\nBattle type: " + type + "\nEnemy: " + Enemy
                + "\nEnemy Strength: " + enStrength  + "\nLosses: " + losses + "\nGains: " +gains + "\n";
        return Battle;
    }
}
