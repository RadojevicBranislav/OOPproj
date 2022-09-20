

import java.util.*;
import java.io.*;

public class Randomi {
	
	public static final String imeDatotekeImena = "RandomIme.txt";
	public static final String imeDatotekePrezimena = "RandomPrezime.txt";
	private Scanner x;
	
	public void citajListu(String imeDatoteke, ArrayList<Zaposleni> ls)
	{
		try {
			x = new Scanner(new File(imeDatoteke));
		} catch (FileNotFoundException e) {
			System.out.println("File not Found!");
		}
		
		
		
		while (x.hasNext()) {
			int id = Integer.parseInt(x.next());
			
			String ime = x.next();
			
			String prezime = x.next();
			
			String jmbg = x.next();
			
			boolean pol = Boolean.parseBoolean(x.next());
			
			String sifra = x.next();
			
			String department = x.next();
			
			int radnihDana = Integer.parseInt(x.next());
			
			int satnica = Integer.parseInt(x.next());
			
			Zaposleni temp = new Zaposleni(id, ime, prezime, jmbg, sifra, department, radnihDana, satnica, pol);
			
			ls.add(temp);
			
			
		}
		
		x.close();
		
	}
	
	public void EmptyDat(String imeDatoteke) throws Exception
	{
		PrintWriter writer = new PrintWriter(imeDatoteke);
		writer.flush();
		writer.print("");
		writer.close();
	}
	
	
	public ArrayList<String> UbaciStringoveUListu(String imeDatoteke)
	{
		try {
			x = new Scanner(new File(imeDatoteke));
		} catch (FileNotFoundException e) {
			System.out.println("File not Found!");
		}
		
		ArrayList<String> lista = new ArrayList<String>();
		
		while (x.hasNext()) {
			String a = x.next();
			
			lista.add(a);
		}
		
		x.close();
		
		return lista;
	}
	
	public ArrayList<String> listaImena = UbaciStringoveUListu(imeDatotekeImena);
	public ArrayList<String> listaPrezimena = UbaciStringoveUListu(imeDatotekePrezimena);
	
	public String IzvuciRandomeIzListe(ArrayList<String> lista)
	{	
		Random rand = new Random();
		
		int grListe = lista.size();
		
		int random = rand.nextInt(grListe);
		
		return lista.get(random);
	}
	

	public String passwordGenerator()
	{
		Random r = new Random();
		
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
		                + "0123456789"
		                + "abcdefghijklmnopqrstuvxyz"
		                + "+-*/!@#$%^&";
		
		StringBuilder sb = new StringBuilder(10);
		
		for (int i = 0; i < 10 ; i++) {
		int index = r.nextInt(AlphaNumericString.length());
		
		sb.append(AlphaNumericString.charAt(index));
		}
		
		return sb.toString();
	}
	
	public boolean isMale(String ime)
	{
		try {
			
			x = new Scanner(new File("MuskoNaA.txt"));
		
		} catch (FileNotFoundException e) {
			System.out.println("File not Found!");
		}
		
		ArrayList<String> lista = new ArrayList<String>();
		
		while (x.hasNext()) {
			String a = x.next();
			
			lista.add(a);
		}
		
		x.close();
		
		char[] ch = new char[ime.length()];
		
		for (int i = 0; i < ch.length; i++) {
			ch[i] = ime.charAt(i);
		}
		
		boolean bool = false;
		
		if(ch[ch.length - 1] != 'a')
		{
			bool = true;
		}
		else if(ch[ch.length - 1] == 'a')
		{
			for (String s : lista) {
				if(ime.equals(s))
					bool = true;
				
			}
		}
		
		return bool;
	}
	
	public String getMeJmbg()
	{
		Random rnd = new Random();
		
		int d = 1 + rnd.nextInt(28);
		
		int m =  1 + rnd.nextInt(11);
		
		int g = 966 + rnd.nextInt(33);
		
		int o = 100000 + rnd.nextInt(899999);
		
		String dan;
		if(d < 10)
			dan = "0" + d;
		else
			dan = "" + d;
		
		String mesec ;
		if(m < 10)
			mesec = "0" + m;
		else
			mesec = "" + m;
		
		String godina = "" + g;
		
		String ostalo = "" + o;
		
		return dan + mesec + godina + ostalo;
		
	}
	public void WriteInDat(String nazivDatoteke, ArrayList<Zaposleni> ls)
	{
		PrintWriter izl;
		try
		{
			izl = new PrintWriter(new FileWriter(nazivDatoteke));
		}
		catch(IOException IOe)
		{
			System.out.println("Neuspelo otvaranje izlaz.txt");
			return;
		}
				
		if (ls != null){
			for (Zaposleni zaposleni : ls) {
				izl.print(zaposleni.getID() + " ");
				izl.flush();
				izl.print(zaposleni.ime + " ");
				izl.flush();
				izl.print(zaposleni.prezime + " ");
				izl.flush();
				izl.print(zaposleni.jmbg + " ");
				izl.flush();
				izl.print(zaposleni.pol+ " ");
				izl.flush();
				izl.print(zaposleni.sifra+ " ");
				izl.flush();
				izl.print(zaposleni.department+ " ");
				izl.flush();
				izl.print(zaposleni.radnihDana+ " ");
				izl.flush();
				izl.print(zaposleni.satnica+ " ");
				izl.flush();
				izl.print("\n");
			}
				
		}
		else
		{
			izl.println("Nema unesenih vrednosti");
			izl.flush();	
		}		
		izl.close();		

		
		
		
	}
	
	public int RandSatnica()
	{
		Random rand = new Random();
		
		return 190 + rand.nextInt(510);
	}
	
	public int RandRadDana()
	{
		Random rand = new Random();
		
		return 16 + rand.nextInt(10);
	}
}
