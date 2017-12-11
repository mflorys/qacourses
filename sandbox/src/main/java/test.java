public class test{
	public static void main(String[] args){

		Point p1 = new Point();
		Point p2 = new Point();
		p1.x = -4.4;
		p1.y = -1;
		p2.x = 2;
		p2.y = 2.1;

		System.out.println(p1.distance(p2));
		System.out.println(p2.distance(p1));

	}
}