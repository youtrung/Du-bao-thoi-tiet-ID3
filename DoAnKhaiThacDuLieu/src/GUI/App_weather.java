/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.DAO_WEATHER;
import MODEL.TableModelWeather;
import java.awt.BorderLayout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.xml.transform.TransformerException;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;
import weka.gui.treevisualizer.PlaceNode2;
import weka.gui.treevisualizer.TreeVisualizer;

/**
 *
 * @author trung
 */
public class App_weather extends javax.swing.JFrame {
    TableModelWeather TableModelWeather;
    static boolean verboseFlag=false;
    static DAO_WEATHER we=new DAO_WEATHER();
    static Instances data;
    static J48 model;
    static ConverterUtils.DataSource source;
    
    
    /**
     * Creates new form App_weather
     */
    public App_weather() throws Exception {
        initComponents();
        intitWeather();
        J48tree();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblWe = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtChance_p = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPreci = new javax.swing.JTextField();
        txtWindSp = new javax.swing.JTextField();
        btnKQ = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtWindGus = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtVisi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCloud = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtKq = new javax.swing.JTextField();
        btnKQ1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblWe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblWe);

        jLabel1.setText("Chance_Precipitation");

        jLabel2.setText("Precipitation");

        jLabel4.setText("Wind_Speed");

        btnKQ.setText("Result");
        btnKQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKQActionPerformed(evt);
            }
        });

        jLabel5.setText("Wind_Gust");

        jLabel6.setText("Visibility");

        jLabel7.setText("Cloud_Cover");

        jLabel8.setText("Conditions");

        txtKq.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtKq.setForeground(new java.awt.Color(255, 0, 0));
        txtKq.setCaretColor(new java.awt.Color(102, 153, 0));
        txtKq.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtKq.setEnabled(false);
        txtKq.setSelectedTextColor(new java.awt.Color(255, 0, 51));

        btnKQ1.setText("Tree Model");
        btnKQ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKQ1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtWindSp, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtWindGus, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnKQ1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtChance_p, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPreci, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addComponent(txtVisi, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(btnKQ)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCloud, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKq, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtChance_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtPreci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKQ)
                    .addComponent(jLabel6)
                    .addComponent(txtVisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtWindSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtWindGus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnKQ1))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCloud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtKq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKQActionPerformed
            if (txtChance_p.getText().isEmpty())
            {
                txtChance_p.setText("0");
            }
            if (txtPreci.getText().isEmpty())
            {
                txtPreci.setText("0");
            }
            if (txtCloud.getText().isEmpty())
            {
                txtCloud.setText("0");
            }
            if (txtVisi.getText().isEmpty())
            {
                txtVisi.setText("0");
            }
            if (txtWindGus.getText().isEmpty())
            {
                txtWindGus.setText("0");
            }
            if (txtWindSp.getText().isEmpty())
            {
                txtWindSp.setText("0");
            }
            
        try {
            Ifthenrule rule =new Ifthenrule();
            double chance_p=Double.parseDouble(txtChance_p.getText());
            double preci=Double.parseDouble(txtPreci.getText());
            double wind_sp=Double.parseDouble(txtWindSp.getText());
            double wind_gust=Double.parseDouble(txtWindGus.getText());
            double visi=Double.parseDouble(txtVisi.getText());
            double cloud=Double.parseDouble(txtCloud.getText());
           
            Object [] t ={chance_p,preci,wind_sp,wind_gust,visi,cloud};
            double kq=rule.classify(t);
            int c = (int)kq;
            System.out.println(c);
            String cons="";
            if (c==0)
            {
               cons="Clear"; 
            }
            else if (c==1)
            {
                cons="OverCast";
            }
            else if (c==2)
            {
                cons="Partially cloudy";
            }
             else if (c==3)
            {
                 cons="Rain, Overcast";
            }
             else if (c==4)
            {
                cons="Rain,Partially cloudy";
            }
             else 
                 cons="Ch??a th??? x??c ?????nh ";
            
           txtKq.setText(cons);
            
        } catch (Exception ex) {
            Logger.getLogger(App_weather.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
         
    }//GEN-LAST:event_btnKQActionPerformed

    private void btnKQ1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKQ1ActionPerformed
        try {
            // TODO add your handling code here:
            TreeVisualizer tv = new TreeVisualizer(null, model.graph(), new PlaceNode2());
            
            JFrame jf = new JFrame("Weka Classifier Tree Visualizer: J48");
            jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jf.setSize(800, 600);
            jf.getContentPane().setLayout(new BorderLayout());
            jf.getContentPane().add(tv, BorderLayout.CENTER);
            jf.setVisible(true);
            
            // adjust tree
            tv.fitToScreen();
        } catch (Exception ex) {
            Logger.getLogger(App_weather.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnKQ1ActionPerformed
    public void intitWeather(){
        try {
            TableModelWeather =new  TableModelWeather();
            tblWe.setModel(TableModelWeather);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(App_weather.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(App_weather.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void J48tree() throws Exception
    {
         source = new ConverterUtils.DataSource("C:\\Users\\trung\\Desktop\\forecast_data_06_overfit.arff");
          data=source.getDataSet();
         // Set class the last attribute as class
         data.setClassIndex(data.numAttributes() - 1);
         model = new J48();
         model.buildClassifier(data);
         System.out.println("Source code:\n"+model.toSource("IfthenRule"));  
         System.out.println(model.toString());
         
         
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new App_weather().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(App_weather.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKQ;
    private javax.swing.JButton btnKQ1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblWe;
    private javax.swing.JTextField txtChance_p;
    private javax.swing.JTextField txtCloud;
    private javax.swing.JTextField txtKq;
    private javax.swing.JTextField txtPreci;
    private javax.swing.JTextField txtVisi;
    private javax.swing.JTextField txtWindGus;
    private javax.swing.JTextField txtWindSp;
    // End of variables declaration//GEN-END:variables
}
