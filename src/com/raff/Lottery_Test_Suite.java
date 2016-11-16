package com.raff;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({Lottery_Test.class})

public class Lottery_Test_Suite {


    @BeforeClass
    public static void setUpClass() {
        System.out.println("Master setup");
    }

    @AfterClass public static void tearDownClass() {
        System.out.println("Master tearDown");
    }


}