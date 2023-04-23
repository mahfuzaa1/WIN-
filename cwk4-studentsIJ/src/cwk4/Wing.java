package cwk4;

public class Wing extends Force
{
    private String reference;
    private String name;
    private String type;
    private int fee;
    private int Strength;
    private int warchest;
    private int Strikers;
    public Wing(String re, String na, int f, int str,String ty,int strik)
    {
        super(re,na,f = 200,str = 20*strik,ty);
        Strikers = strik;
    }
    public String toString(){
        String s = "";
        s = s + super.toString();
        s = s + "\nStrikers" + Strikers;
        return s;
    }
}
