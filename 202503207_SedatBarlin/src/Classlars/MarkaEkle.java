package Classlars;

public class MarkaEkle {
	int id;
	String kategori, marka;
	
	public MarkaEkle() {
		
	}
	
	public MarkaEkle(Integer id, String kategori, String marka) {
		super();
		this.id=id;
		this.kategori=kategori;
		this.marka=marka;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}
