
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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Seyahat_Bilet extends JFrame {
	private static final long serialVersionUID = 1L;
	String firma, gun, ay, yil, kalkis, saat, dakika, varis, sure_saat, sure_dakika, yolcu_sayisi, fiyat;
	private JTextField textField_isim;
	private JTextField textField_soyisim;
	private JTextField textField_yas;
	private JLabel lblTutar;
	private JPanel contentPane;
	private JLabel label;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seyahat_Bilet frame = new Seyahat_Bilet("","","","","","","","","","","","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Seyahat_Bilet(String firma,String gun,String ay,String yil,String kalkis,String saat,String dakika,String varis,String sure_saat,String sure_dakika,String yolcu_sayisi,String fiyat) {
		this.firma=firma;
		this.gun=gun;
		this.ay=ay;
		this.yil=yil;
		this.kalkis=kalkis;
		this.saat=saat;
		this.dakika=dakika;
		this.varis=varis;
		this.sure_saat=sure_saat;
		this.sure_dakika=sure_dakika;
		this.yolcu_sayisi=yolcu_sayisi;
		this.fiyat=fiyat;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 435);
		contentPane = new JPanel();
		contentPane.setBounds(100, 100, 672, 388);
		setContentPane(contentPane);
		contentPane.setLayout(null);


		
		JLabel lblIsim = new JLabel("\u0130sim :");
		lblIsim.setBounds(26, 26, 56, 16);
		getContentPane().add(lblIsim);
		
		textField_isim = new JTextField();
		textField_isim.setBounds(109, 23, 116, 22);
		getContentPane().add(textField_isim);
		textField_isim.setColumns(10);
		
		JLabel lblSoyisim = new JLabel("Soyisim :");
		lblSoyisim.setBounds(255, 26, 56, 16);
		getContentPane().add(lblSoyisim);
		
		textField_soyisim = new JTextField();
		textField_soyisim.setColumns(10);
		textField_soyisim.setBounds(319, 23, 116, 22);
		getContentPane().add(textField_soyisim);
		
		JLabel lblYas = new JLabel("Yas :");
		lblYas.setBounds(26, 55, 56, 16);
		getContentPane().add(lblYas);
		
		textField_yas = new JTextField();
		textField_yas.setColumns(10);
		textField_yas.setBounds(109, 52, 116, 22);
		getContentPane().add(textField_yas);
		
		JLabel lblBilgiler1 = new JLabel("Firma:"+firma+" Tarih: "+gun+"-"+ay+"-"+yil);
		lblBilgiler1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBilgiler1.setBounds(26, 95, 594, 22);
		getContentPane().add(lblBilgiler1);
		
		JLabel lblBilgiler2 = new JLabel("Kalkýþ Noktasý: "+kalkis+" Kalkýþ Saati: "+dakika+"-"+saat);
		lblBilgiler2.setHorizontalAlignment(SwingConstants.CENTER);
		lblBilgiler2.setBounds(26, 117, 594, 22);
		getContentPane().add(lblBilgiler2);
		
		JLabel lblBilgiler3 = new JLabel("Varýþ Noktasý: "+varis+"Yolculuk Süresi: "+sure_dakika+"-"+sure_saat);
		lblBilgiler3.setHorizontalAlignment(SwingConstants.CENTER);
		lblBilgiler3.setBounds(26, 140, 594, 22);
		getContentPane().add(lblBilgiler3);
		
		JLabel lblPuan = new JLabel("Puan: "+Main.puan);
		lblPuan.setBounds(255, 55, 180, 16);
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
		CheckBox_puan.setBounds(470, 51, 113, 25);
		getContentPane().add(CheckBox_puan);
		
		JLabel lblOdemeTr = new JLabel("\u00D6deme T\u00FCr\u00FC");
		lblOdemeTr.setHorizontalAlignment(SwingConstants.CENTER);
		lblOdemeTr.setBounds(0, 175, 654, 16);
		getContentPane().add(lblOdemeTr);
		
		JRadioButton rdbtnNakit = new JRadioButton("Nakit");
		rdbtnNakit.setBounds(205, 200, 71, 25);
		getContentPane().add(rdbtnNakit);
		rdbtnNakit.setSelected(true);
		
		JRadioButton rdbtnKrediKart = new JRadioButton("Kredi Kart\u0131");
		rdbtnKrediKart.setBounds(280, 200, 94, 25);
		getContentPane().add(rdbtnKrediKart);
		
		JRadioButton rdbtnek = new JRadioButton("\u00C7ek");
		rdbtnek.setBounds(378, 200, 71, 25);
		getContentPane().add(rdbtnek);
		
		ButtonGroup group = new ButtonGroup();
        group.add(rdbtnNakit);
        group.add(rdbtnKrediKart);
        group.add(rdbtnek);
        
		
		JButton btndemeyiGerekletir = new JButton("\u00D6demeyi Ger\u00E7ekle\u015Ftir");
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
						FileWriter printer = new FileWriter(new File("Celebi_Seyahat_Acenta/Biletler.txt"),true);
						String text=""+isim+","+soyisim+","+yas+","+firma+","+gun+"-"+ay+"-"+yil+","+kalkis+","+saat+"-"+dakika+","+varis+","+sure_saat+"-"+sure_dakika+","+yolcu_sayisi+","+fiyat;
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
		lblTutar.setBounds(281, 234, 94, 16);
		getContentPane().add(lblTutar);
		btndemeyiGerekletir.setBounds(226, 263, 202, 25);
		getContentPane().add(btndemeyiGerekletir);
		
		label = new JLabel("");
		label.setBounds(26, 301, 594, 39);
		contentPane.add(label);
	}

}
