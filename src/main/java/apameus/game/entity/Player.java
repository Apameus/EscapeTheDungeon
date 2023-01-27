package apameus.game.entity;

import apameus.game.engine.GameEngine;
import apameus.game.input.Control;
import apameus.game.input.Input;
import apameus.game.graphics.Renderer;

import java.awt.*;

public class Player extends Entity{

    public Player() {
        super(3);
    }

    @Override
    public void update(GameEngine engine) {
        Input input = engine.getInput();

        int speed = 5;
        if (input.isActive(Control.MOVE_UP)){ y -= speed; }
        if (input.isActive(Control.MOVE_DOWN)){ y += speed; }
        if (input.isActive(Control.MOVE_LEFT)){ x -= speed; }
        if (input.isActive(Control.MOVE_RIGHT)){ x += speed; }
    }

    @Override
    public void render(Renderer renderer) {
        renderer.setColor(Color.red)
                .fillRect(x,y,50,50);
    }
}
