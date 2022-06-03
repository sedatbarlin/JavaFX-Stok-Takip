package Classlars;

public class MusteriEkle {
	int id;
	String adsoyad,tc,telefon,adres,email;
	
	public MusteriEkle() {
		
	}
	public MusteriEkle(Integer id,String adsoyad,String tc,String telefon,String adres,String email) {
		super();
		this.id=id;
		this.adsoyad=adsoyad;
		this.tc=tc;
		this.telefon=telefon;
		this.adres=adres;
		this.email=email;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdsoyad() {
		return adsoyad;
	}
	public void setAdsoyad(String adsoyad) {
		this.adsoyad = adsoyad;
	}
	public String getTc() {
		return tc;
	}
	public void setTc(String tc) {
		this.tc = tc;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
