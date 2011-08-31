package nl.svenvintges.codekata.harrysales;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: sven
 * Date: 8/26/11
 * Time: 9:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class SalesBasketTest {

    SalesBasket basket;

    @Before
    public void setup() {
        basket = new SalesBasket();
    }

    @Test
    public void oneBookPrice() {
        basket.addBook("Book1");
        assertEquals("8.00 EU", basket.getTotalPrice());
    }

    @Test
    public void twoDiffBookPrice() {
        basket.addBook("Book1");
        basket.addBook("Book2");
        assertEquals("15.20 EU", basket.getTotalPrice());
    }

    @Test
    public void threeDiffBookPrice() {
        basket.addBook("Book1");
        basket.addBook("Book2");
        basket.addBook("Book3");
        assertEquals("21.60 EU", basket.getTotalPrice());
    }

    @Test
    public void fourDiffBookPrice(){
        basket.addBook("Book1");
        basket.addBook("Book2");
        basket.addBook("Book3");
        basket.addBook("Book4");
        assertEquals("25.60 EU", basket.getTotalPrice());
    }

    @Test
    public void fiveDiffBookPrice()
    {
        basket.addBook("Book1");
        basket.addBook("Book2");
        basket.addBook("Book3");
        basket.addBook("Book4");
        basket.addBook("Book5");
        assertEquals("30.00 EU", basket.getTotalPrice());
    }

    @Test
    public void twoSameBookPrice()
    {
        basket.addBook("Book1");
        basket.addBook("Book1");
        assertEquals("16.00 EU", basket.getTotalPrice());
    }

    @Test
    public void VeryComplexOrder()
    {
        basket.addBook("Book1");
        basket.addBook("Book1");
        basket.addBook("Book2");
        basket.addBook("Book2");
        basket.addBook("Book3");
        basket.addBook("Book3");
        basket.addBook("Book4");
        basket.addBook("Book5");

        assertEquals("51.20 EU", basket.getTotalPrice());
    }
}


