package GetProJava.MiniGames.Lotek;

import java.util.Set;

class WinningNumberGeneratorTestImpl implements NumberGenerator {

    Set<Integer> numbers;

    public WinningNumberGeneratorTestImpl(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Set<Integer> generateSixWinningNumbers() {
        return numbers;
    }
}
