public class NBody {
	public static double readRadius(String name) {
		In in = new In(name);
		int N = in.readInt();
        double Radius = in.readDouble();
		return Radius;
	}

    public static Body[] readBodies(String name) {
        In in = new In(name);
		int N = in.readInt();
        double Radius = in.readDouble();
        Body[] body_list = new Body[N];
        for (int i = 0; i < N; i++){
            body_list[i] = new Body(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
        }       
        return body_list;
    }

	// public static void main(String[] args) {
	// 	double T = Double.parseDouble(args[0]);
	// 	double dt = Double.parseDouble(args[1]);
	// 	String filename = args[2];
		
	// 	double radius = readRadius(filename);
	// 	Body[] bodies = readBodies(filename);
	// 	int N = bodies.length;

	// 	StdDraw.setScale(-radius, radius);
	// 	StdDraw.clear();
	// 	StdDraw.picture(0, 0, "images/starfield.jpg");

	// 	for (Body b: bodies) {
	// 		b.draw();
	// 	}

	// 	StdDraw.enableDoubleBuffering();

	// 	double time = 0;
	// 	while (time < T) {
	// 		double[] xForces = new double[N];
	// 		double[] yForces = new double[N];
			
	// 		for (int i = 0; i < N; i++) {
	// 			xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
	// 			yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
	// 		}

	// 		for (int i = 0; i < N; i++) {
	// 			bodies[i].update(dt, xForces[i], yForces[i]);
	// 		}

	// 		StdDraw.picture(0, 0, "images/starfield.jpg");
	// 		for (Body b: bodies) {
	// 			b.draw();
	// 		}
	// 		StdDraw.show();
	// 		StdDraw.pause(10);
	// 		time += dt;
	// 	}

	// 	StdOut.printf("%d\n", bodies.length);
	// 	StdOut.printf("%.2e\n", radius);
	// 	for (int i = 0; i < bodies.length; i++) {
	// 	    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
	// 	                  bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
	// 	                  bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
	// 	}
	// }
}