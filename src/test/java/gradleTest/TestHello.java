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
        // Cache standard output
        PrintStream originalOut = System.out;

        // Redirect System.out to a different stream to catch outputs and to check them later
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        // action
        Hello.main(null);

        // Read outputs
        byte[] outputBytes = bos.toByteArray();
        ByteArrayInputStream bin = new ByteArrayInputStream(outputBytes);
        Scanner sc = new Scanner(bin);

        // assertion
        Assertions.assertTrue(sc.hasNextLine());
        Assertions.assertEquals("Hello world!", sc.nextLine());

        // restore original streams
        System.setOut(originalOut);
    }
}
