import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Jakub
 * Date: 27.02.13
 * Time: 15:30
 * To change this template use File | Settings | File Templates.
 */
public class BinaryKeyStream {
    ArrayList<Integer> encryptedMessage=new ArrayList<Integer>();
    public BinaryKeyStream(ArrayList<Integer> message,ArrayList<Integer> key){
        int count=0;
        for(int i: message){
            if (count>=key.size())count=0;
            int next =  (i^key.get(count));
            encryptedMessage.add(next);
            count++;
        }
        System.out.println("message "+message);
        String word2="";
        for (int i: key){
            word2+=i;
        }
        System.out.println("key: "+word2);
        String word3="";
        for (int i: encryptedMessage){
            word3+=i;
        }
        System.out.println("encrypted message: "+word3);
        System.out.println("Testing");
        System.out.println("The size of the key "+key.size());
        System.out.println("Maximum number of permutations");
        System.out.println((int)Math.pow(2,message.size())-1);


    }



}
