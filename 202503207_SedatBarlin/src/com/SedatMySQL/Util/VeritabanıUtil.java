package com.SedatMySQL.Util;
import java.sql.*;

public class VeritabanýUtil {
	static Connection conn=null;
	
	public static Connection Baglan() {
		try {
			//"jdbc:mysql://ServerIPAdresi/db_ismi", "kullanici", "sifre"
			conn=DriverManager.getConnection("jdbc:mysql://localhost/otomasyonumdb", "root","");
			return conn;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString());
			return null;
		}
	}
}
