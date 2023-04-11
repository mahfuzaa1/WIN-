package cwk4;

import java.util.ArrayList;

public class Force {

    private String reference;
    private String name;
    private String type;
    private int fee;
    private int Strength;
    private int warchest;
    private ArrayList<Force> UFFList =  new ArrayList<Force>();
    private ArrayList<Force> ASFList =  new ArrayList<Force>();

    public Force(String re, String na, int f, int str,String ty){

        reference = re;
        name = na;
        fee = f;
        Strength = str;
        type = ty;
        warchest = 1000;
    }
    public String getReference(){
        return reference;
    }
    public String getname(){
        return name;
    }
    public int getFee(){
        return fee;
    }
    public int getStrength(){
        return Strength;
    }
    public String getType(){
        return type;
    }
    public void deductWarchest(int num){
        warchest -= num;
    }
    public void addWarchest(int num){
        warchest += num;
    }
    public int getWarchest(){return warchest; }
    public void enterUFF(Force f){
        UFFList.add(f);
    }
    public void enterASF(Force f){
        ASFList.add(f);
    }
    public Force findForceUFF(String ref){
       for(Force temp: UFFList){
           if(temp.getReference() == ref) {
               return temp;
           }
       }
        return null;
    }
    public boolean isInUFF(String ref){
        Force f = findForceUFF(ref);
        return f != null;
    }
    public Force findForceASF(String ref){
      for(Force temp:ASFList){
          if(temp.getReference() == ref){
              return temp;
          }
      }
      return null;
    }
    public boolean isInASF(String ref){
        Force f = findForceASF(ref);
        return f != null;
    }
    public void removeASForce(Force f){
        int pos = ASFList.indexOf(f);
        if(pos >=0){
            ASFList.remove(pos);
        }
    }
    public void removeUFForce(Force f){
        int pos = UFFList.indexOf(f);
        if(pos >= 0){
            UFFList.remove(pos);
        }
    }
    public String allUFFPasses(){
      String s = getname() +"\n----------------\n";
      if(UFFList.size() <= 0){
          s+="No passes";
      }
      else{
          for(int i=0; i<= UFFList.size();i++){
              s = s +"\n"+UFFList.get(i);
          }
      }

      return s;
    }
    public String allASFPasses(){
        String s = getname() + "\n---------------\n";
        if(ASFList.size() <= 0){
            s += "No Passes";
        }
        else{
            for(int i=0; i<=ASFList.size();i++){
                s = s + "\n" + ASFList.get(i);
            }
        }
        return s;
    }
    public String toString(){
        String s = "";
        s += "\nReference : "+ reference +"\nname : " + name + "\nType:"
                 + type +"\nFee : " + fee + "Strength: " + Strength;
        return s;
    }

}
