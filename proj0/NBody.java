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
    public static void main(String[] args) {
        double T = Double.valueOf(args[0]);
		double dt = Double.valueOf(args[1]);
        String filename_=args[2];
        double radius=readRadius(filename_);
        Planet[] planets=readPlanets(filename_);


        StdDraw.setXscale(-radius, radius);
		StdDraw.setYscale(-radius,radius);
        StdDraw.enableDoubleBuffering();
        
        int n=planets.length;
        double t=0;
        while(t<=T){
            double[] fx=new double[n];
            double[] fy=new double[n];
            for(int i=0;i<n;i++){
                fx[i]=planets[i].calcNetForceExertedByX(planets);
                fy[i]=planets[i].calcNetForceExertedByY(planets);
            }
            StdDraw.picture(0,0,"images/starfield.jpg");
            for(int i=0;i<n;i++){
                planets[i].update(dt, fx[i], fy[i]);
                planets[i].draw();
            }
            
            StdDraw.show();
            StdDraw.pause(10);
            
			t += dt;
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                          planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                          planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }
        
    }
}
