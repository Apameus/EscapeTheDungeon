package apameus.game.graphics;

import apameus.game.input.Input;

import java.util.function.Consumer;

public interface Window {

    int getWidth();

    int getHeight();

    Input getInput();

    void render(Consumer<Renderer> action);
}
