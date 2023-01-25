package graphics;

import javax.swing.Renderer;
import java.util.function.Consumer;

public interface Window {

    int getWidth();

    int getHeight();

    void render(Consumer<Renderer> action);
}
