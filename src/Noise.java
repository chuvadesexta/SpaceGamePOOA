import java.util.Random;

public class Noise {
	static Random random = new Random();
	
	public static int random(int maxExclusive) {
		return random.nextInt(maxExclusive);
	}
}