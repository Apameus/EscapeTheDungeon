package apameus.game.entity;

import apameus.game.engine.GameEngine;
import apameus.game.graphics.Camera;
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

        int speed = 3;
        if (input.isActive(Control.MOVE_UP)){ worldY -= speed; }
        if (input.isActive(Control.MOVE_DOWN)){ worldY += speed; }
        if (input.isActive(Control.MOVE_LEFT)){ worldX -= speed; }
        if (input.isActive(Control.MOVE_RIGHT)){ worldX += speed; }
    }

    @Override
    public void render(Renderer renderer, Camera camera) {
        renderer.setColor(Color.red)
                .fillRect(camera.playerScreenX(), camera.playerScreenY(), 50,50);
    }
}
