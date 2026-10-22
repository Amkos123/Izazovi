package Sedmica2;
/*
 * ZADATAK 3 – Koliko sam vremena proveo igrajući?
 * Programiranje u Javi – Auditorne vježbe, Sedmica 2
 *
 * Igrica je zabilježila ukupno vrijeme igranja u SEKUNDAMA.
 * Pretvorite ga u dane, sate, minute i sekunde koristeći operatore  /  i  %.
 *
 *   ukupnoSekundi = 200000   ->   2 d, 7 h, 33 min, 20 s
 *
 * Pomoć:  1 dan = 86 400 s     1 sat = 3 600 s     1 minuta = 60 s
 *         dani    = ukupnoSekundi / 86400;     (koliko CIJELIH dana stane)
 *         ostatak = ukupnoSekundi % 86400;     (sekunde koje su ostale)
 *         ... dalje na isti način za sate i minute
 *
 * Dodatno: napravite boolean varijablu viseOdJednogDana i ispišite je.
 * Provjera: probajte i sa 3661  ->  0 d, 1 h, 1 min, 1 s
 */
public class Zadatak3VrijemeIgranja {

    public static void main(String[] args) {
        int ukupnoSekundi = 200000;

        // TODO: izračunajte dane, sate, minute i sekunde (zamijenite nule izrazima)
        int dani = ukupnoSekundi/86400;
        ukupnoSekundi=ukupnoSekundi %86400;
        int sati = ukupnoSekundi/3600;
        ukupnoSekundi=ukupnoSekundi %3600;
        int minute = ukupnoSekundi/60;
        ukupnoSekundi=ukupnoSekundi%60;
        int sekunde = ukupnoSekundi;

        System.out.println(ukupnoSekundi + " s = " + dani + " d, " + sati + " h, "
                + minute + " min, " + sekunde + " s");

        //  TODO (dodatno): boolean viseOdJednogDana =...
        boolean viseOdJednogDana=dani>1;
        System.out.println("Vise od jednog dana: "+ viseOdJednogDana);
    }
}
