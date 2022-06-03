package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.SedatMySQL.Util.VeritabanýUtil;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.sql.*;

public class SampleController implements Initializable{
	
	public SampleController() {
		baglanti=VeritabanýUtil.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_girisyap;
    
    @FXML
    private Button btn_cikis;

    @FXML
    private Button btn_kayitol;

    @FXML
    private Button btn_parolaunuttum;

    @FXML
    private CheckBox chx_benihatirla;

    @FXML
    private TextField txt_kullaniciadi;

    @FXML
    private PasswordField txt_sifre;
    
    @FXML
    private ImageView yukleme_gif;
    
    Connection baglanti=null;
    PreparedStatement sorguIfadesi=null;
    ResultSet getirilen=null;
    String sql;
    
    @FXML
    void kayitolAction(ActionEvent event) throws IOException {
    	btn_kayitol.getScene().getWindow().hide();
    	Stage kayit = new Stage();
    	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/FXML/KayitOL.fxml"));
    	Scene scene = new Scene(root);
    	kayit.setScene(scene);
    	kayit.show();
    	kayit.setResizable(false);
    }
    
    @FXML
    void girisyapAction(ActionEvent event) {
    	
    	sql="select * from login where kul_adi=? and sifre=?";
    	try {
    		btn_girisyap.getScene().getWindow().hide();
			sorguIfadesi=baglanti.prepareStatement(sql);
			sorguIfadesi.setString(1, txt_kullaniciadi.getText().trim());
			sorguIfadesi.setString(2, txt_sifre.getText().trim());
			ResultSet getirilen=sorguIfadesi.executeQuery();
			if(!getirilen.next()) {
				System.out.println("Kullanici adi veya sifre hatali");
				Alert alert  =new  Alert(AlertType.ERROR);
				alert.setHeaderText("HATALI GÝRÝÞ!");
				alert.setContentText("Kullanýcý adý veya þifre hatalý");
				alert.showAndWait();
			}
			else {
				Stage gecis = new Stage();
    	    	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/FXML/Anasayfa.fxml"));
    	    	Scene scene = new Scene(root);
    	    	gecis.setScene(scene);
    	    	gecis.show();
    	    	gecis.setResizable(false);
				System.out.println("kID:"+ getirilen.getString("kID"));
				System.out.println("kullanýcý:"+ getirilen.getString("kul_adi"));
				System.out.println("þifre:"+ getirilen.getString("sifre"));
				
				
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			// TODO: handle exception
			
		}
    	
    	yukleme_gif.setVisible(true);
    	PauseTransition pt = new PauseTransition();
    	pt.setDuration(Duration.seconds(3));
    	/*
    	pt.setOnFinished(ev -> {
    		try {
    	    	Stage gecis = new Stage();
    	    	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/FXML/Anasayfa.fxml"));
    	    	Scene scene = new Scene(root);
    	    	gecis.setScene(scene);
    	    	gecis.show();
    	    	gecis.setResizable(false);
				
			} catch (Exception e) {
				
			}
    	});*/
    	pt.play();
    	
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	yukleme_gif.setVisible(false);

	}
    

}
