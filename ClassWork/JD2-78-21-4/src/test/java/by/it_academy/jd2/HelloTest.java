package by.it_academy.jd2;

import by.it_academy.jd2.utils.ApacheCommonsLang3;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public class HelloTest {
    /**
     *Object of class Hello
     */
    private final Hello checker = new Hello();
    /**
     *override the console output stream changes to its input stream using a byte array as the data source.
     */
    protected ByteArrayOutputStream output;
    /**
     *return the output stream again to System.in
     */
    private PrintStream old;

//    @Test
//    public void shouldAnswerWithTrue() {
//        assertTrue(true);
//    }

    /**
     * Testing main method
     */
    @Test
    public void mainTest() {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        String[] test = {"Olga", "irina", "Hello"};
        checker.main(test);
        String template = "irina";
        Assert.assertEquals(template, output.toString().trim());
        System.setOut(old);
    }


}

