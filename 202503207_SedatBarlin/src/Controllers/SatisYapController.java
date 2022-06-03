package Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;

import com.SedatMySQL.Util.VeritabanýUtil;

import Classlars.SatisYap;
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

public class SatisYapController {
	
	public SatisYapController() {
		
		baglanti=VeritabanýUtil.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_ekle;
    
    @FXML
    private Button btn_ara;

    @FXML
    private Button btn_satisiptal;

    @FXML
    private Button btn_satisyap;

    @FXML
    private Button btn_sil;

    @FXML
    private Button btn_guncelle;
    
    @FXML
    private Label lbl_id;

    @FXML
    private TableView<SatisYap> tbl_satis;
    
    @FXML
    private TableColumn<SatisYap, String> coll_barkodno;

    @FXML
    private TableColumn<SatisYap, Integer> coll_id;

    @FXML
    private TableColumn<SatisYap, String> coll_miktari;

    @FXML
    private TableColumn<SatisYap, String> coll_satisfiyati;

    @FXML
    private TableColumn<SatisYap, String> coll_toplamfiyati;

    @FXML
    private TableColumn<SatisYap, String> coll_urunadi;

    @FXML
    private TextField txt_adsoyad;

    @FXML
    private TextField txt_barkodno;

    @FXML
    private TextField txt_tc;
    
    @FXML
    private TextField txt_arafield;

    @FXML
    private TextField txt_telefon;

    @FXML
    private TextField txt_toplamfiyati;

    @FXML
    private TextField txt_urunadedi;

    @FXML
    private TextField txt_urunadi;

    @FXML
    private TextField txt_urunsatisfiyati;
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;
    
    @FXML
    void table_satisyap_c(MouseEvent event) {
    	
    	SatisYap satisyap=new SatisYap();
    	satisyap=(SatisYap) tbl_satis.getItems().get(tbl_satis.getSelectionModel().getSelectedIndex());
    	lbl_id.setText(String.valueOf(satisyap.getId()));
    	txt_tc.setText(satisyap.getTc());
    	txt_adsoyad.setText(satisyap.getAdsoyad());
    	txt_telefon.setText(satisyap.getTelefon());
    	txt_barkodno.setText(satisyap.getBarkodno());
    	txt_urunadi.setText(satisyap.getUrunadi());
    	txt_urunadedi.setText(satisyap.getMiktari());
    	txt_urunsatisfiyati.setText(satisyap.getSatisfiyati());
    	txt_toplamfiyati.setText(satisyap.getToplamfiyati());

    }

    @FXML
    void EkleAction(ActionEvent event) {
    	if(btn_ekle.getOnMouseClicked()!=btn_ekle) {
    		Alert alert=new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("Satýþ Bilgileri Eklenecek");
    		alert.setContentText("Bu satýþ bilgilerini eklemek istiyor musunuz?");
    		ButtonType button1=new ButtonType("Evet");
    		ButtonType button2=new ButtonType("Hayýr");
    		alert.getButtonTypes().setAll(button1,button2);
    		Optional<ButtonType> ekle=alert.showAndWait();
    		
    		if(ekle.get()==button1) {
    	    	sql="INSERT INTO tbl_satisyap SET tc=?, adsoyad=?, telefon=?, barkodno=?, urunadi=?,miktari=?,satisfiyati=?,toplamfiyati=?";
    	    	try {
    	    		sorguIfadesi=baglanti.prepareStatement(sql);
    	    		sorguIfadesi.setString(1, txt_tc.getText().trim());
    	    		sorguIfadesi.setString(2, txt_adsoyad.getText().trim());
    	    		sorguIfadesi.setString(3, txt_telefon.getText().trim());
    	    		sorguIfadesi.setString(4, txt_barkodno.getText().trim());
    	    		sorguIfadesi.setString(5, txt_urunadi.getText().trim());
    	    		sorguIfadesi.setString(6, txt_urunadedi.getText().trim());
    	    		sorguIfadesi.setString(7, txt_urunsatisfiyati.getText().trim());
    	    		sorguIfadesi.setString(8, txt_toplamfiyati.getText().trim());
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
    	txt_tc.setText("");
    	txt_adsoyad.setText("");
    	txt_tc.setText("");
    	txt_telefon.setText("");
    	txt_urunadi.setText("");
    	txt_urunadedi.setText("");
    	txt_urunsatisfiyati.setText("");
    	txt_toplamfiyati.setText("");
    	degerler(tbl_satis);
    }
    
    @FXML
    void btnguncelle_Action(ActionEvent event) {
    	if(btn_guncelle.getOnMouseClicked()!=btn_guncelle) {
    		Alert alert=new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("Satýþ Bilgileri Güncellenecek");
    		alert.setContentText("Bu satýþ bilgilerini güncellemek istediðinizden emin misiniz?");
    		ButtonType button1=new ButtonType("Evet");
    		ButtonType button2=new ButtonType("Hayýr");
    		alert.getButtonTypes().setAll(button1,button2);
    		Optional<ButtonType> gunc=alert.showAndWait();
    		
    		if(gunc.get()==button1) {
    	    	sql="UPDATE tbl_satisyap SET barkodno=?, urunadi=?, miktari=?, satisfiyati=?, toplamfiyati=? WHERE id=?";
    	    	try {
    	    		sorguIfadesi=baglanti.prepareStatement(sql);
    	    		sorguIfadesi.setString(1, txt_barkodno.getText().trim());
    	    		sorguIfadesi.setString(2, txt_urunadi.getText().trim());
    	    		sorguIfadesi.setString(3, txt_urunadedi.getText().trim());
    	    		sorguIfadesi.setString(4, txt_urunsatisfiyati.getText().trim());
    	    		sorguIfadesi.setString(5, txt_toplamfiyati.getText().trim());
    	    		sorguIfadesi.setString(6, lbl_id.getText().trim());
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
    	txt_urunadi.setText("");
    	txt_urunadedi.setText("");
    	txt_urunsatisfiyati.setText("");
    	txt_toplamfiyati.setText("");
    	degerler(tbl_satis);
    }
    
    @FXML
    void btnara_Action(ActionEvent event) {
    	aramaOlayi(tbl_satis);
    }
    
    public void aramaOlayi(TableView<SatisYap> table) {
   	   sql = "SELECT * FROM tbl_satisyap WHERE urunadi=?";
   	   ObservableList<SatisYap> satisyap = FXCollections.observableArrayList();
   	try {
   		sorguIfadesi = baglanti.prepareStatement(sql);
   		sorguIfadesi.setString(1, String.valueOf(txt_arafield.getText()));
   		getirilen = sorguIfadesi.executeQuery();
   		while(getirilen.next()) {
   			satisyap.add(new SatisYap(getirilen.getInt("id"), getirilen.getString("tc"), getirilen.getString("adsoyad"), getirilen.getString("telefon"), getirilen.getString("barkodno"), getirilen.getString("urunadi"), getirilen.getString("miktari"), getirilen.getString("satisfiyati"), getirilen.getString("toplamfiyati")));
   		}
   		coll_id.setCellValueFactory(new PropertyValueFactory<>("id"));
   		coll_barkodno.setCellValueFactory(new PropertyValueFactory<>("barkodno"));
   		coll_urunadi.setCellValueFactory(new PropertyValueFactory<>("urunadi"));
   		coll_miktari.setCellValueFactory(new PropertyValueFactory<>("miktari"));
   		coll_satisfiyati.setCellValueFactory(new PropertyValueFactory<>("satisfiyati"));
   		coll_toplamfiyati.setCellValueFactory(new PropertyValueFactory<>("toplamfiyati"));
   		tbl_satis.setItems(satisyap);
   		} catch (Exception e) {
   			Alert alert = new Alert(Alert.AlertType.ERROR);
   			alert.setHeaderText(null);
   			alert.setContentText(e.getMessage().toString());
   			alert.show();
   			}	
   		}

    public void degerler(TableView<SatisYap>table) {
    	
    	sql="SELECT * FROM tbl_satisyap";
    	ObservableList<SatisYap> degergetir=FXCollections.observableArrayList();
    	
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		getirilen=sorguIfadesi.executeQuery();
    		
    		while (getirilen.next()) {
				degergetir.add(new SatisYap(getirilen.getInt("id"), getirilen.getString("tc"), getirilen.getString("adsoyad"), getirilen.getString("telefon"),getirilen.getString("barkodno"),getirilen.getString("urunadi"),getirilen.getString("miktari"),getirilen.getString("satisfiyati"),getirilen.getString("toplamfiyati")));
				
			}
    		
    		coll_id.setCellValueFactory(new PropertyValueFactory<>("id"));
    		coll_barkodno.setCellValueFactory(new PropertyValueFactory<>("barkodno"));
    		coll_urunadi.setCellValueFactory(new PropertyValueFactory<>("urunadi"));
    		coll_miktari.setCellValueFactory(new PropertyValueFactory<>("miktari"));
    		coll_satisfiyati.setCellValueFactory(new PropertyValueFactory<>("satisfiyati"));
    		coll_toplamfiyati.setCellValueFactory(new PropertyValueFactory<>("toplamfiyati"));
    		
    		tbl_satis.setItems(degergetir);
			
		} catch (Exception e) {
			
			Alert alert=new Alert(AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText(e.getMessage().toString());
			alert.showAndWait();
			
		}
    	
    }

	@FXML
    void SatisYapAction(ActionEvent event) {
		if(btn_satisiptal.getOnMouseClicked()!=btn_satisiptal) {
    		Alert alert=new Alert(AlertType.WARNING);
    		alert.setHeaderText("Hazýrladýðýnýz Satýþ Silinecek");
    		alert.setContentText("Bu satýþ ekranýný silmek istediðinizden emin misiniz?");
    		ButtonType button1=new ButtonType("Evet");
    		ButtonType button2=new ButtonType("Hayýr");
    		alert.getButtonTypes().setAll(button1,button2);
    		Optional<ButtonType> sil=alert.showAndWait();
    		
    		if(sil.get()==button1) {
    	    	sql="DELETE FROM tbl_satisyap ";
    	    	try {
    	    		sorguIfadesi=baglanti.prepareStatement(sql);
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
    	txt_urunadi.setText("");
    	txt_urunadedi.setText("");
    	txt_urunsatisfiyati.setText("");
    	txt_toplamfiyati.setText("");
    	degerler(tbl_satis);
    }

    @FXML
    void SatisiptalAction(ActionEvent event) {
    	if(btn_satisiptal.getOnMouseClicked()!=btn_satisiptal) {
    		Alert alert=new Alert(AlertType.WARNING);
    		alert.setHeaderText("Hazýrladýðýnýz Satýþ Silinecek");
    		alert.setContentText("Bu satýþ ekranýný silmek istediðinizden emin misiniz?");
    		ButtonType button1=new ButtonType("Evet");
    		ButtonType button2=new ButtonType("Hayýr");
    		alert.getButtonTypes().setAll(button1,button2);
    		Optional<ButtonType> sil=alert.showAndWait();
    		
    		if(sil.get()==button1) {
    	    	sql="DELETE FROM tbl_satisyap ";
    	    	try {
    	    		sorguIfadesi=baglanti.prepareStatement(sql);
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
    	txt_urunadi.setText("");
    	txt_urunadedi.setText("");
    	txt_urunsatisfiyati.setText("");
    	txt_toplamfiyati.setText("");
    	degerler(tbl_satis);
    }

    @FXML
    void btnsil_Action(ActionEvent event) {
    	if(btn_sil.getOnMouseClicked()!=btn_sil) {
    		Alert alert=new Alert(AlertType.WARNING);
    		alert.setHeaderText("Satýþ Bilgileri Silinecek");
    		alert.setContentText("Bu satýþ bilgilerini silmek istediðinizden emin misiniz?");
    		ButtonType button1=new ButtonType("Evet");
    		ButtonType button2=new ButtonType("Hayýr");
    		alert.getButtonTypes().setAll(button1,button2);
    		Optional<ButtonType> sil=alert.showAndWait();
    		
    		if(sil.get()==button1) {
    	    	sql="DELETE FROM tbl_satisyap WHERE id = ?";
    	    	
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
    	txt_urunadi.setText("");
    	txt_urunadedi.setText("");
    	txt_urunsatisfiyati.setText("");
    	txt_toplamfiyati.setText("");
    	degerler(tbl_satis);
    }

    @FXML
    void initialize() {
    	degerler(tbl_satis);
    	
    }

}
