/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.contentpanel.artists;

import events.IArtist;
import gui.MainJFrame;
import gui.RoundedBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import wrappers.DesktopWrapper;

/**
 *
 * @author 10512691
 */
public class PnlArtists extends javax.swing.JPanel {
    
    private MainJFrame parent = null;
    
    private List<IArtist> allArtists;
    private List<IArtist> originalAllArtists;
    private IArtist curArtist;

    /**
     * Creates new Artist panel
     * @param parent
     */
    public PnlArtists(MainJFrame parent) {
        this.parent = parent;
        
        initComponents();
        initButtons();
        populateTable();
        
        lblLoadingIcon.setVisible(false);
        txtSearchBar.setBorder(new RoundedBorder());
    }
    
    private void initButtons() {
        btnNewArtist.setMaximumSize(new Dimension(75, 29));
        btnEditArtist.setMaximumSize(new Dimension(75, 29));
    }
    
    private void editable(boolean flag) {
        lblLoadingIcon.setVisible(!flag);
        btnEditArtist.setEnabled(flag);
        btnLoadMore.setEnabled(flag);
        btnNewArtist.setEnabled(flag);
        tableArtists.setEnabled(flag);
        tableScrollPane.setEnabled(flag);
    }
    
    public void populateTable() {
        
        SwingWorker worker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                try {
                    allArtists = new ArrayList (DesktopWrapper.getInstance().refreshArtists());
                    originalAllArtists = allArtists;
                    if (allArtists.size() > 0) {

                        // Creates a table model
                        TableModel artistData = new ArtistTableModel(allArtists, allArtists.size());

                        tableArtists.setModel(artistData);
                        done();
                    }
                } catch (IOException e) {
                    originalAllArtists = new ArrayList<>();
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
        tableArtists = new javax.swing.JTable();
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

        txtSearchBar.setText("Search Artists...");
        txtSearchBar.setAutoscrolls(false);
        txtSearchBar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtSearchBar.setPreferredSize(new java.awt.Dimension(105, 30));
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
        txtSearchBar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtSearchBarPropertyChange(evt);
            }
        });
        txtSearchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchBarKeyTyped(evt);
            }
        });

        tableArtists.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Description", "Tags", "More"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableArtists.setRowHeight(24);
        tableArtists.setShowVerticalLines(false);
        tableArtists.getTableHeader().setReorderingAllowed(false);
        tableArtists.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableArtistsMouseClicked(evt);
            }
        });
        tableScrollPane.setViewportView(tableArtists);
        if (tableArtists.getColumnModel().getColumnCount() > 0) {
            tableArtists.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableArtists.getColumnModel().getColumn(3).setHeaderValue("More");
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
        btnEditArtist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditArtistActionPerformed(evt);
            }
        });

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
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(txtSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 778, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(btnNewArtist)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLoadMore)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLoadingIcon))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(10, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(txtSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(searchPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNewArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLoadMore, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addComponent(lblLoadingIcon, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchBarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchBarFocusLost
        txtSearchBar.setText("Search Artists...");
    }//GEN-LAST:event_txtSearchBarFocusLost

    private void txtSearchBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchBarMouseClicked
        if (txtSearchBar.getText().contains("Search Artists...")) {
            txtSearchBar.setText("");
        }
    }//GEN-LAST:event_txtSearchBarMouseClicked

    private void tableArtistsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableArtistsMouseClicked
        // User can double click to open 'Edit' dialog.
        // Clicking once sets the current artist
        if (curArtist == null) {
            if (allArtists != null) {
                curArtist = allArtists.get(tableArtists.getSelectedRow());
            }
        } 
        // Clicking the same artist twice opens the dialog.
        else if (curArtist.equals(allArtists.get(tableArtists.getSelectedRow()))) {
            PnlEditArtist editPnl = new PnlEditArtist();
            editPnl.setArtist(curArtist);
            editPnl.setParent(this);
            editPnl.setVisible(true);
            curArtist = null;
        } else {
            // Clicking a different artist sets the current artist.
            if (allArtists != null) {
                curArtist = allArtists.get(tableArtists.getSelectedRow());
            }
        }
    }//GEN-LAST:event_tableArtistsMouseClicked

    private void btnNewArtistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewArtistActionPerformed
        PnlNewArtist newPnl = new PnlNewArtist();
        newPnl.setParent(this);
        newPnl.setVisible(true);
        newPnl.setAlwaysOnTop(true);
    }//GEN-LAST:event_btnNewArtistActionPerformed

    private void btnEditArtistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditArtistActionPerformed
        
        if (allArtists != null) {
            if (curArtist != null) {
                PnlEditArtist editPnl = new PnlEditArtist();
                editPnl.setArtist(curArtist);
                editPnl.setParent(this);
                editPnl.setVisible(true);
                editPnl.setAlwaysOnTop(true);
                curArtist = null;
            }
        }
    }//GEN-LAST:event_btnEditArtistActionPerformed

    private void txtSearchBarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtSearchBarPropertyChange
      
    }//GEN-LAST:event_txtSearchBarPropertyChange

    private void txtSearchBarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchBarKeyTyped
        
    }//GEN-LAST:event_txtSearchBarKeyTyped

    private void txtSearchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchBarActionPerformed
        
        SwingWorker worker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                String textToSearch = txtSearchBar.getText();        
                if (!textToSearch.equals("")) {
                    try {
                        allArtists =  DesktopWrapper.getInstance().searchArtists(textToSearch);
                        done();
                    } 
                    catch (IOException ex) {
                        allArtists = originalAllArtists;
                        done();

                    }
                }
                else {
                    allArtists = originalAllArtists;
                    done();
                }
                
                return "";
            }
            
            @Override
            protected void done() {
                ArtistTableModel model = new ArtistTableModel(allArtists,allArtists.size());
                tableArtists.setModel(model);
                editable(true);
            }
            
        };
        
        editable(false);
        worker.execute();
    }//GEN-LAST:event_txtSearchBarActionPerformed

    private void btnLoadMoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoadMoreMouseClicked
        
        SwingWorker worker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                try {
                    allArtists = DesktopWrapper.getInstance().loadMoreArtists();
                    allArtists = DesktopWrapper.getInstance().getArtists();
                    tableArtists.setModel(new DefaultTableModel());
                    ArtistTableModel artistData = new ArtistTableModel(allArtists, allArtists.size());
                    tableArtists.setModel(artistData);
                    done();

                } 
                catch (IOException ex) {
                    JOptionPane.showMessageDialog(PnlArtists.this, "Unable To Load More Artists");
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
    private javax.swing.JTable tableArtists;
    private javax.swing.JScrollPane tableScrollPane;
    private javax.swing.JTextField txtSearchBar;
    // End of variables declaration//GEN-END:variables

}
