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

    public static void main(String[] args) {
        // TODO code application logic here
        String winner = "";

        ArrayList<String> paraules = new ArrayList();
        List<String> paraulesAfegir = Arrays.asList("Dani", "Uri", "Brian", "Daniel", "jju");
        paraules.addAll(paraulesAfegir);

        Random ran = new Random();
        int randomNum = 0 + ran.nextInt((paraules.size() - 0) + 1);

        System.out.println("random: " + randomNum);

        ListIterator<String> lt = paraules.listIterator();
        int i = 1;
        while (lt.hasNext()) {
            String nom = lt.next();

            if(i==randomNum){
                winner=nom;
            }
            System.out.println(i + "- " + nom);
            i++;
        }
        
        int decisio;
        int vides = 3;
        boolean gameOn = true;
        boolean winCondition = false;

        do {

            decisio = Teclado.leerInt("word number\n");

            ListIterator<String> lt2 = paraules.listIterator();

            boolean trobat = false;
            i = 1;
            while (lt2.hasNext() && !trobat) {
                String nom = lt2.next();

                if (i == decisio) {
                    int coincidencies = 0;
                    System.out.println("nom escollit " + nom);
                    char[] nomChar = nom.toCharArray();
                    char[] winnerChar = winner.toCharArray();

                    //comparacio
                    for (int k = 0; k < nomChar.length; k++) {
                        for (int j = 0; j < winnerChar.length; j++) {
                            if (nomChar[k] == winnerChar[j]) {
                                coincidencies++;
                            }
                        }
                    }
                    if (nom.equals(winner)) {
                        winCondition = true;
                        gameOn = false;
                    } else {
                        vides--;
                    }
                    System.out.println("hi ha " + coincidencies + "coincidencies");
                    System.out.println("winner");

                    System.out.println("Vides actuals " + vides);
                    for (char c : winnerChar) {
                        System.out.print(c);
                    }
                    trobat = true;
                }
                i++;
            }

        } while (vides > 0 && gameOn);

        if (winCondition) {
            System.out.println("victory");
        } else {
            System.out.println("game over");
        }

    }

}
