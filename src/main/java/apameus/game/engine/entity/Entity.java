package apameus.game.engine.entity;

import apameus.game.engine.GameEngine;
import graphics.Renderer;

public abstract class Entity {

    public  int x,y,speed;

    public Entity(int speed) {
        this.speed = speed;
    }

    public abstract void update(GameEngine engine);

    public abstract void render(Renderer renderer);
}
