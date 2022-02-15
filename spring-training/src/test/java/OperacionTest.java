import Interfaz.OperacionImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OperacionTest {

    @Test
    public void testSuma(){
        int a = 7;
        int b = 6;

        OperacionImpl op = new OperacionImpl();
        int expResult = 14;
        int resultado = op.suma(a,b);
        assertEquals(expResult,resultado);
    }

    @Test
    public void testResta(){
        int a = 7;
        int b = 6;

        OperacionImpl op = new OperacionImpl();
        int expResult = 1;
        int resultado = op.resta(a,b);
        assertEquals(expResult,resultado);
    }
}
