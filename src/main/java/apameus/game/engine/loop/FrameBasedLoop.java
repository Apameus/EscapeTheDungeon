package apameus.game.engine.loop;

import apameus.game.engine.GameLoop;

import java.time.LocalDateTime;
import java.util.function.LongConsumer;

public class FrameBasedLoop implements GameLoop {
    public FrameBasedLoop(LongConsumer update, LongConsumer render) {
        this.update = update;
        this.render = render;
    }


    private Boolean shouldRun;
    private int fps;

    private final int NANOS_PER_SECOND = LocalDateTime.MAX.getNano();

    private final int FRAMES_PER_SECOND = 60;

    private final double UPDATE_INTERVAL = (double) FRAMES_PER_SECOND / NANOS_PER_SECOND;

    private final LongConsumer update, render;


    @Override
    public int getFPS() {
        return fps;
    }

    @Override
    public void start() {
        shouldRun = true;

        long lastUpdate = System.nanoTime();
        int delta = 0;

        long fpsTimer = lastUpdate;

        while (shouldRun){
            long now = System.nanoTime();
            delta += (now - lastUpdate) / UPDATE_INTERVAL;

            while (delta > 0) {
                update.accept(now);
                delta--;
            }
            lastUpdate = now;
            render.accept(now);
            fps++;

            if (now - fpsTimer >= NANOS_PER_SECOND){
                System.out.println("fps = " + fps);
                fps = 0 ;
                fpsTimer = now;
            }
        }

    }

    @Override
    public void stop() {
        shouldRun = false;
    }
}
