package graph;

import java.io.File;
import java.net.URL;
import java.util.Map;
import java.util.HashMap;

/**
 * SpriteLibrary
 */

public class SpriteLibrary {

  private final static String PATH_TO_UNITS = "/sprites/units";

  private Map<String, SpriteSet> units;

  public SpriteLibrary() {
    units = new HashMap<>();
    loadSpritesFromdisk();
  }

  private void loadSpritesFromdisk() {
    String[] folderNames = getFolderNames(PATH_TO_UNITS);

    for (String folderName: folderNames) {
     SpriteSet spriteSet = new SpriteSet();
      String pathToFolder = PATH_TO_UNITS +"/" + folderName;
      String[] sheetsInFolder = getSheetsInFolder(pathToFolder);

      for(String sheetName: sheetsInFolder){
        spriteSet.addSheet(
          sheetName.substring(0, sheetName.length()-4),
          ImageUtils.loadImage(pathToFolder+"/"+ sheetName));
      }
      units.put(folderName, spriteSet);
    }
  }

  private String[] getSheetsInFolder(String basePath) {
    URL resource  = SpriteLibrary.class.getResource(basePath);
    File file = new File(resource.getFile());
    return file.list((current, name) -> new File(current, name).isFile());
  }

  private String[] getFolderNames(String basePath) {
    URL resource  = SpriteLibrary.class.getResource(basePath);
    File file = new File(resource.getFile());
    return file.list((current, name) -> new File(current, name).isDirectory());
  }

}
