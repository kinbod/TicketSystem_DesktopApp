/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.contentpanel;

import gui.MainJFrame;
import gui.contentpanel.admins.AdminTableModel;
import gui.contentpanel.admins.PnlEditAdmin;
import gui.contentpanel.admins.PnlNewAdmin;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import people.IAdmin;
import wrappers.DesktopWrapper;

/**
 *
 * @author 10512691
 */
public class PnlHome extends javax.swing.JPanel {

    private final MainJFrame parent;
    private List<IAdmin> allAdmins;
    private IAdmin currAdmin;
    /**
     * Creates new form PnlHome
     * @param parent
     */
    public PnlHome(MainJFrame parent) {
        initComponents();
        
        this.parent = parent;
        lblLoadingIcon.setVisible(false);
        populateAdminTable();
    }
    
    public final void populateAdminTable() {
  
        try {
            allAdmins = DesktopWrapper.getInstance().getAdmins();

            
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
        t.setInitialDelay(3000);
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

        pnlBackground = new javax.swing.JPanel();
        pnlActiveBackground = new javax.swing.JPanel();
        pnlActiveTitle = new javax.swing.JPanel();
        lblActiveTitle = new javax.swing.JLabel();
        lblActive = new javax.swing.JLabel();
        pnlNewEventsBackground = new javax.swing.JPanel();
        pnlNewEventsTitle = new javax.swing.JPanel();
        lblNewEventsTitle = new javax.swing.JLabel();
        lblNewEvent1 = new javax.swing.JLabel();
        lblNewEvent2 = new javax.swing.JLabel();
        lblNewEvent3 = new javax.swing.JLabel();
        lblNewEvent4 = new javax.swing.JLabel();
        lblNewEvent5 = new javax.swing.JLabel();
        pnlSalesBackground2 = new javax.swing.JPanel();
        pnlSalesTitle2 = new javax.swing.JPanel();
        lblSalesTitle1 = new javax.swing.JLabel();
        lblSales2 = new javax.swing.JLabel();
        pnlAdminSettings = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        iconAdminSettings = new javax.swing.JLabel();
        lblAdminSettings = new javax.swing.JLabel();
        tableScrollPane = new javax.swing.JScrollPane();
        tableAdmins = new javax.swing.JTable();
        btnNewAdmin = new javax.swing.JButton();
        btnEditAdmin = new javax.swing.JButton();
        bntLoadMore = new javax.swing.JButton();
        lblLoadingIcon = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        infoTextBox = new javax.swing.JTextArea();

        setMaximumSize(new java.awt.Dimension(873, 32767));
        setMinimumSize(new java.awt.Dimension(873, 0));
        setPreferredSize(new java.awt.Dimension(873, 1043));

        pnlBackground.setBackground(new java.awt.Color(51, 51, 51));

        pnlActiveBackground.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 28, 53), 1, true));

        pnlActiveTitle.setBackground(new java.awt.Color(153, 153, 153));

        lblActiveTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        lblActiveTitle.setText("Active Users");

        javax.swing.GroupLayout pnlActiveTitleLayout = new javax.swing.GroupLayout(pnlActiveTitle);
        pnlActiveTitle.setLayout(pnlActiveTitleLayout);
        pnlActiveTitleLayout.setHorizontalGroup(
            pnlActiveTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlActiveTitleLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(lblActiveTitle)
                .addGap(35, 35, 35))
        );
        pnlActiveTitleLayout.setVerticalGroup(
            pnlActiveTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlActiveTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblActiveTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblActive.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        lblActive.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblActive.setText("14");
        lblActive.setToolTipText("");

        javax.swing.GroupLayout pnlActiveBackgroundLayout = new javax.swing.GroupLayout(pnlActiveBackground);
        pnlActiveBackground.setLayout(pnlActiveBackgroundLayout);
        pnlActiveBackgroundLayout.setHorizontalGroup(
            pnlActiveBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlActiveTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlActiveBackgroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblActive)
                .addGap(55, 55, 55))
        );
        pnlActiveBackgroundLayout.setVerticalGroup(
            pnlActiveBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlActiveBackgroundLayout.createSequentialGroup()
                .addComponent(pnlActiveTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblActive)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pnlNewEventsBackground.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 28, 53), 1, true));

        pnlNewEventsTitle.setBackground(new java.awt.Color(153, 153, 153));

        lblNewEventsTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        lblNewEventsTitle.setText("New Events");

        javax.swing.GroupLayout pnlNewEventsTitleLayout = new javax.swing.GroupLayout(pnlNewEventsTitle);
        pnlNewEventsTitle.setLayout(pnlNewEventsTitleLayout);
        pnlNewEventsTitleLayout.setHorizontalGroup(
            pnlNewEventsTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNewEventsTitleLayout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(lblNewEventsTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlNewEventsTitleLayout.setVerticalGroup(
            pnlNewEventsTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNewEventsTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNewEventsTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblNewEvent1.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        lblNewEvent1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/one.png"))); // NOI18N
        lblNewEvent1.setText("Dub Clash");

        lblNewEvent2.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        lblNewEvent2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/two.png"))); // NOI18N
        lblNewEvent2.setText("Download Festival");

        lblNewEvent3.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        lblNewEvent3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/three.png"))); // NOI18N
        lblNewEvent3.setText("Micheal McIntyre Presents");

        lblNewEvent4.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        lblNewEvent4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/four.png"))); // NOI18N
        lblNewEvent4.setText("Nass Festival");

        lblNewEvent5.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        lblNewEvent5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/five.png"))); // NOI18N
        lblNewEvent5.setText("Summer Solstice");

        javax.swing.GroupLayout pnlNewEventsBackgroundLayout = new javax.swing.GroupLayout(pnlNewEventsBackground);
        pnlNewEventsBackground.setLayout(pnlNewEventsBackgroundLayout);
        pnlNewEventsBackgroundLayout.setHorizontalGroup(
            pnlNewEventsBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlNewEventsTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlNewEventsBackgroundLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnlNewEventsBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNewEvent3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlNewEventsBackgroundLayout.createSequentialGroup()
                        .addGroup(pnlNewEventsBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNewEvent5)
                            .addComponent(lblNewEvent4)
                            .addComponent(lblNewEvent1)
                            .addComponent(lblNewEvent2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlNewEventsBackgroundLayout.setVerticalGroup(
            pnlNewEventsBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNewEventsBackgroundLayout.createSequentialGroup()
                .addComponent(pnlNewEventsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNewEvent1)
                .addGap(18, 18, 18)
                .addComponent(lblNewEvent2)
                .addGap(18, 18, 18)
                .addComponent(lblNewEvent3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNewEvent4)
                .addGap(18, 18, 18)
                .addComponent(lblNewEvent5)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pnlSalesBackground2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 28, 53), 1, true));

        pnlSalesTitle2.setBackground(new java.awt.Color(153, 153, 153));

        lblSalesTitle1.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        lblSalesTitle1.setText("Today's Sales");

        javax.swing.GroupLayout pnlSalesTitle2Layout = new javax.swing.GroupLayout(pnlSalesTitle2);
        pnlSalesTitle2.setLayout(pnlSalesTitle2Layout);
        pnlSalesTitle2Layout.setHorizontalGroup(
            pnlSalesTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSalesTitle2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblSalesTitle1)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        pnlSalesTitle2Layout.setVerticalGroup(
            pnlSalesTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSalesTitle2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSalesTitle1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblSales2.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        lblSales2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSales2.setText("0");
        lblSales2.setToolTipText("");

        javax.swing.GroupLayout pnlSalesBackground2Layout = new javax.swing.GroupLayout(pnlSalesBackground2);
        pnlSalesBackground2.setLayout(pnlSalesBackground2Layout);
        pnlSalesBackground2Layout.setHorizontalGroup(
            pnlSalesBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSalesTitle2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlSalesBackground2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(lblSales2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSalesBackground2Layout.setVerticalGroup(
            pnlSalesBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSalesBackground2Layout.createSequentialGroup()
                .addComponent(pnlSalesTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSales2)
                .addContainerGap())
        );

        pnlAdminSettings.setBackground(new java.awt.Color(51, 51, 51));
        pnlAdminSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlAdminSettingsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlAdminSettingsLayout = new javax.swing.GroupLayout(pnlAdminSettings);
        pnlAdminSettings.setLayout(pnlAdminSettingsLayout);
        pnlAdminSettingsLayout.setHorizontalGroup(
            pnlAdminSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 144, Short.MAX_VALUE)
        );
        pnlAdminSettingsLayout.setVerticalGroup(
            pnlAdminSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 104, Short.MAX_VALUE)
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        iconAdminSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settings_icon.png"))); // NOI18N

        lblAdminSettings.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lblAdminSettings.setForeground(new java.awt.Color(251, 251, 251));
        lblAdminSettings.setText("Admin Accounts");

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

        btnNewAdmin.setText("New");
        btnNewAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewAdminActionPerformed(evt);
            }
        });

        btnEditAdmin.setText("Edit Password");
        btnEditAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditAdminActionPerformed(evt);
            }
        });

        bntLoadMore.setText("Load More");
        bntLoadMore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLoadMoreActionPerformed(evt);
            }
        });

        lblLoadingIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/loading_icon.gif"))); // NOI18N

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

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                                .addComponent(pnlSalesBackground2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                                .addComponent(pnlActiveBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pnlNewEventsBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnNewAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bntLoadMore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEditAdmin))
                                .addGap(65, 65, 65)))
                        .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLoadingIcon)
                            .addComponent(pnlAdminSettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(801, 801, 801))
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(lblAdminSettings)
                        .addGap(18, 18, 18)
                        .addComponent(iconAdminSettings)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlSalesBackground2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlActiveBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnlNewEventsBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconAdminSettings)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblAdminSettings)))
                .addGap(18, 18, 18)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(pnlAdminSettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoadingIcon, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                        .addComponent(btnNewAdmin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditAdmin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bntLoadMore)
                        .addGap(51, 51, 51))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 890, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pnlAdminSettingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlAdminSettingsMouseClicked
        parent.sidebar.deselectAll();
        parent.setPage(Pages.ADMINS);
    }//GEN-LAST:event_pnlAdminSettingsMouseClicked

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
        lblLoadingIcon.setVisible(true);
        
        SwingWorker worker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                try {
                    DesktopWrapper.getInstance().loadMoreAdmins();
                    allAdmins = DesktopWrapper.getInstance().getAdmins();
                    AdminTableModel adminData = new AdminTableModel(allAdmins, allAdmins.size());
                    tableAdmins.setModel(adminData);
                    lblLoadingIcon.setVisible(false);

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(PnlHome.this, "Unable To Load More Admins");
                    lblLoadingIcon.setVisible(false);
                }
                return "";
            }
        };
        
        worker.execute();
    }//GEN-LAST:event_bntLoadMoreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntLoadMore;
    private javax.swing.JButton btnEditAdmin;
    private javax.swing.JButton btnNewAdmin;
    private javax.swing.JLabel iconAdminSettings;
    private javax.swing.JTextArea infoTextBox;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblActive;
    private javax.swing.JLabel lblActiveTitle;
    private javax.swing.JLabel lblAdminSettings;
    private javax.swing.JLabel lblLoadingIcon;
    private javax.swing.JLabel lblNewEvent1;
    private javax.swing.JLabel lblNewEvent2;
    private javax.swing.JLabel lblNewEvent3;
    private javax.swing.JLabel lblNewEvent4;
    private javax.swing.JLabel lblNewEvent5;
    private javax.swing.JLabel lblNewEventsTitle;
    private javax.swing.JLabel lblSales2;
    private javax.swing.JLabel lblSalesTitle1;
    private javax.swing.JPanel pnlActiveBackground;
    private javax.swing.JPanel pnlActiveTitle;
    private javax.swing.JPanel pnlAdminSettings;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlNewEventsBackground;
    private javax.swing.JPanel pnlNewEventsTitle;
    private javax.swing.JPanel pnlSalesBackground2;
    private javax.swing.JPanel pnlSalesTitle2;
    private javax.swing.JTable tableAdmins;
    private javax.swing.JScrollPane tableScrollPane;
    // End of variables declaration//GEN-END:variables
}
