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
    private Random random2 = new Random();
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
            int width = random.nextInt(6) % (6 - 3 + 1) + 4;
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
        /* generate the hallway */
        for (int i = 0; i < rooms.size() - 1; i ++){
            Room r = rooms.get(i);
            int[][] res = HallWay.hallwayGenerator(r, rooms.get(i + 1));
            HallWay.drawHallway2(finalWorldFrame, res);
            HallWay.drawHallway1(finalWorldFrame, res);
            HallWay.drawHallway(finalWorldFrame, res);

        }
        int[][] playerdoor = new int[2][2];
        playerdoor = playDoor(finalWorldFrame);

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
    public static boolean doorcheck(TETile[][] world, int x, int y) {
        return (world[x][y] == Tileset.WALL);
    }

    public static boolean peoplecheck(TETile[][] world, int x, int y) {
        return (world[x][y] == Tileset.FLOOR);
    }
    public int[][] playDoor(TETile[][] finalWorldFrame) {
        int[][] results = new int[2][2];
        int x0 = 0;
        int y0 = 0;
        int xDoor = 0;
        int yDoor = 0;
        while (!peoplecheck(finalWorldFrame, x0, y0)) {
            x0 = random.nextInt(Width - 1);
            y0 = random.nextInt(Height - 1);
        }
        while (!doorcheck(finalWorldFrame, xDoor, yDoor)) {
            xDoor = random2.nextInt(Width - 1);
            yDoor = random2.nextInt(Height - 1);
        }

        finalWorldFrame[x0][y0] = Tileset.PLAYER;
        finalWorldFrame[xDoor][yDoor] = Tileset.LOCKED_DOOR;

        results[0][0] = x0;
        results[0][1] = y0;
        results[1][0] = xDoor;
        results[1][1] = yDoor;
        return results;
    }

}
