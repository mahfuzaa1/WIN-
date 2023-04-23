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

    public SpaceWars(String admiral)
    {
        name = admiral;
        setupForces();
        setupBattles();
        Collection C1 = collection.get(0);
        for(Force temp: allForces){
            C1.enterUFF(temp);
        }
    }

    /** Second constructor - task 3.5
     *  To be added for task 3.5
     */

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
        if(getWarchest() <= 0 && getASFleet() == "No forces activated"){
            return true;
        }
        return false;
    }


    /** returns the number of bit coins in the war chest
     * @returns the number of bit coins in the war chest
     */
    public int getWarchest()
    {
        for(Force temp: allForces){
            return temp.getWarchest();
        }
        return -1;
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
            else{
                return temp.allowActivate(fr);
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
                    temp.removeASForce(ff);
                    temp.enterUFF(ff);
                    int num = ff.getFee() /2;
                    ff.addWarchest(num);
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
    public int doBattle(int battleNo)
    {
        Battle bb = getBattlenum(battleNo);
        Force ff = getForceASF();
        if(bb == null){
            return -1;
        }
        else if(ff == null){
            for(Force temp: allForces){
                temp.deductWarchest(bb.getLosses());
            }
            return 1;
        }
        else if(ff.getStrength() < bb.getEnStrength()){
            for(Collection temp: collection){
                temp.removeASForce(ff);
                temp.addDestroyed(ff);
                ff.deductWarchest(bb.getLosses());
            }
            return 2;
        }
        else if(ff.getStrength() < bb.getEnStrength() && isDefeated() == true){
            return 3;
        }
        else{
            ff.addWarchest(bb.getGains());
            return 0;
        }

    }






    //*******************************************************************************
    private void setupForces()
    {
        Force F1 = new Wing("IW1","Twister",200,200,"Wing",10);
        Force F2 = new Starship("SS2","Enterprise",300,200,"Starship",20,10);
        Force F3 = new WarBird("WB3","Droop",300,100,"Warbird",false);
        Force F4 = new Wing("IW4","Winger",200,400,"Wing",20);
        Force F5 = new WarBird("WB5","Hang",400,300,"Warbird",true);
        Force F6 = new Starship("SS6","Voyager",450,200,"Straship",10,15);
        Force F7 = new Starship("SS7","Explorer",120,65,"Starship",5,4);
        Force F8 = new WarBird("WB9","Hover",300,400,"Warbird",false);
        Force F9 = new Wing("IW10","Flyer",200,100,"Wing",5);
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
        Battle B1 = new Battle(1,"Fight","Borg",200,300,100);
        Battle B2 = new Battle(2,"Skirmish","Kardassians",700,200,120);
        Battle B3 = new Battle(3,"Ambush","Ferengi",100,400,150);
        Battle B4 = new Battle(4,"Fight","Ewoks",600,600,200);
        Battle B5 = new Battle(5,"Ambush","Borg",500,400,90);
        Battle B6 = new Battle(6,"Skirmish","Groaners",250,100,100);
        Battle B7 = new Battle(7,"Fight","Borg",150,500,300);
        Battle B8 = new Battle(8,"Ambush","Wailers",300,300,300);
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
    private Battle getBattlenum(int num){
        for(Battle temp: allBattles){
            if(num == temp.getNumber()){
                return temp;
            }
        }
        return null;
    }
    private Force getForceASF(){
        for(Collection temp: collection){
            return temp.getFirstASF();
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
//     public void saveGame(String fname)
//     {   // uses object serialisation
//
//     }
//
//     /** reads all information about the game from the specified file
//      * and returns a SpaceWars object
//      * @param fname name of file storing the game
//      * @return the game (as a SpaceWars object)
//      */
//     public SpaceWars restoreGame(String fname)
//     {
//
//     }
//
//     /** Reads information about battles from the specified file into the appropriate collection
//      * @param the name of the file
//      */
//     private void readBattles(String fname)
//     {
//
//     }


}