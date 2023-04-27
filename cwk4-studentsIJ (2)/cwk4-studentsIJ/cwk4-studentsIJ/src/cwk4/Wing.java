package cwk4;

public class Wing extends Force
{
    private int fee;
    private int Strikers;
    public Wing(String re,String na,int strikers)
    {
        super(re,na,200,20*strikers);
        Strikers = strikers;
        setBattleType(BattleType.SKIRMISH);
        setBattleType(BattleType.AMBUSH);
    }
    public String toString(){
        String s = "";
        s = s + super.toString();
        s = s + "\nStrikers: " + Strikers;
        return s;
    }
}
