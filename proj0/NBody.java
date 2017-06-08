public class NBody {
	public static double readRadius(String filePath) {
		In input = new In(filePath);
		Integer nums = input.readInt();
		Double radius = input.readDouble();
		return radius;
	} 
	public static Planet[] readPlanets(String filePath) {
		In input = new In(filePath);
		Integer nums = input.readInt();
		Double radius = input.readDouble();
		Planet[] planets = new Planet[nums];
		int i = 0;
		while (i < nums) {
			double xxPos = input.readDouble();
			double yyPos = input.readDouble();
			double xxVel = input.readDouble();
			double yyVel = input.readDouble();
			double mass = input.readDouble();
			String imag = input.readString();
			planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imag);
			i ++;
		}
		return planets;
	}
	public static void main(String args[]) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);
		StdDraw.setScale(-radius, radius);
		StdDraw.clear();
		StdDraw.picture(0,0, "./images/starfield.jpg");
		int nums = planets.length;
		for (int i = 0; i < nums; i ++) {
			planets[i].draw();
		}
		double time = 0;
		while (time < T) {
			double[] xForces = new double[nums];
			double[] yForces = new double[nums];
			for (int i = 0; i < nums; i ++) {
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}
			for (int i = 0; i < nums; i ++) {
				planets[i].update(dt, xForces[i], yForces[i]);
			}
			StdDraw.picture(0,0, "./images/starfield.jpg");
			for (int i = 0; i < nums; i ++) {
				planets[i].draw();
			}
			StdDraw.show(10);
			time += dt;
		}
		StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                planets[i].xxPos, planets[i].yyPos, planets[i].xxVel, planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
	}
}
