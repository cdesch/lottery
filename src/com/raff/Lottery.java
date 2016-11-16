package com.raff;
import javax.management.RuntimeErrorException;
import java.util.Random;
import java.util.Arrays;
/**
 * Created by cj on 11/16/16.
 */
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


        //Generating random numbers

        //Initial an empty
        for (int i = 0; i < size; i++) {

        }
        //With a loop, generate a random number
        //Check to see if that number is already in the array? If it is not, add it, if it is in the array generate a new random number
        // then add it to the array.

        //Sort those random numbers

        //TODO: Replace with random generator
        return new int[]{1, 2, 3};

    }


    //Generate the array with predefined array size
    public static int[] generatePicksAlternate(int size, int lowValue, int highValue, long seed) {

        //Create with empty slots of a certain size
        int[] intArray = new int[size];


        //With a loop, generate a random number and insert it into the array
        for (int i = 0; i < size; i++) {
            int randomNumber = generateRandomNumberInRange(lowValue, highValue, seed);
            //Check to see if that number is already in the array? If it is not, add it, if it is in the array generate a new random number
            while (isInArray(intArray, randomNumber)) {
                randomNumber = generateRandomNumberInRange(lowValue, highValue, seed); // WARNING - Potential LARGE Running Loop
            }
            intArray[i] = randomNumber;
        }

        printArray(intArray); //FIXME: For debugging - Remove


        int[] sortedArray = sortArray(intArray);

        //Sort those random numbers
        printArray(sortedArray); //FIXME: For debugging - Remove

        return sortedArray;

    }


    public static int checkUserNumbers(int[] picks, int[] userNumbers) {

        return 1;
    }


    /*
    *   Sorts the array of elements into ascending order
    *   @param unsorted the array of unsorted elements
    *   @return array of sorted elements
     */
    public static int[] sortArray(int[] unsorted) {
        int[] array = Arrays.copyOf(unsorted,unsorted.length);
        Arrays.sort(array);
        return array;
    }

    public static int[] generatePrizes(int size, int prizeMoney) {
        return new int[]{1, 2, 3};
    }

    public static int generateRandomNumberInRange(int low, int high, long seed) {

        //Check if the lower bound is non equal or higher than the upperbound
        if (low >= high){
            throw new RuntimeErrorException(new Error("The lower bound is greater than the upper bound"));
        }

        //Check to make sure that the Random class has been seeded
        if (rnd == null) {
            rnd = new Random(seed);
        }

        int random = rnd.nextInt();
        //Potentially bad idea with a long running loop
        while (random < low || random > high) {
            random = rnd.nextInt();
        }
        return random;
    }

    /*
        Determines if an integer is within the array or not.
        @param array the array of integers that can be searched through
        @param number the item that is being tested to determine if it is in the array
        @return boolean return a conditional of the result
     */
    public static boolean isInArray(int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            if (number == array[i]) return true; // Return true that it is in the array and escape the function and loop
        }
        return false;
    }

    /*
        Prints the array for debugging or utility purposes
        @param array the array of elements to be printed
     */
    public static void printArray(int[] array) {
        System.out.print("Printing Array: ");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static int[] bubbleSort(int[] unsorted) {

        return new int[]{1, 2, 3};
    }
}