import org.junit.jupiter.api.*;

import java.nio.file.AccessDeniedException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @BeforeAll
    static void setUpAll(){
        System.out.println("BeforeAll is executed");
    }
    @AfterAll
    static void tearDownAll(){
        System.out.println("AfterAll is executed");
    }
    @BeforeEach
    void setUpEach(){
        System.out.println("BeforeEach is executed.");
    }

    @AfterEach
    void tearDownEach(){
        System.out.println("AfterEach is executed");
    }



    @Test
    void add() {
        System.out.println("Add method");
        int actual = Calculator.add(2,3);
        assertEquals(5, actual);
    }

    @Test
    void add2() {
        System.out.println("Add method2");
        //assertThrows(IllegalArgumentException.class, ()-> Calculator.add2(3,2));
        //assertThrows(AccessDeniedException.class, () -> Calculator.add2(3,2));
        assertThrows(IllegalArgumentException.class, ()->Calculator.add2(2,3));
    }

    @Test
    void testCase1(){
        System.out.println("Test Case 1");
    }

    @Test
    void testCase2(){
        System.out.println("Test Case 2");
        assertEquals("add", Calculator.operator);
        assertTrue(Calculator.operator.equals("add"));
    }

    @Test
    void testCase3(){
        System.out.println("Test Case 3");
    }
    @Test
    void testCase4(){
        System.out.println("Test Case 4");
    }
    @Test
    void testCase5(){
        System.out.println("Test Case 5");
        Calculator c1 = new Calculator();
        Calculator c2 = c1;
        Calculator c3 = new Calculator();

        assertSame(c1, c2);
        assertNotSame(c1, c3);
    }

}