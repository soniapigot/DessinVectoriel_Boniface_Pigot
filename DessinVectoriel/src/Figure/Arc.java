package Figure;


public class Arc implements IChemin{

	private Point centre;
	private Point pointDeDepart;
	private double angle;
	
	
	public Arc(Point centre, Point pointDeDepart, double angle) {
		super();
		this.centre = centre;
		this.pointDeDepart = pointDeDepart;
		this.angle = angle;
	}


	public Point getCentre() {
		return centre;
	}


	public void setCentre(Point centre) {
		this.centre = centre;
	}


	public Point getPointDeDepart() {
		return pointDeDepart;
	}


	public void setPointDeDepart(Point pointDeDepart) {
		this.pointDeDepart = pointDeDepart;
	}


	public double getAngle() {
		return angle;
	}


	public void setAngle(double angle) {
		this.angle = angle;
	};
	
	
	
	
	
	
	
}
