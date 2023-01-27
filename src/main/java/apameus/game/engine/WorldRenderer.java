package apameus.game.engine;

import apameus.game.graphics.Renderer;
import apameus.game.graphics.Window;
import apameus.game.world.Tile;
import apameus.game.world.WorldData;

public final class WorldRenderer {

    private final Window window;
    private final WorldData world;

    public WorldRenderer(Window window, WorldData data) {
        this.window = window;
        this.world = data;
    }

    public void renderer(Renderer renderer){
        byte[][] map = world.map();

        int screenY = 0;
        for (byte[] row : map) {
            int screenX = 0;
            for (byte val : row) {
                Tile tile = Tile.of(val);

                renderer.setColor(tile.getColor())
                        .fillRect(screenX,screenY, world.tileWidth(), world.tileHeight());

                screenX += world.tileWidth();
            }

            screenY += world.tileHeight();
        }
    }
}
