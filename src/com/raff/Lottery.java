package com.raff;
import java.util.Arrays;
import java.util.Random;
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

        rnd = new Random(seed);
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
        //Generating random numbers

        rnd = new Random(seed);
        int[] intArray = new int[size];

        //Create with empty slots of a certain size
        for (int i = 0; i < size; i++) {
            int randomNumber = generateRandomNumber(lowValue, highValue);
            while (isInArray(intArray, randomNumber)) {
                randomNumber = generateRandomNumber(lowValue, highValue); // WARNING - Potential LARGE Running Loop
            }
            intArray[i] = randomNumber;
        }

        printArray(intArray);

        //With a loop, generate a random number
        //Check to see if that number is already in the array? If it is not, add it, if it is in the array generate a new random number

        //Sort those random numbers

        //TODO: Replace with random generator
        return new int[]{1, 2, 3};

    }


    public static int checkUserNumbers(int[] picks, int[] userNumbers) {

        return 1;
    }

    public static int[] sortArray(int[] unsorted) {

        //Bubble Sort or Something
        return new int[]{1, 2, 3};
    }

    public static int[] generatePrizes(int size, int prizeMoney) {

        return new int[]{1, 2, 3};

    }

    public static int generateRandomNumber(int low, int high) {

        //Check to make sure that the Random class has been seeded
        if (rnd == null) {
            String message = "rnd property was not initialized correctly prior to running generateRandomNumber()";
            System.out.println(message);
            //throw IllegalArgumentException(message);
        }

        int random = rnd.nextInt();
        //Potentially bad idea with a long running loop
        while (random < low || random > high) {
            random = rnd.nextInt();
        }
        return random;
    }

    public static boolean isInArray(int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            if (number == array[i]) return true; // Return true that it is in the array and escape the function and loop
        }
        return false;
    }

    public static void printArray(int[] array) {
        System.out.print("Printing Array: ");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }

    public static int[] bubbleSort(int[] unsorted) {

        return new int[]{1, 2, 3};
    }
}