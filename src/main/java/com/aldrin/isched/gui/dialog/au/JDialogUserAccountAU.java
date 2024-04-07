/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.aldrin.isched.gui.dialog.au;


import com.aldrin.isched.ISched;
import com.aldrin.isched.dao.impl.RoleDAOImpl;
import com.aldrin.isched.dao.impl.UserAccountDAOImpl;
import com.aldrin.isched.gui.JFrameMain;
import com.aldrin.isched.model.Role;
import com.aldrin.isched.model.UserAccount;
import com.aldrin.isched.util.ComboBoxList;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ALDRIN B. C.
 */
public class JDialogUserAccountAU extends javax.swing.JDialog {

    private RoleDAOImpl roleDAOImpl = new RoleDAOImpl();
    private UserAccountDAOImpl studentDAOImpl = new UserAccountDAOImpl();
    private JFrameMain jFrameRegister;

  
    private UserAccount userAccount = new UserAccount();
    static String title = "";

    public JDialogUserAccountAU(JFrameMain jFrameMain, boolean modal) {
        super(jFrameMain, modal);
        initComponents();
        this.jFrameRegister =jFrameMain;
        setTitle("New user account");
        this.title = "New";
        jTextFieldFirstname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "FIRST NAME");
        jTextFieldSurname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "SURNAME");
        jTextFieldUsername.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "USERNAME");
        jTextFieldPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "PASSWORD");
        comboBoxUserAccount();
        jCheckBoxActive.setSelected(true);
        jButton1.setIcon(new FlatSVGIcon("svg/save.svg",24,24));
        

    }

    public JDialogUserAccountAU(JFrameMain jFrameMain, boolean modal, UserAccount userAccount, String title) {
        super(jFrameMain, modal);
        initComponents();
        setTitle("Update user account");
        this.userAccount = userAccount;
        this.title = title;
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(187, 187, 187));
        jTextFieldFirstname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "First name");
        jTextFieldSurname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Surname");
        jTextFieldUsername.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Username");
        jTextFieldPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Password");
        comboBoxUserAccount();
        jTextFieldFirstname.setText(userAccount.getFirstname());
        jTextFieldSurname.setText(userAccount.getSurname());
        jTextFieldUsername.setText(userAccount.getUsername());
        jTextFieldPassword.setText(userAccount.getPassword());
        jCheckBoxActive.setSelected(userAccount.getActive());
        for (ComboBoxList a : this.roleDAOImpl.getList()) {
            a.setSelectedId(roleDAOImpl.getList(), String.valueOf(userAccount.getRole().getId()), jComboBoxRole);
        }
        jButton1.setIcon(new FlatSVGIcon("svg/edit.svg",24,24));

    }

    public JDialogUserAccountAU(JFrameMain jFrameMain, boolean modal, String title, UserAccount userAccount) {
        super(jFrameMain, modal);
        initComponents();
        setTitle("Delete user account");
        this.userAccount = userAccount;
        this.title = title;
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(187, 187, 187));
        jTextFieldFirstname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "FIRST NAME");
        jTextFieldSurname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "SURNAME");
        jTextFieldUsername.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "USERNAME");
        jTextFieldPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "PASSWORD");
        comboBoxUserAccount();
        jTextFieldFirstname.setText(userAccount.getFirstname());
        jTextFieldSurname.setText(userAccount.getSurname());
        jTextFieldUsername.setText(userAccount.getUsername());
        jTextFieldPassword.setText(userAccount.getPassword());
        jCheckBoxActive.setSelected(userAccount.getActive());
        for (ComboBoxList a : this.roleDAOImpl.getList()) {
            a.setSelectedId(roleDAOImpl.getList(), String.valueOf(userAccount.getRole().getId()), jComboBoxRole);
        }
        jButton1.setIcon(new FlatSVGIcon("svg/delete.svg",24,24));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldFirstname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldSurname = new javax.swing.JTextField();
        jTextFieldPassword = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jComboBoxRole = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jCheckBoxActive = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Student");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("FIRST NAME:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 20, 70, 30));

        jTextFieldFirstname.setPreferredSize(new java.awt.Dimension(64, 30));
        getContentPane().add(jTextFieldFirstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 250, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 220, 80, 30));

        jTextFieldSurname.setPreferredSize(new java.awt.Dimension(64, 30));
        getContentPane().add(jTextFieldSurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 250, -1));

        jTextFieldPassword.setMinimumSize(new java.awt.Dimension(64, 32));
        jTextFieldPassword.setPreferredSize(new java.awt.Dimension(64, 32));
        getContentPane().add(jTextFieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 250, -1));

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 168, 32));

        jComboBoxRole.setPreferredSize(new java.awt.Dimension(72, 32));
        getContentPane().add(jComboBoxRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 250, 30));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("SURNAME:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 60, 70, 30));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("ROLE:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 100, 70, 30));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("USERNAME:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 140, 70, 30));

        jTextFieldUsername.setMinimumSize(new java.awt.Dimension(64, 32));
        jTextFieldUsername.setPreferredSize(new java.awt.Dimension(64, 32));
        getContentPane().add(jTextFieldUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 250, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("PASSWORD:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 180, 70, 30));

        jCheckBoxActive.setText("ACTIVE");
        getContentPane().add(jCheckBoxActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 250, 30));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel4.setPreferredSize(new java.awt.Dimension(100, 1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 318, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 251, 320, -1));

        setSize(new java.awt.Dimension(363, 356));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (this.title.equals("New")) {
            int response = JOptionPane.showConfirmDialog(jFrameRegister, "Are you sure to save " + jTextFieldFirstname.getText() + " " + jTextFieldSurname.getText() + " ?", "Save confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                this.userAccount.setFirstname(jTextFieldFirstname.getText());
                this.userAccount.setSurname(jTextFieldSurname.getText());
                this.userAccount.setUsername(jTextFieldUsername.getText());
                this.userAccount.setPassword(jTextFieldPassword.getText());
                ComboBoxList roleId = (ComboBoxList) this.jComboBoxRole.getSelectedItem();
                Role role = new Role();
                role.setId(roleId.getId());
                this.userAccount.setRole(role);
                try {
                    validatePhoto();
                } catch (URISyntaxException ex) {
                    Logger.getLogger(JDialogUserAccountAU.class.getName()).log(Level.SEVERE, null, ex);
                }
                studentDAOImpl.addUserAccount(userAccount);
                this.dispose();
            }
        } else if (this.title.equals("Update")) {
            int response = JOptionPane.showConfirmDialog(jFrameRegister, "Are you sure to update " + jTextFieldFirstname.getText() + " " + jTextFieldSurname.getText() + " ?", "Save confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                this.userAccount.setFirstname(jTextFieldFirstname.getText());
                this.userAccount.setSurname(jTextFieldSurname.getText());
                this.userAccount.setUsername(jTextFieldUsername.getText());
                this.userAccount.setPassword(jTextFieldPassword.getText());
                ComboBoxList roleId = (ComboBoxList) this.jComboBoxRole.getSelectedItem();
                Role role = new Role();
                role.setId(roleId.getId());
                this.userAccount.setRole(role);
                try {
                    validatePhoto();
                } catch (URISyntaxException ex) {
                    Logger.getLogger(JDialogUserAccountAU.class.getName()).log(Level.SEVERE, null, ex);
                }
                studentDAOImpl.updateUserAccount(userAccount);
                this.dispose();
            }
        } else if (this.title.equals("Delete")) {
            int response = JOptionPane.showConfirmDialog(jFrameRegister, "Are you sure to delete " + jTextFieldFirstname.getText() + " " + jTextFieldSurname.getText() + " ?", "Save confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                studentDAOImpl.deleteUserAccount(userAccount);
                this.dispose();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBoxActive;
    private javax.swing.JComboBox<Object> jComboBoxRole;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextFieldFirstname;
    private javax.swing.JTextField jTextFieldPassword;
    private javax.swing.JTextField jTextFieldSurname;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables

    private void comboBoxUserAccount() {
        roleDAOImpl.comboBoxRole();
        jComboBoxRole.removeAllItems();
        for (ComboBoxList a : roleDAOImpl.getList()) {
            this.jComboBoxRole.addItem(a);
        }
    }

    private File pictureFile = null;

  

    private void uploadPhoto(File file) {
        if (file != null) {
            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] imageData = new byte[(int) file.length()];
                fis.read(imageData);
                userAccount.setPhoto(imageData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    int IMG_WIDTH = 200;
    int IMG_HEIGHT = 200;

   

    private void validatePhoto() throws URISyntaxException {
        if (userAccount.getPhoto() == null) {
            File targetClassesDir = new File(ISched.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "\\images\\no photo.jpg");
            try {
                FileInputStream fis = new FileInputStream(targetClassesDir);
                byte[] imageData = new byte[(int) targetClassesDir.length()];
                fis.read(imageData);
                userAccount.setPhoto(imageData);
            } catch (Exception e) {
                System.out.println("default of no photo is error");
            }
        }
    }

}
