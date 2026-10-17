package com.chenyuexi;
public class App {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: App <number> <operator> <number>");
            return;
        }
        try {
            System.out.println(new Calculator().eval(args[0], args[1], args[2]));
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid input: " + e.getMessage());
        }
    }
}
