package apameus.game.engine;

import apameus.game.graphics.Camera;
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

    public void renderer(Renderer renderer, Camera camera){
        byte[][] map = world.map();

        int worldY = 0;
        for (byte[] row : map) {
            int worldX = 0;

            int screenY = camera.screenY(worldY);
            for (byte val : row) {
                Tile tile = Tile.of(val);

                int screenX = camera.screenX(worldX);

                renderer.setColor(tile.getColor())
                        .fillRect(screenX, screenY, world.tileWidth(), world.tileHeight());

                worldX += world.tileWidth();
            }

            worldY += world.tileHeight();
        }
    }
}
