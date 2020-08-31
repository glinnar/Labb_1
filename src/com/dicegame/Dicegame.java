package com.dicegame;

import java.util.Arrays;
import java.util.Scanner;

public class Dicegame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int higscore[] = new int[3];
        int playerThrows;
        int amountOfThrows;
        int sideOfDice = 6;
        int computerThrows;
        int playersScore = 0;
        int computerScore = 0;
        int menuChoice;
        System.out.println(" Hej och välkommen  till Tärningen .Vänligen skriv in ditt namn");
        String playerName = scanner.nextLine();
        System.out.println("Hej " + playerName + " Du kommer nu få välja mellan tre val");
        boolean gameOn = true;
        int checker = 0;
        while (gameOn) {
            System.out.println("1.Spela");
            System.out.println("2.Visa highscore");
            System.out.println("3.Avsluta spel");
            System.out.println("___________________");
            menuChoice = scanner.nextInt();

            switch (menuChoice) {
                case 1:
                    System.out.println("Du har valt 1");
                    System.out.println("Hur många gånger vill du kasta?");
                    amountOfThrows = scanner.nextInt();

                    for (int i = 1; i <= amountOfThrows; i++) {
                        playerThrows = (int) (Math.random() * sideOfDice + 1);
                        computerThrows = (int) (Math.random() * sideOfDice + 1);
                        System.out.println(playerName + " Kast " + i + " är " + playerThrows);
                        System.out.println("Datorns Kast " + i + " är " + computerThrows);
                        System.out.println("________________________");
                        playersScore += playerThrows;
                        computerScore += computerThrows;

                    }
                    System.out.println(playerName + " Score är " + playersScore);
                    System.out.println("Datorns Score är " + computerScore);

                    if (playersScore > computerScore) {
                        System.out.println(playerName + " Vinner");
                        higscore[checker] = playersScore;
                        checker++;

                        if (higscore[checker] == higscore.length - 1) {
                            higscore[3] = higscore.length - 1;
                            // en if här kanske? som kollar fall man kommit till slutet.
                        }
                        System.out.println("Spelare highscore: " + Arrays.toString(higscore));
                        System.out.println("Hej");

                    } else if (playersScore < computerScore) {
                        System.out.println("Datorn vinner");
                        higscore[checker] = computerScore;
                        checker++;

                        System.out.println("Datorns highscore: " + Arrays.toString(higscore));
                        System.out.println("då");

                    } else if (playersScore == computerScore) {
                        System.out.println("Lika");
                    }
                    break;

                case 2:
                    System.out.println("Du har valt 2");
                    printHighScore(sortHighScoreList(higscore.clone()));

                    break;
                case 3:
                    System.out.println("Du har valt  att avsluta spelet");
                    gameOn = false;
                    break;

                default:
                    System.out.println("Du har inte valt något. Försök igen");
                    break;
            }
        }
    }

    public static void printHighScore(int sortedArray[]) {
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.println("Placering " + " Med poäng " + sortedArray[i]);
        }
    }


    public static int[] sortHighScoreList(int array[]) {
        // int sortedArray[] = Arrays.copyOf(array, array.length);
        boolean sorted = true;
        while (sorted) {
            sorted = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] < array[i + 1]) {
                    int temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                    sorted = true;
                }
            }
        }
        return array;
    }
}
