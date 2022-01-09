package com.careerdevs.intro;

import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        System.out.print("Number: ");
        Scanner scan = new Scanner(System.in);
        int Bignum = scan.nextInt();
        int fizz = Bignum % 5;
        int buzz = Bignum % 3;

        if (fizz == 0) {
            if (buzz == 0)
                System.out.println("Fizz Buzz");
            else
                System.out.println("Fizz");
        }
        else if (buzz == 0)
            System.out.println("Buzz");
        else
            System.out.println(Bignum);
    }
}
