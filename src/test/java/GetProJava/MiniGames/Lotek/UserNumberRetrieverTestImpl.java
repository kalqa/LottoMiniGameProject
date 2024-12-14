package GetProJava.MiniGames.Lotek;

import java.util.Scanner;
import java.util.Set;

class UserNumberRetrieverTestImpl implements UserNumberRetrievable {
    @Override
    public Set<Integer> getSixNumbersFromUser(Scanner scanner) {
        return Set.of(1,2,3,4,5,6);
    }
}
