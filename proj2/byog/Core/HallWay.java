package byog.Core;

import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class HallWay {
    /* Randomly take two points and inflection points in two rooms */
    private static final Random random = new Random();
    private static final Random random2 = new Random();
    public static int[][] hallwayGenerator(Room room1, Room room2){
        int x_r1 = random.nextInt(room1.x + 1, room1.x + room1.width - 2);
        int y_r1 = random.nextInt(room1.y + 1, room1.y + room1.height - 2);
        int x_r2 = random2.nextInt(room2.x + 1, room2.x + room2.width - 2);
        int y_r2 = random2.nextInt(room2.y + 1, room2.y + room2.height - 2);
        int [] inflection = new int[2];
        int [] vertex1 = new int[]{x_r1, y_r1};
        int [] vertex2 = new int[]{x_r2, y_r2};
        int[][] result = new int[3][2];

        if ((x_r1 < x_r2 && y_r1 < y_r2) || (x_r1 > x_r2 && y_r1 > y_r2)){
            /**
             *          [2]
             *
             *    [1]
             * */
            inflection[0] = Math.min(x_r1, x_r2);
            inflection[1] = Math.max(y_r2, y_r1);

            result [0][0] = inflection[0];
            result [0][1] = inflection[1];

            result[1][0] = Math.min(x_r1, x_r2);
            result[1][1] = Math.min(y_r2, y_r1);

            result[2][0] = Math.max(x_r1, x_r2);
            result[2][1] = Math.max(y_r2, y_r1);
        } else if ((x_r1 < x_r2 && y_r1 > y_r2) || (x_r1 > x_r2 && y_r1 < y_r2)) {
            /**
             *     [1]
             *
             *              [2]
             * */
            inflection[0] = Math.max(x_r1, x_r2);
            inflection[1] = Math.max(y_r2, y_r1);

            result [0][0] = inflection[0];
            result [0][1] = inflection[1];

            result[1][0] = Math.min(x_r1, x_r2);
            result[1][1] = Math.max(y_r2, y_r1);

            result[2][0] = Math.max(x_r1, x_r2);
            result[2][1] = Math.min(y_r2, y_r1);
        } else if ((x_r1 == x_r2)){
            result[0][0] = vertex1[0];
            result[0][1] = vertex1[1];
            result[1][0] = vertex1[0];
            result[1][1] = vertex1[1];
            result[2][0] = vertex2[0];
            result[2][1] = vertex2[1];
        }
        return result;
    }
    /* draw the hallway*/
    public static void drawHallway(TETile[][] world, int [][] result){
        int vertex_x1 = result[1][0];
        int vertex_y1 = result[1][1];
        int vertex_x2 = result[2][0];
        int vertex_y2 = result[2][1];
        if (vertex_y1 < vertex_y2){
            for (int i = 0; i <= vertex_x2 - vertex_x1; i++){
                world[vertex_x1 + i][vertex_y2]  = Tileset.FLOOR;
            }
            for (int i = 0; i <= vertex_y2 - vertex_y1; i++){
                world[vertex_x1][vertex_y1 + i]  = Tileset.FLOOR;
            }
        }
        if (vertex_y1 > vertex_y2){
            for (int i = 0; i <= vertex_x2 - vertex_x1; i++){
                world[vertex_x1 + i][vertex_y1]  = Tileset.FLOOR;
            }
            for (int i = 0; i <= vertex_y1 - vertex_y2; i++){
                world[vertex_x2][vertex_y2 + i]  = Tileset.FLOOR;
            }
        }
    }
    /* draw the inside wall*/
    public static void drawHallway1(TETile[][] world, int [][] result){
        int vertex_x1 = result[1][0];
        int vertex_y1 = result[1][1];
        int vertex_x2 = result[2][0];
        int vertex_y2 = result[2][1];
        if (vertex_y1 < vertex_y2){
            vertex_x1 += 1;
            vertex_y2 -= 1;
            for (int i = 0; i <= vertex_x2 - vertex_x1; i++){
                if (world[vertex_x1 + i][vertex_y2] != Tileset.FLOOR){
                    world[vertex_x1 + i][vertex_y2] = Tileset.WALL;
                }
            }
            for (int i = 0; i <= vertex_y2 - vertex_y1; i++){
                if (world[vertex_x1][vertex_y1 + i] != Tileset.FLOOR){
                    world[vertex_x1][vertex_y1 + i] = Tileset.WALL;
                }
            }
        }
        if (vertex_y1 > vertex_y2){
            vertex_y1 -= 1;
            vertex_x2 -= 1;
            for (int i = 0; i <= vertex_x2 - vertex_x1; i++){
                if (world[vertex_x1 + i][vertex_y1] != Tileset.FLOOR){
                    world[vertex_x1 + i][vertex_y1] = Tileset.WALL;
                }
            }
            for (int i = 0; i <= vertex_y1 - vertex_y2; i++){
                if (world[vertex_x2][vertex_y2 + i] != Tileset.FLOOR){
                    world[vertex_x2][vertex_y2 + i] = Tileset.WALL;
                }
            }
        }
    }
    /* draw the outside wall*/
    public static void drawHallway2(TETile[][] world, int [][] result){
        int vertex_x1 = result[1][0];
        int vertex_y1 = result[1][1];
        int vertex_x2 = result[2][0];
        int vertex_y2 = result[2][1];
        if (vertex_y1 < vertex_y2){
            vertex_x1 -= 1;
            vertex_y2 += 1;
            for (int i = 0; i <= vertex_x2 - vertex_x1; i++){
                if (world[vertex_x1 + i][vertex_y2] != Tileset.FLOOR){
                    world[vertex_x1 + i][vertex_y2] = Tileset.WALL;
                }
            }
            for (int i = 0; i <= vertex_y2 - vertex_y1; i++){
                if (world[vertex_x1][vertex_y1 + i] != Tileset.FLOOR){
                    world[vertex_x1][vertex_y1 + i] = Tileset.WALL;
                }
            }
        }
        if (vertex_y1 > vertex_y2){
            vertex_y1 += 1;
            vertex_x2 += 1;
            for (int i = 0; i <= vertex_x2 - vertex_x1; i++){
                if (world[vertex_x1 + i][vertex_y1] != Tileset.FLOOR){
                    world[vertex_x1 + i][vertex_y1] = Tileset.WALL;
                }
            }
            for (int i = 0; i <= vertex_y1 - vertex_y2; i++){
                if (world[vertex_x2][vertex_y2 + i] != Tileset.FLOOR){
                    world[vertex_x2][vertex_y2 + i] = Tileset.WALL;
                }
            }
        }
    }

}
