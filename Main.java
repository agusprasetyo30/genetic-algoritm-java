package GeneticAlgorithmWordSwitching;

import java.util.Scanner;

public class Main {

    static String kata;
    static int[] target;
    static int generation = 0;

    public static void main(String[] args) {
        input();

        int i = 0;
        int individualSize = target.length;

        /**
         * Menambahkan data-data dalam konstruktor seperti
         * target : Kata/target yang akan dicari menggunakan GA
         * individualSize : Jumlah dari individu/target yang akan dicari
         *  ket : Pada implementasinya bisa di jalankan jika data bernilai GENAP
         *        Jika bernilai GANJIL maka di + 1
         * generation : Nilai awal data generation
         */
        GeneticAlgorithm genetic = new GeneticAlgorithm(target, 
                (individualSize % 2 == 0 ? individualSize : individualSize + 1),
                generation);

        // Melakukan perulangan sampai kata yang diinput sesuai dengan
        while (!kata.equals(genetic.convertDataToString())) {
            genetic.test();
            System.out.print(++i + ") => ");
            genetic.convertToString();
        }

        System.out.println("last generation = " + i);
    }

    /**
     * fungsi untuk menginputkan data yang diinput ke daam array
     */
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
