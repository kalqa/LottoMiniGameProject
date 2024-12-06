package GetProJava.MiniGames.Lotek;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class LottoGameMechanismTest {

    private Scanner mockScannerIn(String data) {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(stdin);
        return scanner;
    }


    @Test
    void get6WinningNumbersTest() {
        //Given
        Set<Integer> numbersForChecking = LottoGameMechanism.get6WinnigNumbers();
        //When
        boolean areNumbersValid = numbersForChecking.stream()
                .allMatch(n -> n != null && n >= 1 && n <= 99);
        boolean isProperSize = numbersForChecking.size() == 6;
        boolean result = isProperSize && areNumbersValid;
        // Then
        assertThat(result).isTrue();
    }

    @Test
    void get6NumbersFromUserWithValidInputTest() {
        // Given
        String input = "1 2 3 4 5 6";
        Set<Integer> expectedNumbers = Set.of(1, 2, 3, 4, 5, 6);
        Scanner scanner = mockScannerIn(input);
        // When
        Set<Integer> actualNumbers = LottoGameMechanism.get6NumbersFromUser(scanner);
        // Then
        assertThat(actualNumbers).isEqualTo(expectedNumbers);
    }

    @Test
    void get6NumbersFromUserWithInvalidRangeTest() {
        // Given
        String input = "1 2 3 4 5 0";
        Scanner scanner = mockScannerIn(input);
        // When & Then
        assertThrows(IllegalArgumentException.class, () -> {
            LottoGameMechanism.get6NumbersFromUser(scanner);
        });
    }

    @Test
    void get6NumbersFromUserWithAllNumbersInvalidTest() {
        String input = "0 -2 -3 -4 105 699";
        Scanner scanner = mockScannerIn(input);
        // When & Then
        assertThrows(IllegalArgumentException.class, () -> {
            LottoGameMechanism.get6NumbersFromUser(scanner);
        });
    }
    @Test
    void get6NumbersFromUserWithInvalidTypeTest() {
        String input = "1 2 3 4 5 c";
        Scanner scanner = mockScannerIn(input);
        assertThrows(NumberFormatException.class, () -> {
            LottoGameMechanism.get6NumbersFromUser(scanner);
        });
    }
    @Test
    void get6NumbersFromUserWithTextTest() {
        String input = "alfabet";
        Scanner scanner = mockScannerIn(input);
        assertThrows(IllegalArgumentException.class, () -> {
            LottoGameMechanism.get6NumbersFromUser(scanner);
        });
    }
    @ParameterizedTest
    @MethodSource("provideParameters")
    void testInfoAboutWinning(Integer properNumbers, Integer price) {
        // given
        String expected = "You won " + price + "zl! You have " + properNumbers + " numbers right.";
        // when
        String result = LottoGameMechanism.infoAboutWinning(properNumbers, price);
        // then
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 0),
                Arguments.of(2, 0),
                Arguments.of(3, 10),
                Arguments.of(4, 100),
                Arguments.of(5, 3500),
                Arguments.of(6, 1000000)
        );
    }

}
