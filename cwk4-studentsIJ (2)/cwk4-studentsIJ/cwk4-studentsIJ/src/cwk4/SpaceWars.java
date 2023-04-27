package cwk4;
import java.util.*;
import java.io.*;
/**
 * This class implements the behaviour expected from a WIN
 system as required for 5COM2007 - March 2023
 *
 * @author Team ??
 * @version March 2023
 **/
public class SpaceWars implements WIN
{

//**************** WIN **************************
    /** Constructor requires the name of the admiral
     * @param admiral the name of the admiral
     */
    private String name;
    private ArrayList<Force> allForces = new ArrayList<Force>();
    private ArrayList<Collection> collection = new ArrayList<Collection>();
    private ArrayList<Battle> allBattles = new ArrayList<Battle>();
    private int warchest;
    private String fileName;

    public SpaceWars(String admiral)
    {
        name = admiral;
        setupForces();
        setupBattles();
        warchest = 1000;
        Collection C1 = collection.get(0);
        for(Force temp: allForces){
            C1.enterUFF(temp);
        }
    }

    /** Second constructor - task 3.5
     *  To be added for task 3.5
     */
    public SpaceWars(String admiral, String fname){
        name = admiral;
        setupForces();
        setupBattles();
        warchest = 1000;
        Collection C1 = collection.get(0);
        for(Force temp: allForces){
            C1.enterUFF(temp);
        }
        fileName = fname;
    }

    /**Returns a String representation of the state of the game,
     * including the name of the admiral, state of the war chest,
     * whether defeated or not, and the forces currently in the
     * Active Star Fleet(ASF),(or, "No forces" if Star Fleet is empty)
     * @return a String representation of the state of the game,
     * including the name of the admiral, state of the war chest,
     * whether defeated or not, and the forces currently in the
     * Star Fleet,(or, "No forces" if Active Star Fleet is empty)
     **/
    public String toString()
    {
        String s = "";
        s += "\nname: " + name +"\nwarchest: " + getWarchest() + "\nDefeated: "+
                isDefeated() + "\n ASF Forces: " + getASFleet();
        return s;
    }

    /** returns true if war chest <=0 AND the active Star Fleet(ASF) has no
     * forces which can be recalled.
     * @returns true if war chest <=0 and the active Star Fleet(ASF) has no
     * forces which can be recalled.
     */
    public boolean isDefeated()
    {
        for(Collection temp: collection)
            if(getWarchest() <= 0 && temp.getASFSize() <=0){
            return true;
            }
        return false;
    }


    /** returns the number of bit coins in the war chest
     * @returns the number of bit coins in the war chest
     */
    public int getWarchest()
    {
        return warchest;
    }

    /* Returns a list of all forces in the system by listing :
     * All forces in the Active Star Fleet(ASF), or "No forces in ASF")
     * All forces remaining in the UFF dock, or "No forces in UFF dock
     * All forces destroyed as a result of losing a battle, or "No destroyed forces"
     */
    public String getAllForces()
    {
        String s = "\nAll forces in the system";
        s += getASFleet() + getForcesInDock() + getDestroyedForces();
        return s;
    }


    /**Returns true if force is in the United Forces Fleet(UFF), else false
     * @param ref reference of the force
     * @return a String representation of all forces in the United Forces Fleet(UFF)
     **/
    public boolean isInUFFDock(String ref)
    {
        for(Collection temp: collection){
            return temp.isInUFF(ref);
        }
        return false;
    }


    /**Returns a String representation of all forces in the United Forces Fleet(UFF) dock.
     * Does not include destroyed forces
     * @return a String representation of all forces in the United Forces Fleet(UFF) dock.
     **/
    public String getForcesInDock()
    {
        String s = "\n\n************ Forces available in UFFleet Dock********\n";
        for(Collection temp: collection){
            s+= temp.allUFF();
        }
        return s;
    }

    /** Returns a list of all destroyed forces in the system
     * @return all destroyed forces
     */
    public String getDestroyedForces()
    {
        String s ="\n***** Destroyed Forces ****\n";
        for(Collection temp: collection){
            s+= temp.allDestroyed();
        }
        return s;
    }

    /** Returns details of the force with the given reference code, or "No such force"
     * @param ref the reference of the force
     * @return details of the force with the given reference code
     **/
    public String getForceDetails(String ref)
    {
        Force fr = getForce(ref);
        if(fr != null){
            return fr.toString();
        }
        return "\nNo such Force";
    }


    // ***************** Active Star Fleet Forces ************************
    /** Allows a force to be activated into the Active Star Fleet(ASF), but
     * only if there are enough resources for the activation fee.The force's
     * state is set to "active"
     * @param ref represents the reference code of the force
     * @return 0 if force is activated, 1 if force is not in the UFF dock or is destroyed
     * 2 if not enough money, -1 if no such force
     **/

    public int activateForce(String ref)
    {
        Force fr = getForce(ref);
        for(Collection temp: collection){
            if(fr == null){
                return -1;
            }
            else if(!isInUFFDock(ref)){
                return 1;
            }
            else if(getWarchest() < fr.getFee()){
                return 2;
            }
            else{
                fr.setState(ForceState.ACTIVE);
                temp.removeUFForce(fr);
                temp.enterASF(fr);
                warchest -= fr.getFee();
                return 0;
            }

        }
        return -1;
    }



    /** Returns true if the force with the reference code is in
     * the Active Star Fleet(ASF), false otherwise.
     * @param ref is the reference code of the force
     * @return returns true if the force with the reference code
     * is in the active Star Fleet(ASF), false otherwise.
     **/
    public boolean isInASFleet(String ref)
    {
        for(Collection temp:collection){
            return temp.isInASF(ref);
        }
        return false;

    }

    /**Returns a String representation of the forces in the active
     * Star Fleet(ASF), or the message "No forces activated"
     * @return a String representation of the forces in the active
     * Star Fleet, or the message "No forces activated"
     **/
    public String getASFleet()
    {
        String s = "\n****** Forces in the Active Star Fleet******\n";
        for(Collection temp: collection){
            s+= temp.allASF();
        }
        return s;
    }

    /** Recalls a force from the Star Fleet(ASF) back to the UFF dock, but only
     * if it is in the Active Star Fleet(ASF)
     * @param ref is the reference code of the force
     **/
    public void recallForce(String ref)
    {
        Force ff = getForce(ref);
        if(ff != null){
            for(Collection temp: collection){
                if(isInASFleet(ref) == true){
                    ff.setState(ForceState.DOCKED);
                    temp.removeASForce(ff);
                    temp.enterUFF(ff);
                    int num = ff.getFee() /2;
                    warchest += num;
                }}
        }
    }


//**********************Battles*************************
    /** returns true if the number represents a battle
     * @param num is the number of the required battle
     * @returns true if the number represents a battle
     **/
    public boolean isBattle(int num)
    {
        for(Battle temp: allBattles){
            if(num == temp.getNumber()){
                return true;
            }
        }
        return false;
    }


    /** Provides a String representation of a battle given by
     * the battle number
     * @param num the number of the battle
     * @return returns a String representation of a battle given by
     * the battle number
     **/
    public String getBattle(int num)
    {
        for(Battle temp: allBattles){
            if(num == (temp.getNumber())){
                return temp.toString();
            }
        }
        return "No such battle";
    }

    /** Provides a String representation of all battles
     * @return returns a String representation of all battles
     **/
    public String getAllBattles()
    {
        String s = "\n************ All Battles ************\n";
        for(Battle temp: allBattles){
            s += temp.toString();
        }
        return s;
    }


    /** Retrieves the battle represented by the battle number.Finds
     * a force from the Active Star Fleet which can engage in the battle.The
     * results of battle will be one of the following:
     * 0 - Battle won, battle gains added to the war chest,
     * 1 - Battle lost as no suitable force available, battle losses
     * deducted from war chest
     * 2 - Battle lost on battle strength , battle losses
     * deducted from war chest and force destroyed
     * 3 - If a battle is lost and admiral completely defeated (no resources and
     * no forces to recall)
     * -1 - no such battle
     * @param battleNo is the number of the battle
     * @return an int showing the result of the battle (see above)
     */

public int doBattle(int battleNo){
    Battle bb = null;
    for(Battle temp1: allBattles){
        if(temp1.getNumber() == battleNo){
            bb = temp1;
        }
    }
    if(bb == null){
        return -1;
    }
    for(Collection cc: collection){
        for(Force temp: allForces){
            if(isInASFleet(temp.getReference())){
                if(temp.CompareBattle(bb.getType())){
                    if(temp.getStrength() >= bb.getEnStrength()){
                        warchest += bb.getGains();
                        return 0;
                    }
                }
                else{
                    warchest -= bb.getLosses();
                    cc.removeASForce(temp);
                    cc.addDestroyed(temp);
                    temp.setState(ForceState.DESTROYED);
                    return 2;
                }
            }
        }
        if(isDefeated() == true){
            return 3;
        }
    }
    warchest -= bb.getLosses();
    return 1;
}




    //*******************************************************************************
    private void setupForces()
    {
        Force F1 = new Wing("IW1","Twisters",10);
        Force F2 = new Starship("SS2","Enterprise",10,20);
        Force F3 = new WarBird("WB3","Droop",false,100);
        Force F4 = new Wing("IW4","Wingers",20);
        Force F5 = new WarBird("WB5","Hang",true,300);
        Force F6 = new Starship("SS6","Voyager",15,10);
        Force F7 = new Starship("SS7","Explorer",4,5);
        Force F8 = new WarBird("WB9","Hover",false,400);
        Force F9 = new Wing("IW10","Flyers",5);
        allForces.add(F1);
        allForces.add(F2);
        allForces.add(F3);
        allForces.add(F4);
        allForces.add(F5);
        allForces.add(F6);
        allForces.add(F7);
        allForces.add(F8);
        allForces.add(F9);
    }

    private void setupBattles()
    {
        Battle B1 = new Battle(1,BattleType.FIGHT,"Borg",200,300,100);
        Battle B2 = new Battle(2,BattleType.SKIRMISH,"Kardassians",700,200,120);
        Battle B3 = new Battle(3,BattleType.AMBUSH,"Ferengi",100,400,150);
        Battle B4 = new Battle(4,BattleType.FIGHT,"Ewoks",600,600,200);
        Battle B5 = new Battle(5,BattleType.AMBUSH,"Borg",500,400,90);
        Battle B6 = new Battle(6,BattleType.SKIRMISH,"Groaners",150,100,100);
        Battle B7 = new Battle(7,BattleType.FIGHT,"Borg",150,500,300);
        Battle B8 = new Battle(8,BattleType.AMBUSH,"Wailers",300,300,300);
        Collection C1 = new Collection();
        collection.add(C1);
        allBattles.add(B1);
        allBattles.add(B2);
        allBattles.add(B3);
        allBattles.add(B4);
        allBattles.add(B5);
        allBattles.add(B6);
        allBattles.add(B7);
        allBattles.add(B8);

    }


    private Force getForce(String ref){
        for(Force temp: allForces){
            if(ref.equals(temp.getReference())){
                return temp;
            }
        }
        return null;
    }



    //**************************Add your own private methos here ***********************



    //*******************************************************************************

    //These methods are not needed until Task 3.5. Uncomment thmemto complete task 3.5
    // ***************   file write/read  *********************

//     /** Writes whole game to the specified file
//      * @param fname name of file storing requests
//      */
     public void saveGame(String fname)
     {   // uses object serialisation
         try{
             FileOutputStream fileOut = new FileOutputStream(fname);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
             objectOut.writeObject(this);
             objectOut.close();
         }
         catch(Exception e){
             e.printStackTrace();
         }
     }

     /** reads all information about the game from the specified file
      * and returns a SpaceWars object
      * @param fname name of file storing the game
      * @return the game (as a SpaceWars object)
      */
     public SpaceWars restoreGame(String fname)
     {
         try{
             FileInputStream streamIn = new FileInputStream(fname);
             ObjectInputStream objectIn = new ObjectInputStream(streamIn);
             return (SpaceWars) objectIn.readObject();

         }catch(Exception e){
             e.printStackTrace();
     }
         return new SpaceWars(name);
     }

     /** Reads information about battles from the specified file into the appropriate collection
      */
     private void readBattles(String fname)
     {
         try{
             FileInputStream streamIn = new FileInputStream(fname);
             ObjectInputStream objectIn = new ObjectInputStream(streamIn);
             this.allBattles = (ArrayList<Battle>) objectIn.readObject();
         }catch(Exception e){
             e.printStackTrace();
         }

     }


}
