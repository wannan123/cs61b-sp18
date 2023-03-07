import java.io.FilenameFilter;

public class NBody {
    public static double readRadius(String filename){
        In in = new In(filename);
        int num = in.readInt();
        double radius=in.readDouble();
		return radius;
    }
    public static Planet[] readPlanets(String filename){
        In in = new In(filename);
        int num = in.readInt();
        double radius =in.readDouble();
        Planet[] p=new Planet[num];
        for(int i=0;i<num;i++){
            double xp = in.readDouble();
			double yp = in.readDouble();
			double vx = in.readDouble();
			double vy = in.readDouble();
			double m = in.readDouble();
			String img = in.readString();
			p[i] = new Planet(xp, yp, vx, vy, m, img);
        }
        return p;
    }
}
