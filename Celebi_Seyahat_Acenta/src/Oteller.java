import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Oteller extends JPanel {
	
	private static final long serialVersionUID = 1L;
		private JTable table;
		private DefaultTableModel model;
		private JTable table2;
		private DefaultTableModel model2;
		private JComboBox firmalar;
		private JComboBox days;
		private JComboBox months;
		private JComboBox years;
		private JComboBox departure;
		private JComboBox arrival;
		private JLabel lblFirmalar;
		private JLabel lblTarih;
		private JLabel lblKalkYeri;
		private JLabel lblVarYeri;
		private JButton btnAra;
		private JTextField textField;
		private JButton btnAra_1;
		private JLabel lblYolculuk;
		private JLabel lblOteller;
		private JLabel lblBolgeler;
		private JComboBox bolgeler;
		private JComboBox gunler;
		private JComboBox aylar;
		private JComboBox yillar;
		private JLabel lblTarih_1;
		private JButton button;
		private JLabel lblOtel;
		private JButton btngnlkkirala;
		
	public Oteller() {
		setBounds(0,0,700,550);
		setBorder(new EmptyBorder(100, 100, 700, 550));
		setLayout(null);
        
        lblFirmalar = new JLabel("Firmalar");															//Label Firmalar
        lblFirmalar.setBounds(118, 25, 56, 16);
        add(lblFirmalar);
        
        String[] firma=firma_finder();																	//ComboBox Firmalar
		firmalar = new JComboBox();
		for(int k=0;k<firma.length;k++)
			if(firma[k]!=null)
			firmalar.addItem(firma[k]);
		firmalar.setSelectedIndex(0);
		firmalar.setBackground(Color.WHITE);
		firmalar.setBounds(42, 44, 207, 22);
		add(firmalar);
        
		 lblTarih = new JLabel("Tarih");																	//Label Tarih
	        lblTarih.setBounds(338, 26, 56, 16);
	        add(lblTarih);
		
		String[] day=new String[] {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26",
				"27","28","29","30","31"};
		days = new JComboBox(day);																		//ComboBox Gün
		days.setSelectedIndex(0);
		days.setBackground(Color.WHITE);
		days.setBounds(291, 44, 40, 22);
		add(days);
		
		String[] month=new String[] {"01","02","03","04","05","06","07","08","09","10","11","12"};
		months = new JComboBox(month);																	//ComboBox Ay
		months.setSelectedIndex(0);
		months.setBackground(Color.WHITE);
		months.setBounds(343, 44, 40, 22);
		add(months);
		
		String[] year=new String[] {"2019","2020"};
		years = new JComboBox(year);																	//ComboBox Yil
		years.setSelectedIndex(0);
		years.setBackground(Color.WHITE);
		years.setBounds(395, 44, 55, 22);
		add(years);
		
		String[] cities=new String[]{"Adana","Adýyaman","Afyon","Aðrý","Amasya","Ankara","Antalya","Artvin",		//Þehirler
	            "Aydýn","Balýkesir","Bilecik","Bingöl","Bitlis","Bolu","Burdur","Bursa","Çanakkale",
	            "Çankýrý","Çorum","Denizli","Diyarbakýr","Edirne","Elazýð","Erzincan","Erzurum","Eskiþehir",
	            "Gaziantep","Giresun","Gümüþhane","Hakkari","Hatay","Isparta","Ýçel","Ýstanbul","Ýzmir",
	            "Kars","Kastamonu","Kayseri","Kýrklareli","Kýrþehir","Kocaeli","Konya","Kütahya","Malatya",
	            "Manisa","Kahramanmaraþ","Mardin","Muðla","Muþ","Nevþehir","Niðde","Ordu","Rize","Sakarya",
	            "Samsun","Siirt","Sinop","Sivas","Tekirdað","Tokat","Trabzon","Tunceli","Þanlýurfa","Uþak",
	            "Van","Yozgat","Zonguldak","Aksaray","Bayburt","Karaman","Kýrýkkale","Batman","Þýrnak",
	            "Bartýn","Ardahan","Iðdýr","Yalova","Karabük","Kilis","Osmaniye","Düzce"};
		
		 lblKalkYeri = new JLabel("Kalk\u0131\u015F Yeri:");												//Label Kalkýþ Yeri
	        lblKalkYeri.setBounds(42, 79, 72, 16);
	        add(lblKalkYeri);
		
		departure = new JComboBox(cities);																//ComboBox kalkýþ yeri
		departure.setSelectedIndex(0);
		departure.setBackground(Color.WHITE);
		departure.setBounds(113, 76, 153, 22);
		add(departure);
		
		lblVarYeri = new JLabel("Var\u0131\u015F Yeri:");												//Label Varýþ Yeri
        lblVarYeri.setBounds(278, 79, 72, 16);
        add(lblVarYeri);
		
		arrival = new JComboBox(cities);																//ComboBox Varýþ Noktasý
		arrival.setSelectedIndex(0);
		arrival.setBackground(Color.WHITE);
		arrival.setBounds(353, 76, 153, 22);
		add(arrival);
        
        JScrollPane bilgiler_scrollPane = new JScrollPane();											//ScrollPane Tablo yapýsý
        bilgiler_scrollPane.setBounds(12, 108, 630, 114);
        add(bilgiler_scrollPane);
        model = new DefaultTableModel();
        table = new JTable(model);
        bilgiler_scrollPane.setViewportView(table);
        
        btnAra_1 = new JButton("Ara");																	//Ara Butonu
        btnAra_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		bilgiler();
        	}
        });
        btnAra_1.setBounds(539, 55, 97, 25);
        add(btnAra_1);
        
        JButton btnbiletal = new JButton("<html>B<BR>\u0130<BR>L<BR>E<BR>T<BR> <BR>A<BR>L</html>");
        btnbiletal.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(table.getSelectedRow()!=-1) {
        			String firma=String.valueOf(table.getValueAt(table.getSelectedRow(),0));
        			String gun=String.valueOf(table.getValueAt(table.getSelectedRow(),1));
        			String ay=String.valueOf(table.getValueAt(table.getSelectedRow(),2));
        			String yil=String.valueOf(table.getValueAt(table.getSelectedRow(),3));
        			String kalkis=String.valueOf(table.getValueAt(table.getSelectedRow(),4));
        			String saat=String.valueOf(table.getValueAt(table.getSelectedRow(),5));
        			String dakika=String.valueOf(table.getValueAt(table.getSelectedRow(),6));
        			String varis=String.valueOf(table.getValueAt(table.getSelectedRow(),7));
        			String sure_saat=String.valueOf(table.getValueAt(table.getSelectedRow(),8));
        			String sure_dakika=String.valueOf(table.getValueAt(table.getSelectedRow(),9));
        			String yolcu_sayisi=String.valueOf(table.getValueAt(table.getSelectedRow(),10));
        			String fiyat=String.valueOf(table.getValueAt(table.getSelectedRow(),11));
        			Seyahat_Bilet biletci=new Seyahat_Bilet(firma,gun,ay,yil,kalkis,saat,dakika,varis,sure_saat,sure_dakika,yolcu_sayisi,fiyat);
        			biletci.show();
        		}
        		
        	}
        });
        btnbiletal.setFont(new Font("Tahoma", Font.PLAIN, 10));
        btnbiletal.setBounds(654, 108, 42, 114);
        add(btnbiletal);
        
        lblYolculuk = new JLabel("Seyahat");
        lblYolculuk.setBounds(12, 13, 56, 16);
        add(lblYolculuk);
        
        lblOteller = new JLabel("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        lblOteller.setBounds(0, 225, 696, 16);
        add(lblOteller);
        
        lblBolgeler = new JLabel("B\u00F6lgeler :");
        lblBolgeler.setBounds(90, 290, 56, 16);
        add(lblBolgeler);
        
        String[] bolge=new String[]{"Akdeniz","Ege","Doðu Anadolu","Ýç Anadolu","Marmara","Karadeniz","Güneydoðu Anadolu"};
        bolgeler = new JComboBox(bolge);
        bolgeler.setBounds(63, 316, 111, 22);
        bolgeler.setSelectedIndex(0);
        add(bolgeler);
        
        lblTarih_1 = new JLabel("Tarih :");
        lblTarih_1.setBounds(94, 351, 40, 16);
        add(lblTarih_1);
        
        gunler = new JComboBox(day);
        gunler.setSelectedIndex(0);
        gunler.setBackground(Color.WHITE);
        gunler.setBounds(42, 380, 40, 22);
        add(gunler);
        
        aylar = new JComboBox(month);
        aylar.setSelectedIndex(0);
        aylar.setBackground(Color.WHITE);
        aylar.setBounds(94, 380, 40, 22);
        add(aylar);
        
        yillar = new JComboBox(year);
        yillar.setSelectedIndex(0);
        yillar.setBackground(Color.WHITE);
        yillar.setBounds(146, 380, 55, 22);
        add(yillar);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(213, 275, 415, 209);
        add(scrollPane);
        model2 = new DefaultTableModel();
        table2 = new JTable(model2);
        scrollPane.setViewportView(table2);
        
        button = new JButton("Ara");
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		model2.setRowCount(0);
        		String bolge=bolgeler.getSelectedItem().toString();
        		int gun=Integer.parseInt(gunler.getSelectedItem().toString());
        		int ay=Integer.parseInt(aylar.getSelectedItem().toString());
        		int yil=Integer.parseInt(yillar.getSelectedItem().toString());
				try {
					Scanner sc2 = new Scanner(new File("Celebi_Seyahat_Acenta/Oteller.txt"));
					while(sc2.hasNextLine()) {
						String t_firma="",t_fiyat="",t_bolge="",t_gun="",t_ay="",t_yil="";
						char[] text=sc2.nextLine().toCharArray();
						int i=0;
						while(text[i]!=',') { t_firma+=text[i++]; } i++;									//Veri setinden içerikleri deðiþkene atama
						while(text[i]!=',') { t_fiyat+=text[i++]; } i++;
						while(text[i]!=',') { t_bolge+=text[i++]; } i++;
						while(text[i]!='-') { t_gun+=text[i++]; } i++;
						while(text[i]!='-') { t_ay+=text[i++]; } i++;
						while(text[i]!=' ') { t_yil+=text[i++]; } i++;
						int tmp1=Integer.parseInt(t_gun);
						int tmp2=Integer.parseInt(t_ay);
						int tmp3=Integer.parseInt(t_yil);
						if(t_bolge.equals(bolgeler.getSelectedItem().toString()) && t_ay.equals(aylar.getSelectedItem().toString()) && t_yil.equals(yillar.getSelectedItem().toString())) 
							if((gun-10)<tmp1 && (gun+10)>tmp1 && t_ay.equals(aylar.getSelectedItem().toString()))
								model2.addRow(new Object[] { t_firma,t_gun,t_ay,t_yil,t_bolge,t_fiyat});
							
						}
					sc2.close();	
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
        	}
        });
        button.setBounds(66, 436, 97, 25);
        add(button);
        
        lblOtel = new JLabel("Otel");
        lblOtel.setBounds(12, 249, 56, 16);
        add(lblOtel);
        
        btngnlkkirala = new JButton("<html>G<BR>\u00DC<BR>N<BR>L<BR>\u00DC<BR>K<BR> <BR>K<BR>\u0130<BR>R<BR>A<BR>L<BR>A</html>");
        btngnlkkirala.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(table2.getSelectedRow()!=-1) {
        			String firma=String.valueOf(table2.getValueAt(table2.getSelectedRow(),0));
        			String gun=String.valueOf(table2.getValueAt(table2.getSelectedRow(),1));
        			String ay=String.valueOf(table2.getValueAt(table2.getSelectedRow(),2));
        			String yil=String.valueOf(table2.getValueAt(table2.getSelectedRow(),3));
        			String bolge=String.valueOf(table2.getValueAt(table2.getSelectedRow(),4));
        			String fiyat=String.valueOf(table2.getValueAt(table2.getSelectedRow(),5));
        			Otel_Bilet biletci2=new Otel_Bilet(firma,gun,ay,yil,bolge,fiyat);
        			biletci2.show();
        		}
        	}
        });
        btngnlkkirala.setFont(new Font("Tahoma", Font.PLAIN, 10));
        btngnlkkirala.setBounds(654, 271, 42, 213);
        add(btngnlkkirala);
        
        JLabel label = new JLabel("");
        label.setBounds(0, 0, 700, 550);
        add(label);
        
        model.addColumn("Firma");																		//Tablo Kolonlarý Ekleme
	    model.addColumn("Gün");
	    model.addColumn("Ay");
	    model.addColumn("Yil");
	    model.addColumn("Kalkýþ");
	    model.addColumn("Sa");
	    model.addColumn("Dk");
	    model.addColumn("Varýþ");
	    model.addColumn("Süre Sa");
	    model.addColumn("Süre Dk");
	    model.addColumn("Yolcu Sayisi");
	    model.addColumn("Fiyat");
	    model2.addColumn("Firma");																		//Tablo Kolonlarý Ekleme
	    model2.addColumn("Gün");
	    model2.addColumn("Ay");
	    model2.addColumn("Yil");
	    model2.addColumn("Bolge");
	    model2.addColumn("Fiyat");
	    
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
				if(t_firma.equals(firmalar.getSelectedItem().toString()) && t_gun.equals(days.getSelectedItem().toString()) &&
						t_ay.equals(months.getSelectedItem().toString()) && t_yil.equals(years.getSelectedItem().toString()) &&
						t_kalkis.equals(departure.getSelectedItem().toString()) && t_varis.equals(arrival.getSelectedItem().toString()))
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
		       System.out.println("Working Directory = " + System.getProperty("user.dir"));
			Scanner sc =new Scanner(new File("Celebi_Seyahat_Acenta/Firmalar.txt"));
			int i=0;
			while(sc.hasNext()) {
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
