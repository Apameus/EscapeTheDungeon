package apameus.game.engine;

import apameus.game.engine.loop.FrameBasedLoop;

public class Launcher {

    public static void main(String[] args) {
        GameEngine engine = new GameEngine(FrameBasedLoop::new);

        engine.start();
    }
}
