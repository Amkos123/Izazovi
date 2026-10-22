package Sedmica2;
/*
 * ZADATAK 1 – Vizit karta
 * Programiranje u Javi – Auditorne vježbe, Sedmica 2
 *
 * Napišite program koji ispisuje vašu vizit kartu, na primjer:
 *
 *   ==============================
 *          VIZIT KARTA
 *   ==============================
 *   Ime:    Amar Hodžić
 *   Studij: Informatika
 *   Godina: 1.
 *   Moto:   "Kod je poezija."
 *   ==============================
 *
 * Uslovi:
 *   1) bar jednom koristite print (bez prelaska u novi red), a ne samo println
 *   2) za poravnanje koristite tabulator  \t
 *   3) moto mora biti pod navodnicima  ->  \"
 *
 * BONUS: ispišite cijelu karticu JEDNOM naredbom println (koristite \n).
 */
public class Zadatak1VizitKarta {

    public static void main(String[] args) {
        System.out.println("==============================");
        // TODO: ispišite naslov i ostale redove vizit karte
        System.out.println("\t VIZIT KARTA");
        System.out.print("==============================\n");
        System.out.println("Ime:\tAmar Hodžić");
        System.out.println("Studij: Informatika");
        System.out.println("Godina: 1.");
        System.out.println("Moto:\t\"Kod je poezija.\"");
    }
}
