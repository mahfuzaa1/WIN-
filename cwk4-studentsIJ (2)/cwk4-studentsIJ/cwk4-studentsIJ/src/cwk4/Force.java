package cwk4;

import java.util.ArrayList;
import java.util.HashSet;
public class Force {

    private String reference;
    private String name;
    private int fee;
    private int Strength;
    private ForceState state;
    private HashSet<BattleType> battleTypes;
    public Force(String re, String na, int f, int str){

        reference = re;
        name = na;
        this.fee = f;
        this.Strength = str;
        state = ForceState.DOCKED;
        battleTypes = new HashSet<BattleType>();
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
    public ForceState getState(){
        return state;
    }
    public void setState(ForceState st){
        state = st;
    }
    public void setBattleType(BattleType battle){
        battleTypes.add(battle);
    }
    public boolean CompareBattle(BattleType battle){
        return battleTypes.contains(battle);
    }
    public String toString(){
        String s = "";
        s += "\nReference : "+ reference +"\nname : " + name + "\nstate: " + getState() +
                "\nFee: " + fee + "\nStrength: " + Strength;
        return s;
    }

}

