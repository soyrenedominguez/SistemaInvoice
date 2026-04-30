package sistema;

import java.sql.Connection;
import java.sql.DriverManager;
public class Prueba {
Connection cx=null;
public Connection conectar() {
	try {
		cx= DriverManager.getConnection("jdbc: mysql://localhost/grupo603","root","");
		System.out.println("like");
	} catch (Exception e) {
		// TODO: handle exception
	}
	return cx;
}
public static void main(String[]cecyto) {
	DataInvoice di= new DataInvoice();
	di.conectar();
}
}
