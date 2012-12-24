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
		 Class.forName(driverURL);
		 PARAMS = new Object[1];
		 RJBFact = DriverManager.getConnection(connectionURL);
		 }
		 catch(Exception e)
		 {
			 //System.out.println("rjbDataBaseWrapper Constuctor: " + e.getMessage());
		 }
		 
	 }
	 
	 public void AddParameter(Object obj)
	 {
		 try
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
		 catch(Exception e )
		 {
			 System.out.println("rjbDataBaseWrapper.AddParameter" + e.getMessage());
		 }
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
			 System.out.println("rjbDataBaseWrapper.deleteParameters" + e.getMessage());
		 }
	 }
	 
	 public void executeStoredProcedureWithNoResults(String storedProcName)
	 {
		 try
		 {
			 String statment = this.callStoredProcedure;
			 statment = statment.replace("#proc#", storedProcName);
			 String parameters = this.getParameterString();
			 statment = statment.replace("#PARAMS#", parameters);
			 //System.out.println(statment);
			 query = RJBFact.prepareCall(statment);
			 //System.out.println("Connected.");
			 for(int i = 0; i < PARAMS.length - 1; i++)
			 {
					 query.setObject(i + 1, PARAMS[i]);
					 //System.out.println("Added " + PARAMS[i] + " PARAM"); 
			 }
				 //System.out.println("After Adding PARAMS");
				 
				 //System.out.println("Parameters: " + parameters);
				 //System.out.println("Statment: " + statment);
				
				 query.execute();
				

		 }
		 catch(Exception e)
		 {
			 System.out.println("Execute: " + e.getMessage());
		 }
	 }

	 public String getParameterString()
	 {
		 try
		 {
		 String parameters = "(";
		 for(int i= 0; i <PARAMS.length-2;i++)
		 {
			 if(i == 0)
			 {
				 parameters = parameters  + "?";
			 }
					 parameters = parameters  + ",?";
		 }
		parameters = parameters + ")";
		 return parameters;
		 }
		 catch(Exception e)
		 {
			 System.out.println("PARAMLIST: " + e.getMessage());
			 return "";
		 }
	 }
}
