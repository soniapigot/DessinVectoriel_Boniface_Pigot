package outils;

public class Etiquette {

	private Point point;
	private String etiquete;
	private Crayon crayon;
	public Etiquette(Point point, String etiquete, Crayon crayon) {
		super();
		this.point = point;
		this.etiquete = etiquete;
		this.crayon = crayon;
	}
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
	public String getEtiquete() {
		return etiquete;
	}
	public void setEtiquete(String etiquete) {
		this.etiquete = etiquete;
	}
	public Crayon getCrayon() {
		return crayon;
	}
	public void setCrayon(Crayon crayon) {
		this.crayon = crayon;
	}
	
}
