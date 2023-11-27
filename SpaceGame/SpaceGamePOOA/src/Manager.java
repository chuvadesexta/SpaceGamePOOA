import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Manager extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private static Time time = new Time();

	private static ArrayList<GameObject> garbage = new ArrayList<GameObject>();
	
	public static final int B_WIDTH = 1400, B_HEIGHT = 1000;

	static int sceneIndex = 0;
	
	static Scene[] scenes = new Scene[] {
		new Gameplay(),
		new GameOver()
	};
	
	public Manager() {
		addKeyListener(new Input());
		setFocusable(true);
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
		setDoubleBuffered(true);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		getScene().draw(this, g);
		
		Toolkit.getDefaultToolkit().sync();
	}

	//Called before the first Update
	public static void start() {
		changeScene(0);
		
		Thread framesThread = new Thread(() -> {
			while(true) {
				time.update();
				
				scenes[sceneIndex].update();
				scenes[sceneIndex].lateUpdate();
			}
		});
		
		framesThread.start();
	}
	
	public static Scene getScene() {
		return scenes[sceneIndex];
	}
	public static void changeScene(int index) {
		sceneIndex = index;
		
		
		getScene().start();
	}
	
	public static void clear(GameObject gameObject) {
		if(!isDestroyed(gameObject))
			return;
		
		garbage.remove(gameObject);
	}
	
	public static void destroy(GameObject gameObject) {
		if(isDestroyed(gameObject))
			return;
		
		garbage.add(gameObject);
	}
	public static boolean isDestroyed(GameObject gameObject) {
		return garbage.contains(gameObject);
	}
	
	public static void add(GameObject gameObject) {
		if(getScene().contains(gameObject))
			return;
		
		getScene().add(gameObject);
	}
	public static GameObject get(int index){
		GameObject gameObject = getScene().get(index);
		
		return Manager.isDestroyed(gameObject) ? null : gameObject;
	}
}