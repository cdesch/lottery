package com.raff;

import java.util.Scanner;

/**
 * Driver for PA5 of CS 139.
 *
 * @author R.Grove
 * @version 0.1 2012Nov06
 */
public class LotteryDriver {

    /**
     * Simulates a lottery.
     *
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {
        int[] picks;
        int[] prizes;
        int[] userNumbers;
        Scanner keyboard;
        boolean inputError;
        int correctChoices;

        final int SIZE = 6;
        final int LOW_VALUE = 1;
        final int HIGH_VALUE = 40;
        final int SEED = 314159;
        final int TOTAL_PRIZE = 10000;

        picks = Lottery.generatePicksAlternate(SIZE, LOW_VALUE, HIGH_VALUE, SEED);
        // generate the picks
        picks = Lottery.generatePicks(SIZE, LOW_VALUE, HIGH_VALUE, SEED);
        for (int i=0; i<picks.length; i++) {
            System.out.print(" " + picks[i]);
        }
        System.out.println();

        // determine the prize amounts
        prizes = Lottery.generatePrizes(SIZE, TOTAL_PRIZE);

        // get the user's choices
        userNumbers = new int[SIZE];
        keyboard = new Scanner(System.in);
        for (int i=0; i<SIZE; i++) {
            do {
                System.out.print("Enter a value between " + LOW_VALUE + " and "
                        + HIGH_VALUE + ": ");

                if (!keyboard.hasNextInt()) {
                    System.out.println("Error: that was an invalid selection.");
                    inputError = true;
                }
                else {
                    userNumbers[i] = keyboard.nextInt();
                    inputError = false;

                    if (userNumbers[i] < LOW_VALUE || userNumbers[i] > HIGH_VALUE) {
                        System.out.println("Error: that number is out of range.");
                        inputError = true;
                    }
                }

                keyboard.nextLine();
            } while (inputError);
        }

        // count the matching choices
        correctChoices = Lottery.checkUserNumbers(picks, userNumbers);
        System.out.println("You chose " + correctChoices + " matching numbers");
        System.out.println("You won " + prizes[correctChoices] + " dollars!");

    } // end main

} // end LotteryDriver