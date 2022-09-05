package com.gb;

import java.util.Locale;

public class Palindrome2 {
    public static void main(String[] args) {
        String original = "Madam I m Adam";
        original = original.replace(" ", "");
        original = original.toLowerCase(Locale.forLanguageTag("[^a-zA-Z0-9]"));

        String reverse = "";
        for (int i = original.length() - 1; i >= 0; i--) {
            reverse += original.charAt(i);
            System.out.println(reverse);

        }
        boolean palindrome = true;
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) != reverse.charAt(i)) {
                palindrome = false;
            }
        }
        if (palindrome) {
            System.out.println("PALINDROME!");
        } else {
            System.out.println("Not a palindrome!");
        }
    }
}
