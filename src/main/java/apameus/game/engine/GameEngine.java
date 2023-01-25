package apameus.game.engine;

import apameus.game.engine.loop.FrameBasedLoop;

public final class GameEngine {

    private final GameLoop loop;

    public GameEngine(GameLoop.Factory factory) {
       this.loop  = factory.create(this::update, this::render);
    }

    public void update(long now){}

    public void render(long now){}

    public void start(){
        loop.start();
    }
}
