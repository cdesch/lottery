package com.raff;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

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

    /*
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
        //These are the same
        if (Lottery.checkUserNumbers(picks, userNumbers) == matchedCount){
            return true;
        }else{
            return false;
        }
    }

    /*
     * //TODO: Document
     */
    //Tests that a RuntimeErrorException is thrown if the arrays are not even
    @Test(expected=RuntimeErrorException.class)
    public void testCheckUserNumbersCaseIllegalAttributeCase(){
        boolean result = testUserNumbersMatched(new int[0], new int[]{1, 2, 3, 4, 5}, 0);
    }

    /*
    * //TODO: Document
    */
    //Tests that a RuntimeErrorException is thrown if the arrays are not even
    @Test(expected=RuntimeErrorException.class)
    public void testSortArrayIllegalAttributeCase(){
        //int[] myUninitializedArray;
        //int[] sorted = Lottery.sortArray(myUninitializedArray);
    }



    //Tests the extreme bounds of ensuring the random number is within the input parameters
    @Test
    public void testGenerateRandomNumberInRangeEdgeCase(){
        int lower_bound = 4;
        int upper_bound = 12;
        int random_number = Lottery.generateRandomNumberInRange(lower_bound,upper_bound, SEED);
        assertTrue("Test that the random number is within the range", random_number >= lower_bound && random_number <= upper_bound );
        assertFalse("Test that the random number is not outside the lower range", random_number < lower_bound);
        assertFalse("Test that the random number is not outside the upper range", random_number > upper_bound);
    }

    //Tests that a RuntimeErrorException is thrown if the attributes of High and Low are not passed respecting the require input type;
    @Test(expected=RuntimeErrorException.class)
    public void generateRandomNumberInRangeIllegalAttributesCase(){
        int random_number = Lottery.generateRandomNumberInRange(HIGH_VALUE,LOW_VALUE, SEED);
    }

    //Tests if a integer is in an array
    @Test
    public void testIsInArray(){
        assertTrue("Testing that item is in an array", Lottery.isInArray(sampleFixedArray, 4));
        assertFalse("Testing that item is not in an array", Lottery.isInArray(sampleFixedArray, 6));
    }

}
