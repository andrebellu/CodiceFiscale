package fiscal;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner tastiera = new Scanner(System.in);
        CodiceFiscale cod1 = new CodiceFiscale();

        System.out.println("inserire nome");
        cod1.setName(tastiera.nextLine());

        System.out.println("inserire cognome");
        cod1.setSurname(tastiera.nextLine());

        System.out.println("Inserire sesso (M o F)");
        cod1.setGender(tastiera.nextLine());

        System.out.println("inserire comune di nascita");
        cod1.setCity(tastiera.nextLine());

        System.out.println("inserire giorno di nascita");
        cod1.setDay(tastiera.nextInt());

        System.out.println("inserire mese di nascita");
        cod1.setMonth(tastiera.nextInt());

        System.out.println("inserire anno di nascita");
        cod1.setYear(tastiera.nextInt());

        String risFinale=cod1.cutSurname()+cod1.cutName()+cod1.data()+cod1.codiceCatastale();

        System.out.println("Il codice fiscale è "+cod1.cutSurname()+cod1.cutName()+cod1.data()+cod1.codiceCatastale()+cod1.controllo(risFinale));
    }
}
