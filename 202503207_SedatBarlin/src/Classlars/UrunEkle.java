package Classlars;

public class UrunEkle {
	int id;
	String barkodno,kategori,marka,urunadi,miktari,alisfiyati,satisfiyati;
	
	public UrunEkle() {
		
	}
	
	public UrunEkle(Integer id, String barkodno, String kategori, String marka, String urunadi, String miktari, String alisfiyati, String satisfiyati) {
		super();
		this.id=id;
		this.barkodno=barkodno;
		this.kategori=kategori;
		this.marka=marka;
		this.urunadi=urunadi;
		this.miktari=miktari;
		this.alisfiyati=alisfiyati;
		this.satisfiyati=satisfiyati;
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

	public String getKategori() {
		return kategori;
	}

	public void setKategori(String kategori) {
		this.kategori = kategori;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
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

	public String getAlisfiyati() {
		return alisfiyati;
	}

	public void setAlisfiyati(String alisfiyati) {
		this.alisfiyati = alisfiyati;
	}

	public String getSatisfiyati() {
		return satisfiyati;
	}

	public void setSatisfiyati(String satisfiyati) {
		this.satisfiyati = satisfiyati;
	}

}
