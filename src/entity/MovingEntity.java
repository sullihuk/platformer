package entity;

import java.awt.*;
import controller.Controller;
import core.Direction;
import core.Movement;
import graph.AnimationManager;
import graph.SpriteLibrary;

public abstract class MovingEntity extends GameObject {

  private Controller controller;
  private Movement movement;
  private AnimationManager animationManager;
  private Direction direction;

  public MovingEntity(Controller controller, SpriteLibrary spriteLibrary) {
    super();
    this.controller = controller;
    this.movement = new Movement(5);
    this.direction = Direction.S;
    this.animationManager = new AnimationManager(spriteLibrary.getUnit("dino"));
  }

  @Override
  public void update() {
    movement.update(controller);
    position.apply(movement);
    manageDirection();
    animationManager.update(direction);
  }

  private void manageDirection() {
    if (movement.isMoving()) {
      this.direction = Direction.fromMovement(movement);
    }
  }

  @Override
  public Image getSprite() {
    return animationManager.getSprite();
  }

}
