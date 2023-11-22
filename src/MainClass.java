package main;

import java.lang.*;
import java.util.*;

class Game {

    private GameWindow gameWindow;
    private GamePanel gamePanel;

    public Game() {
        
        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();

        }
        
    }
public class MainClass {
    public static void main(String[] args) {
        Game game = new Game();
    }
}
