package Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;

import com.SedatMySQL.Util.VeritabanýUtil;

import Classlars.UrunEkle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class UrunEkleController {
	
	public UrunEkleController() {
		
		baglanti=VeritabanýUtil.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_urunekle;
    
    @FXML
    private Button btn_sil;
    
    @FXML
    private Label lbl_id;
    
    @FXML
    private Button btn_ara;
    
    @FXML
    private Button btn_guncelle;
    
    @FXML
    private TableColumn<UrunEkle, String> coll_alisfiyati;

    @FXML
    private TableColumn<UrunEkle, String> coll_barkodno;

    @FXML
    private TableColumn<UrunEkle, Integer> coll_id;

    @FXML
    private TableColumn<UrunEkle, String> coll_kategori;

    @FXML
    private TableColumn<UrunEkle, String> coll_marka;

    @FXML
    private TableColumn<UrunEkle, String> coll_miktari;

    @FXML
    private TableColumn<UrunEkle, String> coll_satisfiyati;

    @FXML
    private TableColumn<UrunEkle, String> coll_urunadi;

    @FXML
    private TextField txt_alisfiyati;

    @FXML
    private TextField txt_barkodno;

    @FXML
    private TextField txt_arafield;

    @FXML
    private TextField txt_kategori;

    @FXML
    private TextField txt_markasi;

    @FXML
    private TextField txt_miktari;

    @FXML
    private TextField txt_satisfiyati;

    @FXML
    private TextField txt_urunadi;
    
    @FXML
    private TableView<UrunEkle> tbl_urunekle;
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;

    @FXML
    void table_urunekle_c(MouseEvent event) {
    	
    	UrunEkle urun=new UrunEkle();
    	urun=(UrunEkle) tbl_urunekle.getItems().get(tbl_urunekle.getSelectionModel().getSelectedIndex());
    	lbl_id.setText(String.valueOf(urun.getId()));
    	txt_barkodno.setText(urun.getBarkodno());
    	txt_kategori.setText(urun.getKategori());
    	txt_markasi.setText(urun.getMarka());
    	txt_urunadi.setText(urun.getUrunadi());
    	txt_miktari.setText(urun.getMiktari());
    	txt_alisfiyati.setText(urun.getAlisfiyati());
    	txt_satisfiyati.setText(urun.getSatisfiyati());

    }

    @FXML
    void UrunEkleAction(ActionEvent event) {
    	if(btn_urunekle.getOnMouseClicked()!=btn_urunekle) {
    		Alert alert=new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("Ürün Eklenecek");
    		alert.setContentText("Bu ürünü eklemek istiyor musunuz?");
    		ButtonType button1=new ButtonType("Evet");
    		ButtonType button2=new ButtonType("Hayýr");
    		alert.getButtonTypes().setAll(button1,button2);
    		Optional<ButtonType> ekle=alert.showAndWait();
    		
    		if(ekle.get()==button1) {
    	    	sql="INSERT INTO tbl_urunekle SET barkodno=?, kategori=?,marka=?,urunadi=?,miktari=?,alisfiyati=?,satisfiyati=?";
    	    	try {
    	    		sorguIfadesi=baglanti.prepareStatement(sql);
    	    		sorguIfadesi.setString(1, txt_barkodno.getText().trim());
    	    		sorguIfadesi.setString(2, txt_kategori.getText().trim());
    	    		sorguIfadesi.setString(3, txt_markasi.getText().trim());
    	    		sorguIfadesi.setString(4, txt_urunadi.getText().trim());
    	    		sorguIfadesi.setString(5, txt_miktari.getText().trim());
    	    		sorguIfadesi.setString(6, txt_alisfiyati.getText().trim());
    	    		sorguIfadesi.setString(7, txt_satisfiyati.getText().trim());
    	    		sorguIfadesi.executeUpdate();
    			} catch (Exception e) {
    				Alert alertt=new Alert(Alert.AlertType.ERROR);
    				alertt.setHeaderText(null);
    				alertt.setContentText(e.getMessage().toString());
    				alertt.showAndWait();
    			}
    		}
    		else if(ekle.get()==button2) {
    			alert.close();
    		}
    	}
    	txt_barkodno.setText("");
    	txt_kategori.setText("");
    	txt_markasi.setText("");
    	txt_urunadi.setText("");
    	txt_miktari.setText("");
    	txt_alisfiyati.setText("");
    	txt_satisfiyati.setText("");
    	degerler(tbl_urunekle);
    }
    
    @FXML
    void btnsil_Action(ActionEvent event) {
    	if(btn_sil.getOnMouseClicked()!=btn_sil) {
    		Alert alert=new Alert(AlertType.WARNING);
    		alert.setHeaderText("Ürün Bilgileri Silinecek");
    		alert.setContentText("Bu ürün bilgilerini silmek istediðinizden emin misiniz?");
    		ButtonType button1=new ButtonType("Evet");
    		ButtonType button2=new ButtonType("Hayýr");
    		alert.getButtonTypes().setAll(button1,button2);
    		Optional<ButtonType> sil=alert.showAndWait();
    		
    		if(sil.get()==button1) {
    	    	sql="DELETE FROM tbl_urunekle WHERE id = ?";
    	    	
    	    	try {
    	    		sorguIfadesi=baglanti.prepareStatement(sql);
    	    		sorguIfadesi.setString(1, lbl_id.getText().trim());
    	    		sorguIfadesi.execute();
    			} catch (Exception e) {
    				Alert alertt=new Alert(AlertType.ERROR);
    				alertt.setHeaderText(null);
    				alertt.setContentText(e.getMessage().toString());
    				alertt.showAndWait();
    			}
    		}
    		else if(sil.get()==button2) {
    			alert.close();
    		}
    		}
    	txt_barkodno.setText("");
    	txt_kategori.setText("");
    	txt_markasi.setText("");
    	txt_urunadi.setText("");
    	txt_miktari.setText("");
    	txt_alisfiyati.setText("");
    	txt_satisfiyati.setText("");
    	degerler(tbl_urunekle);
    }
    
    @FXML
    void btnguncelle_Action(ActionEvent event) {
    	if(btn_guncelle.getOnMouseClicked()!=btn_guncelle) {
    		Alert alert=new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("Ürün Bilgileri Güncellenecek");
    		alert.setContentText("Bu ürün bilgilerini güncellemek istediðinizden emin misiniz?");
    		ButtonType button1=new ButtonType("Evet");
    		ButtonType button2=new ButtonType("Hayýr");
    		alert.getButtonTypes().setAll(button1,button2);
    		Optional<ButtonType> gunc=alert.showAndWait();
    		
    		if(gunc.get()==button1) {
    	    	sql="UPDATE tbl_urunekle SET barkodno=?, kategori=?, marka=?, urunadi=?, miktari=?, alisfiyati=?, satisfiyati=? WHERE id=?";
    	    	try {
    	    		sorguIfadesi=baglanti.prepareStatement(sql);
    	    		sorguIfadesi.setString(1, txt_barkodno.getText().trim());
    	    		sorguIfadesi.setString(2, txt_kategori.getText().trim());
    	    		sorguIfadesi.setString(3, txt_markasi.getText().trim());
    	    		sorguIfadesi.setString(4, txt_urunadi.getText().trim());
    	    		sorguIfadesi.setString(5, txt_miktari.getText().trim());
    	    		sorguIfadesi.setString(6, txt_alisfiyati.getText().trim());
    	    		sorguIfadesi.setString(7, txt_satisfiyati.getText().trim());
    	    		sorguIfadesi.setString(8, lbl_id.getText().trim());
    	    		sorguIfadesi.executeUpdate();
    			} catch (Exception e) {
    				Alert alertt=new Alert(AlertType.ERROR);
    				alertt.setHeaderText(null);
    				alertt.setContentText(e.getMessage().toString());
    				alertt.showAndWait();
    			}
    		}
    		else if(gunc.get()==button2) {
    			alert.close();
    		}
    	}
    	txt_barkodno.setText("");
    	txt_kategori.setText("");
    	txt_markasi.setText("");
    	txt_urunadi.setText("");
    	txt_miktari.setText("");
    	txt_alisfiyati.setText("");
    	txt_satisfiyati.setText("");
    	degerler(tbl_urunekle);
    }
    
    @FXML
    void btnara_Action(ActionEvent event) {
    	aramaOlayi(tbl_urunekle);
    }
    
    public void aramaOlayi(TableView<UrunEkle> table) {
   	   sql = "SELECT * FROM tbl_urunekle WHERE barkodno=?";
   	   ObservableList<UrunEkle> urun = FXCollections.observableArrayList();
   	try {
   		sorguIfadesi = baglanti.prepareStatement(sql);
   		sorguIfadesi.setString(1, String.valueOf(txt_arafield.getText()));
   		getirilen = sorguIfadesi.executeQuery();
   		while(getirilen.next()) {
   			urun.add(new UrunEkle(getirilen.getInt("id"), getirilen.getString("barkodno"), getirilen.getString("kategori"), getirilen.getString("marka"), getirilen.getString("urunadi"), getirilen.getString("miktari"), getirilen.getString("alisfiyati"), getirilen.getString("satisfiyati")));
   		}
   		coll_id.setCellValueFactory(new PropertyValueFactory<>("id"));
   		coll_barkodno.setCellValueFactory(new PropertyValueFactory<>("barkodno"));
   		coll_kategori.setCellValueFactory(new PropertyValueFactory<>("kategori"));
   		coll_marka.setCellValueFactory(new PropertyValueFactory<>("marka"));
   		coll_urunadi.setCellValueFactory(new PropertyValueFactory<>("urunadi"));
   		coll_miktari.setCellValueFactory(new PropertyValueFactory<>("miktari"));
   		coll_alisfiyati.setCellValueFactory(new PropertyValueFactory<>("alisfiyati"));
   		coll_satisfiyati.setCellValueFactory(new PropertyValueFactory<>("satisfiyati"));
   		tbl_urunekle.setItems(urun);
   		} catch (Exception e) {
   			Alert alert = new Alert(Alert.AlertType.ERROR);
   			alert.setHeaderText(null);
   			alert.setContentText(e.getMessage().toString());
   			alert.show();
   			}	
   		}
    
    	public void degerler(TableView<UrunEkle>table) {
    	
    	sql="SELECT * FROM tbl_urunekle";
    	ObservableList<UrunEkle> degergetir=FXCollections.observableArrayList();
    	
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		getirilen=sorguIfadesi.executeQuery();
    		
    		while (getirilen.next()) {
				degergetir.add(new UrunEkle(getirilen.getInt("id"),getirilen.getString("barkodno"),getirilen.getString("kategori"),getirilen.getString("marka"),getirilen.getString("urunadi"),getirilen.getString("miktari"),getirilen.getString("alisfiyati"),getirilen.getString("satisfiyati")));
				
			}
    		
    		coll_id.setCellValueFactory(new PropertyValueFactory<>("id"));
    		coll_barkodno.setCellValueFactory(new PropertyValueFactory<>("barkodno"));
    		coll_kategori.setCellValueFactory(new PropertyValueFactory<>("kategori"));
    		coll_marka.setCellValueFactory(new PropertyValueFactory<>("marka"));
    		coll_urunadi.setCellValueFactory(new PropertyValueFactory<>("urunadi"));
    		coll_miktari.setCellValueFactory(new PropertyValueFactory<>("miktari"));
    		coll_alisfiyati.setCellValueFactory(new PropertyValueFactory<>("alisfiyati"));
    		coll_satisfiyati.setCellValueFactory(new PropertyValueFactory<>("satisfiyati"));
    		
    		tbl_urunekle.setItems(degergetir);
			
		} catch (Exception e) {
			
			Alert alert=new Alert(AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText(e.getMessage().toString());
			alert.showAndWait();
			
		}
    	
    }

    @FXML
    void initialize() {
    	degerler(tbl_urunekle);

    }

}