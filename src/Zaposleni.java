
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Zaposleni extends Osoba implements IRadnik{
	
	protected String sifra, department;
	
	private static final AtomicInteger count = new AtomicInteger(0);
	
	
	protected int radnihDana,satnica;
	
	private int ID;
	
	private Randomi r = new Randomi();

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getID() {
		return ID;
	}
	
	public void setID(int ide)
	{
		this.ID = ide;
	}

	public int getRadnihDana() {
		return radnihDana;
	}

	public void setRadnihDana(int radnihDana) {
		this.radnihDana = radnihDana;
	}

	public int getSatnica() {
		return satnica;
	}

	public void setSatnica(int satnica) {
		this.satnica = satnica;
	}
	
	

	public Zaposleni(String ime, String prezime, String jmbg, boolean pol, String sifra, String department,  int radnihDana,
			int satnica) { 
		super(ime, prezime, jmbg);
		this.sifra = sifra;
		this.department = department;
		this.radnihDana = radnihDana;
		this.satnica = satnica;
		ID = count.incrementAndGet();
		
	}
	
	public void editRadnihDana()
	{
		Random rand = new Random();
		
		setRadnihDana(16 + rand.nextInt(10));
	}
	
	
	
	public Zaposleni(int iD,String ime, String prezime, String jmbg, String sifra, String department, int radnihDana,
			int satnica,  boolean pol) {
		super(ime, prezime, jmbg);
		this.sifra = sifra;
		this.department = department;
		this.radnihDana = radnihDana;
		this.satnica = satnica;
		ID = iD;
		this.pol = pol;
	}

	public Zaposleni() {
		super();
		ID = count.incrementAndGet();
	}

	private String postaviDepartment()
	{
		String[] str1 = {"HR", "IT"};
		String[] str2 = {"Finansije", "Kontrola_proizvodnje"};
		
		Random rand = new Random();
		
		if(satnica < 250)
			return "Proizvodnja";
		else if(satnica < 290)
			return "Kontrola_proizvodnje";
		else if(satnica < 340)
		{
			int rnd = rand.nextInt(2);
			return str2[rnd];
		}
		else if(satnica < 450)
			return "HR";
		else if(satnica < 550)
		{
			int rnd = rand.nextInt(2);
			return str1[rnd];
		}
		else
			return "IT";
		
	}
	
	

	

	public void setRandom(Zaposleni z)
	{
		z.setIme(r.IzvuciRandomeIzListe(r.listaImena));
		z.setPrezime(r.IzvuciRandomeIzListe(r.listaPrezimena));
		z.setJmbg(r.getMeJmbg());
		z.setPol(r.isMale(z.getIme()));
		z.setSifra(r.passwordGenerator());
		z.setSatnica(r.RandSatnica());
		z.setRadnihDana(r.RandRadDana());
		z.setDepartment(postaviDepartment());
		
	}
	
	public void setRandominDepartmenta(Zaposleni z,String department)
	{
		z.setIme(r.IzvuciRandomeIzListe(r.listaImena));
		z.setPrezime(r.IzvuciRandomeIzListe(r.listaPrezimena));
		z.setJmbg(r.getMeJmbg());
		z.setPol(r.isMale(z.getIme()));
		z.setSifra(r.passwordGenerator());
		z.setSatnica(r.RandSatnica());
		z.setRadnihDana(r.RandRadDana());
		z.setDepartment(department);
		
	}
	
	

	@Override
	public double netoPlata() {
		return satnica * radnihDana * 8;
	}

	@Override
	public double brutoPlata() {
		return (netoPlata() + 10000) * 1.15;
	}

	@Override
	public String toString() {
		if(pol)
			return "\nZaposleni "+ ID +" [sifra=" + sifra + ", department=" + department + ", radnihDana=" + radnihDana + ", satnica="
				+ satnica + ", ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", pol= muski, plata: " + netoPlata();
		else
			return "\nZaposleni " + ID +" [sifra=" + sifra + ", department=" + department + ", radnihDana=" + radnihDana + ", satnica="
			+ satnica + ", ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", pol = Zenski , plata: " + netoPlata();
	}
	
	
	
}


