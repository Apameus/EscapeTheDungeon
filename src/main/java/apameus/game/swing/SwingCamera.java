package apameus.game.swing;

import apameus.game.entity.Player;
import apameus.game.graphics.Camera;
import apameus.game.graphics.Window;

public final class SwingCamera implements Camera {

    private final Player player;
    private final Window window;

    public SwingCamera(Player player, Window window) {
        this.player = player;
        this.window = window;

        int centerX = window.getWidth() / 2;
        int centerY = window.getHeight() / 2;

        playerScreenX = centerX - 50 / 2;
        playerScreenY = centerY - 50 / 2;
    }

    private int playerScreenX, playerScreenY;

    @Override
    public int playerScreenX() {
        return playerScreenX;
    }

    @Override
    public int playerScreenY() {
        return playerScreenY;
    }

    @Override
    public int screenX(int worldX) {
        return (worldX - player.worldX) + playerScreenX;
    }

    @Override
    public int screenY(int worldY) {
        return (worldY - player.worldY) + playerScreenY;
    }
}
