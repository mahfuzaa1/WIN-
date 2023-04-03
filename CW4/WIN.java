
/**
 Interace WIN
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface WIN
{
    // instance variables - replace the example below with your own
    /**
     * Returns information about admiral's war chest
     * list of all forces in his active star fleet
     * all forces in the United forces fleet's dock
     * list of all possible battles
     * state of one of the forces
    */
   public String toString();
   
   /**
    * Returns a string containing all forces in the UFF
    */
   public String getAllForces();
   
   /**
    * Returns true if a battle is part of the system
    * otherwise returns false
    * @param: id is battle id
    */
   
   public boolean findBattle(int id);
   
    /**
    * Returns true if a force is part of the system
    * otherwise returns false
    * @param: id is force id
    */
   
   public boolean findForce(int id);
   
   
   /**
    * Returns true if the admiral can activate forces into their active star fleet,false otherwise
    * An active star fleet can be activated if:
    * There are enough resources in the war chest
    * @param: name is the name of the admiral requesting to activate a force
    * @param: id ID of the forces they want to activate into their active star fleet
    */
   public boolean canActivateForce(int id, String name);
   
   /**
    * Returns the result of a request to activate a force
    * A force can be actived if:
    * There are enough resources in the war chest
    * IF there are enough resources in the war chest:
    * Deductions should be made from the war chest
    * Result of activation should be displayed
    * State of war chest should be displayed
    * IF there are not enough resources the state of the system remains the same,an appropriate message is displayed
    * @param: name is the name of the admiral activating the force
    * @param: id is the id of the force they want to activate
    */
   public String ActivateForce(int id, String name);
   
   /**
    * Returns the result of taking a battle
    * The player may choose the battle he would like to take by giving its number
    * A battle can be taken if:
    * the admiral has assembled an active star fleet.
    * If the battle can be taken:
    * The first appropriate force in the ASF will be chosen
    * its battle strengths will be compared to the enemy's battle strenghts
    * IF ASF battle strenghts >= enemy battle strength:
    * The system will display an appropriate message stating the ASF has won
    * battle gains are added to the admiral's war chest
    * IF no suitable force can be found:
    * The system will display an appropriate message stating no suitable force was found
    * battle losses are deducted from war chest
    * IF ASF battle strenght < enemy battle strenght:
    * The system will display an appropriate message stating the ASF has lost
    * battle losses are deducted from war chest
    * ASF force is destroyed
    * @param: name is the name of the admiral
    * @param: num is the number of the battle
    */
   public String DoBattle(int num, String name);
   
   /**
    * Allows credits to be added to war chest if it is running out of money
    * A force may be recalled from the ASF to the UFF dock
    * IF: the force is not destroyed
    * Once the system checks the force is not destroyed
    * it will be removed from the ASF
    * added back to the UFF dock
    * half of the force's activation fee is added to the war chest
    * @param: name is the name of the admiral
    * @param: id is the id of the ASF force
    */
   
   public void RecallForce(int id, String name);
   
   /**
    * Allows player to save the game to a named file
    * @param: name1 is the name of the player
    * @param: name2 is the name of the file 
    */
   
   public void SaveFile(String name1, String name2);
   
   /**
    * Allows player to load the game from a named file
    * @param: name1 is the name of the player
    * @param: name2 is the name of the file 
    */
   
   public void LoadFile(String name1, String name2);
   
   
}
