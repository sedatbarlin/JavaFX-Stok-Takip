package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.SedatMySQL.Util.VeritabanýUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class KayitOLController implements Initializable {
		
	
	public KayitOLController() {
		baglanti=VeritabanýUtil.Baglan();
	}
	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private Button btn_kayitgirisyap;

	    @FXML
	    private Button btn_kayitkayitol;
	    
	    @FXML
	    private ImageView camasirgif;

	    @FXML
	    private RadioButton radio_erkek;

	    @FXML
	    private RadioButton radio_kadin;

	    @FXML
	    private TextField txt_kayitkonum;

	    @FXML
	    private TextField txt_kayitkullaniciadi;

	    @FXML
	    private PasswordField txt_kayitsifre;
	    
	    @FXML
	    private ImageView kayitol_yuklemegif;

	    Connection baglanti=null;
	    PreparedStatement sorguIfadesi=null;
	    ResultSet getirilen=null;
	    String sql;
	    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		kayitol_yuklemegif.setVisible(false);
	}
	
	@FXML
	public void KayitOlAction(ActionEvent event) {
		String sorguIfadesi="insert into login (kul_adi,sifre) values(?,?)";
		
		try {
			PreparedStatement pt=baglanti.prepareStatement(sorguIfadesi);
			pt.setString(1, txt_kayitkullaniciadi.getText());
			pt.setString(2, txt_kayitsifre.getText());
			pt.execute();
			Alert alert  =new  Alert(AlertType.INFORMATION);
			alert.setHeaderText("KAYIT BAÞARILI");
			alert.setContentText("Baþarýyla kayýt yaptýnýz, giriþ yapabilirsiniz...");
			alert.showAndWait();
		} catch (Exception e) {
			System.out.println(e.toString());
			// TODO: handle exception
		}
		/*
		kayitol_yuklemegif.setVisible(true);
    	PauseTransition pt = new PauseTransition();
    	pt.setDuration(Duration.seconds(3));
    	pt.setOnFinished(ev -> {
    		System.out.print("Kayýt Baþarýyla Tamamlandý");
    	});
    	pt.play();*/
	}
	
    @FXML
    void GirisYapAction(ActionEvent event) throws IOException {
    	btn_kayitgirisyap.getScene().getWindow().hide();
    	Stage giris = new Stage();
    	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/FXML/Sample.fxml"));
    	Scene scene = new Scene(root);
    	giris.setScene(scene);
    	giris.show();
    	giris.setResizable(false);
    }
	
}
