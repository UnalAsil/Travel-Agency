import java.awt.Color;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;

public class Yonetici_Sayfasi extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField seyahat_firmasi;
	private String chg="Karayolu";
	private JLabel label_1;
	private JComboBox way;
	private JComboBox firmalar;
	private JComboBox days;
	private JComboBox months;
	private JComboBox years;
	private JComboBox departure;
	private JComboBox d_minutes;
	private JComboBox d_hours;
	private JComboBox arrival;
	private JComboBox time_minutes;
	private JComboBox time_hours;
	private JComboBox counts_passenger;
	private JLabel seyahat_firmasi_info;
	private JLabel lblSaat1;
	private JLabel lblTarih;
	private JLabel lblFiyat;
	private JTextField fiyat;
	private JLabel lblFirma;
	private JButton kaydet_seyahat;
	private JLabel seyahat_info;
	private JLabel lblKalkis;
	private JLabel lbl_Varis;
	private JLabel lblYolcu;
	private JLabel lblSaat2;
	private JLabel label_4;
	private JLabel lblSeyahatBilgisiGncelle;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnGncelle;
	private JLabel lbl_bilgi_guncelle;
	private JLabel lblKapasite;
	private JComboBox capacity;


	
	
	public Yonetici_Sayfasi() {
		setBounds(new Rectangle(0, 0, 700, 600));
		setAlignmentY(Component.TOP_ALIGNMENT);
		setAlignmentX(Component.LEFT_ALIGNMENT);
		setLayout(null);
		
		label_1 = new JLabel("Yeni Seyahat Firmasý Ekle");												//Label Yeni seyahat firmasý ekle
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(35, 23, 240, 25);
		add(label_1);
		
		seyahat_firmasi = new JTextField();																//TextField seyahat firmasý
		seyahat_firmasi.setBounds(35, 53, 240, 22);
		add(seyahat_firmasi);
		seyahat_firmasi.setColumns(10);
		
		String[] ways=new String[] {"Karayolu","Havayolu","DemirYolu","Denizyolu"};						//ComboBox yol tipi
		way = new JComboBox(ways);
		way.setSelectedIndex(0);
		way.setBackground(Color.WHITE);
		way.setBounds(285, 53, 153, 22);
		add(way);
		
		JButton kaydet_seyahat_yolu = new JButton("Kaydet");											//Button seyahat yolu kaydetme
		kaydet_seyahat_yolu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(seyahat_firmasi.getText().isEmpty()) {
					seyahat_firmasi_info.setText("Seyahat firmasý boþ býrakýlamaz.");
				}else {
					try {
						FileWriter printer = new FileWriter(new File("Celebi_Seyahat_Acenta/Firmalar.txt"),true);
						String firma="";
						char[] tmp=seyahat_firmasi.getText().toCharArray();
						for(int i=0;i<tmp.length;i++)
							if(tmp[i]==' ' || tmp[i]==',')
								firma+='_';
							else
								firma+=tmp[i];
						printer.write("\n"+firma+" "+way.getSelectedItem().toString());
						printer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					seyahat_firmasi_info.setText("Seyahat firmasý kaydedildi");
					String[] tmp_firmalar=firma_finder();
					firmalar.removeAllItems();
					for(int k=0;k<tmp_firmalar.length;k++)
						if(tmp_firmalar[k]!=null)
						firmalar.addItem(tmp_firmalar[k]);
				}
			}
		});
		kaydet_seyahat_yolu.setBounds(450, 52, 97, 25);
		add(kaydet_seyahat_yolu);
		
		seyahat_firmasi_info = new JLabel("");															//Label seyahat firmasý bilgilendirme
		seyahat_firmasi_info.setBounds(35, 88, 653, 16);
		add(seyahat_firmasi_info);
		
		JLabel label_2 = new JLabel("-------------------------------------------------------------------------------------------------------------------------------------------");
		label_2.setBounds(0, 106, 700, 16);
		add(label_2);
		
		JLabel label_3 = new JLabel("Yeni Seyahat Ekle");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_3.setBounds(35, 123, 240, 25);
		add(label_3);
		
		lblFirma = new JLabel("Firma :");																//Label Firma:
		lblFirma.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblFirma.setBounds(35, 152, 56, 16);
		add(lblFirma);
		
		String[] firma=firma_finder();																	//ComboBox Firmalar
		firmalar = new JComboBox();
		for(int k=0;k<firma.length;k++)
			if(firma[k]!=null)
			firmalar.addItem(firma[k]);
		firmalar.setSelectedIndex(0);
		firmalar.setBackground(Color.WHITE);
		firmalar.setBounds(109, 150, 231, 22);
		add(firmalar);
		
		lblTarih = new JLabel("Tarih :");																//Label Tarih:
		lblTarih.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblTarih.setBounds(365, 152, 56, 16);
		add(lblTarih);
		
		String[] day=new String[] {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26",
				"27","28","29","30","31"};
		days = new JComboBox(day);																		//ComboBox Gün
		days.setSelectedIndex(0);
		days.setBackground(Color.WHITE);
		days.setBounds(433, 150, 40, 22);
		add(days);
		
		String[] month=new String[] {"01","02","03","04","05","06","07","08","09","10","11","12"};
		months = new JComboBox(month);																	//ComboBox Ay
		months.setSelectedIndex(0);
		months.setBackground(Color.WHITE);
		months.setBounds(485, 150, 40, 22);
		add(months);
		
		String[] year=new String[] {"2019","2020"};
		years = new JComboBox(year);																	//ComboBox Yil
		years.setSelectedIndex(0);
		years.setBackground(Color.WHITE);
		years.setBounds(537, 150, 55, 22);
		add(years);
		
		lblKalkis = new JLabel("Kalkýþ Noktasý :");														//Label Kalkýþ Yeri:
		lblKalkis.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblKalkis.setBounds(35, 180, 140, 16);
		add(lblKalkis);
		
		String[] cities=new String[]{"Adana","Adýyaman","Afyon","Aðrý","Amasya","Ankara","Antalya","Artvin",		//Þehirler
	            "Aydýn","Balýkesir","Bilecik","Bingöl","Bitlis","Bolu","Burdur","Bursa","Çanakkale",
	            "Çankýrý","Çorum","Denizli","Diyarbakýr","Edirne","Elazýð","Erzincan","Erzurum","Eskiþehir",
	            "Gaziantep","Giresun","Gümüþhane","Hakkari","Hatay","Isparta","Ýçel","Ýstanbul","Ýzmir",
	            "Kars","Kastamonu","Kayseri","Kýrklareli","Kýrþehir","Kocaeli","Konya","Kütahya","Malatya",
	            "Manisa","Kahramanmaraþ","Mardin","Muðla","Muþ","Nevþehir","Niðde","Ordu","Rize","Sakarya",
	            "Samsun","Siirt","Sinop","Sivas","Tekirdað","Tokat","Trabzon","Tunceli","Þanlýurfa","Uþak",
	            "Van","Yozgat","Zonguldak","Aksaray","Bayburt","Karaman","Kýrýkkale","Batman","Þýrnak",
	            "Bartýn","Ardahan","Iðdýr","Yalova","Karabük","Kilis","Osmaniye","Düzce"};
		
		departure = new JComboBox(cities);																//ComboBox kalkýþ yeri
		departure.setSelectedIndex(0);
		departure.setBackground(Color.WHITE);
		departure.setBounds(187, 180, 153, 22);
		add(departure);
		
		String[] minute=new String[] {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26",
				"27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56",
				"57","58","59"};
		String[] hour=new String[] {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
		
		lblSaat1 = new JLabel("Saat :");																//Label Kalkýþ Saati
		lblSaat1.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblSaat1.setBounds(365, 180, 56, 16);
		add(lblSaat1);
		
		d_minutes = new JComboBox(minute);																//ComboBox Kalkýþ saati
		d_minutes.setSelectedIndex(0);
		d_minutes.setBackground(Color.WHITE);
		d_minutes.setBounds(433, 180, 40, 22);
		add(d_minutes);
		
		d_hours = new JComboBox(hour);																	//ComboBox Kalkýþ saati
		d_hours.setSelectedIndex(0);
		d_hours.setBackground(Color.WHITE);
		d_hours.setBounds(485, 180, 40, 22);
		add(d_hours);
		
		lbl_Varis = new JLabel("Varýþ Noktasý :");														//Label Varýþ Noktasý
		lbl_Varis.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lbl_Varis.setBounds(35, 210, 140, 16);
		add(lbl_Varis);
		
		arrival = new JComboBox(cities);																//ComboBox Varýþ Noktasý
		arrival.setSelectedIndex(0);
		arrival.setBackground(Color.WHITE);
		arrival.setBounds(187, 210, 153, 22);
		add(arrival);
		
		lblSaat2 = new JLabel("S\u00FCre :");																//Label Varýþ Saati
		lblSaat2.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblSaat2.setBounds(365, 211, 56, 16);
		add(lblSaat2);
		
		time_minutes = new JComboBox(minute);																//ComboBox Varýþ Saati
		time_minutes.setSelectedIndex(0);
		time_minutes.setBackground(Color.WHITE);
		time_minutes.setBounds(433, 210, 40, 22);
		add(time_minutes);
		
		time_hours = new JComboBox(hour);																	//ComboBox Varýþ Saati
		time_hours.setSelectedIndex(0);
		time_hours.setBackground(Color.WHITE);
		time_hours.setBounds(485, 210, 40, 22);
		add(time_hours);
		
		lblYolcu = new JLabel("Yolcu Sayýsý :");														//Label Yolcu Sayýsý
		lblYolcu.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblYolcu.setBounds(35, 240, 102, 16);
		add(lblYolcu);
		
		String[] count=new String[] {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26",
				"27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56",
				"57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86",
				"87","88","89","90","91","92","93","94","95","96","97","98","99","100","101","102","103","104","105","106","107","108","109","110","111","112","113",
				"114","115","116","117","118","119","120","121","122","123","124","125","126","127","128","129","130","131","132","133","134","135","136","137","138",
				"139","140","141","142","143","144","145","146","147","148","149","150","151","152","153","154","155","156","157","158","159","160","161","162","163",
				"164","165","166","167","168","169","170","171","172","173","174","175","176","177","178","179","180","181","182","183","184","185","186","187","188",
				"189","190","191","192","193","194","195","196","197","198","199","200"};
		
		counts_passenger = new JComboBox(count);														//ComboBox Yolcu Sayýsý
		counts_passenger.setSelectedIndex(0);
		counts_passenger.setBackground(Color.WHITE);
		counts_passenger.setBounds(149, 240, 40, 22);
		add(counts_passenger);
		
		lblKapasite = new JLabel("Kapasite:");															//Label Kapasite
		lblKapasite.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblKapasite.setBounds(215, 240, 69, 16);
		add(lblKapasite);
		
		capacity = new JComboBox(count);																//Kapasite
		capacity.setSelectedIndex(0);
		capacity.setBackground(Color.WHITE);
		capacity.setBounds(300, 240, 40, 22);
		add(capacity);
		
		lblFiyat = new JLabel("Fiyat :");																//Label Fiyat
		lblFiyat.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblFiyat.setBounds(341, 240, 56, 16);
		add(lblFiyat);
		
		fiyat = new JTextField();																		//TextField fiyat
		fiyat.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char tmp=arg0.getKeyChar();
				if(!Character.isDigit(tmp) || (tmp==KeyEvent.VK_DELETE))
					arg0.consume();
			}
		});
		fiyat.setBounds(409, 240, 116, 22);
		add(fiyat);
		fiyat.setColumns(10);
		
		kaydet_seyahat = new JButton("Kaydet");															//Button Seyahat Kaydet
		kaydet_seyahat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(fiyat.getText().isEmpty())
					seyahat_info.setText("Fiyat boþ býrakýlamaz.");
				else {
					try {
		        	    FileWriter printer = new FileWriter(new File("Celebi_Seyahat_Acenta/Seyahatler.txt"),true);
		        	    String text=firmalar.getSelectedItem().toString()+","+days.getSelectedItem().toString()+"-"+
		        	    months.getSelectedItem().toString()+"-"+years.getSelectedItem().toString()+","+
		        	    departure.getSelectedItem().toString()+","+d_hours.getSelectedItem().toString()+"-"+
		        	    d_minutes.getSelectedItem().toString()+","+arrival.getSelectedItem().toString()+","+
		        	    time_hours.getSelectedItem().toString()+"-"+time_minutes.getSelectedItem().toString()+","+
		        	    counts_passenger.getSelectedItem().toString()+"/"+capacity.getSelectedItem().toString()+","+
		        	    fiyat.getText().toString()+" ";
			        	printer.write("\n"+text);
						printer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				seyahat_info.setText("Seyahat kaydedildi.");
				bilgiler();
				}
			}
		});
		kaydet_seyahat.setBounds(530, 237, 97, 25);
		add(kaydet_seyahat);
		
		seyahat_info = new JLabel("");																	//Label Seyahat info
		seyahat_info.setBounds(35, 269, 653, 16);
		add(seyahat_info);
		
		label_4 = new JLabel("-------------------------------------------------------------------------------------------------------------------------------------------");
		label_4.setBounds(0, 292, 700, 16);
		add(label_4);
				
		lblSeyahatBilgisiGncelle = new JLabel("Seyahat Bilgisi Güncelle");								//Label Seyahat Bilgisi Güncelle
		lblSeyahatBilgisiGncelle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSeyahatBilgisiGncelle.setBounds(35, 309, 240, 25);
		add(lblSeyahatBilgisiGncelle);
		
		JScrollPane bilgiler_scrollPane = new JScrollPane();											//ScrollPane Tablo yapýsý
        bilgiler_scrollPane.setBounds(12, 337, 634, 203);
        add(bilgiler_scrollPane);
        model = new DefaultTableModel();
        table = new JTable(model);
        bilgiler_scrollPane.setViewportView(table);
	    model.addColumn("Firma");																		//Tablo Kolonlarý Ekleme
	    model.addColumn("Gün");
	    model.addColumn("Ay");
	    model.addColumn("Yil");
	    model.addColumn("Kalkýþ");
	    model.addColumn("Dk");
	    model.addColumn("Sa");
	    model.addColumn("Varýþ");
	    model.addColumn("Süre Sa");
	    model.addColumn("Süre Dk");
	    model.addColumn("Yolcu Sayisi");
	    model.addColumn("Fiyat");
	    bilgiler();
		
		btnGncelle = new JButton("<html>G<BR>Ü<BR>N<BR>C<BR>E<BR>L<BR>L<BR>E</html>");					//Button güncelleme butonu
		btnGncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int count=model.getRowCount();
				try {
				FileWriter printer = new FileWriter(new File("Celebi_Seyahat_Acenta/Seyahatler.txt"));
				for(int i=0;i<count;i++) {
	        	    String text=model.getValueAt(i, 0)+","+model.getValueAt(i, 1)+"-"+
	        	    model.getValueAt(i, 2)+"-"+model.getValueAt(i, 3)+","+
	        	    model.getValueAt(i, 4)+","+model.getValueAt(i, 5)+"-"+
	        	    model.getValueAt(i, 6)+","+model.getValueAt(i, 7)+","+
	        	    model.getValueAt(i, 8)+"-"+model.getValueAt(i, 9)+","+
	        	    model.getValueAt(i, 10)+","+model.getValueAt(i, 11)+" ";
	        	    if(i!=0)
	        	    	printer.write("\n"+text);
	        	    else
	        	    	printer.write(text);
				}
				printer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				bilgiler();
				lbl_bilgi_guncelle.setText("Seyahat bilgileri güncellendi");
			}
		});
		btnGncelle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGncelle.setBounds(646, 337, 42, 203);
		add(btnGncelle);
		
		lbl_bilgi_guncelle = new JLabel("");
		lbl_bilgi_guncelle.setBounds(12, 545, 676, 16);
		add(lbl_bilgi_guncelle);
		
		
		

		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 700, 600);
		add(label);				
								

	}
	
	public void bilgiler() {
		try {
			model.setRowCount(0);
	
			Scanner sc=new Scanner(new File("Celebi_Seyahat_Acenta/Seyahatler.txt"));
			while(sc.hasNextLine()) {
				String t_firma="",t_gun="",t_ay="",t_yil="",t_kalkis="",t_dakika="",t_saat="",t_varis="",t_sure_dakika="",t_sure_saat="",t_yolcu_sayisi="",t_fiyat="";
				char[] text=sc.nextLine().toCharArray();
				int i=0;
				while(text[i]!=',') { t_firma+=text[i++]; } i++;									//Veri setinden içerikleri deðiþkene atama
				while(text[i]!='-') { t_gun+=text[i++]; } i++;
				while(text[i]!='-') { t_ay+=text[i++]; } i++;
				while(text[i]!=',') { t_yil+=text[i++]; } i++;
				while(text[i]!=',') { t_kalkis+=text[i++]; } i++;
				while(text[i]!='-') { t_dakika+=text[i++]; } i++;
				while(text[i]!=',') { t_saat+=text[i++]; } i++;
				while(text[i]!=',') { t_varis+=text[i++]; } i++;
				while(text[i]!='-') { t_sure_dakika+=text[i++]; } i++;
				while(text[i]!=',') { t_sure_saat+=text[i++]; } i++;
				while(text[i]!='/') { t_yolcu_sayisi+=text[i++]; } i++;
				t_yolcu_sayisi+="/";
				while(text[i]!=',') { t_yolcu_sayisi+=text[i++]; } i++;
				while(text[i]!=' ') { t_fiyat+=text[i++]; } i++;
				
				model.addRow(new Object[] { t_firma,t_gun,t_ay,t_yil,t_kalkis,t_dakika,t_saat,t_varis,t_sure_saat,t_sure_dakika,t_yolcu_sayisi,t_fiyat});
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public String[] firma_finder() {											//Firmalarý bulucu
		String[] firma=new String[50];
		try {
			Scanner sc =new Scanner(new File("Celebi_Seyahat_Acenta/Firmalar.txt"));
			int i=0;
			while(sc.hasNextLine()) {
				String tmp1=sc.next();
				String tmp2=sc.next();
				firma[i++]=tmp1+"-"+tmp2;
			}
			sc.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		return firma;
	}
	
}
