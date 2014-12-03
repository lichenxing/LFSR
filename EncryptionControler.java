import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Jakub
 * Date: 27.02.13
 * Time: 19:01
 * To change this template use File | Settings | File Templates.
 */
public class EncryptionControler {
    LFSR currentLFSC=new LFSR();
    Scanner reader = new Scanner(System.in);
    ArrayList<Integer> binaryMessage=new ArrayList<Integer>();
    public EncryptionControler(){
            while(0!=1){
                System.out.println("1. Enter a binary message to be encrypted ");
                System.out.println("2. Enter a text, which then is converted to ASCII codes and treated as a binary message to encrypt  ");
                System.out.println("-1. To quit");
                System.out.println("enter 1 or 2");
                int choice=0;
                try{

                     choice=reader.nextInt();
                }
                catch (java.util.InputMismatchException e){
                    System.out.println("Wrong input: "+reader.next());
                    choice=0;


                }
                if (choice==-1)System.exit(0);
                if (choice==1){EnterBM();
                    lfsrPar();
                    ArrayList<Integer> messageCopy=new ArrayList<java.lang.Integer>(binaryMessage);
                    new BinaryKeyStream(binaryMessage,currentLFSC.run(messageCopy));
                }
                if (choice==2){EnterText();
                    lfsrPar();
                    ArrayList<Integer> messageCopy2=new ArrayList<java.lang.Integer>(binaryMessage);
                    new BinaryKeyStream(binaryMessage,currentLFSC.run(messageCopy2));}
                if (choice==-1){ break;}
        }

    }
    public void lfsrPar(){
        ArrayList<Integer> tapPoints=new ArrayList<Integer>();
        int a=-5;
        while (0!=1){
            System.out.println("Define the parameters of the linear feedback shift register ");
            System.out.println("Please enter the index of a bit to be tapped");
            System.out.println("To enter multiple tap points pres enter and type another tap point");
            System.out.println("Enter -1 to Finish");
            System.out.println("Enter the number");
            try{
            a=reader.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Wrong input: "+reader.next());
            }
            if (a==-1){
                currentLFSC.tapPoints(tapPoints);
                break;}
            if(a>=0)tapPoints.add(a);


        }



    }



    public void EnterBM(){
        System.out.println("enter the bits");
        reader.nextLine();
        String rawMessage=reader.nextLine();
        String[] splitMessage =rawMessage.split("");
        for (int i=0; i<rawMessage.length();i++){
            binaryMessage.add(Integer.parseInt(Character.toString(rawMessage.charAt(i))));
        }

    }
    public void EnterText(){
        Charset characterSet = Charset.forName("US-ASCII");
        System.out.println("enter the message");
        reader.nextLine();
        String rawMessage=reader.nextLine();
        for(int i=0; i<rawMessage.length();i++){
           int j =(int)rawMessage.charAt(i);
           StringBuffer temp=new StringBuffer(Integer.toBinaryString(j));
           while (temp.length()<8){

               temp.insert(0,'0');}
           for (int r=0; r<8;r++){
            binaryMessage.add(Integer.parseInt(Character.toString(temp.charAt(r))));
        }
    }
    }}
