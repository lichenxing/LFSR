import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Jakub
 * Date: 27.02.13
 * Time: 13:05
 * To change this template use File | Settings | File Templates.
 */
public class LFSR {
    ArrayList Key=new ArrayList<Integer>();
    ArrayList<Integer> taps;

    ArrayList<Integer>  block;
    public void tapPoints(ArrayList<Integer> tapPoints){
         this.taps=tapPoints;

    }

    public ArrayList<Integer> run(ArrayList<Integer> message){

        block=message;
        int NoOfSteps=(int)Math.pow(2,block.size())-1;
        int N=block.size();
        Key.add(new Integer( block.get(N-1)));
        Set<String> testArray=new HashSet<String>();
        String sStr="";
        for(int z:block){
            sStr+=z;

        }
        testArray.add(sStr);
        for (int t=1; t<NoOfSteps; t++){

            int workingValue=block.get(taps.get(0));
            for (int x=1; x<taps.size();x++){
                workingValue=workingValue^block.get(taps.get(x));
            }
            for (int i=N-1; i>0; i--){
                block.set(i, block.get(i - 1));
            }
            block.set(0,workingValue);
            String text="";
            for (int j :block){
                text=text+(j+" , ");
            }
            Key.add(new Integer( block.get(N-1)));
            sStr="";
            for(int z:block){
                sStr+=z;

            }
            testArray.add(sStr);

        }
        System.out.println("Number of distinct combinations "+testArray.size());
        return Key;

    }}



