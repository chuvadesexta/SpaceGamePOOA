import java.awt.Graphics;
import java.util.ArrayList;

public class Scene {
	ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
	
	//chamado antes do primeiro update
	public void start() {
		gameObjects.clear();
	}
	//chamado no inicio de cada frame
	public void update() {
		for (int i = 0; i < gameObjects.size();){
			GameObject gameObject = gameObjects.get(i);
			
			if(Manager.isDestroyed(gameObject)) {
				gameObjects.remove(gameObject);
				Manager.clear(gameObject);
				
				continue;
			}
			
			if(gameObject.hasCollision) {
				for (int j = i; j < gameObjects.size(); j++) {
					GameObject target = get(j);
					
					if(target == null || !gameObject.getBounds().intersects(target.getBounds()))
						continue;
					
					gameObject.onCollision(this, target);
					target.onCollision(this, gameObject);		
				}
			}

			gameObject.onUpdate(this);
			i++;
		}
	}
	//chamado depois de cada atualização
	public void lateUpdate() {
		for (GameObject gameObject : gameObjects)
			gameObject.onLateUpdate(this);
	}
	public void draw(Manager manager, Graphics g) {
		for(int i = 0; i < gameObjects.size(); i++) {
			GameObject gameObject = gameObjects.get(i);
			
			g.drawImage(gameObject.getImage(), (int)gameObject.position.x, (int)gameObject.position.y, manager);
		}
	}

	
	public boolean contains(GameObject gameObject) {
		return gameObjects.contains(gameObject);
	}
	public void add(GameObject gameObject) {
		if(gameObjects.contains(gameObject))
			return;
		
		gameObjects.add(gameObject);
	}
	public GameObject get(int index){
		GameObject gameObject = gameObjects.get(index);
		
		return Manager.isDestroyed(gameObject) ? null : gameObject;
	}
}