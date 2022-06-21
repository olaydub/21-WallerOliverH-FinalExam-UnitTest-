import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class StringCalcTest {
    private StringCalculator s;

    @BeforeEach
    public void setUp() {
        s = new StringCalculator();
    }

    @AfterEach
    public void tearDown() {
        s = null;
    }

    @Test
    public void testAdd1(){
        String add = "-1, 5";
        Exception exception = assertThrows(Exception.class, () -> s.add(add));
        assertEquals("negatives not allowed.", exception.getMessage());
    }
    @Test
    public void testAdd2(){
        String add = "-1, -5";
        Exception exception = assertThrows(Exception.class, () -> s.add(add));
        assertEquals("negatives not allowed.", exception.getMessage());
    }
    @Test
    public void testAdd3(){
        String add = "1, -5";
        Exception exception = assertThrows(Exception.class, () -> s.add(add));
        assertEquals("negatives not allowed.", exception.getMessage());
    }
    @Test
    public void testAddIgnore(){
        String add = "1,1000";
        assertEquals(1, s.add(add));
    }
    @Test
    public void testAddIgnore2(){
        String add = "1,2000";
        assertEquals(1, s.add(add));
    }
    @Test
    public void testAddIgnore3(){
        String add = "1000,20";
        assertEquals(20, s.add(add));
    }
    @Test
    public void testAddIgnore4(){
        String add = "1000,2000";
        assertEquals(0, s.add(add));
    }
    @Test
    public void testAddReal1(){
        String add = "10,20";
        assertEquals(30, s.add(add));
    }






}
