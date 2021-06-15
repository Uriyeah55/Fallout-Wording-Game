/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package falloutconsole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/**
 *
 * @author omascarop
 */
public class FalloutConsole {

    static int vides = 5;

    public static void main(String[] args) {
        // TODO code application logic here
        String winner = "";

        ArrayList<String> words = new ArrayList();
        List<String> wordsToAdd = Arrays.asList("Dani", "Uri", "Brian", "Daniel", "Eric", "Carlos", "Pepe");
        words.addAll(wordsToAdd);

        int randomNum = loadRandomWinner(winner, words);

        ListIterator<String> lt = words.listIterator();
        int i = 1;

        while (lt.hasNext()) {

            String currentWord = lt.next();

            if (i == randomNum) {
                winner = currentWord;
            }
            System.out.print(i + "- " + currentWord + " |");
            i++;
        }

        int choice;
        boolean gameOn = true;
        boolean winCondition = false;

        do {

            choice = askForNumber();
            ListIterator<String> lt2 = words.listIterator();

            boolean trobat = false;
            i = 1;
            while (lt2.hasNext() && !trobat) {
                String nom = lt2.next();

                if (i == choice) {
                    int matches = 0;
                    //System.out.println("chosen " + nom);
                    char[] nomChar = nom.toCharArray();
                    char[] winnerChar = winner.toCharArray();

                    //comparing strings char by char
                    for (int k = 0; k < nomChar.length; k++) {
                        for (int j = 0; j < winnerChar.length; j++) {
                            if (nomChar[k] == winnerChar[j]) {
                                matches++;
                            }
                        }
                    }
                    if (nom.equals(winner)) {
                        winCondition = true;
                        gameOn = false;
                    } else {
                        vides--;
                    }
                    System.out.println("There are " + matches + " matches");

                    System.out.println("Lives left= " + vides);
                    for (char c : winnerChar) {
                        System.out.print(c);
                    }
                    trobat = true;
                }
                i++;
            }

        } while (vides > 0 && gameOn);
        System.out.println("");
        if (winCondition) {
            System.out.println("Victory");
        } else {
            System.out.println("Game Over");
        }

    }

    static int askForNumber() {
        System.out.println("");
        int choice = Teclado.leerInt("Name index?\n");
        return choice;
    }

    static int loadRandomWinner(String winnerStr, ArrayList<String> paraules) {
        Random ran = new Random();
        int randomNum = 1 + ran.nextInt((paraules.size() - 1) + 1);

        //System.out.println("random: " + randomNum);
        return randomNum;
    }

}
