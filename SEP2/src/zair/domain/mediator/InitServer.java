package zair.domain.mediator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class InitServer
{
   private String serverName;
   private int port;
   private static InitServer instance;
   private String driver;
   private String url;
   private String user;
   private String pw;
   private File dataFile = new File("dataFile.txt");

private InitServer()
   {

   }

   public static InitServer getInstance()
   {

      if(instance == null)
         instance = new InitServer();
      return instance;
   }

   public String getServerName()
   {
      return serverName;
   }

   public int getPort()
   {
      return port;
   }

   public void setServerName(String serverName)
   {
      this.serverName = serverName;
   }

   public void setPort(int port)
   {
      this.port = port;
   }
   public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void getData()
	{
		boolean cont = true;
			 Scanner sc;
			try {
				Scanner scan = new Scanner(dataFile);
				String[] connectionData = scan.nextLine().split(" ");
				InitServer.getInstance().setServerName(connectionData[0]);
				InitServer.getInstance().setPort(Integer.parseInt(connectionData[1]));
				InitServer.getInstance().setDriver(connectionData[2]);
				InitServer.getInstance().setUrl(connectionData[3]);
				InitServer.getInstance().setUser(connectionData[4]);
				InitServer.getInstance().setPw(connectionData[5]);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
}
