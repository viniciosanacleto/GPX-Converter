/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import code.GpxConverter;
import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Vinicios
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public String filePath;
    public java.io.File file;
    private Scanner s;
    private ArrayList<String> lines = new ArrayList<String>();
    
    public Main() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btBrowse = new javax.swing.JButton();
        txtPath = new javax.swing.JTextField();
        btConvert = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTxt = new javax.swing.JTextArea();
        menuBar = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menuExit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GPX Converter");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("File in TXT:");

        btBrowse.setText("Browse");
        btBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBrowseActionPerformed(evt);
            }
        });

        txtPath.setEditable(false);

        btConvert.setText("Convert to GPX");
        btConvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConvertActionPerformed(evt);
            }
        });

        areaTxt.setEditable(false);
        areaTxt.setColumns(20);
        areaTxt.setRows(5);
        jScrollPane1.setViewportView(areaTxt);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/file.png"))); // NOI18N
        jMenu3.setText("File");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/open.png"))); // NOI18N
        jMenuItem1.setText("Choose File");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/convert.png"))); // NOI18N
        jMenuItem2.setText("Convert to GPX");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        menuBar.add(jMenu3);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/info.png"))); // NOI18N
        jMenu1.setText("About");
        menuBar.add(jMenu1);

        menuExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exit.png"))); // NOI18N
        menuExit.setText("Exit");
        menuBar.add(menuExit);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btBrowse))
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btConvert)
                .addGap(119, 119, 119))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBrowse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btConvert))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBrowseActionPerformed
        // TODO add your handling code here:
                
        JFileChooser filechooser = new JFileChooser();        
        if(filechooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            file = filechooser.getSelectedFile();
            filePath = file.getPath();            
            txtPath.setText(filePath);
            
            //OPEN FILE
            try{
                s = new Scanner(new File(filePath));                
            }catch(Exception e){
                System.out.println("Could not open file");
            }
            //READ FILE
            for(int i=0;s.hasNext();i++){
                String a = s.next();
                lines.add(a);                
            }            
            //WRITE ON TEXT AREA
            for(int i=0;i<lines.size();i++){
                areaTxt.append(lines.get(i));
                areaTxt.append("\n");
            }         
            
        }
        
    }//GEN-LAST:event_btBrowseActionPerformed

    private void btConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConvertActionPerformed
        // TODO add your handling code here:        
        String path;        
        JFileChooser filechooser = new JFileChooser();
        if(filechooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
            path = filechooser.getCurrentDirectory().toString()+"\\"+filechooser.getSelectedFile().getName()+".gpx";            
            try{
                GpxConverter gpx = new GpxConverter(lines,path);
            }catch(Exception e){
                System.out.println(e.toString());
            }
        }
               
    }//GEN-LAST:event_btConvertActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        btBrowseActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        btConvertActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTxt;
    private javax.swing.JButton btBrowse;
    private javax.swing.JButton btConvert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuExit;
    private javax.swing.JTextField txtPath;
    // End of variables declaration//GEN-END:variables
}
