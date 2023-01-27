package apameus.game.engine.loop;

import apameus.game.engine.GameLoop;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.function.LongConsumer;

public class FrameBasedLoop implements GameLoop {

    public FrameBasedLoop(LongConsumer update, LongConsumer render) {
        this.update = update;
        this.render = render;
    }

    private static final long NANOS_PER_SECOND = Duration.ofSeconds(1).toNanos();

    private static final int FRAMES_PER_SECOND = 60;

    private static final double UPDATE_INTERVAL = (double) NANOS_PER_SECOND / FRAMES_PER_SECOND;

    private final LongConsumer update, render;
    private Boolean shouldRun;
    private int fps;


    @Override
    public int getFPS() {
        return fps;
    }

    @Override
    public void start() {
        shouldRun = true;

        long lastUpdate = System.nanoTime();
        long fpsTimer = lastUpdate;

        int delta = 0;


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

            sleep();
        }

    }

    private void sleep() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void stop() {
        shouldRun = false;
    }
}
