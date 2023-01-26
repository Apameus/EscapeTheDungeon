package swing;

import graphics.Renderer;

import javax.swing.*;
import java.awt.*;

public record SwingRenderer(Graphics2D graphics) implements Renderer {

    @Override
    public Renderer setColor(Color color) {
        graphics.setColor(color);
        return this;
    }

    @Override
    public Renderer fillRect(int x, int y, int width, int height) {
        graphics.fillRect(x, y, width, height);
        return this;
    }
}
