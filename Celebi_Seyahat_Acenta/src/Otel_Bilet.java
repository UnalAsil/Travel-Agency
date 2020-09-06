import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Otel_Bilet extends JFrame {
	String otel, gun, ay, yil, bolge, fiyat;
	private JPanel contentPane;
	private JTextField textField_isim;
	private JTextField textField_soyisim;
	private JTextField textField_yas;
	private JLabel lblTutar;
	private JLabel label;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Otel_Bilet frame = new Otel_Bilet("","","","","","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Otel_Bilet(String otel,String gun,String ay,String yil,String bolge,String fiyat) {
		this.otel=otel;
		this.gun=gun;
		this.ay=ay;
		this.yil=yil;
		this.bolge=bolge;
		this.fiyat=fiyat;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 421);
		contentPane = new JPanel();
		contentPane.setBounds(100, 100, 672, 388);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIsim = new JLabel("\u0130sim :");
		lblIsim.setBounds(28, 36, 33, 16);
		getContentPane().add(lblIsim);
		
		textField_isim = new JTextField();
		textField_isim.setBounds(67, 33, 116, 22);
		getContentPane().add(textField_isim);
		textField_isim.setColumns(10);
		
		JLabel lblSoyisim = new JLabel("Soyisim :");
		lblSoyisim.setBounds(200, 36, 53, 16);
		getContentPane().add(lblSoyisim);
		
		textField_soyisim = new JTextField();
		textField_soyisim.setColumns(10);
		textField_soyisim.setBounds(263, 33, 116, 22);
		getContentPane().add(textField_soyisim);
		
		JLabel lblYas = new JLabel("Yas :");
		lblYas.setBounds(28, 65, 29, 16);
		getContentPane().add(lblYas);
		
		textField_yas = new JTextField();
		textField_yas.setColumns(10);
		textField_yas.setBounds(67, 62, 116, 22);
		getContentPane().add(textField_yas);
		
		JLabel lblBilgiler1 = new JLabel("Otel:"+otel);
		lblBilgiler1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBilgiler1.setBounds(0, 104, 511, 16);
		getContentPane().add(lblBilgiler1);
		
		JLabel lblBilgiler2 = new JLabel("Tarih: "+gun+"-"+ay+"-"+yil);
		lblBilgiler2.setHorizontalAlignment(SwingConstants.CENTER);
		lblBilgiler2.setBounds(0, 133, 511, 16);
		getContentPane().add(lblBilgiler2);
		
		JLabel lblBilgiler3 = new JLabel("Bölge: "+bolge);JLabel lblOdemeTr = new JLabel("\u00D6deme T\u00FCr\u00FC");
		lblOdemeTr.setHorizontalAlignment(SwingConstants.CENTER);
		lblOdemeTr.setBounds(216, 203, 72, 16);
		getContentPane().add(lblOdemeTr);
		
		JRadioButton rdbtnNakit = new JRadioButton("Nakit");
		rdbtnNakit.setBounds(129, 228, 57, 25);
		getContentPane().add(rdbtnNakit);
		rdbtnNakit.setSelected(true);
		
		JRadioButton rdbtnKrediKart = new JRadioButton("Kredi Kart\u0131");
		rdbtnKrediKart.setBounds(201, 228, 87, 25);
		getContentPane().add(rdbtnKrediKart);
		
		JRadioButton rdbtnek = new JRadioButton("\u00C7ek");
		rdbtnek.setBounds(304, 228, 49, 25);
		getContentPane().add(rdbtnek);
		
		ButtonGroup group = new ButtonGroup();
        group.add(rdbtnNakit);
        group.add(rdbtnKrediKart);
        group.add(rdbtnek);
		lblBilgiler3.setHorizontalAlignment(SwingConstants.CENTER);
		lblBilgiler3.setBounds(0, 164, 511, 16);
		getContentPane().add(lblBilgiler3);
		
		JLabel lblPuan = new JLabel("Puan: "+Main.puan);
		lblPuan.setBounds(200, 68, 102, 16);
		getContentPane().add(lblPuan);
		
		JCheckBox CheckBox_puan = new JCheckBox("Puanlar\u0131 Kullan");
		CheckBox_puan.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int tutar;
				if(CheckBox_puan.isSelected()) {
					tutar=Integer.parseInt(fiyat)-Integer.parseInt(Main.puan);
				}else
					tutar=Integer.parseInt(fiyat);
				lblTutar.setText("Tutar: "+tutar);
			}
		});
		CheckBox_puan.setBounds(356, 61, 113, 25);
		getContentPane().add(CheckBox_puan);
		
		JButton btndemeyiGerekletir = new JButton("Ödemeyi Gerçekleþtir");
		btndemeyiGerekletir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String isim=textField_isim.getText();
				String soyisim=textField_soyisim.getText();
				String yas=textField_yas.getText();
				if(textField_isim.getText().equals(""))
					label.setText("Ýsim boþ býrakýlamaz");
				else if(textField_soyisim.getText().equals(""))
					label.setText("Soyisim boþ býrakýlamaz");
				else if(textField_yas.getText().equals(""))
					label.setText("Yaþ boþ býrakýlamaz");
				else {
					try {
						FileWriter printer = new FileWriter(new File("Celebi_Seyahat_Acenta/Rezervasyonlar.txt"),true);
						String text="";
						text+=isim+","+soyisim+","+yas+","+otel+","+gun+"-"+ay+"-"+yil+","+bolge+","+fiyat+" ";
						printer.write(text+"\n");
						printer.close();
						Scanner scan=new Scanner(new File("Celebi_Seyahat_Acenta/Musteriler.txt"));
						String tmper=scan.nextLine();
						while(scan.hasNextLine()) {
							String tmp=scan.nextLine();
							if(tmp.contains(Main.userid) && CheckBox_puan.isSelected()) 
								tmper=tmper+"\n"+Main.userid+" "+Main.password+" 0";
							else if(tmp.contains(Main.userid)) 
								tmper=tmper+"\n"+Main.userid+" "+Main.password+" "+(int)(Integer.parseInt(Main.puan)+(Integer.parseInt(fiyat)*0.01));
							else 
								tmper=tmper+"\n"+tmp;
						}
						scan.close();
						FileWriter printer2=new FileWriter(new File("Celebi_Seyahat_Acenta/Musteriler.txt"));
						printer2.write(tmper);
						printer2.close();
						///////////////////////////////////////////////////////////////////////////////////////
						Scanner scan2=new Scanner(new File("Celebi_Seyahat_Acenta/Oteller.txt"));
						String t_otel="",t_gun="",t_ay="",t_yil="",t_bolge="",t_fiyat="";
						String texter="";
						while(scan2.hasNextLine()) {
							t_otel="";t_gun="";t_ay="";t_yil="";t_bolge="";t_fiyat="";
							char[] x=scan2.nextLine().toCharArray();
							int l=0;
							while(x[l]!=',') { t_otel+=x[l++]; } l++;
							while(x[l]!=',') { t_fiyat+=x[l++]; } l++;
							while(x[l]!=',') { t_bolge+=x[l++]; } l++;
							while(x[l]!='-') { t_gun+=x[l++]; } l++;
							while(x[l]!='-') { t_ay+=x[l++]; } l++;
							while(x[l]!=' ') { t_yil+=x[l++]; } l++;
							
							if(!(t_gun.equals(gun) && t_ay.equals(ay) && t_yil.equals(yil) && t_bolge.equals(bolge) && t_otel.equals(otel) && t_fiyat.equals(fiyat)))
								texter+=t_otel+","+t_fiyat+","+t_bolge+","+t_gun+"-"+t_ay+"-"+t_yil+" \n";
						}
						scan2.close();
						FileWriter printer3 = new FileWriter(new File("Celebi_Seyahat_Acenta/Oteller.txt"));
						printer3.write(texter+"");
						printer3.close();
						JOptionPane.showMessageDialog(null, "Kayýt yapýlmýþtýr.");
						dispose();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		
		lblTutar = new JLabel("Tutar: "+Integer.parseInt(Main.puan));
		lblTutar.setBounds(216, 275, 72, 16);
		getContentPane().add(lblTutar);
		btndemeyiGerekletir.setBounds(171, 304, 153, 25);
		getContentPane().add(btndemeyiGerekletir);
		
		label = new JLabel("");
		label.setBounds(360, 104, 0, 0);
		contentPane.add(label);
	}

}
