import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class GameOver extends Scene {
	@Override
	public void start() {
		super.start();
	}
	@Override
	public void update() {
		super.update();
		
		if(Input.getKey(KeyEvent.VK_SPACE))
			Manager.changeScene(0);
	}
	@Override
	public void lateUpdate() {
		super.lateUpdate();
	}
	
	@Override
	public void draw(Manager manager, Graphics g) {
		String line1 = "Game Over";
		String line2 = "Press Space To Retry";
		
		Font medium = new Font("Helvetica", Font.BOLD, 20);
		Font small = new Font("Helvetica", Font.BOLD, 15);
		
		FontMetrics mediumFM = manager.getFontMetrics(medium);
		FontMetrics smallFM = manager.getFontMetrics(small);
		
		g.setColor(Color.red);
		g.setFont(medium);
		g.drawString(line1, (Manager.B_WIDTH - mediumFM.stringWidth(line1)) / 2, Manager.B_HEIGHT / 2);
		
		g.setColor(Color.white);
		g.setFont(small);
		g.drawString(line2, (Manager.B_WIDTH - smallFM.stringWidth(line2)) / 2, Manager.B_HEIGHT / 2 + smallFM.getHeight());
	}
}