package GetProJava.MiniGames.Lotek;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

public class WinningNumberGenerator implements NumberGenerator {

    @Override
    public Set<Integer> generateSixWinningNumbers() {
        Set<Integer> winningNumbers = new HashSet<>();
        SecureRandom secureRandomProperNumber = new SecureRandom();
        while (winningNumbers.size() != 6) {
            winningNumbers.add(secureRandomProperNumber.nextInt(99) + 1);
        }
        return winningNumbers;
    }
}
