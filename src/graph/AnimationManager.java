package graph;

import game.Game;
import java.awt.*;
import java.awt.image.BufferedImage;

import core.Direction;

/**
 * AnimationManager
 */
public class AnimationManager {
  private SpriteSet spriteSet;
  private BufferedImage currentAnimationSheet;
  private int currentFrameTime;
  private int updatePreFrame;
  private int frameIndex;
  private int directionIndex;

  public AnimationManager(SpriteSet spriteSet) {
    this.spriteSet = spriteSet;
    this.updatePreFrame = 20;
    this.frameIndex = 0;
    this.currentFrameTime = 0;
    this.directionIndex = 0;
    playAnimation("dino2");
  }

  public Image getSprite() {

    return currentAnimationSheet.getSubimage(
        frameIndex * Game.SPRITE_WIDTH,
        directionIndex * Game.SPRITE_HEIGHT,
        Game.SPRITE_WIDTH,
        Game.SPRITE_HEIGHT);
  }

  public void update(Direction direction) {

    currentFrameTime++;
    directionIndex = direction.getAnimationRow();
    if (currentFrameTime >= updatePreFrame) {
      currentFrameTime = 0;
      frameIndex++;

      if (frameIndex >= currentAnimationSheet.getWidth() / Game.SPRITE_WIDTH) {

        frameIndex = 0;
      }

    }
  }

  public void playAnimation(String name) {
    this.currentAnimationSheet = (BufferedImage) spriteSet.get(name);
  }

}
