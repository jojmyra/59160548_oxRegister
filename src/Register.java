
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.mongodb.*;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.eq;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.bson.Document;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jo
 */
public class Register extends javax.swing.JFrame {

    MongoClientURI uri  = new MongoClientURI("mongodb://admin:admin123456@ds263832.mlab.com:63832/59160548_ox");
    MongoClient client = new MongoClient((List<ServerAddress>) uri);
    MongoDatabase db = client.getDatabase(uri.getDatabase());
    
    /**
     * Creates new form Register
     */
    public Register() {
        initComponents();
        

    }
    // เอาไว้เช็คไอดีซ้ำ
    public static boolean booleancheckID = false;
    
    public void submitRegister(){
        
      
        MongoCollection<Document> user = db.getCollection("user");
        
        List<Document> seedData = new ArrayList<Document>();

        seedData.add(new Document("ID",tx_id.getText())
                .append("Pass", tx_pass.getText())
                .append("Name", tx_Name.getText())
                .append("AvatarID", tx_avatar.getText())

               
        );
        user.insertMany(seedData);
            JLabel label = new JLabel("Register successfully");
            label.setFont(new Font("TH Sarabun New", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this, label);
        
        client.close(); 
    }
    
    public boolean checkrepass(){
        if(tx_pass.getText().equals(tx_repass.getText())){
            System.out.println("duplicate");
            return true;
        }else {
            return false;
        }
    }
    
    
    public void checkID(){
        
        MongoCollection<Document> user = db.getCollection("user");
       
        try {
            
            Document myDoc = user.find(eq("ID", tx_id.getText())).first();
            System.out.println(myDoc.toJson());
            booleancheckID = true;
            
        } catch (Exception e) {
            System.out.println("doesn't duplication");
            //ดักไอดีซ้ำและคืนค่า Boolean
            booleancheckID = false;
        }      
    }
    public boolean checkEmpty(){
        if(tx_id.getText().equals("")||tx_pass.getText().equals("")||tx_Name.getText().equals("")){
           
            return true;
        }else {
            return false;
        }     
    }
    
    public void reset(){
        tx_Name.setText("");
        tx_id.setText("");
        tx_pass.setText("");
        tx_repass.setText("");
        tx_avatar.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tx_repass = new javax.swing.JPasswordField();
        btn_Avatar1 = new javax.swing.JButton();
        btn_Avatar2 = new javax.swing.JButton();
        btn_Avatar4 = new javax.swing.JButton();
        btn_Avatar3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tx_avatar = new javax.swing.JTextField();
        tx_id = new javax.swing.JTextField();
        tx_Name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tx_pass = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        btn_submmit = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tx_repass.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N

        btn_Avatar1.setBorder(null);
        btn_Avatar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Avatar1ActionPerformed(evt);
            }
        });

        btn_Avatar2.setBorder(null);

        btn_Avatar4.setBorder(null);

        btn_Avatar3.setBorder(null);

        jLabel5.setFont(new java.awt.Font("TH Sarabun New", 1, 36)); // NOI18N
        jLabel5.setText("Avatar            :");

        tx_avatar.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N

        tx_id.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N

        tx_Name.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("TH Sarabun New", 1, 36)); // NOI18N
        jLabel1.setText("User               :");

        jLabel2.setFont(new java.awt.Font("TH Sarabun New", 1, 36)); // NOI18N
        jLabel2.setText("Pass               :");

        jLabel3.setFont(new java.awt.Font("TH Sarabun New", 1, 36)); // NOI18N
        jLabel3.setText("Name             :");

        tx_pass.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("TH Sarabun New", 1, 36)); // NOI18N
        jLabel4.setText("ConfirmPass :");

        btn_submmit.setText("Register");
        btn_submmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submmitActionPerformed(evt);
            }
        });

        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(btn_Avatar1)
                        .addGap(70, 70, 70)
                        .addComponent(btn_Avatar2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tx_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tx_avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tx_repass, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tx_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tx_id, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_submmit, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(btn_Avatar3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Avatar4)
                        .addGap(72, 72, 72))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tx_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tx_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tx_repass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(tx_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tx_avatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Avatar1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_Avatar2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_Avatar3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_Avatar4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_submmit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_Avatar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Avatar1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_Avatar1ActionPerformed

    private void btn_submmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submmitActionPerformed
        // TODO add your handling code here:
        checkrepass();
        checkID();
        checkEmpty();
        checkrepass();
        if(booleancheckID){
            JLabel label = new JLabel("Id exist!");
            label.setFont(new Font("TH Sarabun New", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);

            reset();
        }else{
            if(checkEmpty()){
                JLabel label = new JLabel("Please fill all information!");
                label.setFont(new Font("TH Sarabun New", Font.BOLD, 18));
                JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                reset();

            }else if(!checkEmpty()){
                if(!checkrepass()){
                    JLabel label = new JLabel("Password doesn't match!");
                    label.setFont(new Font("TH Sarabun New", Font.BOLD, 18));
                    JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                    reset();
                }
                else{
                    submitRegister();
                    reset();
                }

            }
        }
    }//GEN-LAST:event_btn_submmitActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Avatar1;
    private javax.swing.JButton btn_Avatar2;
    private javax.swing.JButton btn_Avatar3;
    private javax.swing.JButton btn_Avatar4;
    private javax.swing.JButton btn_submmit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField tx_Name;
    private javax.swing.JTextField tx_avatar;
    private javax.swing.JTextField tx_id;
    private javax.swing.JPasswordField tx_pass;
    private javax.swing.JPasswordField tx_repass;
    // End of variables declaration//GEN-END:variables
}
