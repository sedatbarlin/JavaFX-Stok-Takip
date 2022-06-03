package Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;

import com.SedatMySQL.Util.VeritabanýUtil;

import Classlars.MarkaEkle;
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

public class MarkaEkleController {
	
	public MarkaEkleController() {
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
    private TextField txt_arafield;
    
    @FXML
    private Button btn_sil;
    
    @FXML
    private Button btn_guncelle;
    
    @FXML
    private Label lbl_id;
    
    @FXML
    private TableColumn<MarkaEkle, Integer> coll_id;

    @FXML
    private TableColumn<MarkaEkle, String> coll_kategori;

    @FXML
    private TableColumn<MarkaEkle, String> coll_marka;

    @FXML
    private TextField txt_marka;
    
    @FXML
    private TextField txt_kategori;
    
    @FXML
    private TableView<MarkaEkle> tbl_marka;
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;

    @FXML
    void table_markaekle_c(MouseEvent event) {
    	
    	MarkaEkle marka=new MarkaEkle();
    	marka=(MarkaEkle) tbl_marka.getItems().get(tbl_marka.getSelectionModel().getSelectedIndex());
    	lbl_id.setText(String.valueOf(marka.getId()));
    	txt_kategori.setText(marka.getKategori());
    	txt_marka.setText(marka.getMarka());
    	
    	
    
    }

    @FXML
    void MarkaEkleAction(ActionEvent event) {
    	if(btn_ekle.getOnMouseClicked()!=btn_ekle) {
    		Alert alert=new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("Marka Eklenecek");
    		alert.setContentText("Bu markayý eklemek istiyor musunuz?");
    		ButtonType button1=new ButtonType("Evet");
    		ButtonType button2=new ButtonType("Hayýr");
    		alert.getButtonTypes().setAll(button1,button2);
    		Optional<ButtonType> ekle=alert.showAndWait();
    		
    		if(ekle.get()==button1) {
    	    	sql="INSERT INTO tbl_marka SET kategori=?, marka=?";
    	    	try {
    	    		sorguIfadesi=baglanti.prepareStatement(sql);
    	    		sorguIfadesi.setString(1, txt_kategori.getText().trim());
    	    		sorguIfadesi.setString(2, txt_marka.getText().trim());
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
    	txt_kategori.setText("");
    	txt_marka.setText("");
    	degerler(tbl_marka);
    }
    
    @FXML
    void btnsil_Action(ActionEvent event) {
    	if(btn_sil.getOnMouseClicked()!=btn_sil) {
    		Alert alert=new Alert(AlertType.WARNING);
    		alert.setHeaderText("Marka Silinecek");
    		alert.setContentText("Bu markayý silmek istediðinizden emin misiniz?");
    		ButtonType button1=new ButtonType("Evet");
    		ButtonType button2=new ButtonType("Hayýr");
    		alert.getButtonTypes().setAll(button1,button2);
    		Optional<ButtonType> sil=alert.showAndWait();
    		
    		if(sil.get()==button1) {
    	    	sql="DELETE FROM tbl_marka WHERE id = ?";
    	    	
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
    	txt_marka.setText("");
    	degerler(tbl_marka);
    }
    
    @FXML
    void btnguncelle_Action(ActionEvent event) {
    	if(btn_guncelle.getOnMouseClicked()!=btn_guncelle) {
    		Alert alert=new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("Kategori ve Marka Adý Güncellenecek");
    		alert.setContentText("Bu kategoriyi ve marka adýný güncellemek istediðinizden emin misiniz?");
    		ButtonType button1=new ButtonType("Evet");
    		ButtonType button2=new ButtonType("Hayýr");
    		alert.getButtonTypes().setAll(button1,button2);
    		Optional<ButtonType> gunc=alert.showAndWait();
    		
    		if(gunc.get()==button1) {
    	    	sql="UPDATE tbl_marka SET kategori=?, marka=? WHERE id=?";
    	    	try {
    	    		sorguIfadesi=baglanti.prepareStatement(sql);
    	    		sorguIfadesi.setString(1, txt_kategori.getText().trim());
    	    		sorguIfadesi.setString(2, txt_marka.getText().trim());
    	    		sorguIfadesi.setString(3, lbl_id.getText().trim());
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
    	txt_marka.setText("");
    	degerler(tbl_marka);
    }
    
    @FXML
    void btnara_Action(ActionEvent event) {
    	aramaOlayi(tbl_marka);
    }
    
    public void aramaOlayi(TableView<MarkaEkle> table) {
   	   sql = "SELECT * FROM tbl_marka WHERE marka=?";
   	   ObservableList<MarkaEkle> marka = FXCollections.observableArrayList();
   	try {
   		sorguIfadesi = baglanti.prepareStatement(sql);
   		sorguIfadesi.setString(1, String.valueOf(txt_arafield.getText()));
   		getirilen = sorguIfadesi.executeQuery();
   		while(getirilen.next()) {
   			marka.add(new MarkaEkle(getirilen.getInt("id"), getirilen.getString("kategori"), getirilen.getString("marka")));
   		}
   		coll_id.setCellValueFactory(new PropertyValueFactory<>("id"));
   		coll_kategori.setCellValueFactory(new PropertyValueFactory<>("kategori"));
   		coll_marka.setCellValueFactory(new PropertyValueFactory<>("marka"));
   		tbl_marka.setItems(marka);
   		} catch (Exception e) {
   			Alert alert = new Alert(Alert.AlertType.ERROR);
   			alert.setHeaderText(null);
   			alert.setContentText(e.getMessage().toString());
   			alert.show();
   			}	
   		}
    
    	public void degerler(TableView<MarkaEkle>table) {
    		
    		sql="SELECT * FROM tbl_marka";
        	ObservableList<MarkaEkle> degergetir=FXCollections.observableArrayList();
        	
        	try {
        		sorguIfadesi=baglanti.prepareStatement(sql);
        		getirilen=sorguIfadesi.executeQuery();
        		
        		while (getirilen.next()) {
    				degergetir.add(new MarkaEkle(getirilen.getInt("id"),getirilen.getString("kategori"),getirilen.getString("marka")));
    				
    			}
        		
        		coll_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        		coll_kategori.setCellValueFactory(new PropertyValueFactory<>("kategori"));
        		coll_marka.setCellValueFactory(new PropertyValueFactory<>("marka"));
        		
        		tbl_marka.setItems(degergetir);
    			
    		} catch (Exception e) {
    			
    			Alert alert=new Alert(AlertType.ERROR);
    			alert.setHeaderText(null);
    			alert.setContentText(e.getMessage().toString());
    			alert.showAndWait();
    			
    		}
    }

    @FXML
    void initialize() {
    	degerler(tbl_marka);

}
}
