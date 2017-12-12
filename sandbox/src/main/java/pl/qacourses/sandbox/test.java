package pl.qacourses.sandbox;

public class test{
	public static void main(String[] args){

		Point p1 = new Point(-4.4, -1);
		Point p2 = new Point(2, 2.1);

		System.out.println(p1.distance(p2));
		System.out.println(p2.distance(p1));

	}
}