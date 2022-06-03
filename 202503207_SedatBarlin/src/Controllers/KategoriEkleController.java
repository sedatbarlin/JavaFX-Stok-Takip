package Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;

import com.SedatMySQL.Util.VeritabanýUtil;

import Classlars.KategoriEkle;

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

public class KategoriEkleController {
	
	
	
	public KategoriEkleController() {
		baglanti=VeritabanýUtil.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_kategoriekle;
    
    @FXML
    private Button btn_guncelle;
    
    @FXML
    private Button btn_sil;
    
    @FXML
    private Label lbl_id;
    
    @FXML
    private TextField txt_arafield;

    @FXML
    private Button btn_ara;
    
    @FXML
    private TableColumn<KategoriEkle, Integer> coll_id;

    @FXML
    private TableColumn<KategoriEkle, String> coll_kategori;

    @FXML
    private TextField txt_kategori;
    
    @FXML
    private TableView<KategoriEkle> tbl_kategori;
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;
    
    @FXML
    void table_kategori_c(MouseEvent event) {
    	
    	KategoriEkle kategori=new KategoriEkle();
    	kategori=(KategoriEkle) tbl_kategori.getItems().get(tbl_kategori.getSelectionModel().getSelectedIndex());
    	lbl_id.setText(String.valueOf(kategori.getId()));
    	txt_kategori.setText(kategori.getKategori());
    }

    @FXML
    void KategoriEkleAction(ActionEvent event) {
    	if(btn_kategoriekle.getOnMouseClicked()!=btn_kategoriekle) {
    		Alert alert=new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("Kategori Eklenecek");
    		alert.setContentText("Bu kategoriyi eklemek istiyor musunuz?");
    		ButtonType button1=new ButtonType("Evet");
    		ButtonType button2=new ButtonType("Hayýr");
    		alert.getButtonTypes().setAll(button1,button2);
    		Optional<ButtonType> ekle=alert.showAndWait();
    		
    		if(ekle.get()==button1) {
    	    	sql="INSERT INTO tbl_kategori SET kategori=?";
    	    	try {
    	    		sorguIfadesi=baglanti.prepareStatement(sql);
    	    		sorguIfadesi.setString(1, txt_kategori.getText().trim());
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
    	txt_kategori.setText("");
    	degerler(tbl_kategori);
    }
    
    @FXML
    void btnsil_Action(ActionEvent event) {
    	if(btn_sil.getOnMouseClicked()!=btn_sil) {
    		Alert alert=new Alert(AlertType.WARNING);
    		alert.setHeaderText("Kategori Silinecek");
    		alert.setContentText("Bu kategoriyi silmek istediðinizden emin misiniz?");
    		ButtonType button1=new ButtonType("Evet");
    		ButtonType button2=new ButtonType("Hayýr");
    		alert.getButtonTypes().setAll(button1,button2);
    		Optional<ButtonType> sil=alert.showAndWait();
    		
    		if(sil.get()==button1) {
    	    	sql="DELETE FROM tbl_kategori WHERE id = ?";
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
    	txt_kategori.setText("");
    	degerler(tbl_kategori);
    }
    
    @FXML
    void btnguncelle_Action(ActionEvent event) {
    	if(btn_guncelle.getOnMouseClicked()!=btn_guncelle) {
    		Alert alert=new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("Kategori Adý Güncellenecek");
    		alert.setContentText("Bu kategori adýný güncellemek istediðinizden emin misiniz?");
    		ButtonType button1=new ButtonType("Evet");
    		ButtonType button2=new ButtonType("Hayýr");
    		alert.getButtonTypes().setAll(button1,button2);
    		Optional<ButtonType> gunc=alert.showAndWait();
    		
    		if(gunc.get()==button1) {
    			sql="UPDATE tbl_kategori SET kategori=? WHERE id=?";
    	    	try {
    	    		sorguIfadesi=baglanti.prepareStatement(sql);
    	    		sorguIfadesi.setString(1, txt_kategori.getText().trim());
    	    		sorguIfadesi.setString(2, lbl_id.getText().trim());
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
    	txt_kategori.setText("");
    	degerler(tbl_kategori);
    }
    
    @FXML
    void btnara_Action(ActionEvent event) {
    	aramaOlayi(tbl_kategori);
    }
    
    public void aramaOlayi(TableView<KategoriEkle> table) {
  	   sql = "SELECT * FROM tbl_kategori WHERE kategori = ?";
  	   ObservableList<KategoriEkle> kategori = FXCollections.observableArrayList();
  	try {
  		sorguIfadesi = baglanti.prepareStatement(sql);
  		sorguIfadesi.setString(1, String.valueOf(txt_arafield.getText()));
  		getirilen = sorguIfadesi.executeQuery();
  		while(getirilen.next()) {
  			kategori.add(new KategoriEkle(getirilen.getInt("id"), getirilen.getString("kategori")));
  		}
  		coll_id.setCellValueFactory(new PropertyValueFactory<>("id"));
  		coll_kategori.setCellValueFactory(new PropertyValueFactory<>("kategori"));
  		
  		tbl_kategori.setItems(kategori);
  		
  		} catch (Exception e) {
  			Alert alert = new Alert(Alert.AlertType.ERROR);
  			alert.setHeaderText(null);
  			alert.setContentText(e.getMessage().toString());
  			alert.show();
  			}	
  		}
    
    	public void degerler(TableView<KategoriEkle>table) {
    	
    	sql="SELECT * FROM tbl_kategori";
    	ObservableList<KategoriEkle> degergetir=FXCollections.observableArrayList();
    	
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		getirilen=sorguIfadesi.executeQuery();
    		
    		while (getirilen.next()) {
				degergetir.add(new KategoriEkle(getirilen.getInt("id"),getirilen.getString("kategori")));
			}
    		
    		coll_id.setCellValueFactory(new PropertyValueFactory<>("id"));
    		coll_kategori.setCellValueFactory(new PropertyValueFactory<>("kategori"));
    		tbl_kategori.setItems(degergetir);
			
		} catch (Exception e) {
			
			Alert alert=new Alert(AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText(e.getMessage().toString());
			alert.showAndWait();
		}
    }

    @FXML
    void initialize() {
    	degerler(tbl_kategori);
    }
}
