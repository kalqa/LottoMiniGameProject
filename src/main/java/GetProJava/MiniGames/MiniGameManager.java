package GetProJava.MiniGames;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MiniGameManager implements MiniGame{
    private String nameOfMiniGame;

    @Override
    public void start() {
        System.out.println("Game "+nameOfMiniGame+" started");
    }

    @Override
    public void end() {
        System.out.println("Game "+nameOfMiniGame+" ended");
    }
    @Override
    public String getNameOfCurrentGame() {
        return nameOfMiniGame;
    }
}