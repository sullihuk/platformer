package graph;

/**
 * ImageUtils
 */
import java.awt.*;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtils {

  public static Image loadImage(String filePath) {
    try {
      return ImageIO.read(ImageUtils.class.getResource(filePath));

    } catch (IOException e) {
      System.out.println("Картинка не смогла загрузится по этому пути: " + filePath);

    }
    return null;
  }
}
