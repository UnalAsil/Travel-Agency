
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.JPasswordField;

public class Giris extends JPanel {

	private static final long serialVersionUID = 1L;
		private JTextField id;
		private JLabel labelInfo;
		private JButton login;
		private JButton register;
		private JButton changer;
		private JPasswordField password;
		private boolean chooser=true;
		private JLabel label;
		private JLabel user_admin1;
		private JLabel user_admin2;
		private boolean yonetici=false;
		


		public Giris() {
			setBounds(new Rectangle(0, 0, 700, 600));
			setAlignmentY(Component.TOP_ALIGNMENT);
			setAlignmentX(Component.LEFT_ALIGNMENT);
			setLayout(null);
			
			JLabel lblUserId = new JLabel("Kullanýcý adý:");                         //UserId Label
			lblUserId.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblUserId.setBounds(134, 216, 120, 25);
			add(lblUserId);
			
			JLabel lblPassword = new JLabel("Þifre:");						//Password Label
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblPassword.setBounds(134, 279, 120, 25);
			add(lblPassword);
			
			id = new JTextField();												//id TextField
			id.setBounds(277, 220, 223, 22);
			add(id);
			id.setColumns(10);
			
			password = new JPasswordField();									//password
			password.setEchoChar('*');
			password.setBounds(277, 283, 193, 22);
			add(password);
			
			JButton btnNewButton = new JButton("");								//Show password
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(chooser) {
						password.setEchoChar((char)0);			
						chooser=false;
					}else{
						password.setEchoChar('*');
						chooser=true;
					}
					
				}
			});
			btnNewButton.setBounds(482, 280, 18, 25);
			add(btnNewButton);
			
			
			login = new JButton("Giriþ");										//Login button
			login.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(yonetici) {
						String pass="";
						char[] tmp=password.getPassword();
						for(int i=0;i<tmp.length;i++)
							pass+=tmp[i];
						if(id.getText().equals("admin") && pass.equals("password")) {
							Main.lpane.removeAll();
							Main.lpane.add(Main.yonet,new Integer(0),0);
						}else {
							labelInfo.setText("Yönetici adý yada þifre hatali");
						}
					}else {
						try {
							Scanner sc =new Scanner(new File("Celebi_Seyahat_Acenta/Musteriler.txt"));
							while(sc.hasNext()) {
								String pass="";
								char[] tmp=password.getPassword();
								for(int i=0;i<tmp.length;i++)
									pass+=tmp[i];
								String tmp1=sc.next();
								String tmp2=sc.next();
								String tmp3=sc.next();
								if(tmp1.equals(id.getText()))
									if(tmp2.equals(pass)) {
										Main.userid=tmp1;
										Main.password=tmp2;
										Main.puan=tmp3;
										Main.lpane.removeAll();
										Main.lpane.add(Main.otel,new Integer(0),0);
									}
							}
						labelInfo.setText("Hatalý kullanýcý adý yada þifre");
						sc.close();
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			login.setBounds(324, 351, 176, 25);
			add(login);
			
			changer = new JButton("Yönetici Giriþi");								//User-Admin Button
			changer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(yonetici) {
						user_admin1.setText("Misafir Giriþi:");
						user_admin2.setText("---------------");
						changer.setText("Yönetici Giriþi");
						lblUserId.setText("Kullanýcý adý:");
						register.setVisible(true);
					}else{
						register.setVisible(false);
						user_admin1.setText("Yönetici Giriþi:");
						user_admin2.setText("----------------");
						changer.setText("Misafir Giriþi");
						lblUserId.setText("Yönetici adý:");
					}
					yonetici=(!yonetici);
				}
			});
			changer.setBounds(285, 500, 120, 25);
			add(changer);
			
			register = new JButton("Kay\u0131t Ol");									//Register
			register.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						boolean control=true;
			        try {
			        	Scanner sc=new Scanner(new File("Celebi_Seyahat_Acenta/Musteriler.txt"));
			        	while(sc.hasNext()) {
			        		if(sc.next().equals(id.getText()))
			        			control=false;
			        		sc.next();
			        	}
			        	sc.close();
			        	if(!control) {
			        		labelInfo.setText("Kullanýcý adý zaten var");
			        	}else{
			        		char[] pas=password.getPassword();
			        		String pass="";
			        		for(int m=0;m<pas.length;m++)
				        		pass+=pas[m];
			        		if(id.getText().contains(" ") || pass.contains(" "))
			        			labelInfo.setText("Kullanýcý adý yada þifre de hatalý karakter");
			        		else if(id.getText().isEmpty() || pass.isEmpty()) {
			        			labelInfo.setText("Kullanýcý adý veya þifre boþ kalamaz");
			        		}else{
			        			labelInfo.setText("Kullanýcý oluþturuldu");
			        			FileWriter printer = new FileWriter(new File("Celebi_Seyahat_Acenta/Musteriler.txt"),true);
					        	printer.write("\n"+id.getText().toString()+" "+pass);
								printer.close();
			        		}
			        	    
			        	}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			register.setBounds(134, 351, 176, 25);
			add(register);
			
			labelInfo = new JLabel();											//Secret Info
			labelInfo.setBounds(134, 315, 366, 16);
			add(labelInfo);
			
			user_admin1 = new JLabel("M\u00FC\u015Fteri Giri\u015Fi");
			user_admin1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			user_admin1.setBounds(134, 160, 131, 32);
			add(user_admin1);
			
			user_admin2 = new JLabel("-----------------");
			user_admin2.setFont(new Font("Tahoma", Font.PLAIN, 20));
			user_admin2.setBounds(134, 187, 131, 20);
			add(user_admin2);
			
			label = new JLabel();
			label.setBounds(0, 0, 700, 550);
			label.setIcon(new ImageIcon("login_background.JPG"));
			add(label);
			
		}
	}
