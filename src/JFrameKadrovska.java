import java.awt.EventQueue;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class JFrameKadrovska extends JFrame {

	private JPanel contentPane;
	private JTextField tfIme;
	private JTextField tfPrezime;
	private JTextField tfJMBG;
	private JTextField tfRadnihDana;
	private JTextField tfSatnica;
	private JTextField tfKadarIT;
	private JTextField tfKadarHR;
	private JTextField tfKadarFinansije;
	private JTextField tfKadarKontrolaProizvodnje;
	private JTextField tfKadarProizvodnja;
	private static final Randomi r = new Randomi();
	private ArrayList<Zaposleni> ls = new ArrayList<>();
	private static final String[] deps = {"IT", "HR", "Finansije", "Kontrola_proizvodnje", "Proizvodnja"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameKadrovska frame = new JFrameKadrovska();
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
	public JFrameKadrovska() {
		setTitle("Kadrovska sluzba");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\faks\\2\\3\\OOP\\projekat\\ProjekatJava47-2019\\human-resources-symbol.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1127, 662);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(255, 204, 153));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Unesi novog zaposlemog", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(38, 24, 379, 273);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBackground(new Color(255, 204, 153));

		
		JLabel lblIme = new JLabel("Ime: ");
		lblIme.setBounds(20, 31, 45, 13);
		panel.add(lblIme);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setBounds(20, 54, 45, 13);
		panel.add(lblPrezime);
		
		JLabel lblJmbg = new JLabel("JMBG");
		lblJmbg.setBounds(20, 78, 45, 13);
		panel.add(lblJmbg);
		
		JLabel lblRadnihDana = new JLabel("Radnih dana: ");
		lblRadnihDana.setBounds(20, 140, 78, 13);
		panel.add(lblRadnihDana);
		
		JLabel lblSatnica = new JLabel("Satnica:");
		lblSatnica.setBounds(20, 168, 45, 13);
		panel.add(lblSatnica);
		
		JLabel lblNewLabel_1 = new JLabel("Department: ");
		lblNewLabel_1.setBounds(20, 107, 96, 13);
		panel.add(lblNewLabel_1);
		
		tfIme = new JTextField();
		tfIme.setBounds(110, 25, 96, 19);
		panel.add(tfIme);
		tfIme.setColumns(10);
		
		tfPrezime = new JTextField();
		tfPrezime.setBounds(110, 48, 96, 19);
		panel.add(tfPrezime);
		tfPrezime.setColumns(10);
		
		tfJMBG = new JTextField();
		tfJMBG.setColumns(10);
		tfJMBG.setBounds(110, 72, 96, 19);
		panel.add(tfJMBG);
		
		tfRadnihDana = new JTextField();
		tfRadnihDana.setColumns(10);
		tfRadnihDana.setBounds(110, 134, 96, 19);
		panel.add(tfRadnihDana);
		
		tfSatnica = new JTextField();
		tfSatnica.setBounds(110, 162, 96, 19);
		panel.add(tfSatnica);
		tfSatnica.setColumns(10);
		
		JLabel pol = new JLabel("Pol:");
		pol.setBounds(266, 51, 45, 13);
		panel.add(pol);
		
		JRadioButton rdbMusko = new JRadioButton("Muski");
		rdbMusko.setBounds(240, 70, 103, 21);
		panel.add(rdbMusko);
		
		JRadioButton rdbZensko = new JRadioButton("Zensko");
		rdbZensko.setBounds(240, 99, 103, 21);
		panel.add(rdbZensko);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbMusko);
		bg.add(rdbZensko);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"IT", "HR", "Kontrola_proizvodnje", "Proizvodnja", "Finansije"}));
		comboBox.setBounds(110, 100, 109, 21);
		panel.add(comboBox);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(694, 24, 407, 588);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel = new JLabel("Potrebe za kadrovima:");
		lblNewLabel.setBounds(469, 24, 111, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("IT");
		lblNewLabel_2.setBounds(522, 56, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("HR");
		lblNewLabel_2_1.setBounds(522, 84, 46, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Finansije");
		lblNewLabel_2_2.setBounds(487, 109, 78, 14);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Kontrola proizvodnje");
		lblNewLabel_2_3.setBounds(444, 134, 124, 14);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Proizvodnja");
		lblNewLabel_2_4.setBounds(487, 169, 78, 14);
		contentPane.add(lblNewLabel_2_4);
		
		tfKadarIT = new JTextField();
		tfKadarIT.setBounds(569, 56, 86, 20);
		contentPane.add(tfKadarIT);
		tfKadarIT.setColumns(10);
		
		tfKadarHR = new JTextField();
		tfKadarHR.setColumns(10);
		tfKadarHR.setBounds(569, 81, 86, 20);
		contentPane.add(tfKadarHR);
		
		tfKadarFinansije = new JTextField();
		tfKadarFinansije.setColumns(10);
		tfKadarFinansije.setBounds(569, 109, 86, 20);
		contentPane.add(tfKadarFinansije);
		
		tfKadarKontrolaProizvodnje = new JTextField();
		tfKadarKontrolaProizvodnje.setColumns(10);
		tfKadarKontrolaProizvodnje.setBounds(569, 134, 86, 20);
		contentPane.add(tfKadarKontrolaProizvodnje);
		
		tfKadarProizvodnja = new JTextField();
		tfKadarProizvodnja.setColumns(10);
		tfKadarProizvodnja.setBounds(569, 169, 86, 20);
		contentPane.add(tfKadarProizvodnja);
		
		JLabel lblNewLabel_2_5 = new JLabel("IT:");
		lblNewLabel_2_5.setBounds(457, 326, 46, 14);
		contentPane.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("HR:");
		lblNewLabel_2_1_1.setBounds(457, 354, 46, 14);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Finansije:");
		lblNewLabel_2_2_1.setBounds(457, 379, 78, 14);
		contentPane.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Kontrola proizvodnje:");
		lblNewLabel_2_3_1.setBounds(457, 404, 123, 14);
		contentPane.add(lblNewLabel_2_3_1);
		
		JLabel lblNewLabel_2_4_1 = new JLabel("Proizvodnja:");
		lblNewLabel_2_4_1.setBounds(457, 439, 78, 14);
		contentPane.add(lblNewLabel_2_4_1);
		
		JLabel lblPKIT = new JLabel("0");
		lblPKIT.setBounds(589, 326, 46, 14);
		contentPane.add(lblPKIT);
		
		JLabel lblPKHR = new JLabel("0");
		lblPKHR.setBounds(589, 354, 46, 14);
		contentPane.add(lblPKHR);
		
		JLabel lblPKFinansija = new JLabel("0");
		lblPKFinansija.setBounds(589, 379, 46, 14);
		contentPane.add(lblPKFinansija);
		
		JLabel lblPKKntrProi = new JLabel("0");
		lblPKKntrProi.setBounds(589, 404, 46, 14);
		contentPane.add(lblPKKntrProi);
		
		JLabel lblPKProizvodnja = new JLabel("0");
		lblPKProizvodnja.setBounds(589, 439, 46, 14);
		contentPane.add(lblPKProizvodnja);
	
		
		JButton btnNewButton = new JButton("Unesi podatke");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					r.citajListu("Januar.txt", ls);
					
					r.EmptyDat("Januar.txt");
					
					String ime = tfIme.getText();
					
					String prezime = tfPrezime.getText();
					
					String jmbg = tfJMBG.getText();
					
					if(jmbg.length() != 13)
						throw new Exception("Mora imati 13 cifara!");
					
					boolean pomocna = false;
					for (int i = 0; i < jmbg.length(); i++) {
						
						char temp = jmbg.charAt(i);
						
						if(!Character.isDigit(temp))
						{
							pomocna = true;
							break;
						}
					}
					
					if(pomocna)
						throw new Exception("Ponovo unesi JMBG svi karakteri moraju biti cifre");
					
					String department = (String) comboBox.getSelectedItem();
					
					int radnihDana = Integer.parseInt(tfRadnihDana.getText().trim());
					
					if(radnihDana > 30)
						throw new Exception("Radnik ne moze raditi vise od 30 dana u mesecu");
					
					int satnica = Integer.parseInt(tfSatnica.getText().trim());
					
					boolean pol = false;
					
					if(rdbMusko.isSelected())
						pol = true;
					
					if(rdbZensko.isSelected())
						pol = false;
					
					if(rdbMusko.isSelected() == false && rdbZensko.isSelected() == false)
						throw new Exception("Morate izabrati pol!");
					
					Zaposleni z = new Zaposleni(ime, prezime, jmbg, pol, r.passwordGenerator(), department, radnihDana, satnica);
					
					int idde = ls.size() + 1;
					
					z.setID(idde);
					
					ls.add(z);
					
					if(z.getDepartment().equals("IT"))
					{
						lblPKIT.setText((Integer.parseInt(lblPKIT.getText().trim()) - 1)+ "");
					}
					else if(z.getDepartment().equals("HR"))
					{
						lblPKHR.setText((Integer.parseInt(lblPKHR.getText().trim()) - 1)+ "");
					}
					else if(z.getDepartment().equals("Finansije"))
					{
						lblPKFinansija.setText((Integer.parseInt(lblPKFinansija.getText().trim()) - 1)+ "");
					}
					else if(z.getDepartment().equals("Proizvodnja"))
					{
						lblPKProizvodnja.setText((Integer.parseInt(lblPKProizvodnja.getText().trim()) - 1)+ "");
					}
					else
						lblPKKntrProi.setText((Integer.parseInt(lblPKKntrProi.getText().trim()) - 1)+ "");
					
					
					
					r.WriteInDat("Januar.txt", ls);
					
					ls.clear();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} finally {
					tfIme.setText("");
					tfPrezime.setText("");
					tfJMBG.setText("");
					tfRadnihDana.setText("");
					tfSatnica.setText("");
					rdbMusko.setSelected(false);
					rdbZensko.setSelected(false);
				}
				
				
			}
		});
		btnNewButton.setBounds(20, 202, 137, 21);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Unesi random zaposlenog");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					r.citajListu("Januar.txt", ls);
					
					r.EmptyDat("Januar.txt");
					
					Zaposleni z = new Zaposleni();
					
					z.setRandom(z);
					
					int idde = ls.size() + 1;
					
					z.setID(idde);
					
					try {
						r.EmptyDat("Januar.txt");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					
					ls.add(z);
					
					if(z.getDepartment().equals("IT"))
					{
						lblPKIT.setText((Integer.parseInt(lblPKIT.getText().trim()) - 1)+ "");
					}
					else if(z.getDepartment().equals("HR"))
					{
						lblPKHR.setText((Integer.parseInt(lblPKHR.getText().trim()) - 1)+ "");
					}
					else if(z.getDepartment().equals("Finansije"))
					{
						lblPKFinansija.setText((Integer.parseInt(lblPKFinansija.getText().trim()) - 1)+ "");
					}
					else if(z.getDepartment().equals("Proizvodnja"))
					{
						lblPKProizvodnja.setText((Integer.parseInt(lblPKProizvodnja.getText().trim()) - 1)+ "");
					}
					else
						lblPKKntrProi.setText((Integer.parseInt(lblPKKntrProi.getText().trim()) - 1)+ "");
					
					r.WriteInDat("Januar.txt", ls);
					
					JOptionPane.showMessageDialog(null, "Unet random zaposleni!");
					
					ls.clear();
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton_1.setBounds(125, 241, 244, 21);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Nasumicno departmenta");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					r.citajListu("Januar.txt", ls);
					
					if(ls.size() == 0)
						throw new Exception("Prazna je lista!");
					
					r.EmptyDat("Januar.txt");
					
					String[] dep = deps;
					
					JComboBox<String> jcbd = new JComboBox<>(dep);
					
					jcbd.setEditable(true);
				
					JOptionPane.showMessageDialog(null, jcbd, "Izaberite department: ",JOptionPane.QUESTION_MESSAGE);
					
					String d = (String) jcbd.getSelectedItem();
					
					Zaposleni z = new Zaposleni();
					
					z.setRandominDepartmenta(z, d);
					
					z.setID(ls.size() + 1);
					
					ls.add(z);
					
					if(z.getDepartment().equals("IT"))
					{
						lblPKIT.setText((Integer.parseInt(lblPKIT.getText().trim()) - 1)+ "");
					}
					else if(z.getDepartment().equals("HR"))
					{
						lblPKHR.setText((Integer.parseInt(lblPKHR.getText().trim()) - 1)+ "");
					}
					else if(z.getDepartment().equals("Finansije"))
					{
						lblPKFinansija.setText((Integer.parseInt(lblPKFinansija.getText().trim()) - 1)+ "");
					}
					else if(z.getDepartment().equals("Proizvodnja"))
					{
						lblPKProizvodnja.setText((Integer.parseInt(lblPKProizvodnja.getText().trim()) - 1)+ "");
					}
					else
						lblPKKntrProi.setText((Integer.parseInt(lblPKKntrProi.getText().trim()) - 1)+ "");
					
					
					
					r.WriteInDat("Januar.txt", ls);
					
					ls.clear();
				} catch (HeadlessException e1) {
					JOptionPane.showMessageDialog(null, "Prazna lista!");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
				
			}
		});
		btnNewButton_1_1.setBounds(167, 202, 202, 21);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("Ispisi sve zaposlene");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.setText("");
				
				r.citajListu("Januar.txt", ls);
				
				for (Zaposleni zaposleni : ls) {
					textArea.append("\n" + zaposleni.getIme() + " " + zaposleni.getPrezime() + " " + zaposleni.getDepartment() + " plata: " + zaposleni.netoPlata() + "\n");
				}
				
				ls.clear();
			}
		});
		btnNewButton_2.setBounds(38, 326, 152, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Sortitaj zaposlene po plati");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					r.citajListu("Januar.txt", ls);
					
					textArea.setText("");
					
					if(ls.size() == 0)
						throw new Exception("Prazna lista");
					
					ArrayList<Zaposleni> lista = ls;
					
					for (int i = 0; i < lista.size() - 1; i++) {
						for (int j = i + 1; j < lista.size(); j++) {
							if(lista.get(i).netoPlata() < lista.get(j).netoPlata())
							{
								Zaposleni pom = lista.get(i);
								
								Zaposleni pom2 = lista.get(j);
								
								lista.set(i, pom2);
								
								lista.set(j, pom);
							}
						}
						
					}
					
					textArea.setText("");
					
					for (Zaposleni zaposleni : lista) {
						textArea.append("\n" + zaposleni.getIme() + " " + zaposleni.getPrezime() + " " + zaposleni.getDepartment() + " plata: " + zaposleni.netoPlata() + "\n");
					}
					
					lista.clear();
					
					ls.clear();
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
		});
		btnNewButton_2_1.setBounds(212, 326, 205, 21);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("Ispisi zaposlene sektora");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					r.citajListu("Januar.txt", ls);
					
					textArea.setText("");
					
					if(ls.size() == 0)
						throw new Exception("Prazna je lista!");
					
					String[] dep = deps;
					
					JComboBox<String> jcbd = new JComboBox<>(dep);
					
					jcbd.setEditable(true);
					
					JOptionPane.showMessageDialog(null, jcbd, "Izaberite department: ",JOptionPane.QUESTION_MESSAGE);
					
					String d = (String) jcbd.getSelectedItem();
					
					
					int br = 0;
					
					for (Zaposleni zaposleni : ls) {
						if(zaposleni.getDepartment().equals(d)) {
							br++;
							textArea.append("\n" + zaposleni.getIme() + " " + zaposleni.getPrezime() + " " + zaposleni.getDepartment() + " plata: " + zaposleni.netoPlata() + "\n");
						}
					}
					
					if(br == 0)
						throw new Exception("Nema nijedan zaposleni u sluzbi izabranog odeljka firme");
					
					ls.clear();
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
		        		
				
			}
		});
		btnNewButton_2_1_1.setBounds(212, 375, 205, 21);
		contentPane.add(btnNewButton_2_1_1);
		
		JButton btnNewButton_3 = new JButton("Ispisi troskove");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					r.citajListu("Januar.txt", ls);
					
					textArea.setText("");
					
					if(ls.size() == 0)
						throw new Exception("Nema unetih zaposlenih u listu");
					
					double suma = 0;
					
					for (Zaposleni zaposleni : ls) {
						suma += zaposleni.brutoPlata();
					}
					
					JOptionPane.showMessageDialog(null, "Ukupni troskovi kompanije su: " + suma);
					
					ls.clear();
				} catch (HeadlessException e1) {
					JOptionPane.showMessageDialog(null, "Lista je prazna");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			
			}
		});
		btnNewButton_3.setBounds(38, 375, 152, 21);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_2_1_1_1 = new JButton("Obrisi zaposlenog");
		btnNewButton_2_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					r.citajListu("Januar.txt", ls);
					
					r.EmptyDat("Januar.txt");
					
					textArea.setText("");
					
					if(ls.size() == 0)
						throw new Exception("Prazna lista");
					
					int idd = Integer.parseInt(JOptionPane.showInputDialog("Unesi ID:"));
					
					if(idd > ls.size() + 1 || idd < 0)
						throw new Exception("Ne postoji ovaj ID!");
					
					String pass = JOptionPane.showInputDialog("Unesi sifru: ");
					
					if(pass.length() != 10)
						throw new Exception("Nije tacna sifra!");
					
					boolean postoji = false;
					
					for (Zaposleni z : ls) {
						if(z.getID() == idd && z.getSifra().equals(pass))
							postoji = true;
					}
					
					if(!postoji)
						throw new Exception("Nepostoji zaposleni sa ovim IDijem ili sifrom!");
					
					int index = 0;
					
					for (int i = 0; i < ls.size(); i++) {
						
						if(ls.get(i).getID() == idd && ls.get(i).getSifra().equals(pass))
							index = i;
						
					}
					
					ls.remove(index);

					
					r.WriteInDat("Januar.txt", ls);
					
					ls.clear();
				} catch (NumberFormatException e1) {
				
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (HeadlessException e1) {
					
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (Exception e1) {
	
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
				
				
				
				
				
			}
		});
		btnNewButton_2_1_1_1.setBounds(38, 423, 152, 21);
		contentPane.add(btnNewButton_2_1_1_1);
		
		JButton btnNewButton_2_1_1_2 = new JButton("Ispisi zaposlenog max plata");
		btnNewButton_2_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					r.citajListu("Januar.txt", ls);
					
					textArea.setText("");
					
					if(ls.size() == 0)
						throw new Exception("Prazna listaa!");
					
					Zaposleni max = ls.get(0);
					
					for (Zaposleni zaposleni : ls) {
						if(zaposleni.netoPlata() > max.netoPlata())
							max = zaposleni;
					}
					
					JOptionPane.showMessageDialog(null, "Zaposleni sa njavecom platom je: " + "\n" + max.getIme() + " " + max.getPrezime() + " " 
					+ max.getDepartment() + " plata: " + max.netoPlata() + "\n");
					
					ls.clear();
				} catch (HeadlessException e1) {
					
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, e1.getMessage());
				
				}
				
			}
		});
		btnNewButton_2_1_1_2.setBounds(212, 423, 205, 21);
		contentPane.add(btnNewButton_2_1_1_2);
		
		JButton btnGenerisiPotrebe = new JButton("Generisi potrebe");
		btnGenerisiPotrebe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					textArea.setText("");
					
					Random r = new Random();
					
					int it = r.nextInt(8);
					
					int hr = r.nextInt(8);
					
					int finansije = r.nextInt(8);
					
					int kontrola = r.nextInt(8);
					
					int proizvodnja = r.nextInt(8);
					
					lblPKIT.setText((Integer.parseInt(lblPKIT.getText().trim()) + it )+ "");
					
					lblPKHR.setText((Integer.parseInt(lblPKHR.getText().trim()) + hr) + "");
					
					lblPKFinansija.setText((Integer.parseInt(lblPKFinansija.getText().trim()) + finansije) + "");
					
					lblPKKntrProi.setText((Integer.parseInt(lblPKKntrProi.getText().trim()) + kontrola) + "");
					
					lblPKProizvodnja.setText((Integer.parseInt(lblPKProizvodnja.getText().trim()) + proizvodnja) + "");
					
					tfKadarIT.setText("");
					
					tfKadarHR.setText("");
					
					tfKadarFinansije.setText("");
					
					tfKadarKontrolaProizvodnje.setText("");
					
					tfKadarProizvodnja.setText("");
				} catch (NumberFormatException e1) {
					
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
		});
		btnGenerisiPotrebe.setBounds(444, 486, 152, 23);
		contentPane.add(btnGenerisiPotrebe);
		
		JButton btnNewButton_4 = new JButton("Unesi potrebe");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int it = Integer.parseInt(tfKadarIT.getText().trim());
					
					int hr = Integer.parseInt(tfKadarHR.getText().trim());
					
					int finansije = Integer.parseInt(tfKadarFinansije.getText().trim());
					
					int kontrola = Integer.parseInt(tfKadarKontrolaProizvodnje.getText().trim());
					
					int proizvodnja = Integer.parseInt(tfKadarProizvodnja.getText().trim());
					
					lblPKIT.setText((Integer.parseInt(lblPKIT.getText().trim()) + it )+ "");
					
					lblPKHR.setText((Integer.parseInt(lblPKHR.getText().trim()) + hr) + "");
					
					lblPKFinansija.setText((Integer.parseInt(lblPKFinansija.getText().trim()) + finansije) + "");
					
					lblPKKntrProi.setText((Integer.parseInt(lblPKKntrProi.getText().trim()) + kontrola) + "");
					
					lblPKProizvodnja.setText((Integer.parseInt(lblPKProizvodnja.getText().trim()) + proizvodnja) + "");
					
					tfKadarIT.setText("");
					
					tfKadarHR.setText("");
					
					tfKadarFinansije.setText("");
					
					tfKadarKontrolaProizvodnje.setText("");
					
					tfKadarProizvodnja.setText("");
				} catch (NumberFormatException e1) {
					
					JOptionPane.showMessageDialog(null, "Nepravilan unos!");
				}
				
				
			}
		});
		btnNewButton_4.setBounds(469, 220, 111, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Isprazni formu");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.setText("");
				
				ls.clear();
				
			}
		});
		btnNewButton_5.setBounds(469, 566, 154, 23);
		contentPane.add(btnNewButton_5);
		
	}
}
