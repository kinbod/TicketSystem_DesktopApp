/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.contentpanel.bookings;

import bookings.GuestBooking;
import bookings.IBooking;
import gui.contentpanel.artists.ArtistTableModel;
import gui.Home;
import gui.RoundedBorder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import wrappers.DesktopWrapper;

/**
 *
 * @author 10512691
 */
public class PnlBookings extends javax.swing.JPanel {

    private LinkedList<GuestBooking> guestBookings = new LinkedList<>();
    private LinkedList<GuestBooking> origialBookings = new LinkedList<>();
    private Home parent = null;

    /**
     * Creates new Artist panel
     *
     * @param parent
     */
    public PnlBookings(Home parent) {

        initComponents();
        this.parent = parent;

        txtSearchBar.setBorder(new RoundedBorder());
        populateTable();

    }

    public final void populateTable() {

        populateGuestTable();// No Method IN the API for guestBookings;

    }

    public final void populateGuestTable() {
        try {
            guestBookings = (LinkedList<GuestBooking>) DesktopWrapper.getInstance().getGuestBookings();
            origialBookings = guestBookings;

            if (guestBookings.size() > 0) {

                // Creates a table model
                TableModel bookingData = new GuestBookingTableModel(guestBookings, guestBookings.size());
                tableGuestBookings.setModel(bookingData);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error getting bookings from the database. \n  "
                    + e.getMessage());
        }
    }

    public void setParent(Home parent) {
        this.parent = parent;
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
        tableGuestBookings = new javax.swing.JTable();
        searchPnl = new javax.swing.JPanel();
        searchPnlLbl = new javax.swing.JLabel();
        btnNewBooking = new javax.swing.JButton();

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

        txtSearchBar.setText("Search Bookings");
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

        tableGuestBookings.setModel(new javax.swing.table.DefaultTableModel(
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
        tableGuestBookings.setRowHeight(24);
        tableGuestBookings.getTableHeader().setReorderingAllowed(false);
        tableGuestBookings.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tableGuestBookingsFocusLost(evt);
            }
        });
        tableGuestBookings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableGuestBookingsMouseClicked(evt);
            }
        });
        tableScrollPane.setViewportView(tableGuestBookings);
        if (tableGuestBookings.getColumnModel().getColumnCount() > 0) {
            tableGuestBookings.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableGuestBookings.getColumnModel().getColumn(3).setHeaderValue("More");
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

        btnNewBooking.setText("New");
        btnNewBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewBookingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
            .addGroup(layout.createSequentialGroup()
                .addGap(372, 372, 372)
                .addComponent(btnNewBooking)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSearchBar))
                .addGap(47, 47, 47)
                .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNewBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
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

    private void tableGuestBookingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableGuestBookingsMouseClicked
    }//GEN-LAST:event_tableGuestBookingsMouseClicked

    private void tableGuestBookingsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableGuestBookingsFocusLost
    }//GEN-LAST:event_tableGuestBookingsFocusLost

    private void btnNewBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewBookingActionPerformed
        PnlGuestBooking newPnl = new PnlGuestBooking();
        newPnl.setParent(this);
        newPnl.setVisible(true);
        newPnl.setAlwaysOnTop(true);
    }//GEN-LAST:event_btnNewBookingActionPerformed

    private void txtSearchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchBarActionPerformed
            String textToSearch = txtSearchBar.getText();        
        if(!textToSearch.equals(""))
        {
            try {
                System.out.println("Change");
              guestBookings =  (LinkedList<GuestBooking>) DesktopWrapper.getInstance().searchGuestBookings(textToSearch);
              GuestBookingTableModel model = new GuestBookingTableModel(guestBookings,guestBookings.size());
              tableGuestBookings.setModel(model);
            } catch (IOException ex) {

                guestBookings = origialBookings;
               GuestBookingTableModel model = new GuestBookingTableModel(guestBookings,guestBookings.size());
              tableGuestBookings.setModel(model);

            }
        }
        else
        {
                guestBookings = origialBookings;
               GuestBookingTableModel model = new GuestBookingTableModel(guestBookings,guestBookings.size());
              tableGuestBookings.setModel(model);

        }

    }//GEN-LAST:event_txtSearchBarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNewBooking;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JPanel searchPnl;
    private javax.swing.JLabel searchPnlLbl;
    private javax.swing.JTable tableGuestBookings;
    private javax.swing.JScrollPane tableScrollPane;
    private javax.swing.JTextField txtSearchBar;
    // End of variables declaration//GEN-END:variables

}
