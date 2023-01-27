package apameus.game.entity;

import apameus.game.engine.GameEngine;
import apameus.game.graphics.Renderer;

public abstract class Entity {

    public  int x,y,speed;

    public Entity(int speed) {
        this.speed = speed;
    }

    public abstract void update(GameEngine engine);

    public abstract void render(Renderer renderer);
}
