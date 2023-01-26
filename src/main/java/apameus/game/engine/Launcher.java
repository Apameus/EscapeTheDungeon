package apameus.game.engine;

import apameus.game.engine.loop.FrameBasedLoop;
import graphics.Window;
import swing.SwingWindow;

public class Launcher {

    public static void main(String[] args) {

        Window window = new SwingWindow();
        GameEngine engine = new GameEngine(FrameBasedLoop::new, window);

        engine.start();
    }
}
