package com.raff;
//import static org.junit.Assert.assertEquals;
//import org.junit.Test;
/**
 * Created by cj on 11/16/16.
 */
public class Lottery_Test {


    public int[] seedTests(){
        return Lottery.generatePicks(5,10,25,2342);
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

}
