package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    /**
     * alege notele sub 38
     * @param noten - array de int cu toate notele
     * @return array de int cu notele sub 38
     */
    public static int[] nicht_ausreichend(int[] noten){
        //avem nevoie de o lista de Integer pentru a putea adauga elementele cautate
        List<Integer> filtered = new ArrayList<Integer>();

        //parcurgem array-ul de note si adaugam in lista doar elementele cautate
        for (int a : noten){
            if(a < 38){
                filtered.add(a);
            }
        }

        //avem nevoie sa returnam rezultatul sub forma de array de int
        return filtered.stream().mapToInt(Integer::intValue).toArray();

    }

    /**
     * calculeaza media notelor
     * @param noten - array de int cu toate notele
     * @return media notelor
     */
    public static double durschnittswert(int[] noten){
        double summe = 0;

        //parcurgem array-ul de note si calculam suma notelor
        for (int a : noten){
            summe += a;
        }

        return summe/noten.length;
    }

    /**
     * rotunjeste notele
     * @param noten - array de int cu toate notele
     * @return array de int cu notele rotunjite
     */
    public static int[] gerundete_noten(int[] noten){

        //cream un nou array care va contine notele rotunjite
        int[] gerundet = new int[noten.length];

        //modificam elementele unde se aplica rotunjirea, altfel doar copiem nota din array-ul initial
        for (int i = 0; i < gerundet.length; i++){
            if ((noten[i] + 1)% 5 == 0){
                gerundet[i] = noten[i] + 1;
            }

            else if ((noten[i] + 2)% 5 == 0){
                gerundet[i] = noten[i] + 2;
            }

            else{
                gerundet[i] = noten[i];
            }

        }

        return gerundet;
    }

    /**
     * calculeaza nota maxima rotunjita
     * @param noten - array de int cu toate notele
     * @return int - nota maxima rotunjita
     */
    public static int maximale_note(int[] noten){

        //lucram cu notele rotunjite
        int[] ger = gerundete_noten(noten);
        int max = 0;

        //parcurgem notele si salvam nota maxima
        for (int a : ger){
            if (a > max){
                max = a;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] noten = new int[]{45, 25, 89, 88, 94, 74, 35, 38};

        System.out.println("\nNicht ausreichende Noten:");
        int[] under_38 = nicht_ausreichend(noten);
        for (int a : under_38){
            System.out.println(a);
        }

        System.out.println("\nDurchschnittsnote: " + String.valueOf(durschnittswert(noten)));

        System.out.println("\nGerundete Noten:");
        int[] ger = gerundete_noten(noten);
        for (int a : ger){
            System.out.println(a);
        }

        System.out.println("\nMaximale Note: " + String.valueOf(maximale_note(noten)));

    }
}
