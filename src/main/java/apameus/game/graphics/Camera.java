package apameus.game.graphics;

public interface Camera {

    int playerScreenX();

    int playerScreenY();

    int screenX(int worldX);

    int screenY(int worldY);
}
