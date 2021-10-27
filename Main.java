package GeneticAlgorithmWordSwitching;

import java.util.Scanner;

public class Main {

    static String kata;
    static int[] target;
    static int generation = 0;

    public static void main(String[] args) {
        input();

        int i = 0;
        int idividualSize = target.length;

        GenetikAlogarithm demo = new GenetikAlogarithm(target, (idividualSize % 2 == 0 ? idividualSize : idividualSize + 1), generation);

        while (!kata.equals(demo.convertDataToString())) {
            demo.test();
            System.out.print(++i + ") => ");
            demo.convertToString();
        }

        System.out.println("last generation = " + i);
    }

    public static void input() {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukan kata : ");
        kata = input.nextLine();

        target = new int[kata.length()];

        for (int i = 0; i < kata.length(); i++) {
            target[i] = (int) kata.charAt(i) - 96;
        }
    }
}
