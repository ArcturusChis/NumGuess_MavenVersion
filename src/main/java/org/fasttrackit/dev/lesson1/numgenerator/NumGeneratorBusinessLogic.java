package org.fasttrackit.dev.lesson1.numgenerator;

/**
 * Created by condor on 29/11/14.
 * FastTrackIT, 2015
 */


/* didactic purposes

Some items are intentionally not optimized or not coded in the right way

FastTrackIT 2015

*/

public class NumGeneratorBusinessLogic {

    private static final int MAX_NUMBER = 6;

    private double t1;
    private double t2;
    private double diff;
    private boolean isFirstTime = true;
    private boolean successfulGuess;
    private int numberOfGuesses;
    private int generatedNumber;
    private String hint;

    public NumGeneratorBusinessLogic(){
        resetNumberGenerator();
    }

    public boolean getSuccessfulGuess(){
        return successfulGuess;
    }

    public String getHint(){
        return hint;
    }

    public int getNumGuesses(){
        return numberOfGuesses;
    }

    public boolean isFirstTime(){
        return isFirstTime;
    }

    public double getDiff() {return diff; }

    public void resetNumberGenerator(){
        isFirstTime = true;
        numberOfGuesses = 0;
        hint = "";
        //reset diff
        diff= 0;
    }

    public boolean determineGuess(int guessNumber){
        if (isFirstTime) {

            // t1 =Syste.current
            t1=System.currentTimeMillis();
            System.out.println("Timpul de inceput  "+t1);

            generatedNumber = NumGenerator.generate(MAX_NUMBER);
            System.out.println("gennr:"+generatedNumber);
            isFirstTime = false;
        }
        numberOfGuesses++;
        if (guessNumber == generatedNumber) { //gasit
            //t2
            t2=System.currentTimeMillis();
            System.out.println("timp final"+ t2);

            // diff=t2-11 /1000
            diff = (t2-t1)/1000.0;


            //sout
            System.out.println("timpul scurs "+diff);

            hint="";
            successfulGuess = true;
        } else if (guessNumber < generatedNumber) {
            hint = "higher";
            successfulGuess = false;
        } else if (guessNumber > generatedNumber) {
            hint = "lower";
            successfulGuess = false;
        }
        return successfulGuess;
    }


}