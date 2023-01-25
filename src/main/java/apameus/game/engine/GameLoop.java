package apameus.game.engine;

import java.util.function.LongConsumer;

public interface GameLoop {

    int getFPS();

    void start();

    void stop();


    interface Factory {
        GameLoop create(LongConsumer update, LongConsumer render);
    }
}
