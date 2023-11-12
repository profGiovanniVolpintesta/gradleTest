package gradleTest;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;

public class TestHello
{
    @Test
    public void testHelloWorld()
    {
        PrintStream originalOut = System.out;

        // Redirect System.out to a different stream to catch outputs and to check them later
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Hello.main(null);

        // Read bytes
        byte[] outputBytes = bos.toByteArray();
        ByteArrayInputStream bin = new ByteArrayInputStream(outputBytes);
        Scanner sc = new Scanner(bin);

        // assertion
        Assertions.assertTrue(sc.hasNextLine());
        Assertions.assertEquals("Hello world!", sc.nextLine());

        // undo the binding in System
        System.setOut(originalOut);
    }
}
