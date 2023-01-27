package apameus.game.engine;

import apameus.game.engine.entity.Player;
import apameus.game.engine.input.Control;
import apameus.game.engine.input.Input;
import graphics.Window;


import java.awt.*;

public final class GameEngine {

    private final Window window;
    private final GameLoop loop;
    private Player player;

    public GameEngine(GameLoop.Factory factory, Window window) {
       this.loop  = factory.create(this::update, this::render);
        this.window = window;
    }

    public void start(){
        player = new Player();
        loop.start();
    }

    public Input getInput(){
        return window.getInput();
    }

    public void update(long now){
        player.update(this);
    }

    public void render(long now){
        window.render(renderer -> {
            renderer.setColor(Color.black)
                            .fillRect(0,0, window.getWidth(), window.getHeight());

            player.render(renderer);
        });
    }
}
