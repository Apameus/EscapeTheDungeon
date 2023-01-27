package apameus.game.world;

import java.awt.*;

public enum Tile {
    VOID(Color.BLACK),
    FLOOR(Color.GREEN);

    private final Color color;

    Tile(Color color) {
        this.color = color;
    }

    public Color getColor(){
        return color;
    }

    public static Tile of(byte val){
        return TILES[val];
    }
    private static final Tile[] TILES = Tile.values();
}
