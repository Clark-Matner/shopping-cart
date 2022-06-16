import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import src.main.models.Cart;
import src.main.models.Item;

public class CartTest {
    Cart cart;

    @Before
    public void setup(){
        cart = new Cart();
        cart.add(new Item("Pepsi", 1.99));
        cart.add(new Item("Crush", 1.99));
    }

    @Test
    public void itemAddedTest(){
        assertTrue(cart.contains(new Item("Pepsi", 1.99)));
    }
  

    @Test
    public void skipsDuplicate(){
        assertTrue(cart.add((new Item("Crush", 1.99))));
    }

    @Test
    public void removedItemTest(String name){
        cart.remove("Crush");
        assertFalse(cart.contains((new Item("Crush", 1.99))));

    }

    @Test
    public void subtotalIsValid(){
        assertEquals(13.5, cart.getSubtotal());
    }

    @Test
    public void taxIsvalid(){
        assertEquals(4.5, cart.getTax(30));
    }

    @Test
    public void totalIsValid(){
        assertEquals(96.67, cart.getTotal(85.55, 11.12));
    }


    
}
