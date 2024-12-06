package GetProJava.MiniGames.Lotek;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

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
    void testGet6NumbersFromUserWithValidInput() {
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
    void testGet6NumbersFromUserWithInvalidRange() {
        // Given
        String input = "1 2 3 4 5 0";
        Scanner scanner = mockScannerIn(input);
        // When & Then
        assertThrows(IllegalArgumentException.class, () -> {
            LottoGameMechanism.get6NumbersFromUser(scanner);
        });
    }


}
