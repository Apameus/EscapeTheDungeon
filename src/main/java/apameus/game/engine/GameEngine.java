package apameus.game.engine;

import apameus.game.entity.Player;
import apameus.game.input.Input;
import apameus.game.graphics.Window;
import apameus.game.world.SimpleWorldGenerator;
import apameus.game.world.WorldData;
import apameus.game.world.WorldGenerator;


import java.awt.*;

public final class GameEngine {

    private Player player;
    private final Window window;
    private final GameLoop loop;
    private final WorldRenderer worldRenderer;

    public GameEngine(GameLoop.Factory factory, Window window) {
       this.loop  = factory.create(this::update, this::render);
        this.window = window;

        WorldGenerator generator = new SimpleWorldGenerator();
        WorldData data = generator.generate();
        worldRenderer = new WorldRenderer(window, data);
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
            renderer.clear(0, 0, window.getWidth(), window.getHeight());

            worldRenderer.renderer(renderer);
            player.render(renderer);
        });
    }
}
