package hust.soict.dsai.lab01.JavaBasics.src;

import java.util.Scanner;
// Exercise 6.2
public class InputFromKeyboard {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What's your name?");
        String strName = keyboard.nextLine();
        System.out.println("How old are you?");
        int iAge = keyboard.nextInt();
        System.out.println("How tall are your (m)?");
        double dHeight = keyboard.nextDouble();
        System.out.println("Mrs/Ms. " + strName + ", " + iAge + " years old. " + "Your height is " + dHeight + ".");
    }
}