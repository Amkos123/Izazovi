/*
 * ZADATAK 2 – Kartica lika za igru
 * Programiranje u Javi – Auditorne vježbe, Sedmica 2
 *
 * Napravite varijable za lik iz igre. Za svaku izaberite ODGOVARAJUĆI tip!
 *   - ime lika                          npr. Aria
 *   - klasa lika kao JEDAN znak         npr. 'M' (mag), 'R' (ratnik), 'S' (strijelac)
 *   - nivo                              npr. 7
 *   - zdravlje                          npr. 120
 *   - preciznost                        npr. 0.85
 *   - da li lik ima štit                da / ne
 *   - ukupno iskustvo (XP)              3 500 000 000   <- pažnja: prevelik broj za int!
 *   - konstanta MAX_NIVO = 50           (koristite final)
 *
 * Zatim ispišite karticu, na primjer:
 *
 *   *** Aria (M) ***
 *   Nivo: 7 / 50
 *   Zdravlje: 120
 *   Preciznost: 0.85
 *   Ima štit: false
 *   Iskustvo: 3500000000 XP
 *
 * EKSPERIMENT: pokušajte u int varijablu upisati 3.5, a u char "M" (dvostruki navodnici).
 *              Pročitajte poruku o grešci – šta vam IntelliJ kaže?
 */
public class Zadatak2KarticaLika {

    public static void main(String[] args) {
        // TODO 1: deklarišite i inicijalizirajte varijable
int nivo=7;
char klasa='M';
String ime="Aria";
int zdravlje=120;
double  preciznost=0.85;
boolean imaStit=false;
long iskustvo=3500000000L;
final int MAX_LEVEL=50;




        // TODO 2: ispišite karticu lika
        System.out.println("***" + ime + " (" + klasa + ") ***" );
        System.out.println("Nivo: " + nivo + " / " + MAX_LEVEL);
        System.out.println("Zdravlje: " + zdravlje );
        System.out.println("Precisznost: " + preciznost);
        System.out.println("Ima štit:" + imaStit);
        System.out.println("Iskustvo: " + iskustvo + "XP");

    }
}
