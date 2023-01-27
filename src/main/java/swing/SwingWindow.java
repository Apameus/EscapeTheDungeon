package swing;

import apameus.game.engine.input.Input;
import graphics.Renderer;
import graphics.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.function.Consumer;

public final class SwingWindow implements Window {

    private final Keyboard keyboard;
    private final Toolkit toolkit;
    private final Canvas canvas;

    public SwingWindow() {
        JFrame frame = new JFrame("EscapeTheDungeon");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        keyboard = new Keyboard();
        frame.addKeyListener(keyboard);

        canvas = new Canvas();
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(canvas, BorderLayout.CENTER);

        frame.add(panel);
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas.createBufferStrategy(2);
        toolkit = Toolkit.getDefaultToolkit();
    }

    @Override
    public int getWidth() {
        return canvas.getWidth();
    }

    @Override
    public int getHeight() {
        return canvas.getHeight();
    }

    @Override
    public Input getInput() {
        return keyboard;
    }

    @Override
    public void render(Consumer<Renderer> action) {
        BufferStrategy buffer = canvas.getBufferStrategy();

        do {
            do {
                Graphics graphics = buffer.getDrawGraphics();
                SwingRenderer renderer = new SwingRenderer((Graphics2D) graphics);

                action.accept(renderer);

                graphics.dispose();

            }while (buffer.contentsLost());
            buffer.show();
        }while (buffer.contentsRestored());

        toolkit.sync();
    }
}
