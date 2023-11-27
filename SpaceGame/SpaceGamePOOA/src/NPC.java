public class NPC extends Character {
    public NPC(Vector2 position) {
        super(position);
        
        Generate("/sprites/Enemy.png");
        
        durability = 1;
        
        direction.x = -1f;
    }

    @Override
    public void onUpdate(Scene scene) {
    	speed = 70f + ((Gameplay)scene).timer * 5f;
    	
    	super.onUpdate(scene);
    }
    
    @Override
    public void onCollision(Scene scene, GameObject collider) {
    	if(collider instanceof Player player){
    		player.damage(1);
			damage(1);
		}
	}
}