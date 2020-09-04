package com.dicegame;

import java.util.Arrays;
import java.util.Scanner;

public class Dicegame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int higscore[] = new int[100];
        int playerThrows;
        int computerThrows;
        int amountOfThrows;
        int sideOfDice = 6;
        int playersScore = 0;
        int computerScore = 0;
        int menuChoice;
        System.out.println(" Hej och välkommen till Tärningen. Vänligen skriv in ditt namn");
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
                    System.out.println("Du har valt att spela");
                    System.out.println("Hur många gånger vill du kasta?");
                    amountOfThrows = scanner.nextInt();

                    for (int i = 1; i <= amountOfThrows; i++) {
                        playerThrows = (int) (Math.random() * sideOfDice + 1);
                        computerThrows = (int) (Math.random() * sideOfDice + 1);
                        System.out.println(playerName + "s kast " + i + " är " + playerThrows);
                        System.out.println("Datorns kast " + i + " är " + computerThrows);
                        System.out.println("________________________");
                        playersScore += playerThrows;
                        computerScore += computerThrows;

                    }
                    System.out.println(playerName + "s totala score är " + playersScore);
                    System.out.println("Datorns totala score är " + computerScore);

                    if (playersScore > computerScore) {
                        System.out.println(playerName + " vinner");
                        System.out.println(playersScore + " Tillagt i highscore.");
                        System.out.println("________________________");
                        higscore[checker] = playersScore;
                        checker++;


                    } else if (playersScore < computerScore) {
                        System.out.println("Datorn vinner");
                        System.out.println(computerScore + " Tillagt i highscore.");
                        System.out.println("________________________");
                        higscore[checker] = computerScore;
                        checker++;


                    } else {
                        System.out.println("Det blev lika, inget score tillagt.");

                    }
                    break;

                case 2:
                    System.out.println("Du har valt att visa highscorelistan");
                    printHighScoreList(sortHighScoreList(higscore));

                    break;
                case 3:
                    System.out.println("Du har valt att avsluta spelet");
                    gameOn = false;
                    break;

                default:
                    System.out.println("Du har inte valt något. Försök igen");
                    break;
            }
        }
    }

    public static void printHighScoreList(int sortedHighScoreList[]) {
        int position = 0;
        for (int i = 0; i < 3; i++) {
            position++;
            System.out.println("Placering " + position + " Med poäng " + sortedHighScoreList[i]);
        }
        System.out.println("________________________");
    }


    public static int[] sortHighScoreList(int unSortedHighScorelist[]) {
        int sortedHighScorelist[] = Arrays.copyOf(unSortedHighScorelist, unSortedHighScorelist.length);
        boolean sorted = true;
        while (sorted) {
            sorted = false;
            for (int i = 0; i < sortedHighScorelist.length - 1; i++) {
                if (sortedHighScorelist[i] < sortedHighScorelist[i + 1]) {
                    int temp = sortedHighScorelist[i + 1];
                    sortedHighScorelist[i + 1] = sortedHighScorelist[i];
                    sortedHighScorelist[i] = temp;
                    sorted = true;
                }
            }
        }
        return sortedHighScorelist;
    }
}
