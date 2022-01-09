package com.careerdevs.intro;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
        int principal = (int) readNumber("Principal", 1000, 1_000_000);
        float annualInterest = (float) readNumber("Annual Interest Rate ", 1, 30);
        byte years = (byte) readNumber("Period (years)", 1, 30);

        printMortgage(principal, annualInterest, years);
        printPaymentSchedule(principal, annualInterest, years);
    }

    public static void printMortgage(int principal, float annualInterest, byte years) {
        double mortgage = calculateMortgage(principal, annualInterest, years);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Monthly Mortgage payments: " + mortgageFormatted);
    }

    public static void printPaymentSchedule(int principal, float annualInterest, byte years) {
        System.out.println("Your Payment Schedule: ");
        System.out.println("____________");
        //PRINT PAYMENT SCHEDULE
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++){
            double balance = calculateBalance(principal, annualInterest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double readNumber(String prompt, double min, double max){
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true){
            System.out.println(prompt);
            value = scanner.nextFloat();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }

    public static double calculateBalance(
            int principal,
            float annualInterest,
            byte years,
            short numberOfPaymentsMade
    ){

        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = (years * MONTHS_IN_YEAR);

        double realRate = 1 + monthlyInterest;

        double balance =
                principal *
                        (Math.pow(realRate, numberOfPayments)
                                - Math.pow(realRate,numberOfPaymentsMade))
                                / (Math.pow(realRate, numberOfPayments) - 1);
        return balance;

    };

    public static double calculateMortgage(
            int principal,
            float annualInterest,
            byte years){

        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        return mortgage;
    }
}
