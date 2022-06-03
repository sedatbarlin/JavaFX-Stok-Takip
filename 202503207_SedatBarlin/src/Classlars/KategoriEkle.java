package Classlars;

public class KategoriEkle {
	int id;
	String kategori;
	
	public KategoriEkle() {
		
	}
	
	public KategoriEkle(Integer id, String kategori) {
		super();
		this.id=id;
		this.kategori=kategori;
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
	
	
	
}
