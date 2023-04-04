package byog.Core;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;
import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;
import java.util.Random;

public class Game {
    TERenderer ter = new TERenderer();
    /* Feel free to change the width and height. */
    public static final int WIDTH = 80;
    public static final int HEIGHT = 30;
    private boolean gameOver;
    public TETile[][] finalWorldFrame = new TETile[WIDTH][HEIGHT];

    public Game() {
        StdDraw.setCanvasSize(this.WIDTH * 16, this.HEIGHT * 16);
        Font font = new Font("Monaco", Font.BOLD, 30);
        StdDraw.setFont(font);
        StdDraw.setXscale(0, this.WIDTH);
        StdDraw.setYscale(0, this.HEIGHT);
        StdDraw.clear(Color.BLACK);
        StdDraw.enableDoubleBuffering();
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                finalWorldFrame[x][y] = Tileset.FLOWER;
            }
        }
    }
    /**
     * Method used for playing a fresh game. The game should start from the main menu.
     */

    public void playWithKeyboard() {
        Menu menu = new Menu();
        gameOver = false;
        String input = "";
        menu.drawFrame("");
        while (!gameOver) {
            if (!StdDraw.hasNextKeyTyped()) {
                continue;
            } else {
                char c = StdDraw.nextKeyTyped();
                if (c == 'N' || c == 'n'){
                    input = menu.solicitNCharsInput();
                    playWithInputString(input);
                } else if (c == 'Q' || c == 'q') {
                    gameOver = true;
                } else if (c == 'L' || c == 'l') {
                    System.out.println("ll");
                }
            }
        }
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
        ter.renderFrame(finalWorldFrame);
        return finalWorldFrame;
    }
}
