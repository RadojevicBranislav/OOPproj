import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.*;
import javax.swing.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class LoginJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfID;
	private JTextField tfSifra;
	private static Randomi r = new Randomi();
	private ArrayList<Zaposleni> ls = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginJFrame frame = new LoginJFrame();
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
	public LoginJFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.setBackground(new Color(255, 204, 153));
		
		JLabel lblNewLabel = new JLabel("ID: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(86, 83, 49, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblSifra = new JLabel("Sifra: ");
		lblSifra.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSifra.setBounds(86, 141, 62, 38);
		contentPane.add(lblSifra);
		
		tfID = new JTextField();
		tfID.setBounds(131, 91, 148, 31);
		contentPane.add(tfID);
		tfID.setColumns(10);
		
		tfSifra = new JTextField();
		tfSifra.setColumns(10);
		tfSifra.setBounds(131, 145, 148, 31);
		contentPane.add(tfSifra);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				r.citajListu("Januar.txt", ls);
				
				try {	
					
					int id = Integer.parseInt(tfID.getText().trim());				
					
					String pass = tfSifra.getText();
					
					boolean imaPristup = false;
					
					for (Zaposleni zaposleni : ls) {
						
						if(zaposleni.getDepartment().equals("IT") || zaposleni.getDepartment().equals("HR")) {
							if(zaposleni.getID() == id && zaposleni.getSifra().equals(pass))
							{
								imaPristup = true;
							}
						}
					}
					
					if (imaPristup) {
						
						JFrameKadrovska jfrmk = new JFrameKadrovska();
						jfrmk.setVisible(true);
						setVisible(false);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid input!");
					}
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Ima greska");
				}
			}
		});
		btnNewButton.setFont(new Font("Algerian", Font.PLAIN, 18));
		btnNewButton.setBounds(63, 233, 110, 47);
		contentPane.add(btnNewButton);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tfID.setText("");
				tfSifra.setText("");
				JOptionPane.showMessageDialog(null, "Resetovani unosi!");
				
			}
		});
		btnReset.setFont(new Font("Algerian", Font.PLAIN, 18));
		btnReset.setBounds(250, 233, 110, 47);
		contentPane.add(btnReset);
		
		
		
		
		
		
		
	
	}
}
