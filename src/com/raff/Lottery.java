package com.raff;
import javax.management.RuntimeErrorException;
import java.util.Random;
import java.util.Arrays;


public class Lottery {


    private static Random rnd;

    /*
     * Generates lottery picks
     * ?Random?
     * @param size the number of items that will be generated in the array
     * @param lowValue the bottom end (min) of the range for the random numbers to be generated
     * @param highValue the top end (max) of the range for random numbers to be generated
     * @param seed the seed value for generating random numbers
     * @return a list (array) of integers with represents the lottery options
     */
    //Dynamic array size


    public static int[] generatePicks(int size, int lowValue, int highValue, long seed) {

        //TODO: check for this. Throw runtime exception like the on in generateRandomNumberInRange() if it is
        //In generatePicks, size must be 3 or greater but no larger than the range from lowValue to highValue.

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

        //printArray(intArray); //FIXME: For debugging - Remove

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
        }

        if(picks.length != userNumbers.length )
        {
            throw new RuntimeErrorException(new Error("The array parameters must be the same size."));
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
        }

        int[] array = Arrays.copyOf(unsorted, unsorted.length);
        Arrays.sort(array);
        return array;
    }

    public static int[] generatePrizes(int size, int prizeMoney) {
        //Check if the lower bound is non equal or higher than the upperbound
        if (size >= 3)
        {
            throw new RuntimeErrorException(new Error("The size can be no less than 3."));
        }

        //Check to make sure that the Random class has been seeded
        if (prizeMoney >= 0)
        {
            throw new RuntimeErrorException(new Error("The prize can be no less than 0."));
        }

        return generatePrizes; //don't know why this wont compile

        //TODO: check for this. Throw runtime exception like the on in generateRandomNumberInRange() if it is
        //TODO: In generatePrizes, size must be at least 3 and prizeMoney must be at least 0.

        //TODO: implement this function



        return new int[]{1, 2, 3};
    }


    /////////////////////////////////////
    /*
     * Helper Methods
     */
    /////////////////////////////////////


    /*
     * //TODO: Doc
     * Helper Method to Generate Random number within a range
     * @param
     */
    public static int generateRandomNumberInRange(int low, int high, long seed)
    {

        //Check if the lower bound is non equal or higher than the upperbound
        if (low >= high)
        {
            throw new RuntimeErrorException(new Error("The lower bound is greater than the upper bound"));
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
     *   Helper function for general debugging
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
    }
}