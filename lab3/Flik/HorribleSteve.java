public class HorribleSteve {
	public static void main (String [] args) {
		int i = 200;
		for (int j = 0; j < 500; ++j) {
			if (Flik.isSameNumber(i, j)) {
          		break; // break exits the for loop!
			}
		}
		System.out.println("i is " + i);
	}
} 