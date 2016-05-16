/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.contentpanel.venues;
import events.IVenue;
import gui.MainJFrame;
import gui.RoundedBorder;
import gui.contentpanel.artists.ArtistTableModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import wrappers.DesktopWrapper;

/**
 *
 * @author 10512691
 */
public class PnlVenues extends javax.swing.JPanel {
    
    private MainJFrame parent = null;
    private List<IVenue> originalAllVenues;
    private List<IVenue> allVenues;
    private IVenue currVenue;


    /**
     * Creates new User panel
     * @param parent
     */
    public PnlVenues(MainJFrame parent) {
        
        initComponents();
        initButtons();
        this.parent = parent;
        
        lblLoadingIcon.setVisible(false);
        txtSearchBar.setBorder(new RoundedBorder());
        populateTable();
    }
    
    private void editable(boolean flag) {
        lblLoadingIcon.setVisible(!flag);
        btnEditArtist.setEnabled(flag);
        btnLoadMore.setEnabled(flag);
        btnNewArtist.setEnabled(flag);
        tableScrollPane.setEnabled(flag);
        tableVenues.setEnabled(flag);
        txtSearchBar.setEditable(flag);
    }
    
    public final void populateTable() {
        
        SwingWorker worker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                try {
                    allVenues = DesktopWrapper.getInstance().getVenues();
                    originalAllVenues = allVenues;

                    if(allVenues.size() > 0) {
                        VenueTableModel venueData = new VenueTableModel(allVenues, allVenues.size());
                        tableVenues.setModel(venueData);
                    }
                    
                    done();
                } 
                catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(PnlVenues.this, ex.getMessage());
                    done();
                }
                catch (IOException ex) {
                    JOptionPane.showMessageDialog(PnlVenues.this, "Error getting venues from the database. Please refresh.");
                    done();
                }
                
                return "";
            }
            
            protected void done() {
                editable(true);
            }
            
        };
        
        editable(false);
        worker.execute();
  
        
    }
    
    public void addVenue(IVenue venue) {
        DesktopWrapper.getInstance().addVenue(venue);
        populateTable();
    }
    
    public void setParent(MainJFrame parent) {
        this.parent = parent;
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
        btnNewArtist.setMaximumSize(new Dimension(75, 29));
        btnEditArtist.setMaximumSize(new Dimension(75, 29));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        txtSearchBar = new javax.swing.JTextField();
        tableScrollPane = new javax.swing.JScrollPane();
        tableVenues = new javax.swing.JTable();
        searchPnl = new javax.swing.JPanel();
        searchPnlLbl = new javax.swing.JLabel();
        btnNewArtist = new javax.swing.JButton();
        btnEditArtist = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        infoTextBox = new javax.swing.JTextArea();
        btnLoadMore = new javax.swing.JButton();
        lblLoadingIcon = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(51, 51, 51));

        txtSearchBar.setText("Search Venues...");
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

        tableVenues.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Email", "Address", "Postcode", "Phone No.", "Total Capacity", "More"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableVenues.setRowHeight(24);
        tableVenues.getTableHeader().setReorderingAllowed(false);
        tableVenues.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tableVenuesFocusLost(evt);
            }
        });
        tableVenues.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableVenuesMouseClicked(evt);
            }
        });
        tableScrollPane.setViewportView(tableVenues);
        if (tableVenues.getColumnModel().getColumnCount() > 0) {
            tableVenues.getColumnModel().getColumn(4).setResizable(false);
        }

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

        btnNewArtist.setText("New");
        btnNewArtist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewArtistActionPerformed(evt);
            }
        });

        btnEditArtist.setText("Edit");

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

        btnLoadMore.setText("Load More");
        btnLoadMore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoadMoreMouseClicked(evt);
            }
        });
        btnLoadMore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadMoreActionPerformed(evt);
            }
        });

        lblLoadingIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/loading_icon.gif"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(btnNewArtist)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLoadMore, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(lblLoadingIcon))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchPnl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEditArtist, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnNewArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnLoadMore, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addComponent(lblLoadingIcon, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchBarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchBarFocusLost
        txtSearchBar.setText("Search Venues...");
    }//GEN-LAST:event_txtSearchBarFocusLost

    private void txtSearchBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchBarMouseClicked
        if (txtSearchBar.getText().contains("Search Venues...")) {
            txtSearchBar.setText("");
        }
    }//GEN-LAST:event_txtSearchBarMouseClicked

    private void tableVenuesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVenuesMouseClicked
        // User can double click to open 'Edit' dialog.
        // Clicking once sets the current artist
        if (currVenue == null) {
            if (allVenues != null) {
                currVenue = allVenues.get(tableVenues.getSelectedRow());
                System.out.println(currVenue.getName());
            }
        } 
        // Clicking the same artist twice opens the dialog.
        else if (currVenue.equals(allVenues.get(tableVenues.getSelectedRow()))) {
            PnlEditVenue editPnl = new PnlEditVenue();
            editPnl.setVenue(currVenue);
            editPnl.setParent(this);
            editPnl.setVisible(true);
            editPnl.setAlwaysOnTop(true);
            currVenue = null;
        } else {
            // Clicking a different artist sets the current artist.
            if (allVenues != null) {
                currVenue = allVenues.get(tableVenues.getSelectedRow());
            } else {
                currVenue = null;
            }
        }
    }//GEN-LAST:event_tableVenuesMouseClicked

    private void tableVenuesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableVenuesFocusLost
        currVenue = null;
    }//GEN-LAST:event_tableVenuesFocusLost

    private void txtSearchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchBarActionPerformed
        String textToSearch = txtSearchBar.getText();        
        if(!textToSearch.equals(""))
        {
            try {
                System.out.println("Change");
              allVenues =  DesktopWrapper.getInstance().searchVenues(textToSearch);
              VenueTableModel model = new VenueTableModel(allVenues,allVenues.size());
              tableVenues.setModel(model);
            } catch (IOException ex) {
              System.out.println("Nah");

                allVenues = originalAllVenues;
              VenueTableModel model = new VenueTableModel(allVenues,allVenues.size());
              tableVenues.setModel(model);

            }
        }
        else
        {
               allVenues = originalAllVenues;
              VenueTableModel model = new VenueTableModel(allVenues,allVenues.size());
              tableVenues.setModel(model);
              System.out.println("nope");


        }
    }//GEN-LAST:event_txtSearchBarActionPerformed

    private void btnNewArtistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewArtistActionPerformed
        PnlNewVenue newPnl = new PnlNewVenue();
        newPnl.setParent(this);
        newPnl.setVisible(true);
        newPnl.setAlwaysOnTop(true);
    }//GEN-LAST:event_btnNewArtistActionPerformed

    private void btnLoadMoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoadMoreMouseClicked
    
        SwingWorker worker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                try {
                    allVenues =  DesktopWrapper.getInstance().loadMoreVenues();
                    allVenues =  DesktopWrapper.getInstance().getVenues();
                    tableVenues.setModel(new DefaultTableModel());
                    VenueTableModel venueData = new VenueTableModel(allVenues, allVenues.size());
                    tableVenues.setModel(venueData);
                    done();

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(PnlVenues.this, "Unable To Load More Venues");
                    done();
                }
                
                return "";
            }
            
            @Override
            protected void done() {
                editable(true);
            }
        };
        editable(false);
        worker.execute();
    }//GEN-LAST:event_btnLoadMoreMouseClicked

    private void btnLoadMoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadMoreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLoadMoreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditArtist;
    private javax.swing.JButton btnLoadMore;
    private javax.swing.JButton btnNewArtist;
    private javax.swing.JTextArea infoTextBox;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLoadingIcon;
    private javax.swing.JPanel searchPnl;
    private javax.swing.JLabel searchPnlLbl;
    private javax.swing.JScrollPane tableScrollPane;
    private javax.swing.JTable tableVenues;
    private javax.swing.JTextField txtSearchBar;
    // End of variables declaration//GEN-END:variables

}

