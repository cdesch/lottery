package com.raff;
import javax.management.RuntimeErrorException;
import java.util.Random;
import java.util.Arrays;
import java.lang.Math;

public class Lottery {


    private static Random rnd;

    /*
     * Generates lottery picks
     * @param size the number of items that will be generated in the array
     * @param lowValue the bottom end (min) of the range for the random numbers to be generated
     * @param highValue the top end (max) of the range for random numbers to be generated
     * @param seed the seed value for generating random numbers
     * @return a list (array) of integers with represents the lottery options
     */
    public static int[] generatePicks(int size, int lowValue, int highValue, long seed) {


        //In generatePicks, size must be 3 or greater but no larger than the range from lowValue to highValue.\
        if (size < 3)
        {
            throw new RuntimeErrorException(new Error("The size must be greater than 3"));
        }

        if (size > (highValue - lowValue)){
            throw new RuntimeErrorException(new Error("The size must be less than the difference of the highValue and lowValue"));
        }

        //Create with empty slots of a certain size
        int[] intArray = new int[size];

        //With a loop, generate a random number and insert it into the array
        for (int i = 0; i < size; i++)
        {
            int randomNumber = generateRandomNumberInRange(lowValue, highValue, seed);
            //Check to see if that number is already in the array? If it is not, add it, if it is in the array generate a new random number
            while (isInArray(intArray, randomNumber))
            {
                randomNumber = generateRandomNumberInRange(lowValue, highValue, seed); // WARNING - Potential LARGE Running Loop
            }
            //Lets put the random number generated that we are sure does NOT already exist in the array
            //into the array
            intArray[i] = randomNumber;
        }

        return sortArray(intArray);
    }



    /*
     * //TODO: Docs
     */
    public static int checkUserNumbers(int[] picks, int[] userNumbers) {

        //Check to see that the picks and userNumbers are the same length

        if(picks == null || userNumbers == null)
        {
            throw new RuntimeErrorException(new Error("The parameters cannot be null."));
            //return -1; //Alternatively return -1 if exceptions are not supported
        }

        if(picks.length != userNumbers.length )
        {
            throw new RuntimeErrorException(new Error("The array parameters must be the same size."));
            //return -1; //Alternatively return -1 if exceptions are not supported
        }

        int sharedNumbersCount = 0;

        //Use a nested loop to compare the two arrays
        //if one number shared between the arrays, increment the counter
        for(int i = 0; i < picks.length; i++)
        {
            for(int j = 0; j < userNumbers.length; j++)
            {
                if(picks[i] == userNumbers[j])
                {
                    sharedNumbersCount++;
                }
            }
        }

        return sharedNumbersCount;
    }


    /*
     *   Sorts the array of elements into ascending order
     *   @param unsorted the array of unsorted elements
     *   @return array of sorted elements
     */
    public static int[] sortArray(int[] unsorted)
    {

        //In sortArray, unsorted may not be null. If it is null, throw a RuntimeErrorException
        if (unsorted == null)
        {
            throw new RuntimeErrorException(new Error("the parameter unsorted cannot be null."));
            //return null; //Alternatively return null if exceptions are not supported
        }

        int[] array = Arrays.copyOf(unsorted, unsorted.length);
        Arrays.sort(array);
        return array;
    }

    /*
     * TODO: Doc
     */
    public static int[] generatePrizes(int size, int prizeMoney) {

        //In generatePrizes, size must be at least 3.
        if (size <= 3)
        {
            throw new RuntimeErrorException(new Error("The size can be no less than 3."));
            //return null; //Alternatively return null if exceptions are not supported
        }

        //In generatePrizes, prizeMoney must be at least 0.
        if (prizeMoney < 0)
        {
            throw new RuntimeErrorException(new Error("The prize can be no less than 0."));
            //return null; //Alternatively return null if exceptions are not supported
        }


        //0,0,0

        //Number of possible correct guesses. Starting at not guessing any correct (0 guessed correctly)
        // plus the size of the array as the player may guess N numbers of the size of the array correct.
        int numberPossibleCorrect = size + 1;
        int[] prizes = new int[numberPossibleCorrect]; //Java guarantees that integers will default to 0

        int remainingPrizeMoney = prizeMoney; //Initialize the remaining prize money with the total money available

        //Starting at the right side of the array (highest index) to the last 3 elements of the array
        // calculate the prize money for the level
        for(int i = prizes.length - 1; i > 3; i-- ){
            //Calculate the prize money for the slot
            prizes[i] = calcPrizeMoney(remainingPrizeMoney);
            //Subtract the money allocated for that level from the pool of prize money available.
            remainingPrizeMoney -= prizes[i];
        }

        //Prize Award slots 0,1,2 should ALWAYS be 0 (Set to automatically from JAVA default initialization)
        //The 3rd index should ALWAYS be the remaining amount of money
        prizes[3] = remainingPrizeMoney;

        return prizes;
    }

    /*
     * Helper Function to Calculate Prize Value
     */

    public static int calcPrizeMoney(int prizeMoney){
        //Cast to floats then determine 3/4 amount. Round to nearest dollar
        float prizeValue = (float) ((float)prizeMoney * 0.75);
        return Math.round(prizeValue);
    }

    /////////////////////////////////////
    /*
     * Helper Methods for utility within the program for
     */
    /////////////////////////////////////


    /*
     * Helper Method to Generate Random number within a range
     * @param low is the lower range the number must be within
     * @param high is the higher range the number must be within
     * @param seed is the integer seed for randomization
     * @return random is the random number generated within the low and high ranges
     */
    public static int generateRandomNumberInRange(int low, int high, long seed)
    {

        //Check if the lower bound is non equal or higher than the upperbound
        if (low >= high)
        {
            throw new RuntimeErrorException(new Error("The lower bound is greater than the upper bound"));
            //return -1; //Alternatively return -1 if exceptions are not supported
        }

        //Check to make sure that the Random class has been seeded
        if (rnd == null)
        {
            rnd = new Random(seed);
        }

        int random = rnd.nextInt();
        //Potentially bad idea with a long running loop
        while (random < low || random > high)
        {
            random = rnd.nextInt();
        }
        return random;
    }

    /*
     *   Helper Method for checking an array
     *   Determines if an integer is within the array or not.
     *   @param array the array of integers that can be searched through
     *   @param number the item that is being tested to determine if it is in the array
     *   @return boolean return a conditional of the result
     */
    public static boolean isInArray(int[] array, int number)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (number == array[i])
            {
                return true;// Return true that it is in the array and escape the function and loop
            }
        }
        //Return false if the loop completed without finding an item
        //in the array that was equal to the number passed into the argument
        return false;
    }

    /*
     *   Helper Method for general debugging
     *   Prints the array for debugging or utility purposes
     *   @param array the array of elements to be printed
     */
    public static void printArray(int[] array)
    {
        System.out.print("Printing Array: ");
        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println(""); //Print Carriage Return using println()
    }
}