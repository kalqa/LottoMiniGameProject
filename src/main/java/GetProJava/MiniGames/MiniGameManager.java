package GetProJava.MiniGames;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class MiniGameManager implements MiniGame {
    private String nameOfMiniGame;

    @Override
    public void start() {
        System.out.println("Game " + getNameOfMiniGame() + " started");
    }

    @Override
    public void end() {
        System.out.println("Game " + getNameOfMiniGame() + " ended");
    }

}
