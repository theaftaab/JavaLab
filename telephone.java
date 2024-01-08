package MyJavaPractice;

import java.util.HashMap;
import java.util.*;
class missedCall{
    static Map<String, String> missedCalls;
    static HashMap<String,String> callerList = new HashMap<>();
    missedCall(){
        missedCalls = new LinkedHashMap<>();

        callerList.put("9164811216", "aftaab");
        callerList.put("9448266874", "fahi");
        callerList.put("7892304029", "kas");
    }
    public void addMissedCalls(String number){
        if(callerList.containsKey(number)){
            missedCalls.put(number, callerList.get(number));
        }
        else{
            missedCalls.put(number, "private number");
        }
    }
    public void deleteMissedcall(int number){
        if (number <= 0 || missedCalls.isEmpty()) {
            System.out.println("no missed calls");
            return;
        }
        Iterator<Map.Entry<String, String>> iterator = missedCalls.entrySet().iterator();
        int count = 0;
        while (iterator.hasNext() && count < number) {
            iterator.next();
            iterator.remove();
            count++;
        }
    }



}
public class telephone {

    public static void main(String args[]){

        missedCall missobj = new missedCall();
        missobj.addMissedCalls("9164811216");
        missobj.addMissedCalls("9035781499");
        missobj.addMissedCalls("7892304029");

        System.out.println(missobj.missedCalls);
        missobj.deleteMissedcall(1);
        System.out.println(missobj.missedCalls);



    }
}
