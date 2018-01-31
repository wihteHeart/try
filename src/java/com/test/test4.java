/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author soft
 */
@Path("test")
public class test4 {
    @GET
    @Path("/getdata")
    //@Produces(MediaType.APPLICATION_JSON)
    public String getjson(@QueryParam("par") String lice){
/*        String[] licenseExpiryDate = getUsesrsList(lice).getExpiryDate().toString().split("-");
        Calendar cal = Calendar.getInstance();
		 int year  = cal.get(Calendar.YEAR);
		 int month = cal.get(Calendar.MONTH);
		 int date  = cal.get(Calendar.DATE);
		 cal.clear();
		 cal.set(year, month, date);
		 long serverDateInMillis = cal.getTimeInMillis();
		 cal.clear();
                 
		 cal.set(Integer.parseInt(licenseExpiryDate[0]), Integer.parseInt(licenseExpiryDate[1]), Integer.parseInt(licenseExpiryDate[2]));

		 long licenseExpiryDateInMillis = cal.getTimeInMillis();  */
       //return licenseExpiryDateInMillis >= serverDateInMillis; 
        return lice  ;
    }
    
      public Connection getConnection()
   {
       Connection con;
       try {
           con = DriverManager.getConnection("jdbc:mysql://localhost/test_db", "root","root");
           return con;
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       }
   }
        

 // get a list of users from mysql database
   public User getUsesrsList(String lice)
   {
       ArrayList<User> usersList = new ArrayList<User>();
       Connection connection = getConnection();
       
       String query = "SELECT * FROM  `users` WHERE `license` like '" + lice + "'";
       Statement st;
       ResultSet rs;
       User user = null;
       try {
           st = connection.createStatement();
           rs = st.executeQuery(query);
           
           while(rs.next())
           { 
               user = new User(rs.getInt("id"),rs.getString("name"),rs.getString("license"),rs.getString("address") ,rs.getDate("expiry_date"));
               usersList.add(user);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       return user;
   }
    
    
}
