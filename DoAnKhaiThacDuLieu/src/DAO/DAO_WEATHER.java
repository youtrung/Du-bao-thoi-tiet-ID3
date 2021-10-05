/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import POJO.POJO_WEATHER1;
import SQLServer.SQLprovider;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author trung
 */
public class DAO_WEATHER {
    public static ArrayList<POJO_WEATHER1> getlist() throws ClassNotFoundException, SQLException
    {
        ArrayList<POJO_WEATHER1> list=new ArrayList<POJO_WEATHER1>();
         SQLprovider provider =new SQLprovider();
          provider.open();
          String query="select * from mytable";
          ResultSet rs=provider.executeQuery(query);
           while (rs.next())
              {
                
                  POJO_WEATHER1 we=new POJO_WEATHER1();
                  we.setChance_Precipitation(rs.getString("Chance_Precipitation"));
                  we.setCloud_Cover(rs.getString("Cloud_Cover"));
                  we.setConditions(rs.getString("Conditions"));
                  we.setVisibility(rs.getString("Visibility"));
                  we.setWind_Gust(rs.getString("Wind_Gust"));
                  we.setWind_Speed(rs.getString("Wind_Speed"));
                  we.setPrecipitation(rs.getString("Precipitation"));
                  
                  list.add(we);
              }
             provider.close();
             return list;
    }
   
    
}
