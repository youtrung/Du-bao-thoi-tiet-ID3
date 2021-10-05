/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import DAO.DAO_WEATHER;

import POJO.POJO_WEATHER1;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author trung
 */
public class TableModelWeather extends  AbstractTableModel {
        ArrayList<POJO_WEATHER1> list;
        DAO_WEATHER we=new DAO_WEATHER();
     public TableModelWeather () throws ClassNotFoundException, SQLException {
        list= we.getlist();
    }
    
    @Override
    public int getRowCount() {
           return list.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         POJO_WEATHER1 we=list.get(rowIndex);
        switch(columnIndex){
            case 0: return we.getChance_Precipitation();
            case 1: return we.getPrecipitation();
            case 2: return we.getWind_Speed();
            case 3: return we.getWind_Gust();
            case 4: return we.getVisibility();
            case 5:return we.getCloud_Cover();
            case 6: return we.getConditions();
            default :return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Chance_Precipitation";
            case 1: return "Precipitation";
            case 2: return " Wind_Speed";
            case 3: return "Wind_Gust";
            case 4: return "Visibility";
            case 5:return "Cloud_Cover";
            case 6: return "Conditions";
            default :return null;
        }
    }
    
    
}
