package cwk4;
import java.util.*;
public class Tester {
    public void doTest1() {
        WIN fortunate = new SpaceWars("Aya");
        Scanner enter = new Scanner(System.in);
        System.out.println("To string");
        System.out.println(fortunate.toString());
        System.out.println("Forces in dock");
        System.out.println(fortunate.getForcesInDock());
        System.out.println("Force details");
        System.out.println(fortunate.getForceDetails("IW1"));
        System.out.println("Activating AB non existing force");
        System.out.println(fortunate.activateForce("AB"));
        System.out.println("Activating IW1");
        System.out.println(fortunate.activateForce("IW1"));
        System.out.println("Warchest state");
        System.out.println(fortunate.getWarchest());
        System.out.println("Current forces in the ASF");
        System.out.println(fortunate.getASFleet());
        System.out.println("Testing if we are defeated");
        System.out.println(fortunate.isDefeated());
        System.out.println("checking if IW1 is in ASF");
        System.out.println(fortunate.isInASFleet("IW1"));
        System.out.println("checking if IW1 is in UFF");
        System.out.println(fortunate.isInUFFDock("IW1"));
        System.out.println("Recalling IW1 back");
        fortunate.recallForce("IW1");
        System.out.println("state of warchest after recalling the force");
        System.out.println(fortunate.getWarchest());
        System.out.println("printing forces in the UFF(IW1 should now be there)");
        System.out.println(fortunate.getForcesInDock());
        System.out.println("printing the forces in the ASF");
        System.out.println(fortunate.getASFleet());
    }

    public static void main(String[] args) {
        Tester xx = new Tester();
        xx.doTest1();
    }
}

