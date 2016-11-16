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


    @Test
    public void evaluatesExpression() {

        assertEquals(6, 6);
    }


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
    Before running each test, generate seed data that can be reused
     */
    @Before
    public void seedData(){

    }
    /*
    generatePicks
    //TODO Doc properly
     */

    public void generatePicksRangeTest( int min, int max){
        //Test that the

//        fail("Not Implemented");

        //Valid test that has an array with Min - that it is valid
        // generatePicksRangeMinTest(seedTests(), 3); // false
        // generatePicksRangeMinTest(seedTests(), 11); // true
        // generatePicksRangeMaxTest(seedTests(), 11); // true
        // generatePicksRangeMaxTest(seedTests(), 26); // true
        // generatePicksSizeTest(seedTests(), 4); //false for less than
        // generatePicksSizeTest(seedTests(), 5); //true for equals
        // generatePicksSizeTest(seedTests(), 4); //false for greater than

    }

    public void generatePicksRangeMinTest(int[] array, int min){
        //Test that the
       // fail("Not Implemented");
    }

    public void generatePicksRangeMaxTest(int[] array,  int max){
        //Test that the
      //  fail("Not Implemented");
    }


    public void generatePicksSizeTest(int[] array,  int size){
        //Test that the
      //  fail("Not Implemented");
    }


    //TODO: Test 1 seed should not generate the same array as a different seed
    public void generatePicksSeedTest(int[] array,  int size){
        //Test that the
     //   fail("Not Implemented");
    }

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

        //Uneven
        //assertTrue("Test that there are " + String.valueOf(0) + " elements shared between the arrays", testUserNumbersMatched(new int[0], new int[]{1, 2, 3, 4, 5}, 0));
    }

    /*
     * Helper Function for test case testCheckUserNumbersCase()
     * @param
     * @param
     * @param
     * @return
     */
    public boolean testUserNumbersMatched(int[] picks, int[] userNumbers, int matchedCount){
        return Lottery.checkUserNumbers(picks, userNumbers) == matchedCount ? true : false;
    }

    //Tests that a RuntimeErrorException is thrown if the arrays are not event
    @Test(expected=RuntimeErrorException.class)
    public void testCheckUserNumbersCaseIllegalAttributeCase(){
        boolean result =  testUserNumbersMatched(new int[0], new int[]{1, 2, 3, 4, 5}, 0);
    }

    //Tests the extrem bounds of ensuring the random number is within the input parameters
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
