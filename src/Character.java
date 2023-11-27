public class Character extends GameObject {
	public Vector2 direction = new Vector2();
	
	public float speed = 0f;
	public int durability = 1;
	
	public Character(Vector2 position) {
		super(position);
	}
	
    @Override
    public void onUpdate(Scene scene) {
    	super.onUpdate(scene);
    	
    	position.x += direction.x * speed * Time.getDeltaTime();
    	position.y += direction.y * speed * Time.getDeltaTime();
    	
    	if (position.x < 0 ||
    		position.y > Manager.B_HEIGHT || position.y < 0)
    		Manager.destroy(this);
    }
    
    public void damage(int damage) {
    	durability -= damage;
    	
    	if(durability <= 0)
    		Manager.destroy(this);
    }
}