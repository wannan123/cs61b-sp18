package byog.Core;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;

public class Menu {
    public static final int WIDTH = 80;
    public static final int HEIGHT = 30;
    private boolean is_input_ing = false;

    public void drawFrame(String s) {
        int midWidth = WIDTH / 2;
        int midHeight = HEIGHT / 2;

        StdDraw.clear();
        StdDraw.clear(Color.black);

        // Draw the actual text
        Font bigFont = new Font("Monaco", Font.BOLD, 30);
        StdDraw.setFont(bigFont);
        StdDraw.setPenColor(Color.white);
        StdDraw.text(midWidth, HEIGHT - (HEIGHT / 4), "CS61B THE GAME");

        Font smallFont = new Font("Monaco", Font.BOLD, 20);
        StdDraw.setFont(smallFont);
        StdDraw.setPenColor(Color.white);
        StdDraw.text(midWidth, midHeight + 2, "New Game (N)");
        StdDraw.text(midWidth, midHeight, "Load Game (L)");
        StdDraw.text(midWidth, midHeight - 2, "Quit Game (Q)");
        if (is_input_ing){
            StdDraw.text(midWidth, midHeight - 4, "Input your seed:");
            StdDraw.text(midWidth, midHeight - 6, s);
        }
        StdDraw.show();
    }
    /**
     * Print out the user input.
     * @return String
     */
    public String solicitNCharsInput() {
        String input = "";
        is_input_ing = true;
        drawFrame("");
        boolean is_S = false;
        while (true) {
            if (!StdDraw.hasNextKeyTyped()) {
                continue;
            }
            else {
                char key = StdDraw.nextKeyTyped();
                if (key == 'S'){
                    break;
                }
                input += String.valueOf(key);
                drawFrame(input);
            }
        }
        is_input_ing = false;
//        StdDraw.pause(500);
        return input;
    }
}
