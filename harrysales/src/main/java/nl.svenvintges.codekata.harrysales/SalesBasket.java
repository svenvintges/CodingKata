package nl.svenvintges.codekata.harrysales;

import java.beans.BeanInfo;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sven
 * Date: 8/26/11
 * Time: 9:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class SalesBasket {

    private static final double PRIJSPERBOEKSTANDAARD = 8.00;
    private static final double KORTING2BOEKEN = 0.95;
    private static final double KORTING3BOEKEN = 0.90;
    private static final double KORTING4BOEKEN = 0.80;
    private static final double KORTING5BOEKEN = 0.75;
    public int book1, book2, book3, book4, book5;

    public void addBook(String book) {
        if (book.equalsIgnoreCase("book1")) {
            book1++;
        } else if (book.equalsIgnoreCase("book2")) {
            book2++;
        } else if (book.equalsIgnoreCase("book3")) {
            book3++;
        } else if (book.equalsIgnoreCase("book4")) {
            book4++;
        } else if (book.equalsIgnoreCase("book5")) {
            book5++;
        } else {
            // unkown book, throw exception?
        }
    }

    public String getTotalPrice() {
        return String.format("%.2f EU", determineTotalPrice());
    }

    //zou een recursieve variant ook mogelijk zijn?
    private double determineTotalPrice() {

        int totaalBoeken = book1 + book2 + book3 + book4 + book5;
        int berekendeBoeken = 0;
        double laagstePrijsTotNuToe = 0;

        for (int i = 1; i <= 5; i++) {
            List<Integer> bundels = BerekenBundel(i, book1, book2, book3, book4, book5);
            double prijsTotNuToe = 0;

            for (Integer aantalBoeken : bundels) {
                berekendeBoeken += aantalBoeken;
                prijsTotNuToe += getPrijsAantalVoorverschillendeBoeken(aantalBoeken);

            }

            if(laagstePrijsTotNuToe == 0 || (laagstePrijsTotNuToe > prijsTotNuToe && prijsTotNuToe > 0))
                laagstePrijsTotNuToe = prijsTotNuToe;

        }
        //double resterendBedrag = ((book1+book2+book3+book4+book5) *8.00);

        return laagstePrijsTotNuToe;
    }

    private List<Integer> BerekenBundel(int startMaxDepth, int book1, int book2, int book3, int book4, int book5) {
        int maxDepth = startMaxDepth;
        List<Integer> bundels = new ArrayList<Integer>();
        while (book1 + book2 + book3 + book4 + book5 > 0) {
            int aantalBoekenInBundel = 0;
            if (book1 > 0) {
                aantalBoekenInBundel++;
                book1--;
                maxDepth--;
            }
            if (book2 > 0 && maxDepth > 0) {
                aantalBoekenInBundel++;
                book2--;
                maxDepth--;
            }
            if (book3 > 0 && maxDepth > 0) {
                aantalBoekenInBundel++;
                book3--;
                maxDepth--;
            }
            if (book4 > 0 && maxDepth > 0) {
                aantalBoekenInBundel++;
                book4--;
                maxDepth--;
            }
            if (book5 > 0 && maxDepth > 0) {
                aantalBoekenInBundel++;
                book5--;
                maxDepth--;
            }
            maxDepth = 5;
            bundels.add(aantalBoekenInBundel);
        }
        return bundels;
    }

    private double getPrijsAantalVoorverschillendeBoeken(Integer verschillendeBoeken) {

        if (verschillendeBoeken == 2) {
            return (verschillendeBoeken * PRIJSPERBOEKSTANDAARD) * KORTING2BOEKEN;
        } else if (verschillendeBoeken == 3) {
            return (verschillendeBoeken * PRIJSPERBOEKSTANDAARD) * KORTING3BOEKEN;
        } else if (verschillendeBoeken == 4) {
            return (verschillendeBoeken * PRIJSPERBOEKSTANDAARD) * KORTING4BOEKEN;
        } else if (verschillendeBoeken == 5) {
            return (verschillendeBoeken * PRIJSPERBOEKSTANDAARD) * KORTING5BOEKEN;
        } else {
            return PRIJSPERBOEKSTANDAARD;
        }

    }


}
