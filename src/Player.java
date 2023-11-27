import java.awt.event.KeyEvent;

public class Player extends Character {
    private float fireCooldown = 0;

    public Player(Vector2 position) {
        super(position);
        
        durability = 1;
        speed = 400f;
        
        Generate("/sprites/Player.png");
    }

    @Override
    public void onUpdate(Scene scene) {
    	if(Input.getKey(KeyEvent.VK_SPACE))
    		fire();
    	
    	if(Input.getKey(KeyEvent.VK_A))
    		direction.x = -1;
    	else if(Input.getKey(KeyEvent.VK_D))
    		direction.x = 1;
    	else
    		direction.x = 0;
    	
    	if(Input.getKey(KeyEvent.VK_W))
    		direction.y = -1;
    	else if(Input.getKey(KeyEvent.VK_S))
    		direction.y = 1;
    	else
    		direction.y = 0;
    	
    	super.onUpdate(scene);
    }
	
	private void fire() {
		if (Time.getElapsedSeconds() < fireCooldown)
			return;
		
        fireCooldown = Time.getElapsedSeconds() + 0.5f;
		
        new Projectile(new Vector2(position.x + width, position.y + height/ 2));
    }
}