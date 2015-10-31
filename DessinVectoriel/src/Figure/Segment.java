package Figure;

public class Segment implements IChemin{

	private Point point1;
	private Point point2;
	
	public Segment(Point point1, Point point2) {
		super();
		this.point1 = point1;
		this.point2 = point2;
	}
	public Point getPoint1() {
		return point1;
	}
	public void setPoint1(Point point1) {
		this.point1 = point1;
	}
	public Point getPoint2() {
		return point2;
	}
	public void setPoint2(Point point2) {
		this.point2 = point2;
	}
	
	
	
}
