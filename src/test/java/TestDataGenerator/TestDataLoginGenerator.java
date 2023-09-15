package TestDataGenerator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TestDataLoginGenerator {

    @ParameterizedTest
    @MethodSource("testLoginData")
    public void testFileCreationDate(String targetLoginName, String targetPasswordName) {

    }

    static Stream<Arguments> testLoginData() {
        return Stream.of(
                Arguments.of("standard_user", "secret_sauce"),
                Arguments.of("locked_out_user", "secret_sauce"),
                Arguments.of("problem_user", "secret_sauce"),
                Arguments.of("performance_glitch_user", "secret_sauce")

        );


    }
}
