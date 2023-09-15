package TestDataGenerator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDataFileGenerator {

    @ParameterizedTest
    @MethodSource("testFileData")
    public void testFileCreationDate(String targetFileName, String expectedCreationDate) {

        System.out.println("Target File Name: " + targetFileName);
        System.out.println("Expected Creation Date: " + expectedCreationDate);

        assertEquals("Expected file name is incorrect", "TestFenster1.txt", targetFileName);

        assertEquals("Creation date does not match", "11.09.23, 10:41:33", expectedCreationDate);
    }


    static Stream<Arguments> testDataFile() {
        return Stream.of(
                Arguments.of("TestFenster1.txt", "11.09.23, 10:41:33"),
                Arguments.of("TestFenster2.txt", "11.09.23, 12:14:03"),
                Arguments.of("TestFenster3.txt", "11.09.23, 12:14:03")

        );


    }
}
