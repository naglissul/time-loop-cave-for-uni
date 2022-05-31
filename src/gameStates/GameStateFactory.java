package gameStates;

public class GameStateFactory {
    private StateHandler handler;
    public GameStateFactory(StateHandler handler) {
        this.handler = handler;
    }
    public GameState getState(GameStateID id) {
        switch (id) {
            case Win:
                return new Win(handler);
            case Level1:
                return new Level1(handler);
            case GameOver:
                return new GameOver(handler);
            default:
                return null;
        }
    }
}
