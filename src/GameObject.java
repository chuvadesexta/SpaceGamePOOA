import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class GameObject {
	protected Vector2 position;
    protected Image image;
    
	protected int width, height;
	
	protected boolean hasCollision = true;

    public GameObject(Vector2 position) {
        this.position = position;
    }

    void Generate(String spritePath) {
        ImageIcon icon = new ImageIcon(getClass().getResource(spritePath));
        image = icon.getImage();
        
        width = image.getWidth(null);
        height = image.getHeight(null);
        
        Manager.add(this);
    }

    public Image getImage() {
		return image;
    }
    public Rectangle getBounds() {
        return new Rectangle((int)position.x, (int)position.y, width, height);
    }
    
    public void onUpdate(Scene scene) {
    	
    }
    public void onFixedUpdate(Scene scene) {
    	
    }
    public void onLateUpdate(Scene scene) {
    	
    }
    public void onCollision(Scene scene, GameObject collider) {
    	
    }
}