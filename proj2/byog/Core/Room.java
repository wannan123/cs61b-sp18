package byog.Core;

import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Room {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    public Room(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    /**
     * This function help you check if the room's Pixel block in the world.
     */
    public static boolean checkExist(List<Room> r, int x, int y, int width, int height){
        boolean b = true;
        for (Room room : r){
            Set<Pixel> s = new HashSet<>();
            int x_s = room.x;
            int y_s = room.y;
            int new_x = x;
            int new_y = y;
            for (int i = 0; i < room.width; i++){
                for (int j = 0; j < room.height; j++){
                    Pixel pixel = new Pixel(x_s + i, y_s + j);
                    s.add(pixel);
                    //System.out.println("Pixel:"+pixel.x_+"and y:"+pixel.y_);
                }
            }
            for (int i = 0; i < width; i++ ){
                for (int j = 0; j < height; j++ ){
                    if (s.contains(new Pixel(new_x + i, new_y + j))){
                        b = false;
                    }
                }
            }

        }

        return b;
    }
    private static class Pixel{
        private int x_;
        private int y_;
        Pixel(int x,int y){
            x_ = x;
            y_ = y;
        }
    }
    public void drawRoom(TETile[][] world) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if ((j == 0 || j == height - 1)) {
                    if (world[x + i][y + j] != Tileset.FLOOR){
                        world[x + i][y + j] = Tileset.WALL;
                    }
                } else if (i == 0 || i == width - 1) {
                    if (world[x + i][y + j] != Tileset.FLOOR){
                        world[x + i][y + j] = Tileset.WALL;
                    }

                } else {
                    world[x + i][y + j] = Tileset.FLOOR;
                }
            }
        }
    }

}
