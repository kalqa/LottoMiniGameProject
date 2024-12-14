package GetProJava.MiniGames.Lotek;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;


public class LottoResultShowerTest {

    private Scanner mockScannerIn(String data) {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(stdin);
        return scanner;
    }

    static Stream<Arguments> provideParametersForWinningMessageTest() {
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

    @Test
    void shouldUserWinWhenGaveSixNumbersInCorrectRangeAndNumbersWereWinning() {
        // given
        NumberGenerator winningNumberGenerator = new WinningNumberGeneratorTestImpl(Set.of(1,2,3,4,5,6));
        UserNumberRetrievable userNumberRetriever = new UserNumberRetrieverTestImpl();
        LottoResultShower lottoResultShower = new LottoResultShower(winningNumberGenerator, userNumberRetriever);
        LottoGame app = new LottoGame(lottoResultShower);
        // when
        String result = app.play();
        // then
        assertThat(result).isEqualTo("You won " + 10000 + "zl! You have " + Set.of(1, 2, 3, 4, 5, 6) + " numbers right.");
    }

    @Test
    void shouldUserWinWhenGaveSixNumbersInCorrectRangeAndNumbersWereNotWinning() {
        // given
        NumberGenerator winningNumberGenerator = new WinningNumberGeneratorTestImpl(Set.of(1, 2, 3, 4, 50, 60));
        UserNumberRetrievable userNumberRetriever = new UserNumberRetrieverTestImpl();
        LottoResultShower lottoResultShower = new LottoResultShower(winningNumberGenerator, userNumberRetriever);
        LottoGame app = new LottoGame(lottoResultShower);
        // when
        String result = app.play();
        // then
        assertThat(result).isEqualTo("You won " + 100 + "zl! You have " + Set.of(1, 2, 3, 4, 50, 60) + " numbers right.");
    }

//
//    @Test
//    void getSixWinningNumbersTest() {
//        //Given
//        //When
//        Set<Integer> numbersForChecking = LottoResultShower.get6WinnigNumbers();
//        // Then
//        boolean areNumbersValid = numbersForChecking.stream()
//                .allMatch(n -> n != null && n >= 1 && n <= 99);
//        boolean isProperSize = numbersForChecking.size() == 6;
//        boolean result = isProperSize && areNumbersValid;
//        assertThat(result).isTrue();
//    }
//
//    @Test
//    void get6NumbersFromUserWithValidInputTest() {
//        // Given
//        String input = "1 2 3 4 5 6";
//        Set<Integer> expectedNumbers = Set.of(1, 2, 3, 4, 5, 6);
//        Scanner scanner = mockScannerIn(input);
//        // When
//        Set<Integer> actualNumbers = LottoResultShower.get6NumbersFromUser(scanner);
//        // Then
//        assertThat(actualNumbers).isEqualTo(expectedNumbers);
//    }
//
//    @Test
//    void get6NumbersFromUserWithInvalidRangeTest() {
//        // Given
//        String input = "1 2 3 4 5 0";
//        Scanner scanner = mockScannerIn(input);
//        // When & Then
//        assertThrows(IllegalArgumentException.class, () -> LottoResultShower.get6NumbersFromUser(scanner));
//    }
//
//    @Test
//    void get6NumbersFromUserWithAllNumbersInvalidTest() {
//        // Given
//        String input = "0 -2 -3 -4 105 699";
//        Scanner scanner = mockScannerIn(input);
//        // When & Then
//        assertThrows(IllegalArgumentException.class, () -> LottoResultShower.get6NumbersFromUser(scanner));
//    }
//
//    @Test
//    void get6NumbersFromUserWithInvalidTypeTest() {
//        // Given
//        String input = "1 2 3 4 5 c";
//        Scanner scanner = mockScannerIn(input);
//        //When & Then
//        assertThrows(NumberFormatException.class, () -> LottoResultShower.get6NumbersFromUser(scanner));
//    }
//
//    @Test
//    void get6NumbersFromUserWithTextTest() {
//        // Given
//        String input = "alfabet";
//        Scanner scanner = mockScannerIn(input);
//        // When & Then
//        assertThrows(IllegalArgumentException.class, () -> LottoResultShower.get6NumbersFromUser(scanner));
//    }
//
//    @ParameterizedTest
//    @MethodSource("provideParametersForWinningMessageTest")
//    void getInfoAboutWinningTest(Integer properNumbers, Integer price) {
//        // Given
//        String expected = "You won " + price + "zl! You have " + properNumbers + " numbers right.";
//        // When
//        String result = LottoResultShower.infoAboutWinning(properNumbers, price);
//        // Then
//        assertThat(result).isEqualTo(expected);
//    }



}
