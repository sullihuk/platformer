package main;

import inputs.*;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

  private MouseInputs mouseInputs;

  public GamePanel() {

    mouseInputs = new MouseInputs();

    addKeyListener(new KeyboardInputs());
    addMouseListener(new MouseInputs());
    addMouseMotionListener(mouseInputs);
  }

  public void paintComponent(Graphics g) {

    super.paintComponent(g);
    g.fillRect(100, 100, 200, 50);

  }
}
