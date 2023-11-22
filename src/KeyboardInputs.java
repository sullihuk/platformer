package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {

  public void keyTyped(KeyEvent e) {
  }

  public void keyReleased(KeyEvent e) {
  }

  public void keyPressed(KeyEvent e) {
    switch (e.getExtendedKeyCode()) {

      case KeyEvent.VK_W:
        System.out.println("Its W");
        break;
      case KeyEvent.VK_A:
        System.out.println("Its S");
        break;
      case KeyEvent.VK_S:
        System.out.println("Its S");
        break;
      case KeyEvent.VK_D:
        System.out.println("Its D");
        break;

    }
  }

}
