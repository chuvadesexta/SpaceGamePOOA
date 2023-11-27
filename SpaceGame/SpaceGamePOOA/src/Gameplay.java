import java.awt.Color;
import java.awt.Graphics;

public class Gameplay extends Scene {
	public int score = 0, level = 1;
	private float waveCooldown = 0;
	
	public float timer = 0;
	
	public Player player;
	
	@Override
	public void start() {
		super.start();
		
		score = 0;
		level = 1;
		waveCooldown = 0;
		timer = 0;
		
		for(int i = 0; i < 255; i++)
			new Star(new Vector2(Noise.random.nextInt(Manager.B_WIDTH), Noise.random.nextInt(Manager.B_HEIGHT)));
		
		player = new Player(new Vector2(0, Manager.B_HEIGHT / 2));
	}
	@Override
	public void update() {
		super.update();
		
		if(score == 200 || !gameObjects.contains(player))
			Manager.changeScene(1);
		
		timer += Time.getDeltaTime();
		waveCooldown -= Time.getDeltaTime();
		
		if(waveCooldown > 0)
			return;
		
		waveCooldown = 2 + Noise.random.nextInt(3);
		
		int waveSize = 2 + Noise.random.nextInt(4);
		
		float heightFactor = (float)Manager.B_HEIGHT / waveSize;
		
		for (int i = 0; i < level; i++) {
			int levelOffset = (i % 2) * 20;
			
			for (int j = 0; j < waveSize; j++) {
				int posOffset = (j % 2) * 50;
				
				int yAxys = (int)(j * heightFactor - levelOffset);
				int xAxys = Manager.B_WIDTH - (-i * 100 - posOffset);
				
				new NPC(new Vector2(xAxys, yAxys));
			}
		}
		
		level++;
	}
	@Override
	public void lateUpdate() {
		super.lateUpdate();
		
		for (GameObject gameObject : gameObjects)
			gameObject.onLateUpdate(this);
	}
	
	@Override
	public void draw(Manager manager, Graphics g) {
		super.draw(manager, g);
		
		g.setColor(Color.WHITE);
		g.drawString("POINTS: " + score, 5, 15);
		g.drawString("TIME: " + timer, 5, 30);
	}
}