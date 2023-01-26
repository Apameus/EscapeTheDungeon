package apameus.game.engine;

import apameus.game.engine.input.Control;
import apameus.game.engine.input.Input;
import apameus.game.engine.loop.FrameBasedLoop;
import graphics.Window;
import swing.Keyboard;

import java.awt.*;

public final class GameEngine {

    private final Window window;
    private final GameLoop loop;

    public GameEngine(GameLoop.Factory factory, Window window) {
       this.loop  = factory.create(this::update, this::render);
        this.window = window;
    }

    int x,y;

    public void update(long now){
        Input input = window.getInput();

        int speed = 5;
        if (input.isActive(Control.MOVE_UP)){
            y -= speed;
        }
        if (input.isActive(Control.MOVE_DOWN)){
            y += speed;
        }
        if (input.isActive(Control.MOVE_LEFT)){
            x -= speed;
        }
        if (input.isActive(Control.MOVE_RIGHT)){
            x += speed;
        }
    }

    public void render(long now){
        window.render(renderer -> {
            renderer.setColor(Color.black)
                            .fillRect(0,0, window.getWidth(), window.getHeight());

            renderer.setColor(Color.red);
            renderer.fillRect(x,y,50,50);
        });
    }

    public void start(){
        loop.start();
    }
}
