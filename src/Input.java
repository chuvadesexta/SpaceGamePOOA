import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Input extends KeyAdapter implements KeyListener {
	static ArrayList<Integer> pressedKeys = new ArrayList<Integer>();
	
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if(pressedKeys.contains(keyCode))
        	return;
        
        pressedKeys.add(keyCode);
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        Integer keyCode = e.getKeyCode();

        if(!pressedKeys.contains(keyCode))
        	return;
        
        pressedKeys.remove(keyCode);
    }
    
	public static boolean getKey(int keyCode) {
		return pressedKeys.contains(keyCode);
	}
}