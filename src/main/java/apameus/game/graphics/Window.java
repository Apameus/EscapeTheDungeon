package apameus.game.graphics;

import apameus.game.entity.Player;
import apameus.game.input.Input;

import java.security.cert.X509Certificate;
import java.util.function.Consumer;

public interface Window {

    int getWidth();

    int getHeight();

    Input getInput();

    Camera createCamera(Player player);
    void render(Consumer<Renderer> action);
}
