import java.awt.EventQueue;
import javax.swing.JFrame;

public class Game extends JFrame {
	private static final long serialVersionUID = 1L;

	static Manager manager = new Manager();
	
	public Game() {
        add(manager);
        setResizable(false);
        pack();
        setTitle("Space Game");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new Game();
                
                frame.setVisible(true);
                
                Thread renderThread = new Thread(() -> {
                    while (true)
                        manager.repaint();
                });

                renderThread.start();
            }
        });
        
        Manager.start();
    }
}