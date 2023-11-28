public class GameLoop implements Runnable {

  private Game game;

  private boolean running;
  private final double updateRate = 1.0d / 60.0d;

  private long nextStatTime;
  private int fps, updatePerSecond;

  public GameLoop(Game game) {
    this.game = game;
  }

  @Override
  public void run() {
    running = true;
    double accumulator = 0;
    long currentTime, lastUpdate = System.currentTimeMillis();
    nextStatTime = System.currentTimeMillis() + 1000;

    while (running) {
      currentTime = System.currentTimeMillis();
      double lastRenderTimeInSeconds = (currentTime - lastUpdate) / 1000d;
      accumulator += lastRenderTimeInSeconds;
      lastUpdate = currentTime;

      if (accumulator >= updateRate) {
        while (accumulator >= updateRate) {
          update();
          accumulator -= updateRate;
        }
        render();
      }
      printStats();
    }
  }

  private void printStats() {
    if (System.currentTimeMillis() > nextStatTime) {
      System.out.println(String.format("FPS: %d, updatePerSecond: %d", fps, updatePerSecond));
      fps = 0;
      updatePerSecond = 0;
      nextStatTime = System.currentTimeMillis() + 1000;
    }
  }

  private void render() {
    game.render();
    fps++;
  }

  private void update() {
    game.update();
    updatePerSecond++;
  }
}
