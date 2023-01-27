package apameus.game.swing;

import apameus.game.input.Control;
import apameus.game.input.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.BitSet;
import java.util.Map;

import static java.awt.event.KeyEvent.*;

public final class Keyboard implements Input, KeyListener {

    private final Map<Integer, Control> keyMap;
    private final BitSet bitSet;

    @Override
    public boolean isActive(Control control) {
        return bitSet.get(control.ordinal());
    }

    public Keyboard() {
        keyMap = Map.of(
                VK_W, Control.MOVE_UP,
                VK_S, Control.MOVE_DOWN,
                VK_A, Control.MOVE_LEFT,
                VK_D, Control.MOVE_RIGHT
        );
        bitSet = new BitSet();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        set(keyCode, true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        set(keyCode, false);
    }

    private void set(int keyCode, boolean value) {
        Control control = keyMap.get(keyCode);
        if (control != null){
            bitSet.set(control.ordinal(), value);
        }
    }
}
