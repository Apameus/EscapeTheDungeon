package graphics;

import java.awt.*;

public interface Renderer {

    Renderer setColor(Color color);

    Renderer fillRect(int x, int y, int width, int height);



}
