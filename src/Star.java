public class Star extends GameObject {
	public Star(Vector2 position) {
		super(position);
		
        String[] stars = new String[] {
    		"Blue Star",
    		"Small Blue Star",
    		"Purple Star",
    		"Small Purple Star",
        };
        
        Generate("/sprites/" + stars[Noise.random.nextInt(stars.length)] + ".png");
        
		hasCollision = false;
	}
}