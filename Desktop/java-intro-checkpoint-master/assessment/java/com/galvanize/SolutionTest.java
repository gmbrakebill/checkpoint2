package com.galvanize;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import com.galvanize.util.ClassProxy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class SolutionTest {

    private static final PrintStream ORIGINAL_OUT = System.out;

    private static final String SOLUTION_CLASS_NAME = "com.galvanize.SumOfPositivesCLI";

    private static ClassProxy AppProxy;

    @BeforeAll
    public static void validateStructure() {
        ClassProxy solutionHelper = ClassProxy.classNamed(SOLUTION_CLASS_NAME).ensureMainMethod();

        executeMain(new String[]{"1"}, solutionHelper);
    }

    @BeforeEach
    public void setup() {
        AppProxy = ClassProxy.classNamed(SOLUTION_CLASS_NAME).ensureMainMethod();
    }

    @Test
    public void sumOfZerosShouldBeZero() {
        int expected = 0;
        String[] input_array = {"0", "0"};

        int result = executeMain(input_array);

        assertEquals(expected, result, String.format("Failed for input %s", Arrays.toString(input_array)));
    }

    @Test
    public void sumOfPositivesShouldBeCorrect() {
        int expected = 30;
        String[] input_array = {"23", "2", "5"};

        int result = executeMain(input_array);

        assertEquals(expected, result, String.format("Failed for input %s", Arrays.toString(input_array)));
    }

    @Test
    public void sumOfNegativesShouldBeZero() {
        int expected = 0;
        String[] input_array = {"-4", "-6"};

        int result = executeMain(input_array);

        assertEquals(expected, result, String.format("Failed for input %s", Arrays.toString(input_array)));
    }

    @Test
    public void sumOfEmptyShouldBeZero() {
        int expected = 0;
        String[] input_array = {};

        int result = executeMain(input_array);

        assertEquals(expected, result, String.format("Failed for input %s", Arrays.toString(input_array)));
    }

    @Test
    public void sumOfMixedShouldBeCorrect() {
        int expected = 47;
        String[] input_array = {"-1", "45", "2", "-4"};

        int result = executeMain(input_array);

        assertEquals(expected, result, String.format("Failed for input %s", Arrays.toString(input_array)));
    }

    private static int executeMain(String[] args) {
        return executeMain(args, AppProxy);
    }

    private static int executeMain(String[] args, ClassProxy solutionHelper) {
        final ByteArrayOutputStream outputByteArray = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputByteArray));

        Object[] params = {args};
        solutionHelper.invoke("main", params);

        String output = outputByteArray.toString();

        System.out.flush();
        System.setOut(ORIGINAL_OUT);

        if (output.trim().isEmpty()) {
            fail("Expected the main method to print something, but it printed nothing");
        }

        try {
            return Integer.parseInt(output.trim());
        } catch (NumberFormatException e) {
            fail(String.format(
                    "Expected the main method to print a number, but it printed \"%s\"",
                    output.trim()
            ));
            return -1; // just for the compiler
        }
    }
}
