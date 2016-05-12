/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.contentpanel.bookings;

import bookings.GuestBooking;
import bookings.IBooking;
import events.IChildEvent;
import events.IParentEvent;
import gui.contentpanel.events.PnlEvents;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import people.Guest;
import people.ICustomer;
import people.IGuest;
import tickets.ITicket;
import wrappers.DesktopWrapper;

/**
 *
 * @author 10512691
 */
public class PnlGuestBooking extends javax.swing.JFrame {

    private  List<IParentEvent> allParentEvents = new ArrayList<>();
    private List<IChildEvent> childEvents = new ArrayList<>();
    private List<ITicket> tickets = new ArrayList<>();
    private List<GuestBooking> guestBookings = new ArrayList<>();
    private ComboBoxModel childEventsModel;
    private DefaultListModel listModel;
    private ComboBoxModel ticketsModel;
    private IGuest guest;
    private DefaultListModel bookingListModel;
    private PnlBookings parent;
    
    /**
     * Creates new form PnlGuestBooking
     */
    public PnlGuestBooking() {
        listModel = new DefaultListModel();
        childEventsModel = new DefaultComboBoxModel();
        ticketsModel = new DefaultComboBoxModel();
        bookingListModel = new DefaultListModel();
        loadParentEvents();
        
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        loading_icon_lbl.setVisible(false);
    }
    
    public void setParent(PnlBookings parent) {
        this.parent = parent;
    }
    
    private void editable(boolean flag) {
        jScrollPane1.setEnabled(flag);
        cmbChildEvents.setEnabled(flag);
        cmbTickets.setEnabled(flag);
        spnQuantity.setEnabled(flag);
        btnBuyNow.setEnabled(flag);
        btnCancel.setEnabled(flag);
        btnSave.setEnabled(flag);
        loading_icon_lbl.setVisible(!flag);
    }
    
    private void loadParentEvents() {
        try {
            //DesktopWrapper.getInstance().g  
             allParentEvents = DesktopWrapper.getInstance().refreshParentEvents();
           for (IParentEvent currEvent : allParentEvents)
            {
                listModel.addElement(currEvent.getName());
            }
    
        } catch (IOException ex) {
         listModel.addElement("No Events Found");
        }
    }

    private void loadChildEvents() {
        if(lstParentEvents.getSelectedIndex() != -1)
        {
            IParentEvent currParentEvent = allParentEvents.get(lstParentEvents.getSelectedIndex());
            try {
                childEvents = currParentEvent.getChildEvents();
                cmbChildEvents.setModel(new DefaultComboBoxModel());
                
                if(childEvents.isEmpty()) {
                 cmbChildEvents.addItem("No Events Found");
                 cmbTickets.setEnabled(false);

                }
                else {
                    cmbTickets.setEnabled(true);
                    cmbTickets.setModel(new DefaultComboBoxModel());
                    cmbTickets.addItem("No Tickets Found");
                    for (IChildEvent event : childEvents) {
                        cmbChildEvents.addItem(event.getName());
                    }
                }

            } catch (IOException ex) {
                Logger.getLogger(PnlEvents.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstParentEvents = new javax.swing.JList<>();
        cmbChildEvents = new javax.swing.JComboBox<>();
        cmbTickets = new javax.swing.JComboBox<>();
        spnQuantity = new javax.swing.JSpinner();
        lblParEvent = new javax.swing.JLabel();
        lblChildEvent = new javax.swing.JLabel();
        lblTickets = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        btnBuyNow = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        loading_icon_lbl = new javax.swing.JLabel();
        jSeparator = new javax.swing.JSeparator();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblEmail = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblPostcode = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtPostcode = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstBookings = new javax.swing.JList<>();
        lblBookings = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlBackground.setBackground(new java.awt.Color(51, 51, 51));

        lstParentEvents.setModel(listModel);
        lstParentEvents.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstParentEvents.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstParentEventsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstParentEvents);

        cmbChildEvents.setModel(childEventsModel);
        cmbChildEvents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbChildEventsActionPerformed(evt);
            }
        });
        cmbChildEvents.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbChildEventsPropertyChange(evt);
            }
        });

        cmbTickets.setModel(ticketsModel);

        spnQuantity.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        lblParEvent.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        lblParEvent.setForeground(new java.awt.Color(255, 255, 255));
        lblParEvent.setText("Parent Events");

        lblChildEvent.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        lblChildEvent.setForeground(new java.awt.Color(255, 255, 255));
        lblChildEvent.setText("Child Events");

        lblTickets.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        lblTickets.setForeground(new java.awt.Color(255, 255, 255));
        lblTickets.setText("Tickets");

        lblQuantity.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        lblQuantity.setForeground(new java.awt.Color(255, 255, 255));
        lblQuantity.setText("Quantity");

        btnBuyNow.setText("Add Booking");
        btnBuyNow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuyNowMouseClicked(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("New Guest Booking");

        loading_icon_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/loading_icon.gif"))); // NOI18N

        jSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator.setToolTipText("");

        btnSave.setText("Save");
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblEmail.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("Email");

        lblAddress.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        lblAddress.setForeground(new java.awt.Color(255, 255, 255));
        lblAddress.setText("Address");

        lblPostcode.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        lblPostcode.setForeground(new java.awt.Color(255, 255, 255));
        lblPostcode.setText("Postcode");

        txtEmail.setBackground(new java.awt.Color(51, 51, 51));
        txtEmail.setForeground(new java.awt.Color(250, 250, 250));
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });

        txtAddress.setBackground(new java.awt.Color(51, 51, 51));
        txtAddress.setForeground(new java.awt.Color(250, 250, 250));
        txtAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAddressKeyTyped(evt);
            }
        });

        txtPostcode.setBackground(new java.awt.Color(51, 51, 51));
        txtPostcode.setForeground(new java.awt.Color(250, 250, 250));
        txtPostcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPostcodeKeyTyped(evt);
            }
        });

        lstBookings.setModel(bookingListModel);
        lstBookings.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(lstBookings);

        lblBookings.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        lblBookings.setForeground(new java.awt.Color(255, 255, 255));
        lblBookings.setText("Bookings");

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(lblTitle))
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(138, 138, 138)
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(loading_icon_lbl))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(lblEmail))
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addComponent(lblAddress))
                                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addComponent(lblPostcode))
                                    .addComponent(txtPostcode, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(lblBookings)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(lblParEvent)))
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbChildEvents, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnBuyNow)
                                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                        .addComponent(lblQuantity)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(lblChildEvent))
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(lblTickets)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(lblEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblAddress)
                        .addGap(3, 3, 3)
                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPostcode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPostcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblBookings)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(lblParEvent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lblChildEvent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbChildEvents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTickets)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTickets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(spnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblQuantity))
                                .addGap(57, 57, 57)
                                .addComponent(btnBuyNow, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(131, 131, 131)
                                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnCancel)
                                    .addComponent(btnSave)))
                            .addComponent(loading_icon_lbl)))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstParentEventsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstParentEventsValueChanged
        loading_icon_lbl.setVisible(true);
        SwingWorker<String, Object> worker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                loadChildEvents();
                loading_icon_lbl.setVisible(false);
                return "";
            }
        };
        worker.execute();
    }//GEN-LAST:event_lstParentEventsValueChanged

    private void cmbChildEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbChildEventsActionPerformed
        if(!cmbChildEvents.getSelectedItem().equals("No Events Found"))
        {
            try {
                tickets = childEvents.get(cmbChildEvents.getSelectedIndex()).getTickets();
                cmbTickets.setModel(new DefaultComboBoxModel());
                for (ITicket ticket : tickets) {
                    cmbTickets.addItem(ticket.getType() + " - " + utilities.Formatter.formatPrice(ticket.getPrice()));
                }
            } catch (IOException ex) {
                cmbTickets.setModel(new DefaultComboBoxModel());
                cmbTickets.addItem(("IO ERROR"));
            }
        }
    }//GEN-LAST:event_cmbChildEventsActionPerformed

    private void cmbChildEventsPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbChildEventsPropertyChange

    }//GEN-LAST:event_cmbChildEventsPropertyChange

    private void btnBuyNowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuyNowMouseClicked

        boolean guestFlag = false;
        if (guest == null) {        // Check whether a guest has been created
            try {
                guest = new Guest(txtEmail.getText(), txtAddress.getText(), txtPostcode.getText());
                guestFlag = true;
            }
            catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, "Error creating user.\n\n"
                        + ex.getMessage());
            }
        } 
        else guestFlag = true;
        
        if (guestFlag == true) {
            if(cmbTickets.getSelectedIndex() != -1 && !tickets.isEmpty()) {

                ITicket ticket = tickets.get(cmbTickets.getSelectedIndex());
                Integer quantity = (Integer) spnQuantity.getValue();

                String question = "Are you sure you want to book " + quantity.toString() +
                " " + ticket.getType() + " tickets for " + guest.getEmail() + "?";

                if(JOptionPane.showConfirmDialog(this,question,"Customer Booking", 0) == JOptionPane.OK_OPTION) {

                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                IBooking booking = new GuestBooking(ticket, quantity, new Date(), guest);
                                addBooking(booking);
                                // FINALLY, WHEN DONE ADDING BOOKINGS, YOU CONFIRM THE ORDER WITH THEM,
                                // AND CREATE AN ORDER OUT OF THE BOOKING OBJECTS IN THE LIST.
                                // DesktopWrapper.getInstance().makeGuestBookings(guestBookings);
                                
                                editable(true);
                            }
                            catch (IllegalArgumentException | IOException ex) {
                                JOptionPane.showMessageDialog(PnlGuestBooking.this, "Cannot make booking.\n\n" + ex.getMessage());
                            }
                            finally {
                                parent.populateTable();
                            }
                        }

                    }, "OrderThread");

                    editable(false);
                    t.start();
                }
            }
            else {
                JOptionPane.showMessageDialog(this,"Please select a ticket to buy first");
            }
        }
        
//        if (user != null) {
//            if(cmbTickets.getSelectedIndex() != -1 && !tickets.isEmpty()) {
//
//                ITicket ticket = tickets.get(cmbTickets.getSelectedIndex());
//                Integer quantity = (Integer) spnQuantity.getValue();
//
//                String question = "Are you sure you want to book " + quantity.toString() +
//                " " + ticket.getType() + " tickets for " + user.getFirstName() + " " +  user.getLastName();
//
//                if(JOptionPane.showConfirmDialog(this,question,"Customer Booking", 0) == JOptionPane.OK_OPTION) {
//
//                    Thread t = new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            try {
//                                user.addOrder(DesktopWrapper.getInstance().makeCustomerBooking(user, ticket, quantity));
//                                dispose();
//                                editable(true);
//                            }
//                            catch (IllegalArgumentException ex) {
//                                JOptionPane.showMessageDialog(PnlCustomerBooking.this, "Cannot make booking.\n\n" + ex.getMessage());
//                            }
//                            catch (IOException ex) {
//                                JOptionPane.showMessageDialog(PnlCustomerBooking.this, "There's been an error creating the booking.\n\n"
//                                    + "Please check the Customer Tickets table for confirmation of result.");
//                            }
//                            finally {
//                                parent.populateTable();
//                            }
//                        }
//
//                    }, "OrderThread");
//
//                    editable(false);
//                    t.start();
//                }
//            }
//            else {
//                JOptionPane.showMessageDialog(this,"Please select a ticket to buy first");
//            }
//        }
//        else {
//            JOptionPane.showMessageDialog(this, "Error : No User Selected. \n\n"
//                + "Please Contact a developer about this issue!");
//            dispose();
//        }
    }//GEN-LAST:event_btnBuyNowMouseClicked

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to cancel this booking?") == JOptionPane.OK_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        //editedUser = true;
    }//GEN-LAST:event_txtEmailKeyTyped

    private void txtAddressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressKeyTyped

    private void txtPostcodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPostcodeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPostcodeKeyTyped

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked

            try{
            
          String question = "Are you sure You wish to make a booking for " + guest.getEmail() +
                  " for the following tickets \n";
          
            for (GuestBooking currBooking : guestBookings) {
                question += currBooking.getTicket().getChildEvent().getName() + " - " +
                        currBooking.getTicket().getType() + " - " + currBooking.getQuantity()+ "\n";
            }         
          if(JOptionPane.showConfirmDialog(this,question,"Guest Booking", 0) == JOptionPane.OK_OPTION) {
                DesktopWrapper.getInstance().makeGuestBookings(guestBookings);
                bookingListModel.clear();
                dispose();
                editable(true);

          }
                      
        }catch(IOException ex)
         {
          JOptionPane.showMessageDialog(PnlGuestBooking.this, "Cannot make an order at this time.\n\n" + ex.getMessage());
         }         
        catch(NullPointerException ex)
        {
         JOptionPane.showMessageDialog(PnlGuestBooking.this, "Cannot make booking, \n do you have any orders to book?");

        }
            finally{
                            parent.populateTable();

            }
        

    }//GEN-LAST:event_btnSaveMouseClicked

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
            java.util.logging.Logger.getLogger(PnlGuestBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PnlGuestBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PnlGuestBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PnlGuestBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PnlGuestBooking().setVisible(true);
            }
        });
    }
    
    private void addBooking(IBooking booking) throws IOException 
    {
       bookingListModel.addElement(booking.getTicket().getChildEvent().getName() + " " + booking.getTicket().getType() + " - " + booking.getQuantity());
       guestBookings.add((GuestBooking) booking);
    }
            

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuyNow;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbChildEvents;
    private javax.swing.JComboBox<String> cmbTickets;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblBookings;
    private javax.swing.JLabel lblChildEvent;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblParEvent;
    private javax.swing.JLabel lblPostcode;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblTickets;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel loading_icon_lbl;
    private javax.swing.JList<String> lstBookings;
    private javax.swing.JList<String> lstParentEvents;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JSpinner spnQuantity;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtPostcode;
    // End of variables declaration//GEN-END:variables
}