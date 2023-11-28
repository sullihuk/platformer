import java.awt.*;
import java.awt.image.BufferedImage;

public class Square extends GameObject {

  @Override
  public void update() {
    position = new Position(position.getX() + 1, position.getY() + 1);

  }

  @Override
  public Image getSprite() {
    BufferedImage image = new BufferedImage(size.getWidth(), size.getHeight(), BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics = image.createGraphics();

    graphics.setColor(Color.BLUE);
    graphics.fillRect(0, 0, size.getWidth(), size.getHeight());

    graphics.dispose();
    return image;

  }

}
