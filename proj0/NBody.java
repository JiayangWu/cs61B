public class NBody {
	public static double readRadius(final String name) {
        final In in = new In(name);
        final int N = in.readInt();
        final double Radius = in.readDouble();
        return Radius;
    }

public static Body[] readBodies(String filename) {
		In in = new In(filename);
		int N = in.readInt();
		double R = in.readDouble();
		
		Body[] bodies = new Body[N];

		for (int i = 0; i < N; i++) {
			double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            bodies[i] = new Body(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
		}

		return bodies;
	}

    public static void main(final String[] args) {
        final double T = Double.parseDouble(args[0]);
        final double dt = Double.parseDouble(args[1]);

        final String filename = args[2];
        final double radius = readRadius(filename);
        final Body[] bodies = readBodies(filename);
        final int N = bodies.length;

        final String image = "images/starfield.jpg";

        StdDraw.setScale(-100, 100);
        StdDraw.clear();
        StdDraw.picture(0, 0, image);

        StdDraw.enableDoubleBuffering();
        for (final Body b : bodies) {
            b.draw();
        }

        StdDraw.enableDoubleBuffering();

        double time = 0;
        while (time < T) {
            final double[] xForces = new double[N];
            final double[] yForces = new double[N];

            for (int i = 0; i < N; i++) {
                xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
                yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
            }

            for (int i = 0; i < N; i++) {
                bodies[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (final Body b : bodies) {
				b.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
			time += dt;
		}

		System.out.printf("%d\n", bodies.length);
		System.out.printf("%.2e\n", radius);
		for (int i = 0; i < bodies.length; i++) {
		    System.out.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		                  bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
		                  bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
		}
	}
}
	