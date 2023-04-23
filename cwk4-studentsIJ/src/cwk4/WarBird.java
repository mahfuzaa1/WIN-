package cwk4;

public class WarBird extends Force
{
    private String reference;
    private String name;
    private String type;
    private int fee;
    private int Strength;
    private int warchest;
    private boolean Cloaking;
    public WarBird(String re, String na, int f, int str,String ty,boolean cloak)
    {
        super(re,na,f,str,ty);
        Cloaking = cloak;
    }
    public boolean hasCloaking(){
        return Cloaking;
    }
    public void setFee(){
        if(hasCloaking() == true){
            fee = 400;
        }
        else{
            fee = 300;
        }
    }
    public String toString(){
        String s="";
        s = s+ super.toString();
        s = s + "\nCloaking" + Cloaking;
        return s;
    }

}