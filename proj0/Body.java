public class Body{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Body(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Body(Body b){
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b1){
        return Math.sqrt(Math.pow(Math.abs(b1.xxPos - xxPos), 2) + Math.pow(Math.abs(b1.yyPos - yyPos), 2));
    }

    public double calcForceExertedBy(Body b1){
        double distance = calcDistance(b1);
        return 6.67 * Math.pow(10, -11) * mass * b1.mass / (distance * distance);
    }

    public double calcForceExertedByX(Body b1){
        double total_force = calcForceExertedBy(b1);
        double distance = calcDistance(b1);
        return total_force * (b1.xxPos - xxPos) / distance;
    }

    public double calcForceExertedByY(Body b1){
        double total_force = calcForceExertedBy(b1);
        double distance = calcDistance(b1);
        return total_force * (b1.yyPos - yyPos) / distance;
    }

    public double calcNetForceExertedByX(Body[] body_array){
        double net_force_x = 0;
        int N = body_array.length;
        for (int i = 0; i < N; i ++){
            net_force_x += calcForceExertedByX(body_array[i]);
        }
        return net_force_x;
    }

    public double calcNetForceExertedByY(Body[] body_array){
        double net_force_y = 0;
        int N = body_array.length;
        for (int i = 0; i < N; i ++){
            net_force_y += calcForceExertedByY(body_array[i]);
        }
        return net_force_y;
    }

    public void update(double time, double force_x, double force_y){
        double acc_x = force_x / mass;
        double acc_y = force_y / mass;

        xxVel += acc_x * time;
        yyVel += acc_y * time;

        xxPos += xxVel * time;
        yyPos += yyVel * time;

    }
}