/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.contentpanel.admins;

import database.DatabaseTable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import people.Admin;
import people.IAdmin;
import wrappers.DesktopWrapper;

/**
 *
 * @author 10512691
 */
public class PnlNewAdmin extends javax.swing.JFrame {

    private static PnlAdmins parent;
    
    /**
     * Creates new form PnlNewAdminNew
     * @param parent
     */
    public PnlNewAdmin(PnlAdmins parent) {
        
        initComponents();
        PnlNewAdmin.parent = parent;
        loading_icon_lbl.setVisible(false);
        initHelp();
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
    }
    
    private void initHelp() {
        helpEmail.setToolTipText("The email address for the admin account.");
        helpPassword.setToolTipText("Enter the password for the account.");
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground2 = new javax.swing.JPanel();
        lblEmail = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblDetailsTitle = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        helpEmail = new javax.swing.JLabel();
        helpPassword = new javax.swing.JLabel();
        lblPasswordReEnter = new javax.swing.JLabel();
        txtPasswordCheck = new javax.swing.JPasswordField();
        txtPassword = new javax.swing.JPasswordField();
        loading_icon_lbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlBackground2.setBackground(new java.awt.Color(51, 51, 51));

        lblEmail.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("Email:");

        lblPassword.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword.setText("Password:");

        txtEmail.setBackground(new java.awt.Color(51, 51, 51));
        txtEmail.setForeground(new java.awt.Color(250, 250, 250));

        lblDetailsTitle.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        lblDetailsTitle.setForeground(new java.awt.Color(250, 250, 250));
        lblDetailsTitle.setText("Admin Details");

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        helpEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/helpIconNew.png"))); // NOI18N

        helpPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/helpIconNew.png"))); // NOI18N

        lblPasswordReEnter.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        lblPasswordReEnter.setForeground(new java.awt.Color(255, 255, 255));
        lblPasswordReEnter.setText("Re-Enter:");

        txtPasswordCheck.setText("password");
        txtPasswordCheck.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPasswordCheckMousePressed(evt);
            }
        });

        txtPassword.setText("password");
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPasswordMousePressed(evt);
            }
        });

        loading_icon_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/loading_icon.gif"))); // NOI18N

        javax.swing.GroupLayout pnlBackground2Layout = new javax.swing.GroupLayout(pnlBackground2);
        pnlBackground2.setLayout(pnlBackground2Layout);
        pnlBackground2Layout.setHorizontalGroup(
            pnlBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackground2Layout.createSequentialGroup()
                .addGroup(pnlBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlBackground2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBackground2Layout.createSequentialGroup()
                                .addComponent(lblPasswordReEnter)
                                .addGap(18, 18, 18)
                                .addComponent(txtPasswordCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 53, Short.MAX_VALUE))
                            .addGroup(pnlBackground2Layout.createSequentialGroup()
                                .addComponent(lblPassword)
                                .addGap(14, 14, 14)
                                .addGroup(pnlBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEmail)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(helpPassword))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackground2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblDetailsTitle)
                                .addGap(135, 135, 135))))
                    .addGroup(pnlBackground2Layout.createSequentialGroup()
                        .addComponent(loading_icon_lbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBackground2Layout.createSequentialGroup()
                        .addComponent(lblEmail)
                        .addGap(315, 315, 315)
                        .addComponent(helpEmail)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        pnlBackground2Layout.setVerticalGroup(
            pnlBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackground2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(lblDetailsTitle)
                .addGap(18, 18, 18)
                .addGroup(pnlBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEmail)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(helpEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(pnlBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(helpPassword)
                    .addGroup(pnlBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPassword)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPasswordReEnter)
                    .addComponent(txtPasswordCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackground2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(pnlBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave)
                            .addComponent(btnCancel))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackground2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loading_icon_lbl))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed

        int dialog = JOptionPane.showConfirmDialog(this, "Are you sure you want to cancel?", "Confirm", JOptionPane.OK_CANCEL_OPTION);
        if (dialog == JOptionPane.OK_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
        if (txtPassword.getText().equals(txtPasswordCheck.getText())) {
        
            int result = JOptionPane.showConfirmDialog(this, "Are you ready to save? Changes will immediately become live.", "Save Artist", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {

                loading_icon_lbl.setVisible(true);
                txtEmail.setEditable(false);
                txtPassword.setEditable(false);
                txtPasswordCheck.setEditable(false);
                btnSave.setEnabled(false);
                String email = txtEmail.getText();

                SwingWorker<String, Object> worker = new SwingWorker() {
                    
                    @Override
                    protected Object doInBackground() {
                        
                        try {
                            IAdmin admin = new Admin("ADMIN", "ADMIN", email, txtPassword.getText());
                            admin = (IAdmin) DesktopWrapper.getInstance().createNewObject(admin, DatabaseTable.ADMIN);
                            DesktopWrapper.getInstance().addAdmin(admin);
                            dispose();
                            parent.populateTable();
                            parent.displayText("Success! Admin account created for: " + admin.getEmail());
                            done();
                        } 
                        catch (IOException ex) {
                            JOptionPane.showMessageDialog(PnlNewAdmin.this, "Error connecting to database. Please try again.");
                            done();
                        }
                        catch (IllegalArgumentException ex) {
                            JOptionPane.showMessageDialog(PnlNewAdmin.this, ex.getMessage());
                            done();
                        }
                        
                        return "";
                    }

                    @Override
                    protected void done() {
                        loading_icon_lbl.setVisible(false);
                        txtEmail.setEditable(true);
                        txtPassword.setEditable(true);
                        txtPasswordCheck.setEditable(true);
                        btnSave.setEnabled(true);
                    }
                };
                
                worker.execute();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Passwords do not match. Please try again.");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMousePressed
        txtPassword.setText("");
    }//GEN-LAST:event_txtPasswordMousePressed

    private void txtPasswordCheckMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordCheckMousePressed
        txtPasswordCheck.setText("");
    }//GEN-LAST:event_txtPasswordCheckMousePressed

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
            java.util.logging.Logger.getLogger(PnlNewAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PnlNewAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PnlNewAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PnlNewAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PnlNewAdmin(parent).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel helpEmail;
    private javax.swing.JLabel helpPassword;
    private javax.swing.JLabel lblDetailsTitle;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPasswordReEnter;
    private javax.swing.JLabel loading_icon_lbl;
    private javax.swing.JPanel pnlBackground2;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPasswordCheck;
    // End of variables declaration//GEN-END:variables
}