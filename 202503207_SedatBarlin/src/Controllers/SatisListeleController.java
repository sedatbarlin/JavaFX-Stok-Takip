package Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.SedatMySQL.Util.VeritabanýUtil;

import Classlars.SatisListele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class SatisListeleController {
	
	public SatisListeleController() {
		baglanti=VeritabanýUtil.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TableColumn<SatisListele, String> coll_adsoyad;

    @FXML
    private TableColumn<SatisListele, String> coll_barkodno;

    @FXML
    private TableColumn<SatisListele, Integer> coll_id;

    @FXML
    private TableColumn<SatisListele, String> coll_miktari;

    @FXML
    private TableColumn<SatisListele, String> coll_satisfiyati;

    @FXML
    private TableColumn<SatisListele, String> coll_tarih;

    @FXML
    private TableColumn<SatisListele, String> coll_tc;

    @FXML
    private TableColumn<SatisListele, String> coll_telefon;

    @FXML
    private TableColumn<SatisListele, String> coll_toplamfiyat;

    @FXML
    private TableColumn<SatisListele, String> coll_urunadi;

    @FXML
    private TableView<SatisListele> tbl_satislistele;
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;
    
    @FXML
    void table_satislistele_c(MouseEvent event) {


    }
    
    public void degerler(TableView<SatisListele>table) {
    	
    	sql="SELECT * FROM tbl_satislistele";
    	ObservableList<SatisListele> degergetir=FXCollections.observableArrayList();
    	
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		getirilen=sorguIfadesi.executeQuery();
    		
    		while (getirilen.next()) {
				degergetir.add(new SatisListele(getirilen.getInt("id"), getirilen.getString("tc"), getirilen.getString("adsoyad"), getirilen.getString("telefon"),getirilen.getString("barkodno"),getirilen.getString("urunadi"),getirilen.getString("miktari"),getirilen.getString("satisfiyati"),getirilen.getString("toplamfiyati")));
				
			}
    		
    		coll_id.setCellValueFactory(new PropertyValueFactory<>("id"));
    		coll_tc.setCellValueFactory(new PropertyValueFactory<>("tc"));
    		coll_adsoyad.setCellValueFactory(new PropertyValueFactory<>("adsoyad"));
    		coll_telefon.setCellValueFactory(new PropertyValueFactory<>("telefon"));
    		coll_barkodno.setCellValueFactory(new PropertyValueFactory<>("barkodno"));
    		coll_urunadi.setCellValueFactory(new PropertyValueFactory<>("urunadi"));
    		coll_miktari.setCellValueFactory(new PropertyValueFactory<>("miktari"));
    		coll_satisfiyati.setCellValueFactory(new PropertyValueFactory<>("satisfiyati"));
    		coll_toplamfiyat.setCellValueFactory(new PropertyValueFactory<>("toplamfiyat"));
    		
    		tbl_satislistele.setItems(degergetir);
			
		} catch (Exception e) {
			
			Alert alert=new Alert(AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText(e.getMessage().toString());
			alert.showAndWait();
			
		}
    	
    }


    @FXML
    void initialize() {
    	degerler(tbl_satislistele);
    	
    }

}