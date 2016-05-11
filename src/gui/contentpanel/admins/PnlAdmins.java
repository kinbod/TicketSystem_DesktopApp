/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.contentpanel.admins;

import gui.Home;
import gui.RoundedBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import people.IAdmin;
import wrappers.DesktopWrapper;

/**
 *
 * @author 10512691
 */
public class PnlAdmins extends javax.swing.JPanel {

    private Home parent = null;
    private List<IAdmin> allAdmins;
    private List<IAdmin> originalAllAdmins;
    private IAdmin currAdmin;
    
    /**
     * Creates new form PnlAdminsNew
     */
    public PnlAdmins(Home parent) {
        
        initComponents();
        initButtons();
        this.parent = parent;
        
        txtSearchBar.setBorder(new RoundedBorder());
        populateTable();
    }
    
    /**
     * Displays a message that fades out after 2 seconds.
     * Use for notifying user.
     * @param text Must be less than 30 characters.
     */
    public void displayText(String text) {
        infoTextBox.setForeground(new Color(251,251,251));
        infoTextBox.setText(text);

        Timer t = new Timer(50, null);

        ActionListener fadeDown = new ActionListener() {

            Color c = infoTextBox.getForeground();
            int rgb = c.getBlue();

            @Override
            public void actionPerformed(ActionEvent e) {
                if (rgb > 51) {
                    rgb -= 5;
                    infoTextBox.setForeground(new Color(rgb, rgb, rgb));
                }
                else {
                    infoTextBox.setText("");
                    t.stop();
                }
            }
        };
        t.addActionListener(fadeDown);
        t.setInitialDelay(5000);
        t.start();
    }
    
    private void initButtons() {
        btnNewAdmin.setMaximumSize(new Dimension(75, 29));
        btnDeleteAdmin.setMaximumSize(new Dimension(75, 29));
        btnEditAdmin.setMaximumSize(new Dimension(75, 29));
    }
    
    public final void populateTable() {
  
        try {
            allAdmins = DesktopWrapper.getInstance().getAdmins();
            originalAllAdmins = allAdmins;

            
            if(allAdmins.size() > 0) {
                AdminTableModel adminData = new AdminTableModel(allAdmins, allAdmins.size());
                tableAdmins.setModel(adminData);
            }
        } 
        catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error connecting to the database. Please try again.");
        }
        catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        txtSearchBar = new javax.swing.JTextField();
        tableScrollPane = new javax.swing.JScrollPane();
        tableAdmins = new javax.swing.JTable();
        searchPnl = new javax.swing.JPanel();
        searchPnlLbl = new javax.swing.JLabel();
        btnNewAdmin = new javax.swing.JButton();
        btnEditAdmin = new javax.swing.JButton();
        btnDeleteAdmin = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        infoTextBox = new javax.swing.JTextArea();
        bntLoadMore = new javax.swing.JButton();

        pnlBackground.setBackground(new java.awt.Color(51, 51, 51));

        txtSearchBar.setText("Search Admins...");
        txtSearchBar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtSearchBar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchBarFocusLost(evt);
            }
        });
        txtSearchBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchBarMouseClicked(evt);
            }
        });
        txtSearchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchBarActionPerformed(evt);
            }
        });

        tableAdmins.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableAdmins.setRowHeight(24);
        tableAdmins.getTableHeader().setReorderingAllowed(false);
        tableAdmins.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tableAdminsFocusLost(evt);
            }
        });
        tableAdmins.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAdminsMouseClicked(evt);
            }
        });
        tableScrollPane.setViewportView(tableAdmins);

        searchPnl.setBackground(new java.awt.Color(51, 51, 51));

        searchPnlLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/search.png"))); // NOI18N

        javax.swing.GroupLayout searchPnlLayout = new javax.swing.GroupLayout(searchPnl);
        searchPnl.setLayout(searchPnlLayout);
        searchPnlLayout.setHorizontalGroup(
            searchPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchPnlLbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        searchPnlLayout.setVerticalGroup(
            searchPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchPnlLbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnNewAdmin.setText("New");
        btnNewAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewAdminActionPerformed(evt);
            }
        });

        btnEditAdmin.setText("<html><center>Edit<br>Password</center></html>");
        btnEditAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditAdminActionPerformed(evt);
            }
        });

        btnDeleteAdmin.setText("Delete");
        btnDeleteAdmin.setMaximumSize(new java.awt.Dimension(75, 29));
        btnDeleteAdmin.setMinimumSize(new java.awt.Dimension(75, 29));
        btnDeleteAdmin.setPreferredSize(new java.awt.Dimension(75, 29));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        infoTextBox.setEditable(false);
        infoTextBox.setBackground(new java.awt.Color(51, 51, 51));
        infoTextBox.setColumns(20);
        infoTextBox.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        infoTextBox.setLineWrap(true);
        infoTextBox.setRows(5);
        infoTextBox.setWrapStyleWord(true);
        infoTextBox.setAutoscrolls(false);
        infoTextBox.setDragEnabled(false);
        jScrollPane1.setViewportView(infoTextBox);

        bntLoadMore.setText("Load More");
        bntLoadMore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntLoadMoreMouseClicked(evt);
            }
        });
        bntLoadMore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLoadMoreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap(101, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(btnNewAdmin)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bntLoadMore)
                        .addGap(7, 7, 7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchPnl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNewAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnDeleteAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bntLoadMore, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(btnEditAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 881, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlBackground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchBarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchBarFocusLost
        txtSearchBar.setText("Search Customers...");
    }//GEN-LAST:event_txtSearchBarFocusLost

    private void txtSearchBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchBarMouseClicked
        if (txtSearchBar.getText().contains("Search Customers...")) {
            txtSearchBar.setText("");
        }
    }//GEN-LAST:event_txtSearchBarMouseClicked

    private void txtSearchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchBarActionPerformed
        //        String textToSearch = txtSearchBar.getText();
        //        if(!textToSearch.equals(""))
        //        {
            //            try {
                //                System.out.println("Change");
                //               allAdmins =  DesktopWrapper.getInstance().searchAdmins(textToSearch);
                //               tableAdmins.setModel(new AdminTableModel(allAdmins, allAdmins.size()));
                //            } catch (IOException ex) {
                //               System.out.println("Couldn't pull admin data from database. Please try again.");
                //
                //               allAdmins = originalAllAdmins;
                //               tableAdmins.setModel(new AdminTableModel(allAdmins, allAdmins.size()));
                //            }
            //        }
        //        else
        //        {
            //            allAdmins = originalAllAdmins;
            //            tableAdmins.setModel(new AdminTableModel(allAdmins, allAdmins.size()));
            //            System.out.println("nope");
            //        }
    }//GEN-LAST:event_txtSearchBarActionPerformed

    private void tableAdminsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableAdminsFocusLost

    }//GEN-LAST:event_tableAdminsFocusLost

    private void tableAdminsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAdminsMouseClicked
        // User can double click to open 'Edit' dialog.
        // Clicking once sets the current artist
        if (currAdmin == null) {
            if (allAdmins != null) {
                currAdmin = allAdmins.get(tableAdmins.getSelectedRow());
            }
        }
        // Clicking the same artist twice opens the dialog.
        else if (currAdmin.equals(allAdmins.get(tableAdmins.getSelectedRow()))) {
                        PnlEditAdmin editPnl = new PnlEditAdmin(this, currAdmin);
                        editPnl.setVisible(true);
                        editPnl.setAlwaysOnTop(true);
                        currAdmin = null;
        } else {
            // Clicking a different artist sets the current artist.
            if (allAdmins != null) {
                currAdmin = allAdmins.get(tableAdmins.getSelectedRow());
            } else {
                currAdmin = null;
            }
        }
    }//GEN-LAST:event_tableAdminsMouseClicked

    private void btnNewAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewAdminActionPerformed
        PnlNewAdmin newPnl = new PnlNewAdmin(this);
        newPnl.setVisible(true);
        newPnl.setAlwaysOnTop(true);
    }//GEN-LAST:event_btnNewAdminActionPerformed

    private void btnEditAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditAdminActionPerformed
        if (currAdmin == null)
            JOptionPane.showMessageDialog(this, "No admin selected!");
        else {
            PnlEditAdmin editPnl = new PnlEditAdmin(this, currAdmin);
            editPnl.setVisible(true);
            editPnl.setAlwaysOnTop(true);
        }
    }//GEN-LAST:event_btnEditAdminActionPerformed

    private void bntLoadMoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLoadMoreActionPerformed
             System.out.println("Clicked");
        try {
            allAdmins = DesktopWrapper.getInstance().loadMoreAdmins();
            allAdmins = DesktopWrapper.getInstance().getAdmins();
            System.out.println(allAdmins.size() + "Size");
            AdminTableModel adminData = new AdminTableModel(allAdmins, allAdmins.size());
            tableAdmins.setModel(new DefaultTableModel());
            tableAdmins.setModel(adminData);
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Unable To Load More Admins");
        }
    }//GEN-LAST:event_bntLoadMoreActionPerformed

    private void bntLoadMoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntLoadMoreMouseClicked
   
    }//GEN-LAST:event_bntLoadMoreMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntLoadMore;
    private javax.swing.JButton btnDeleteAdmin;
    private javax.swing.JButton btnEditAdmin;
    private javax.swing.JButton btnNewAdmin;
    private javax.swing.JTextArea infoTextBox;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel searchPnl;
    private javax.swing.JLabel searchPnlLbl;
    private javax.swing.JTable tableAdmins;
    private javax.swing.JScrollPane tableScrollPane;
    private javax.swing.JTextField txtSearchBar;
    // End of variables declaration//GEN-END:variables
}
