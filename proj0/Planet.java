public class Planet {
	// instance variables
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;
	// constructor 
    public Planet(double xP, double yP, double xV, double yV,
		  double m, String imag){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = imag;
	}
	// copy constructor
	public Planet(Planet p) {
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}
	public double calcDistance(Planet p) {
		return Math.sqrt((p.xxPos - this.xxPos) * (p.xxPos - this.xxPos) +
			(p.yyPos - this.yyPos) * (p.yyPos - this.yyPos));
	}
	public double calcForceExertedBy(Planet p) {
		double r = calcDistance(p);
		return (6.67 * Math.pow(10, - 11) * this.mass * p.mass) / (r * r);
	}
	public double calcForceExertedByX(Planet p) {
		double r = calcDistance(p);
		double f = calcForceExertedBy(p);
		return f * (p.xxPos - this.xxPos) / r; 
	}
	public double calcForceExertedByY(Planet p) {
		double r = calcDistance(p);
		double f = calcForceExertedBy(p);
		return f * (p.yyPos - this.yyPos) / r; 
	}
	public double calcNetForceExertedByX(Planet[] p) {
		int nums = p.length;
		double xNetForce = 0; 
		for (int i = 0; i < nums; i ++) {
			if (p[i] == this) {
				continue;
			}
			xNetForce += calcForceExertedByX(p[i]);
		}
		return xNetForce;
	}
	public double calcNetForceExertedByY(Planet[] p) {
		int nums = p.length;
		double yNetForce = 0;
		for (int i = 0; i < nums; i ++) {
			if (p[i] == this) {
				continue;
			}
			yNetForce += calcForceExertedByY(p[i]);
		}
		return yNetForce;
	}

	public void update(double dt, double fx, double fy) {
		double aX = fx / mass;
		double aY = fy / mass;
		xxVel = xxVel + dt * aX;
		yyVel = yyVel + dt * aY;
		xxPos = xxPos + dt * xxVel;
		yyPos = yyPos + dt * yyVel;
	}
	public void draw(){
		StdDraw.picture(this.xxPos, this.yyPos, "./images/"+imgFileName);
	} 
}
