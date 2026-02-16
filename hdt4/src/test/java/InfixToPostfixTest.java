import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import edu.uvg.hdt4.InfixToPostfix;

public class InfixToPostfixTest {

    @Test
    public void testPrecedence() {
        assertEquals(3, InfixToPostfix.precedence('^'));
        assertEquals(2, InfixToPostfix.precedence('*'));
        assertEquals(2, InfixToPostfix.precedence('/'));
        assertEquals(1, InfixToPostfix.precedence('+'));
        assertEquals(1, InfixToPostfix.precedence('-'));
        assertEquals(-1, InfixToPostfix.precedence('('));
    }

    @Test
    public void testRightAssociative() {
        assertTrue(InfixToPostfix.isRightAssociative('^'));
        assertFalse(InfixToPostfix.isRightAssociative('*'));
    }

    @Test
    public void testSimpleExpression() {
        String infix = "A+B";
        String expected = "AB+";

        assertEquals(expected, InfixToPostfix.conversionStackVector(infix));
        assertEquals(expected, InfixToPostfix.conversionStackArrayList(infix));
        assertEquals(expected, InfixToPostfix.conversionStackLista(infix));
    }

    @Test
    public void testPrecedenceExpression() {
        String infix = "A+B*C";
        String expected = "ABC*+";

        assertEquals(expected, InfixToPostfix.conversionStackVector(infix));
        assertEquals(expected, InfixToPostfix.conversionStackArrayList(infix));
        assertEquals(expected, InfixToPostfix.conversionStackLista(infix));
    }

    @Test
    public void testParenthesesExpression() {
        String infix = "(A+B)*C";
        String expected = "AB+C*";

        assertEquals(expected, InfixToPostfix.conversionStackVector(infix));
        assertEquals(expected, InfixToPostfix.conversionStackArrayList(infix));
        assertEquals(expected, InfixToPostfix.conversionStackLista(infix));
    }

    @Test
    public void testPowerAssociativity() {
        String infix = "A^B^C";
        String expected = "ABC^^"; // asociativa a la derecha

        assertEquals(expected, InfixToPostfix.conversionStackVector(infix));
        assertEquals(expected, InfixToPostfix.conversionStackArrayList(infix));
        assertEquals(expected, InfixToPostfix.conversionStackLista(infix));
    }

    @Test
    public void testComplexExpression() {
        String infix = "A+(B*C-(D/E^F)*G)*H";
        String expected = "ABC*DEF^/G*-H*+";

        assertEquals(expected, InfixToPostfix.conversionStackVector(infix));
        assertEquals(expected, InfixToPostfix.conversionStackArrayList(infix));
        assertEquals(expected, InfixToPostfix.conversionStackLista(infix));
    }
}
