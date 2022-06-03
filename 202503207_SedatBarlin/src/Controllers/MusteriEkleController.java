package Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;

import com.SedatMySQL.Util.VeritabanýUtil;

import Classlars.MusteriEkle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class MusteriEkleController {
	
	public MusteriEkleController() {
		
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
    private Button btn_sil;
    
    @FXML
    private Button btn_guncelle;

    @FXML
    private TableView<MusteriEkle> tbl_musteriekle;
    
    @FXML
    private TableColumn<MusteriEkle, Integer> collId;

    @FXML
    private TableColumn<MusteriEkle, String> coll_adres;

    @FXML
    private TableColumn<MusteriEkle,  String> coll_adsoyad;

    @FXML
    private TableColumn<MusteriEkle,  String> coll_email;

    @FXML
    private TableColumn<MusteriEkle,  String> coll_tc;

    @FXML
    private TableColumn<MusteriEkle,  String> coll_telefon;
    
    @FXML
    private Label lbl_id;

    @FXML
    private TextField txt_adisoyadi;

    @FXML
    private TextField txt_adres;

    @FXML
    private TextField txt_email;
    
    @FXML
    private TextField txt_arafield;

    @FXML
    private TextField txt_tcno;

    @FXML
    private TextField txt_telno;
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;

    @FXML
    void table_musterý_c(MouseEvent event) {
    	MusteriEkle musteri=new MusteriEkle();
    	musteri=(MusteriEkle) tbl_musteriekle.getItems().get(tbl_musteriekle.getSelectionModel().getSelectedIndex());
    	lbl_id.setText(String.valueOf(musteri.getId()));
    	txt_adisoyadi.setText(musteri.getAdsoyad());
    	txt_tcno.setText(musteri.getTc());
    	txt_telno.setText(musteri.getTelefon());
    	txt_adres.setText(musteri.getAdres());
    	txt_email.setText(musteri.getEmail());
    }
    
    @FXML
    void btnekle_click(ActionEvent event) {
    	if(btn_ekle.getOnMouseClicked()!=btn_ekle) {
    		Alert alert=new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("Müþteri Eklenecek");
    		alert.setContentText("Bu müþteriyi eklemek istiyor musunuz?");
    		ButtonType button1=new ButtonType("Evet");
    		ButtonType button2=new ButtonType("Hayýr");
    		alert.getButtonTypes().setAll(button1,button2);
    		Optional<ButtonType> ekle=alert.showAndWait();
    		
    		if(ekle.get()==button1) {
    	    	sql="INSERT INTO tbl_musteri SET adsoyad=?, tc=?,telefon=?,adres=?,email=?";
    	    	try {
    	    		sorguIfadesi=baglanti.prepareStatement(sql);
    	    		sorguIfadesi.setString(1, txt_adisoyadi.getText().trim());
    	    		sorguIfadesi.setString(2, txt_tcno.getText().trim());
    	    		sorguIfadesi.setString(3, txt_telno.getText().trim());
    	    		sorguIfadesi.setString(4, txt_adres.getText().trim());
    	    		sorguIfadesi.setString(5, txt_email.getText().trim());
    	    		sorguIfadesi.executeUpdate();
    			} catch (Exception e) {
    				Alert alertt=new Alert(Alert.AlertType.ERROR);
    				alertt.setHeaderText(null);
    				alertt.setContentText(e.getMessage().toString());
    				alert.showAndWait();
    			}
    		}
    		else if(ekle.get()==button2) {
    			alert.close();
    		}
    	}
    	txt_adisoyadi.setText("");
    	txt_tcno.setText("");
    	txt_telno.setText("");
    	txt_adres.setText("");
    	txt_email.setText("");
    	degerler(tbl_musteriekle);
    }
    
    @FXML
    void btnsil_Action(ActionEvent event) {
    	if(btn_sil.getOnMouseClicked()!=btn_sil) {
    		Alert alert=new Alert(AlertType.WARNING);
    		alert.setHeaderText("Müþteri Silinecek");
    		alert.setContentText("Bu müþteriyi silmek istediðinizden emin misiniz?");
    		ButtonType button1=new ButtonType("Evet");
    		ButtonType button2=new ButtonType("Hayýr");
    		alert.getButtonTypes().setAll(button1,button2);
    		Optional<ButtonType> sil=alert.showAndWait();
    		
    		if(sil.get()==button1) {
    	    	sql="DELETE FROM tbl_musteri WHERE Id = ?";
    	    	
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
    	txt_adisoyadi.setText("");
    	txt_tcno.setText("");
    	txt_telno.setText("");
    	txt_adres.setText("");
    	txt_email.setText("");
    	degerler(tbl_musteriekle);
    }
    
    @FXML
    void btnguncelle_Action(ActionEvent event) {
    	if(btn_guncelle.getOnMouseClicked()!=btn_guncelle) {
    		Alert alert=new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("Müþteri Bilgileri Güncellenecek");
    		alert.setContentText("Müþteri bilgilerini güncellemek istediðinizden emin misiniz?");
    		ButtonType button1=new ButtonType("Evet");
    		ButtonType button2=new ButtonType("Hayýr");
    		alert.getButtonTypes().setAll(button1,button2);
    		Optional<ButtonType> gunc=alert.showAndWait();
    		
    		if(gunc.get()==button1) {
    	    	sql="UPDATE tbl_musteri SET adsoyad=?, tc=?, telefon=?, adres=?, email=? WHERE Id=?";
    	    	try {
    	    		sorguIfadesi=baglanti.prepareStatement(sql);
    	    		sorguIfadesi.setString(1, txt_adisoyadi.getText().trim());
    	    		sorguIfadesi.setString(2, txt_tcno.getText().trim());
    	    		sorguIfadesi.setString(3, txt_telno.getText().trim());
    	    		sorguIfadesi.setString(4, txt_adres.getText().trim());
    	    		sorguIfadesi.setString(5, txt_email.getText().trim());
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
    	txt_adisoyadi.setText("");
    	txt_tcno.setText("");
    	txt_telno.setText("");
    	txt_adres.setText("");
    	txt_email.setText("");
    	degerler(tbl_musteriekle);
    }
    
    @FXML
    void btnara_Action(ActionEvent event) {
    	aramaOlayi(tbl_musteriekle);
    }
    
    public void aramaOlayi(TableView<MusteriEkle> table) {
   	   sql = "SELECT * FROM tbl_musteri WHERE adsoyad=?";
   	   ObservableList<MusteriEkle> musteri = FXCollections.observableArrayList();
   	try {
   		sorguIfadesi = baglanti.prepareStatement(sql);
   		sorguIfadesi.setString(1, String.valueOf(txt_arafield.getText()));
   		getirilen = sorguIfadesi.executeQuery();
   		while(getirilen.next()) {
   			musteri.add(new MusteriEkle(getirilen.getInt("Id"), getirilen.getString("adsoyad"), getirilen.getString("tc"), getirilen.getString("telefon"), getirilen.getString("adres"), getirilen.getString("email")));
   		}
   		collId.setCellValueFactory(new PropertyValueFactory<>("id"));
   		coll_adsoyad.setCellValueFactory(new PropertyValueFactory<>("adsoyad"));
   		coll_tc.setCellValueFactory(new PropertyValueFactory<>("tc"));
   		coll_telefon.setCellValueFactory(new PropertyValueFactory<>("telefon"));
   		coll_adres.setCellValueFactory(new PropertyValueFactory<>("adres"));
   		coll_email.setCellValueFactory(new PropertyValueFactory<>("email"));
   		tbl_musteriekle.setItems(musteri);
   		} catch (Exception e) {
   			Alert alert = new Alert(Alert.AlertType.ERROR);
   			alert.setHeaderText(null);
   			alert.setContentText(e.getMessage().toString());
   			alert.show();
   			}	
   		}
    
    public void degerler(TableView<MusteriEkle>table) {
    	
    	sql="SELECT * FROM tbl_musteri";
    	ObservableList<MusteriEkle> degergetir=FXCollections.observableArrayList();
    	
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		getirilen=sorguIfadesi.executeQuery();
    		
    		while (getirilen.next()) {
				degergetir.add(new MusteriEkle(getirilen.getInt("Id"),getirilen.getString("adsoyad"),getirilen.getString("tc"),getirilen.getString("telefon"),getirilen.getString("adres"),getirilen.getString("email")));
				
			}
    		
    		collId.setCellValueFactory(new PropertyValueFactory<>("Id"));
    		coll_adsoyad.setCellValueFactory(new PropertyValueFactory<>("adsoyad"));
    		coll_tc.setCellValueFactory(new PropertyValueFactory<>("tc"));
    		coll_telefon.setCellValueFactory(new PropertyValueFactory<>("telefon"));
    		coll_adres.setCellValueFactory(new PropertyValueFactory<>("adres"));
    		coll_email.setCellValueFactory(new PropertyValueFactory<>("email"));
    		
    		tbl_musteriekle.setItems(degergetir);
			
		} catch (Exception e) {
			
			Alert alert=new Alert(AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText(e.getMessage().toString());
			alert.showAndWait();
		}
    }
    
    @FXML
    void initialize() {
    	degerler(tbl_musteriekle);
    }

}
