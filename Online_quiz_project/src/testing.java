import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.*;
import javax.servlet.http.*;

public class testing {
            public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException , IOException {
            	try {
            		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            		Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433/samplelogin","sa","root");
            		System.out.print("Database Connected");
            	}
            	catch(Exception e) {
            		System.out.print("Database not connected");
            	}
            }
	  }
