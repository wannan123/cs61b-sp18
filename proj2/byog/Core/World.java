package byog.Core;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.*;

public class World {
    private int x;
    private int y;
    private int Width;
    private int Height;
    private Random random = new Random();
    private List<Room> rooms = new LinkedList<>();
    public World (int width , int height , long seed){
        this.Width = width;
        this.Height = height;
        random.setSeed(seed);
    }
    public void GenerateWorld(TETile finalWorldFrame[][]){
        int count = 0;
        int number = random.nextInt(15) % (15 - 9 + 1) + 16;
        while (rooms.size() < number){
            count ++;
            int x = random.nextInt(Width - 1);
            int y = random.nextInt(Height - 1);
            int width = random.nextInt(6) % (6 - 3 + 1) + 5;
            int height = random.nextInt(6) % (6 - 3 + 1) + 5;
            boolean is_cross_border = CheckBoundary(x, y, width, height);
            if (is_cross_border && Room.checkExist(rooms,x,y,width,height)){
                rooms.add(new Room(x, y, width, height));
            }
            if (count > 1000){
                break;
            }
        }
        System.out.println("Start draw");
        for (Room r : rooms){
            r.drawRoom(finalWorldFrame);
        }

    }
    public boolean CheckBoundary(int x, int y, int width, int height){
        boolean b = true;
        if (x + width > Width || x + width - 1 < 0){
            b = false;
        }
        if (y + height > Height || y + height -1 < 0){
            b = false;
        }
        return b;
    }

}
