package game;

import display.Display;
import controller.PlayerController;
//import core.*;
import entity.*;
import input.Input;
import graph.SpriteLibrary;

//import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Game
 */
public class Game {

  public static int SPRITE_WIDTH = 88;
  public static int SPRITE_HEIGHT = 96;

  private Display display;
  private List<GameObject> gameObjects;
  private Input input;
  private SpriteLibrary spriteLibrary;

  public Game(int width, int height) {
    input = new Input();
    display = new Display(width, height, input);
    gameObjects = new ArrayList<>();
    spriteLibrary = new SpriteLibrary();
    gameObjects.add(new Player(new PlayerController(input), spriteLibrary));
  }

  public void update() {
    gameObjects.forEach(gameObject -> gameObject.update());

  }

  public void render() {
    display.render(this);
  }

  public List<GameObject> getGameObjects() {
    return gameObjects;
  }
}
