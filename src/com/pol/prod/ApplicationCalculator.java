package com.pol.prod;

import java.util.Scanner;

/**
 * Created by Vladislav Domaniewski
 */

public class ApplicationCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Main.calculator(scanner.nextLine()));
    }
}
