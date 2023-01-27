package apameus.game.swing;

import apameus.game.graphics.Renderer;

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

    @Override
    public void clear(int x, int y, int width, int height) {
        graphics.clearRect(x,y, width, height);
    }
}
