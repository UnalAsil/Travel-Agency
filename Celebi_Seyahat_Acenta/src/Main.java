
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;

public class Main {

	public static JFrame frame;
	public static JLayeredPane lpane = new JLayeredPane();
	public static Giris sec=new Giris();
	public static Oteller otel=new Oteller();
	public static Yonetici_Sayfasi yonet=new Yonetici_Sayfasi();
	public static String userid=null;
	public static String password=null;
	public static String puan=null;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void chnge() {
		frame.getContentPane().removeAll();
	}
	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(650, 300, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lpane.setBounds(new Rectangle(0, 0, 700, 600));
		lpane.setBorder(new EmptyBorder(0, 0, 0, 0));
		lpane.setLayout(null);
		
		
		lpane.add(sec,new Integer(0),0);
		
		frame.getContentPane().add(lpane);
		
	}

}

