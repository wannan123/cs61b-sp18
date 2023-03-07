public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final double G = 6.67e-11;
    public Planet(double xP, double yP, double xV,double yV, double m, String img){
        xxPos=xP;
        yyPos=yP;
        xxVel=xV;
        yyVel=yV;
        mass=m;
        imgFileName=img;
    };
    public Planet(Planet b){
        xxPos=b.xxPos;
        yyPos=b.yyPos;
        xxVel=b.xxVel;
        yyVel=b.yyVel;
        mass=b.mass;
        imgFileName=b.imgFileName;
    };
    public double calcDistance(Planet rocinante){
        return Math.sqrt(Math.pow(xxPos-rocinante.xxPos, 2)+Math.pow(yyPos-rocinante.yyPos,2));
    };
    public double calcForceExertedBy(Planet p){
        double dis=calcDistance(p);
        return G*mass*p.mass/(dis*dis);
    };
    public double calcForceExertedByX(Planet p){
        double F=calcForceExertedBy(p);
        return F*(-(xxPos-p.xxPos))/calcDistance(p);
    }
    public double calcForceExertedByY(Planet p){
        double F=calcForceExertedBy(p);
        return F*(p.yyPos-yyPos)/calcDistance(p);
    }
    public double calcNetForceExertedByX(Planet[] planets){
        double F_sum=0;
        for(int i=0;i<planets.length;i++){
            if(this.equals(planets[i])){
                continue;
            }
            F_sum+=calcForceExertedByX(planets[i]);
        }
        return F_sum;
    }
    public double calcNetForceExertedByY(Planet[] planets){
        double F_sum=0;
        for(int i=0;i<planets.length;i++){
            if(this.equals(planets[i])){
                continue;
            }
            F_sum+=calcForceExertedByY(planets[i]);
        }
        return F_sum;

    }
    public void update(double dt, double fX, double fY){
        double ax=fX/mass;
        double ay=fY/mass;
        xxVel+=dt*ax;
        yyVel+=dt*ay;
        xxPos+=dt*xxVel;
        yyPos+=dt*yyVel;
    }



}
