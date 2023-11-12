package gradleTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

public class TestSum
{
    @Test
    public void testHelloWorld() throws IOException {
        // Cache standard input and output
        PrintStream originalOut = System.out;
        InputStream originalIn = System.in;

        // Redirect System.out to a different stream to catch outputs and to check them later
        PipedInputStream newOutputStreamPipedInputStream = new PipedInputStream();
        PipedOutputStream newOutputStream = new PipedOutputStream(newOutputStreamPipedInputStream);
        Scanner newOutputStreamController = new Scanner(newOutputStreamPipedInputStream);
        System.setOut(new PrintStream(newOutputStream));

        // Redirect System.in to a different stream to catch outputs and to check them later
        PipedOutputStream newInputStreamPipedOutputStream = new PipedOutputStream();
        PipedInputStream newInputStream = new PipedInputStream(newInputStreamPipedOutputStream);
        PrintStream newInputStreamController = new PrintStream(newInputStreamPipedOutputStream);
        System.setIn(newInputStream);

        // Enqueue inputs
        newInputStreamController.println(2);
        newInputStreamController.println(3);
        newInputStreamController.flush();
        // Close input stream controllers to launch an exception
        // if an input more is read.
        newInputStreamController.close();
        newInputStreamPipedOutputStream.close();

        // action
        Sum.main(null);

        // restore input stream
        newInputStream.close();
        System.setIn(originalIn);

        // assertion
        newOutputStream.flush();
        Assertions.assertTrue(newOutputStreamController.hasNextLine());
        Assertions.assertEquals("Il risultato è: " + 5, newOutputStreamController.nextLine());

        // restore output stream
        newOutputStream.close();
        newOutputStreamController.close();
        newOutputStreamPipedInputStream.close();
        System.setOut(originalOut);
    }
}
