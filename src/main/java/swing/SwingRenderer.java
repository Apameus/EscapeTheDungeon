package swing;

import javax.swing.*;
import java.awt.*;

public record SwingRenderer(Graphics2D graphics) implements Renderer {

    @Override
    public void setValue(Object aValue, boolean isSelected) {

    }

    @Override
    public Component getComponent() {
        return null;
    }
}
