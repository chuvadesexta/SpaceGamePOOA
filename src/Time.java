public final class Time {
	public static final float MILLIS_TO_SECOND = 1f / 1000f;
	
	private static float framesPerSecond = 0f;
	
	private static long initialTime = System.currentTimeMillis(), elapsedTime = 0, cycledTime = 0, deltaTime = 0;
	
	public void update() {
		elapsedTime = System.currentTimeMillis() - initialTime;
		
		deltaTime = elapsedTime - cycledTime;
		
		framesPerSecond = (0.9f * framesPerSecond) + (0.1f * (1f / deltaTime));
		
		cycledTime = elapsedTime;
	}
	
	public static float getElapsedSeconds() {
		return MILLIS_TO_SECOND * elapsedTime;
	}
	
	public static float getDeltaTime() {
		return MILLIS_TO_SECOND * deltaTime;
	}
	
	public static float getFPS() {
		return framesPerSecond;
	}
}