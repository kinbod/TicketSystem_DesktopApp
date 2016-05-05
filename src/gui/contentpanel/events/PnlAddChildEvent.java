/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.contentpanel.events;

import database.DatabaseTable;
import events.ChildEvent;
import events.IArtist;
import events.IChildEvent;
import events.IParentEvent;
import events.IVenue;
import gui.ObjectSelectDialog;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerDateModel;
import wrappers.DesktopWrapper;

/**
 *
 * @author 10512691
 */
public class PnlAddChildEvent extends javax.swing.JFrame {

    private PnlEvents parent;
    private final int descLength = 500;
    private IParentEvent parentEvent;
    private IVenue venue;
    private List<IArtist> artists;
    DefaultListModel listModel;
    /**
     * Creates new form PnlEditArtist
     */
    public PnlAddChildEvent() {
        listModel = new DefaultListModel();
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
    }
    
    public void setParentEvent(IParentEvent parentEvent) {
        this.parentEvent = parentEvent;
        populateLineup();
        initPanel();
    }
    public void setVenue(IVenue venue)
    {
        if(venue!=null)
        {
            this.venue = venue; 
            txtVenue.setText(venue.getName());
        }else
        {
            throw new NullPointerException();
        }
    }
    
    public void setParent(PnlEvents parent) {
        this.parent = parent;
    }

    private void initPanel() {
       txtParentName.setText(parentEvent.getName());
       lblDescriptionRemaining.setText(descLength + " characters remaining");
          }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        lblDescriptionRemaining = new javax.swing.JLabel();
        jSeparator = new javax.swing.JSeparator();
        lblDetailsTitle = new javax.swing.JLabel();
        btnSelectVenue = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        lblName1 = new javax.swing.JLabel();
        lblName2 = new javax.swing.JLabel();
        lblName3 = new javax.swing.JLabel();
        txtParentName = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstLineup = new javax.swing.JList<>();
        lblDetailsTitle1 = new javax.swing.JLabel();
        lblName4 = new javax.swing.JLabel();
        txtVenue = new javax.swing.JTextField();
        btnCancel1 = new javax.swing.JButton();
        lblAddArtist = new javax.swing.JLabel();
        lblRemoveArtist = new javax.swing.JLabel();
        spnStartTime = new javax.swing.JSpinner();
        spnEndTime = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));

        pnlBackground.setBackground(new java.awt.Color(51, 51, 51));

        lblName.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setText("Name:");

        lblDescription.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        lblDescription.setForeground(new java.awt.Color(255, 255, 255));
        lblDescription.setText("Description:");

        txtName.setBackground(new java.awt.Color(51, 51, 51));
        txtName.setForeground(new java.awt.Color(250, 250, 250));

        jScrollPane1.setBackground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setForeground(new java.awt.Color(250, 250, 250));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtDescription.setBackground(new java.awt.Color(51, 51, 51));
        txtDescription.setColumns(1);
        txtDescription.setForeground(new java.awt.Color(250, 250, 250));
        txtDescription.setLineWrap(true);
        txtDescription.setRows(5);
        txtDescription.setWrapStyleWord(true);
        txtDescription.setCaretColor(new java.awt.Color(250, 250, 250));
        txtDescription.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtDescription.setSelectedTextColor(new java.awt.Color(250, 250, 250));
        txtDescription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescriptionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtDescription);

        lblDescriptionRemaining.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        lblDescriptionRemaining.setForeground(new java.awt.Color(255, 0, 0));
        lblDescriptionRemaining.setText("500 characters remaining");

        jSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator.setToolTipText("");

        lblDetailsTitle.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        lblDetailsTitle.setForeground(new java.awt.Color(250, 250, 250));
        lblDetailsTitle.setText("Child Event Details");

        btnSelectVenue.setText("Select Venue");
        btnSelectVenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectVenueActionPerformed(evt);
            }
        });

        btnSave.setText("Add");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        lblName1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        lblName1.setForeground(new java.awt.Color(255, 255, 255));
        lblName1.setText("Parent Event :");

        lblName2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        lblName2.setForeground(new java.awt.Color(255, 255, 255));
        lblName2.setText("Start Time");

        lblName3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        lblName3.setForeground(new java.awt.Color(255, 255, 255));
        lblName3.setText("End Time");

        txtParentName.setEditable(false);
        txtParentName.setBackground(new java.awt.Color(51, 51, 51));
        txtParentName.setForeground(new java.awt.Color(250, 250, 250));

        lstLineup.setModel(listModel);
        jScrollPane2.setViewportView(lstLineup);

        lblDetailsTitle1.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        lblDetailsTitle1.setForeground(new java.awt.Color(250, 250, 250));
        lblDetailsTitle1.setText("Lineup");

        lblName4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        lblName4.setForeground(new java.awt.Color(255, 255, 255));
        lblName4.setText("Event Venue");

        txtVenue.setBackground(new java.awt.Color(51, 51, 51));
        txtVenue.setForeground(new java.awt.Color(250, 250, 250));

        btnCancel1.setText("Cancel");
        btnCancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancel1ActionPerformed(evt);
            }
        });

        lblAddArtist.setForeground(new java.awt.Color(251, 251, 251));
        lblAddArtist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/addIcon.png"))); // NOI18N
        lblAddArtist.setText("Add Artist");
        lblAddArtist.setToolTipText("");
        lblAddArtist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddArtistMouseClicked(evt);
            }
        });

        lblRemoveArtist.setForeground(new java.awt.Color(250, 250, 250));
        lblRemoveArtist.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblRemoveArtist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/removeIcon.png"))); // NOI18N
        lblRemoveArtist.setText(" Remove Artist");
        lblRemoveArtist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRemoveArtistMouseClicked(evt);
            }
        });

        spnStartTime.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1462273200000L), new java.util.Date(1462273200000L), null, java.util.Calendar.DAY_OF_MONTH));

        spnEndTime.setModel(new javax.swing.SpinnerDateModel());

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(lblDescription)
                                .addGap(318, 318, 318)
                                .addComponent(lblDescriptionRemaining))))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(lblDetailsTitle))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName1)
                            .addComponent(lblName4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtParentName, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(txtVenue, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSelectVenue))))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName2)
                            .addComponent(lblName3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spnEndTime)
                            .addComponent(spnStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(lblDetailsTitle1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(lblAddArtist)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblRemoveArtist))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8))))
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(317, 317, 317)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlBackgroundLayout.createSequentialGroup()
                    .addGap(114, 114, 114)
                    .addComponent(btnCancel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(619, Short.MAX_VALUE)))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(0, 30, Short.MAX_VALUE)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(lblDetailsTitle1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblAddArtist)
                                    .addComponent(lblRemoveArtist)))
                            .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDescriptionRemaining)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(lblDetailsTitle)
                                .addGap(21, 21, 21)
                                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblName)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDescription)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName1)
                            .addComponent(txtParentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName4)
                            .addComponent(txtVenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSelectVenue))
                        .addGap(18, 18, 18)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(lblName2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblName3))
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(spnStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
            .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                    .addContainerGap(444, Short.MAX_VALUE)
                    .addComponent(btnCancel1)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Are you ready to save? Changes will immediately become live.", "Save Artist", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            dispose();
            if (parent != null) {
              SpinnerDateModel endModel = (SpinnerDateModel) spnEndTime.getModel();
              SpinnerDateModel startModel = (SpinnerDateModel) spnStartTime.getModel();
              Date  startTime = startModel.getDate();
              Date  endTime = endModel.getDate();
              String name,desc;
              name = txtName.getText();
              desc = txtDescription.getText();
              if(name != null)
              {
                  if(desc!= null)
                  {
                      if(startTime != null)
                      {
                          if(endTime != null)
                          {
                              if(venue != null)
                              {
                                  if(parentEvent != null)
                                  {
                                   IChildEvent event = new ChildEvent(name,desc,startTime,endTime,venue,parentEvent);
                                   IChildEvent  onceAddedEvent;  
                                   try {
                                            onceAddedEvent = (IChildEvent) DesktopWrapper.getInstance().createNewObject(event, DatabaseTable.CHILD_EVENT);
                                      } catch (IOException ex) {
                                          onceAddedEvent = new ChildEvent();
                                      }
                                   if(artists != null || onceAddedEvent.getID() != 0)
                                   {
                                       Boolean failed = false;
                                       for (IArtist artist : artists) {
                                           try {
                                               event.newContract(artist);
                                           } catch (IOException ex) {
                                               failed = true;
                                           }
                                       }
                                       if(failed == true)
                                       {
                                           JOptionPane.showMessageDialog(parent, "Unable to add all of the lineup");
                                       }
                                   }
                                  }else{}//parent
                              }else{}//venue IS NULL
                          }else{}//end is null
                      }else{}//start is null
                  }else{}//DESC IS NULL
             
              System.out.println("Event Added");
              parent.refreshParentEventsList();
              dispose();
              }else{}//name is null
              
                  
              
             
              
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnSelectVenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectVenueActionPerformed

            ObjectSelectDialog dialog = new ObjectSelectDialog();
            dialog.setTable(DatabaseTable.VENUE);
            dialog.setVisible(true);
            dialog.setAlwaysOnTop(true);
            dialog.setAddParent(this);

    }//GEN-LAST:event_btnSelectVenueActionPerformed

    private void txtDescriptionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescriptionKeyTyped
        // Allow user to type if the description length is < 500
        if (descLength - txtDescription.getText().length() >= 0) {
            lblDescriptionRemaining.setText((descLength - txtDescription.getText().length()) + " characters remaining");
        } else {
            // else remove any additional characters
            txtDescription.setText(txtDescription.getText().substring(0, txtDescription.getText().length() - 1));
        }
    }//GEN-LAST:event_txtDescriptionKeyTyped

    private void btnCancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancel1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancel1ActionPerformed

    private void lblAddArtistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddArtistMouseClicked
        ObjectSelectDialog dialog = new ObjectSelectDialog();
            dialog.setTable(DatabaseTable.ARTIST);
            dialog.setVisible(true);
            dialog.setAddParent(this);
            dialog.setAlwaysOnTop(true);
    }//GEN-LAST:event_lblAddArtistMouseClicked

    private void lblRemoveArtistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRemoveArtistMouseClicked
      // Remove Artist from Lineup Here

    }//GEN-LAST:event_lblRemoveArtistMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PnlAddChildEvent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel1;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSelectVenue;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator;
    private javax.swing.JLabel lblAddArtist;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblDescriptionRemaining;
    private javax.swing.JLabel lblDetailsTitle;
    private javax.swing.JLabel lblDetailsTitle1;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblName1;
    private javax.swing.JLabel lblName2;
    private javax.swing.JLabel lblName3;
    private javax.swing.JLabel lblName4;
    private javax.swing.JLabel lblRemoveArtist;
    private javax.swing.JList<String> lstLineup;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JSpinner spnEndTime;
    private javax.swing.JSpinner spnStartTime;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtParentName;
    private javax.swing.JTextField txtVenue;
    // End of variables declaration//GEN-END:variables
    private void populateLineup() {
    }

    public void addLineup(IArtist artist) {
        if(artists.contains(artist))
        {
            throw new IllegalArgumentException("Artist allready is in the lineup");
        }
        listModel.addElement(artist.getName());
        artists.add(artist);
        
    }
}