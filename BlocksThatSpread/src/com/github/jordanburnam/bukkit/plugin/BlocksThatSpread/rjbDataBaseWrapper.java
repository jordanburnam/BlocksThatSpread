package com.github.jordanburnam.bukkit.plugin.BlocksThatSpread;
import java.sql.*;

public class rjbDataBaseWrapper 
{
	
 private String connectionURL = "jdbc:sqlserver://192.168.1.71;Database=MineCraft;user=sa;password=123456;";
 private String driverURL = "com.microsoft.sqlserver.jdbc.SQLServerDriver";	
 private CallableStatement query = null;
 private Object[] PARAMS = null;
 private final String callStoredProcedure = "{call #proc##PARAMS#}";
 private  Connection RJBFact = null;
 
 public rjbDataBaseWrapper()
 {
	 try
	 {
	 PARAMS = new Object[1];
	 RJBFact = DriverManager.getConnection(connectionURL);
	 }
	 catch(Exception e)
	 {
		 
	 }
	 
 }
 
 public void AddParameter(Object obj)
 {
	 PARAMS[PARAMS.length - 1] = obj;
	 Object[] TEMP = new Object[PARAMS.length + 1];
	 int i = 0;
	 for(Object o: PARAMS)
	 {
		 TEMP[i] = o;
		 i++;
	 }
	PARAMS = null;
	PARAMS = TEMP;
 }
 
 public void DeleteParameters()
 {
	 try
	 {
		 if(this.query != null)
		 {
			 this.query.clearParameters();
		 }
	 }
	 catch(Exception e)
	 {
		 
	 }
 }
 
 public void executeStoredProcedureWithNoResults(String storedProcName)
 {
	 try
	 {
		 String statment = this.callStoredProcedure;
		 String parameters = "(";
		 statment.replace("#proc#", "storedProcName");
		 
		 int i = 0;
		 for(Object o : PARAMS)
		 {
			 if(i == 0)
			 {
				 parameters = parameters  + "?";
				 i++;
				 query.setObject(i, o);
			 }
			 else
			 {
				 if(i == (PARAMS.length - 1))
				 {
					 parameters = parameters  + "?";
					 i++;
					 query.setObject(i, o);
				 }
				 else
				 {
					 parameters = parameters  + "?,";
					 i++;
					 query.setObject(i, o);
				 }
			 }
			 parameters = parameters + ")";
			 statment.replace("#PARAMS#", parameters);
			 System.out.println("Parameters: " + parameters);
			 System.out.println("Statment: " + statment);
			 RJBFact.prepareCall("{call rjb_mc_addBlocktoUpdate(?, ?, ?, ?, ?)}");
			 System.out.println("Connected.");
			 query.execute();
			
		 }
	 }
	 catch(Exception e)
	 {
		 
	 }
 }
 public void update()
	{
		try
		{
			
			Class.forName(driverURL);

			 
			
			
			
			
		}
		catch(Exception e)
		{
			
		}
	}

}
