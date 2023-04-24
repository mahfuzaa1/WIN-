package cwk4;
import java.util.*;

public class Force {
    private String reference;
    private String name;
    private String type;
    private int fee;
    private int Strength;
    private int warchest;

    private ArrayList<Force> forceList;

    public Force(String ref, String nme, int f, int strn, String ty)
    {

        reference = ref;
        name = nme;
        fee = f;
        Strength = strn;
        type = ty;
        warchest = 1000;
    }

    public String getReference()
    {
        return reference;
    }

    public String getname()
    {
        return name;
    }

    public int getFee()
    {
        return fee;
    }

    public int getStrength()
    {
        return Strength;
    }

    public String getType()
    {
        return type;
    }

    public void deductWarchest(int num)
    {
        warchest = num - 1;
    }

    public void addWarchest(int num)
    {
        warchest = num + 1;
    }

    public int getWarChest()
    {
        return warchest;
    }

    public void activateForce()
    {
        warchest =  warchest- fee;
    }

    public String toString()
    {
        String Force = "";
        Force += "\nReference : "+ reference +"\nname : " + name + "\nType:"
                + type +"\nFee : " + fee + "Strength: " + Strength;
        return Force;

    }
}
