package apameus.game.entity;

import apameus.game.engine.GameEngine;
import apameus.game.graphics.Camera;
import apameus.game.graphics.Renderer;

public abstract class Entity {

    public  int worldX, worldY,speed;

    public Entity(int speed) {
        this.speed = speed;
    }

    public abstract void update(GameEngine engine);

    public abstract void render(Renderer renderer, Camera camera);
}
