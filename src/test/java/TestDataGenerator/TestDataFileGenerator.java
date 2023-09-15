package TestDataGenerator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDataFileGenerator {

    @ParameterizedTest
    @MethodSource("testDataFile")
    public void testFileCreationDate(String targetFileName, String expectedCreationDate) {

        }


    static Stream<Arguments> testDataFile() {
        return Stream.of(
                Arguments.of("TestFenster1.txt", "11.09.23, 10:41:33"),
                Arguments.of("TestFenster2.txt", "11.09.23, 12:14:03"),
                Arguments.of("TestFenster3.txt", "11.09.23, 12:14:03"),
                Arguments.of("TestFenster2.txt", "11.09.23, 10:14:03")

        );


    }
}
