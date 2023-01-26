package graphics;

import apameus.game.engine.input.Input;

import java.util.function.Consumer;

public interface Window {

    int getWidth();

    int getHeight();

    Input getInput();

    void render(Consumer<Renderer> action);
}
