package cwk4;

public class WarBird extends Force
{
    private int Strength;
    private boolean HasCloaking;
    public WarBird(String re, String na,boolean HasCloaking, int strength)
    {
        super(re,na,HasCloaking ? 400: 300,strength);
        HasCloaking = HasCloaking;
        if(HasCloaking){
            setBattleType(BattleType.AMBUSH);
        }
        setBattleType(BattleType.FIGHT);
    }
    public boolean hasCloaking(){
        return HasCloaking;
    }
    public String toString(){
        String s="";
        s = s+ super.toString();
        s = s + "\nCloaking: " + HasCloaking;
        return s;
    }

}