package apameus.game.world;

public class SimpleWorldGenerator implements WorldGenerator{
    @Override
    public WorldData generate() {
        byte[][] map = {
                {1,0,0,1,0},
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,1,0,0,1},
                {1,0,0,1,0}
        };
        return new WorldData(map, 30, 30);
    }
}
