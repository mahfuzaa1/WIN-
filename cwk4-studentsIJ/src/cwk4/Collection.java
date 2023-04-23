package cwk4;
import java.util.*;
public class Collection
{
    private ArrayList<Force> UFF;
    private ArrayList<Force> ASF;
    private ArrayList<Force> Destroyed;

    public Collection()
    {
        // initialise instance variables
        UFF = new ArrayList<Force>();
        ASF = new ArrayList<Force>();
        Destroyed = new ArrayList<Force>();
    }
    public void enterUFF(Force f){
        UFF.add(f);
    }
    public void enterASF(Force f){
        ASF.add(f);
    }
    public void addDestroyed(Force f){
        Destroyed.add(f);
    }
    public Force findForceUFF(String ref){
        for(Force temp: UFF){
            if(temp.getReference() == ref){
                return temp;
            }
        }
        return null;
    }
    public boolean isInUFF(String ref){
        Force f = findForceUFF(ref);
        return f!= null;
    }
    public Force findForceASF(String ref){
        for(Force temp: ASF){
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
        int pos = ASF.indexOf(f);
        if(pos >=0){
            ASF.remove(pos);
        }
    }
    public void removeUFForce(Force f){
        int pos = UFF.indexOf(f);
        if(pos >=0){
            UFF.remove(pos);
        }
    }
    public Force getFirstASF(){
        if(ASF.size() >0){
            return ASF.get(0);
        }
        else{
            return null;
        }}
    public String allUFF(){
        String s = "\n--------------\n";
        if(UFF.size() <=0){
            s+="No Forces";
        }
        else{
            for(Force ff :UFF){
                s = s + ff.toString() +"\n";
            }
        }
        return s;
    }
    public String allASF(){
        String s = "\n-------------\n";
        if(ASF.size() <=0){
            s +="No Forces";
        }
        else{
            for(Force ff: ASF){
                s = s + ff.toString() +"\n";
            }
        }
        return s;
    }
    public String allDestroyed(){
        String s = "\n------------\n";
        if(Destroyed.size() <=0){
            s +="No forces";
        }
        else{
            for(Force ff: Destroyed){
                s = s + ff.toString() +"\n";
            }
        }
        return s;
    }
    public int allowActivate(Force ff){
        String ForceRef = ff.getReference();
        if(!isInUFF(ForceRef)){
            return 1;
        }
        else if(ff.getWarchest() < ff.getFee()){
            return 2;
        }
        else{
            removeUFForce(ff);
            enterASF(ff);
            ff.activate();
            return 0;
        }
    }
}

