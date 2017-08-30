import java.util.*;
import java.io.*;

class MasterMind{

    public static int[] getArray(int input){
        
        int guess[] = new int[4];
        
        for(int i=3;i>=0;i--){
            int value = input % 10;
            guess[i] = value;
            input = input/10;
        }

        return guess;
    }


    public static void main(String[] args){
        
        int Min=1, Max = 9;
        
        Set<Integer> randomSet = new TreeSet<Integer>();
        while(randomSet.size()<4){
            int value = Min + (int)(Math.random() * ((Max - Min) + 1));
            randomSet.add(value);
        }

        Integer[] secret = randomSet.toArray(new Integer[randomSet.size()]);

        int no_of_guess = 8;
        boolean correct = false;

        System.out.println("Please enter four digit number as your guess! !");

        while(!correct){


            if(no_of_guess==0){
                System.out.println("You are out of guess Please try Again !");
                System.out.println("The correct number is "+secret[0]+""+secret[1]+""+secret[2]+""+secret[3]);
                break;
            }

            int length = 0;
            int input = 0;

            do{
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter Your Guess !");
                
                input = scanner.nextInt();
                length = String.valueOf(input).length();
                if(length!=4){
                    System.out.println("Please enter four digit number ! !");
                }

            }while(length!=4);

            int guess[] = new int[4];

            guess = getArray(input);
            
            int white = 0;
            int black = 0;
            for(int i=0;i<4;i++){
                if(secret[i]==guess[i]){
                    black++;
                }
                for(int j=0; j<4; j++){
                    if(i!=j){
                        if(secret[i]==guess[j]){
                            white++;
                        }
                    }
                }
            }

            no_of_guess--;

            if(black==4){
                System.out.println();
                System.out.println("Congrats !!");
                System.out.println("You have guessed secret correctly");
                correct = true;
            
            }else if(no_of_guess>0){
 
                System.out.println("There are "+black+" digit in correct position");
                System.out.println("There are "+white+" digit in incorrect position");

                System.out.println(no_of_guess+" guess remaining ! !");
            }

        }
    }
}
