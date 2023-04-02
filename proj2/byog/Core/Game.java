package byog.Core;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;
import java.util.Random;

public class Game {
    TERenderer ter = new TERenderer();
    /* Feel free to change the width and height. */
    public static final int WIDTH = 80;
    public static final int HEIGHT = 30;
    private int round;
    private boolean gameOver;


    /**
     * Method used for playing a fresh game. The game should start from the main menu.
     */
    public Game() {
        StdDraw.setCanvasSize(this.WIDTH * 16, this.HEIGHT * 16);
        Font font = new Font("Monaco", Font.BOLD, 30);
        StdDraw.setFont(font);
        StdDraw.setXscale(0, this.WIDTH);
        StdDraw.setYscale(0, this.HEIGHT);
        StdDraw.clear(Color.BLACK);
        StdDraw.enableDoubleBuffering();
    }
    public void playWithKeyboard() {
        startGame();
    }
    public void startGame() {
        gameOver = false;
        round = 1;
        String seed_;
        drawFrame("CS61B THE GAME");
        while (!gameOver) {
            if (!StdDraw.hasNextKeyTyped()) {
                continue;
            } else if (StdDraw.nextKeyTyped() == 'N') {
                seed_ = solicitNCharsInput();
                System.out.println(seed_);
            } else if (StdDraw.nextKeyTyped() == 'Q') {
                gameOver = true;
            }
        }
    }
    public void drawFrame(String s) {
        int midWidth = WIDTH / 2;
        int midHeight = HEIGHT / 2;

        StdDraw.clear();
        StdDraw.clear(Color.black);

        // Draw the actual text
        Font bigFont = new Font("Monaco", Font.BOLD, 30);
        StdDraw.setFont(bigFont);
        StdDraw.setPenColor(Color.white);
        StdDraw.text(midWidth, HEIGHT - (HEIGHT / 4), s);

        Font smallFont = new Font("Monaco", Font.BOLD, 20);
        StdDraw.setFont(smallFont);
        StdDraw.setPenColor(Color.white);
        StdDraw.text(midWidth, midHeight + 2, "New Game (N)");
        StdDraw.text(midWidth, midHeight, "Load Game (L)");
        StdDraw.text(midWidth, midHeight - 2, "Quit Game (Q)");
        StdDraw.show();
    }
    public void drawInput(String s) {
        int midWidth = WIDTH / 2;
        int midHeight = HEIGHT / 2;

        StdDraw.clear();
        StdDraw.clear(Color.black);

        // Draw the actual text
        Font bigFont = new Font("Monaco", Font.BOLD, 30);
        StdDraw.setFont(bigFont);
        StdDraw.setPenColor(Color.white);
        StdDraw.text(midWidth, midHeight, s);
        StdDraw.show();
    }
    public String solicitNCharsInput() {
        String input = "";
        drawInput(input);
        boolean is_S = false;
        while (true) {
            if (!StdDraw.hasNextKeyTyped()) {
                continue;
            }
            else if (is_S){
                break;
            }
            else {
                char key = StdDraw.nextKeyTyped();
                if (key == 'S'){
                    is_S = true;
                    continue;
                }
                input += String.valueOf(key);
                drawInput(input);
            }
        }
        StdDraw.pause(500);
        return input;
    }
    /**
     * Method used for autograding and testing the game code. The input string will be a series
     * of characters (for example, "n123sswwdasdassadwas", "n123sss:q", "lwww". The game should
     * behave exactly as if the user typed these characters into the game after playing
     * playWithKeyboard. If the string ends in ":q", the same world should be returned as if the
     * string did not end with q. For example "n123sss" and "n123sss:q" should return the same
     * world. However, the behavior is slightly different. After playing with "n123sss:q", the game
     * should save, and thus if we then called playWithInputString with the string "l", we'd expect
     * to get the exact same world back again, since this corresponds to loading the saved game.
     * @param input the input string to feed to your program
     * @return the 2D TETile[][] representing the state of the world
     */
    public TETile[][] playWithInputString(String input) {
        // TODO: Fill out this method to run the game using the input passed in,
        // and return a 2D tile representation of the world that would have been
        // drawn if the same inputs had been given to playWithKeyboard().

        TETile[][] finalWorldFrame = null;
        return finalWorldFrame;
    }
}
