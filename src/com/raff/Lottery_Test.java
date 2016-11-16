package com.raff;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.management.RuntimeErrorException;

/**
 * Created by cj on 11/16/16.
 */

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
