package Controllers;


import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


public class AnasayfaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_cikis;

    @FXML
    private Button btn_kategoriekle;

    @FXML
    private Button btn_markaekle;

    @FXML
    private Button btn_musteriekle;

    @FXML
    private Button btn_satis;

    @FXML
    private Button btn_stoklarilistele;

    @FXML
    private Button btn_urunekle;

    @FXML
    private AnchorPane sag_anchor;

    @FXML
    private AnchorPane sol_anchor;
    
    @FXML
    private ImageView camasirmakinesi_gif;
    
    @FXML
    void MusteriEkleAction(ActionEvent event)  {
    	try {
    		AnchorPane pane1=(AnchorPane) FXMLLoader.load(getClass().getResource("/FXML/MusteriEkle.fxml"));
        	sag_anchor.getChildren().setAll(pane1);
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    @FXML
    void KategoriEkleAction(ActionEvent event)  {
    	try {
    		AnchorPane pane2=(AnchorPane) FXMLLoader.load(getClass().getResource("/FXML/KategoriEkle.fxml"));
        	sag_anchor.getChildren().setAll(pane2);
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    @FXML
    void UrunEkleAction(ActionEvent event) {
    	try {
    		AnchorPane pane3=(AnchorPane) FXMLLoader.load(getClass().getResource("/FXML/UrunEkle.fxml"));
        	sag_anchor.getChildren().setAll(pane3);
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    @FXML
    void MarkaEkleAction(ActionEvent event) {
    	try {
    		AnchorPane pane4=(AnchorPane) FXMLLoader.load(getClass().getResource("/FXML/MarkaEkle.fxml"));
        	sag_anchor.getChildren().setAll(pane4);
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    @FXML
    void StoklariListeleAction(ActionEvent event) {
    	try {
    		AnchorPane pane4=(AnchorPane) FXMLLoader.load(getClass().getResource("/FXML/StoklariListele.fxml"));
        	sag_anchor.getChildren().setAll(pane4);
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    @FXML
    void SatisListeleAction(ActionEvent event) {
    	try {
    		AnchorPane pane5=(AnchorPane) FXMLLoader.load(getClass().getResource("/FXML/SatisListele.fxml"));
        	sag_anchor.getChildren().setAll(pane5);
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    @FXML
    void SatisYapAction(ActionEvent event) {
    	try {
    		AnchorPane pane6=(AnchorPane) FXMLLoader.load(getClass().getResource("/FXML/SatisYap.fxml"));
        	sag_anchor.getChildren().setAll(pane6);
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    @FXML
    void btncikis_Action(ActionEvent event) {
    	if(btn_cikis.getOnMouseClicked()!=btn_cikis) {
    		Alert alert=new Alert(AlertType.WARNING);
    		alert.setTitle("UYARI");
    		alert.setHeaderText("Otomasyondan Çýkýþ Yapýlacak!");
    		alert.setContentText("Otomasyondan Çýkýþ Yapýlsýn mý?");
    		ButtonType button1=new ButtonType("Evet");
    		ButtonType button2=new ButtonType("Hayýr");
    		alert.getButtonTypes().setAll(button1,button2);
    		Optional<ButtonType> cikis=alert.showAndWait();
    		if(cikis.get()==button1) {
    			System.exit(0);
    		} else if(cikis.get()==button2) {
    			alert.close();
    		}
    	}

    }

    @FXML
    void initialize() {
    	
    	

    }


	
}
