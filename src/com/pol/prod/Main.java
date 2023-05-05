package com.pol.prod;

/**
 * Created by Vladislav Domaniewski
 */

public class Main {
    public static String [] arrayInput;
    public static int a,b;

    public static String calculator(String input) {

        // Разбираемся со знаком
        String [] actions = {"+", "-", "/", "*"};
        int actionIndex = -1;
        for (int i = 0; i < actions.length; i++) {
            if (input.contains(actions[i])){
                actionIndex = i;
                break;
            };
        }
        if (actionIndex == -1) {
            return "Такого знака действия с числами нету ";
        }
        // ===========================================

        // Определяем арабские или римские цифры
        arrayInput = input.split(" ");
        int countNumberArabian = 0;
        try {
            for (int i = 1; i <= 10; i++) {
                String checkNumber = Integer.toString(i);
                if (arrayInput[0].contains(checkNumber)) {
                    countNumberArabian++;
                }
                if (arrayInput[2].contains(checkNumber)) {
                    countNumberArabian++;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            return "Неверно задан формат";
        }

        // ============================================

        // Проверка чисел на один формат
        // Римские числа
        if (countNumberArabian == 0) {
            a = NumberTranslation.romanToArabic(arrayInput[0]);
            b = NumberTranslation.romanToArabic(arrayInput[2]);
            if (a > 10 || b > 10) {
                return "Числа выходят за пределы диапазона";
            }
            String result = actionWithNumber(actions, actionIndex);
            NumberTranslation numberTranslation = new NumberTranslation();
            return numberTranslation.arabicToRoman(Integer.parseInt(result));
        }
        if (countNumberArabian == 1) {
            return "Числа должны быть одного формата";
        }
        //Арабские
        if (countNumberArabian == 2 | countNumberArabian == 4 | countNumberArabian == 3) {
            try {
                a = Integer.parseInt(arrayInput[0]);
                b = Integer.parseInt(arrayInput[2]);
            } catch (NumberFormatException e) {
                return "Числа должны быть одного формата";
            }

        }
        // Проверка диапазона
        if (a > 10 || b > 10) {
            return "Числа выходят за пределы диапазона";
        }

        // Проводим алгебраические операции

        return actionWithNumber(actions, actionIndex);
    }

    private static String actionWithNumber(String [] actions, int actionIndex) {
        int res = 0;
        switch (actions[actionIndex]) {
            case "+":
                res = a + b;
                return Integer.toString(res);
            case "-":
                res = a - b;
                return Integer.toString(res);
            case "/":
                res = a / b;
                return Integer.toString(res);
            case "*":
                res = a * b;
                return Integer.toString(res);
        }
        return "";
    }
}
