package Classlars;

public class SatisYap {
	int id;
	String tc,adsoyad,telefon,barkodno,urunadi,miktari,satisfiyati,toplamfiyati;
	
	public SatisYap() {
		
	}
	
	public SatisYap(Integer id, String tc, String adsoyad, String telefon, String barkodno, String urunadi, String miktari, String satisfiyati, String toplamfiyati){
		super();
		this.id=id;
		this.tc=tc;
		this.adsoyad=adsoyad;
		this.telefon=telefon;
		this.barkodno=barkodno;
		this.urunadi=urunadi;
		this.miktari=miktari;
		this.satisfiyati=satisfiyati;
		this.toplamfiyati=toplamfiyati;
	}

	public String getTc() {
		return tc;
	}

	public void setTc(String tc) {
		this.tc = tc;
	}

	public String getAdsoyad() {
		return adsoyad;
	}

	public void setAdsoyad(String adsoyad) {
		this.adsoyad = adsoyad;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBarkodno() {
		return barkodno;
	}

	public void setBarkodno(String barkodno) {
		this.barkodno = barkodno;
	}

	public String getUrunadi() {
		return urunadi;
	}

	public void setUrunadi(String urunadi) {
		this.urunadi = urunadi;
	}

	public String getMiktari() {
		return miktari;
	}

	public void setMiktari(String miktari) {
		this.miktari = miktari;
	}

	public String getSatisfiyati() {
		return satisfiyati;
	}

	public void setSatisfiyati(String satisfiyati) {
		this.satisfiyati = satisfiyati;
	}

	public String getToplamfiyati() {
		return toplamfiyati;
	}

	public void setToplamfiyati(String toplamfiyati) {
		this.toplamfiyati = toplamfiyati;
	}

}
