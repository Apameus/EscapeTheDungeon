package apameus.game;

import apameus.game.engine.GameEngine;
import apameus.game.loop.FrameBasedLoop;
import apameus.game.graphics.Window;
import apameus.game.swing.SwingWindow;

public class Launcher {

    public static void main(String[] args) {

        Window window = new SwingWindow();
        GameEngine engine = new GameEngine(FrameBasedLoop::new, window);

        engine.start();
    }
}
