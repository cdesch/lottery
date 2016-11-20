package com.raff;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.Arrays;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.management.RuntimeErrorException;


public class Lottery_Test {


    //Test Class Attributes
    public static int[] seedArray;
    public static int[] sampleFixedArray;
    public static int SIZE = 6;
    public static int LOW_VALUE = 1;
    public static int HIGH_VALUE = 40;
    public static int SEED = 314159;
    public static int TOTAL_PRIZE = 10000;


    @BeforeClass
    public static void setUpClass() {
        System.out.println("Test Class Setup & Seed Attributes");
        seedArray = Lottery.generatePicks(5,10,25,2342);
        sampleFixedArray = new int[]{1, 2, 3, 4, 5};

        SIZE = 6;
        LOW_VALUE = 1;
        HIGH_VALUE = 40;
        SEED = 314159;
        TOTAL_PRIZE = 10000;
    }

    /*
     * Before running each test, generate seed data that can be reused
     */
    @Before
    public void seedData(){

    }

    ///////////////////////////////////////
    // generatePrizes Test Cases
    ///////////////////////////////////////

    /*
     * Test GeneratePrizes()
     */
    @Test
    public void testGeneratePrizesCase(){
        generatePrizesArrayAssertion(6, 1000, new int[]{0, 0, 0, 15, 47, 188, 750});
        generatePrizesArrayAssertion(6, 750, new int[]{0, 0, 0, 12, 35, 140, 563 });
        generatePrizesArrayAssertion(7, 250, new int[]{0, 0, 0, 1, 3, 11, 47, 188 });
        generatePrizesArrayAssertion(10, 250, new int[]{0, 0, 0, 0, 0, 0, 1, 3, 11, 47, 188  });
    }

    /*
     * Helper for testGeneratePrizesCase for repeatable expected results
     * @param size of the array
     * @param prizeMoney of the total jackpot
     * @param expectedResults array of elements expect for a passing test
     */
    public void generatePrizesArrayAssertion(int size, int prizeMoney, int[] expectedResults){
        int[] prizes =  Lottery.generatePrizes(size, prizeMoney);
        //Lottery.printArray(prizes);
        //Lottery.printArray(expectedResults);
        assertTrue("Tests generated prizes correctly", Arrays.equals(prizes, expectedResults));
        //The sum of the elements in the array should equal the prize money
        assertEquals("Tests that the prize money allocated to each slot " +
                "of the array is equal to total amount of money passed in",
                sumElementsInArray(prizes), prizeMoney);
    }

    /*
     * Helper function to sum the number of elements in the array
     * @param array is an array of integer values
     * @return sumOfElements is the summation of all the elements in the array
     */
    public int sumElementsInArray(int[] array){
        int sumOfElements = 0;
        for(int i = 0; i < array.length; i++){
            sumOfElements += array[i];
        }
        return sumOfElements;
    }


    /*
     * Test calcPrizeMoney helper function for generatePrizes()
     */
    @Test
    public void testCalcPrizeMoneyCase(){


        int[] prizeMoneyValues = new int[]{1000, 250, 62, 500};
        int[] expectedResults  = new int[]{750, 188, 47, 375};

        //Loop through each test case expecting to round to nearest integer
        for (int i = 0; i < prizeMoneyValues.length; i++ ){
            assertEquals("Test that prize money is calcuated correctly at 3/4 of the value",
                    Lottery.calcPrizeMoney(prizeMoneyValues[i]), expectedResults[i]);
        }

    }

    /*
     * Tests that a RuntimeErrorException is thrown if size is less than 3
     * TODO: DOC
     */
    @Test(expected=RuntimeErrorException.class)
    public void testGeneratePrizesCaseIllegalSize(){
        int[] prizes = Lottery.generatePrizes(2, 100);
    }


    /*
     * Tests that a RuntimeErrorException is thrown if size is less than 3
     * TODO: DOC
     */
    @Test(expected=RuntimeErrorException.class)
    public void testGeneratePrizesCaseIllegalPrizeMoney(){
        int[] prizes = Lottery.generatePrizes(4, -100);
    }

    ///////////////////////////////////////
    // checkUserNumbers Test Cases
    ///////////////////////////////////////

    /*
     * Test checkUserNumbers function
     * TODO: Document properly
     */
    @Test
    public void testCheckUserNumbersCase(){

        assertTrue("Test that there are " + String.valueOf(2) + " number elements shared between the arrays",
                testUserNumbersMatched(new int[]{10, 9, 3, 6, 5}, new int[]{1, 2, 3, 4, 5}, 2));
        assertTrue("Test that there are " + String.valueOf(0) + " elements shared between the arrays",
                testUserNumbersMatched(new int[]{10, 9, 11, 6, 23}, new int[]{1, 2, 3, 4, 5}, 0));
        assertFalse("Test that there are not " + String.valueOf(0) + " elements shared between the arrays",
                testUserNumbersMatched(new int[]{10, 9, 3, 6, 5}, new int[]{1, 2, 3, 4, 5}, 3));
        assertTrue("Test that there are " + String.valueOf(5) + " elements shared between the arrays",
                testUserNumbersMatched(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}, 5));
        assertTrue("Test that there are " + String.valueOf(0) + " elements shared between the arrays",
                testUserNumbersMatched(new int[0], new int[0], 0));
    }

    /*
     * Helper Function for test case testCheckUserNumbersCase()
     * @param
     * @param
     * @param
     * @return
     */
    public boolean testUserNumbersMatched(int[] picks, int[] userNumbers, int matchedCount){
        //return Lottery.checkUserNumbers(picks, userNumbers) == matchedCount ? true : false;
        //The Code above and the code below are two different ways to express the same evaluation
        if (Lottery.checkUserNumbers(picks, userNumbers) == matchedCount){
            return true;
        }else{
            return false;
        }
    }

    /*
     * Tests that a RuntimeErrorException is thrown if the arrays are not even
     * //TODO: Document
     */
    @Test(expected=RuntimeErrorException.class)
    public void testCheckUserNumbersCaseIllegalAttributeCase(){
        boolean result = testUserNumbersMatched(new int[0], new int[]{1, 2, 3, 4, 5}, 0);
    }

    ///////////////////////////////////////
    // sortArray Test Cases
    ///////////////////////////////////////

    /*
    * Tests that a RuntimeErrorException is thrown if the arrays are not even
    * //TODO: Document
    */
    @Test(expected=RuntimeErrorException.class)
    public void testSortArrayIllegalAttributeCase(){
        int[] myUninitializedArray = new int[5];
        myUninitializedArray = null;
        int[] sorted = Lottery.sortArray(myUninitializedArray);
    }


    ///////////////////////////////////////
    // generateRandomNumber Test Cases
    ///////////////////////////////////////

    /*
     * Tests the extreme bounds of ensuring the random number is within the input parameters
     */
    @Test
    public void testGenerateRandomNumberInRangeEdgeCase(){
        int lower_bound = 4;
        int upper_bound = 12;
        int random_number = Lottery.generateRandomNumberInRange(lower_bound,upper_bound, SEED);
        assertTrue("Test that the random number is within the range", random_number >= lower_bound && random_number <= upper_bound );
        assertFalse("Test that the random number is not outside the lower range", random_number < lower_bound);
        assertFalse("Test that the random number is not outside the upper range", random_number > upper_bound);
    }

    /*
     * Tests that a RuntimeErrorException is thrown if the attributes of
     * High and Low are not passed respecting the require input type
     */
    @Test(expected=RuntimeErrorException.class)
    public void testGenerateRandomNumberInRangeIllegalAttributesCase(){
        int random_number = Lottery.generateRandomNumberInRange(HIGH_VALUE,LOW_VALUE, SEED);
    }


    ///////////////////////////////////////
    // isInArray Test Cases
    ///////////////////////////////////////

    /*
     * Tests if a integer is in an array
     * Helper Function in
     */
    @Test
    public void testIsInArray(){
        assertTrue("Testing that item is in an array", Lottery.isInArray(sampleFixedArray, 4));
        assertFalse("Testing that item is not in an array", Lottery.isInArray(sampleFixedArray, 6));
    }

}
