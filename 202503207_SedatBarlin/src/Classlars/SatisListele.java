package Classlars;

public class SatisListele {
	int id;
	String tc, adsoyad, telefon, barkodno, urunadi, miktari, satisfiyati, toplamfiyat;
	
	public SatisListele() {
		
	}
	
	public SatisListele(Integer id, String tc, String adsoyad, String telefon, String barkodno, String urunadi, String miktari, String satisfiyati, String toplamfiyat) {
		super();
		this.id=id;
		this.tc=tc;
		this.adsoyad=adsoyad;
		this.telefon=telefon;
		this.barkodno=barkodno;
		this.urunadi=urunadi;
		this.miktari=miktari;
		this.satisfiyati=satisfiyati;
		this.toplamfiyat=toplamfiyat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getToplamfiyat() {
		return toplamfiyat;
	}

	public void setToplamfiyat(String toplamfiyat) {
		this.toplamfiyat = toplamfiyat;
	}


}
