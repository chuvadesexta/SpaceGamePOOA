public class Projectile extends Character {
	private final int damage = 1;
	
	public Projectile(Vector2 position) {
		super(position);
		Generate("/sprites/Laser.png");
		
		durability = 1;
		speed = 4000f;
		
		direction.x = 1f;
	}

	@Override
	public void onUpdate(Scene scene) {
    	if (position.x < 0 || position.x > Manager.B_WIDTH ||
    		position.y > Manager.B_HEIGHT || position.y < 0)
    		Manager.destroy(this);
    	
    	position.x += direction.x * speed * Time.getDeltaTime();
    	position.y += direction.y * speed * Time.getDeltaTime();
	}
	
	@Override
	public void onCollision(Scene scene, GameObject collider) {
		if(collider instanceof NPC npc){
			npc.damage(damage);
			
			if(npc.durability <= 0)
				((Gameplay)scene).score++;
			
		    damage(1);
		}
	}
}