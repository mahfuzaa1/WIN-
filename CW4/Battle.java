import java.util.*;
/**
 * Write a description of class Battle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Battle
{
    // instance variables - replace the example below with your own
    private String name; //enemy name
    private int number;  //battle number
    private String type; //battle type either: Wings, Straship or WarBird
    private int Strength; //enemy strength
    private int gains;    //battle gains
    private int losses;   //battle losses
    private ArrayList<ASF> ASFList;

    public Battle(String ty, String nme, int strn, int ls, int gs)
    {
        type = ty;
        name = nme;
        Strength = strn;
        losses = ls;
        gains = gs;
    }
    
    
   /**Returns the name of the battle type
    *@return name 
    */
   public String getName()
   {
    return name;
   }
   
   public int Strength()
   {
       Strength = 10;
   }
   
   /** returns the number of bit coins in the war chest
     * @returns the number of bit coins in the war chest
     */
    public int getWarchest()
   {
       return gains;
   }
   
   public String toString()
   {
       String s;
       s = "\n" + type + "Type" + name + "\nStrenght: " + Strength 
                       + "\n*********ASFList***" + ASFList.toString();
       return s;
   }

}