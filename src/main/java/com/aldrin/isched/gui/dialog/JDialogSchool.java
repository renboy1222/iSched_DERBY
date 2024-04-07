/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.aldrin.isched.gui.dialog;

import com.aldrin.isched.ISched;
import com.aldrin.isched.dao.impl.SchoolDAOImpl;
import com.aldrin.isched.gui.JFrameMain;
import com.aldrin.isched.model.School;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.URISyntaxException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author ALDRIN B. C.
 */
public class JDialogSchool extends javax.swing.JDialog {

    private JFrameMain jFrameMain;

    /**
     * Creates new form JDialogStudent
     */
    private School school = new School();
    static String title = "";
    private SchoolDAOImpl schoolDAOImpl = new SchoolDAOImpl();

    public JDialogSchool(JFrameMain jFrameMain, boolean modal) {
        super(jFrameMain, modal);
        initComponents();
        this.jFrameMain = jFrameMain;
        setTitle("SCHOOL SETTINGS");

        jTextFieldSchoolName.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "SCHOOL NAME");
        jTextFieldAddress.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "ADDRESS");
        jTextFieldTel.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "TELEPHONE");
        jTextFieldTeleFax.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "TELEFAX");
        jTextFieldSite.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "SITE");
        jTextFieldTitle.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "TITLE");
        jTextFieldCampus.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "CAMPUS");
        jButton1.setIcon(new FlatSVGIcon("svg/edit.svg", 24, 24));
        school = schoolDAOImpl.selectSchool();
        jTextFieldSchoolName.setText(school.getSchool());
        jTextFieldAddress.setText(school.getAddress());
        jTextFieldTel.setText(school.getTel());
        jTextFieldTeleFax.setText(school.getTeleFax());
        jTextFieldSite.setText(school.getSchool());
        jTextFieldTitle.setText(school.getTitle());
        jTextFieldCampus.setText(school.getCampus());
//        displayLogo(school);

    }

//    public JDialogSchool(JFrameMain jFrameMain, boolean modal, UserAccount school, String title) {
//        super(jFrameMain, modal);
//        initComponents();
//        setTitle("Update user account");
//        this.school = school;
//        this.title = title;
//        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(187, 187, 187));
//        jTextFieldFirstname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "First name");
//        jTextFieldSurname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Surname");
//        jTextFieldUsername.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Username");
//        jTextFieldPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Password");
//        comboBoxUserAccount();
//        jTextFieldFirstname.setText(school.getFirstname());
//        jTextFieldSurname.setText(school.getSurname());
//        jTextFieldUsername.setText(school.getUsername());
//        jTextFieldPassword.setText(school.getPassword());
//        displayPicture(school);
//        jButton1.setIcon(new FlatSVGIcon("svg/edit.svg",24,24));
//
//    }
//
//    public JDialogSchool(JFrameMain jFrameMain, boolean modal, String title, UserAccount school) {
//        super(jFrameMain, modal);
//        initComponents();
//        setTitle("Delete user account");
//        this.school = school;
//        this.title = title;
//        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(187, 187, 187));
//        jTextFieldFirstname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "FIRST NAME");
//        jTextFieldSurname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "SURNAME");
//        jTextFieldUsername.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "USERNAME");
//        jTextFieldPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "PASSWORD");
//        comboBoxUserAccount();
//        jTextFieldFirstname.setText(school.getFirstname());
//        jTextFieldSurname.setText(school.getSurname());
//        jTextFieldUsername.setText(school.getUsername());
//        jTextFieldPassword.setText(school.getPassword());
//        displayPicture(school);
//        jButton1.setIcon(new FlatSVGIcon("svg/delete.svg",24,24));
//    }
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
        jTextFieldSchoolName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldAddress = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabelPicture = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTextFieldCampus = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldTel = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldTeleFax = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldSite = new javax.swing.JTextField();
        jTextFieldTitle = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SCHOOL");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("SCHOOL NAME:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 20, 90, 30));

        jTextFieldSchoolName.setPreferredSize(new java.awt.Dimension(64, 30));
        getContentPane().add(jTextFieldSchoolName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 350, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("CAMPUS:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 260, 90, 30));

        jTextFieldAddress.setPreferredSize(new java.awt.Dimension(64, 30));
        getContentPane().add(jTextFieldAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 350, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "LOGO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 102, 153))); // NOI18N
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabelPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/reports/logo.png"))); // NOI18N
        jLabelPicture.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPictureMouseClicked(evt);
            }
        });
        jPanel2.add(jLabelPicture, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setPreferredSize(new java.awt.Dimension(210, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 210, 230));

        jTextFieldCampus.setMinimumSize(new java.awt.Dimension(64, 32));
        jTextFieldCampus.setPreferredSize(new java.awt.Dimension(64, 30));
        getContentPane().add(jTextFieldCampus, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 350, -1));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("ADDRESS:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 60, 90, 30));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("TITLE:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 220, 90, 30));

        jTextFieldTel.setMinimumSize(new java.awt.Dimension(64, 32));
        jTextFieldTel.setPreferredSize(new java.awt.Dimension(64, 30));
        getContentPane().add(jTextFieldTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 350, -1));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("TEL:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 100, 90, 30));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("TELEFAX:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 90, 30));

        jTextFieldTeleFax.setMinimumSize(new java.awt.Dimension(64, 32));
        jTextFieldTeleFax.setPreferredSize(new java.awt.Dimension(64, 30));
        getContentPane().add(jTextFieldTeleFax, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 350, -1));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("SITE:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 180, 90, 30));

        jTextFieldSite.setMinimumSize(new java.awt.Dimension(64, 32));
        jTextFieldSite.setPreferredSize(new java.awt.Dimension(64, 30));
        getContentPane().add(jTextFieldSite, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 350, -1));

        jTextFieldTitle.setMinimumSize(new java.awt.Dimension(64, 32));
        jTextFieldTitle.setPreferredSize(new java.awt.Dimension(64, 30));
        getContentPane().add(jTextFieldTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 350, -1));

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 20));

        jButton1.setText("UPDATE");
        jButton1.setPreferredSize(new java.awt.Dimension(320, 32));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1);

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 660, 80));

        setSize(new java.awt.Dimension(696, 420));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int response = JOptionPane.showConfirmDialog(jFrameMain, "Are you sure to update " + jTextFieldSchoolName.getText() + " " + jTextFieldAddress.getText() + " ?", "Save confirmation", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            this.school.setSchool(jTextFieldSchoolName.getText());
            this.school.setAddress(jTextFieldAddress.getText());
            this.school.setTel(jTextFieldTel.getText());
            this.school.setTeleFax(jTextFieldTeleFax.getText());
            this.school.setSite(jTextFieldSite.getText());
            this.school.setTitle(jTextFieldTitle.getText());
            this.school.setCampus(jTextFieldCampus.getText());
            try {
                validatePhoto();
            } catch (URISyntaxException ex) {
                java.util.logging.Logger.getLogger(JDialogSchool.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            schoolDAOImpl.updateSchool(school);
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabelPictureMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPictureMouseClicked
        openImage();

    }//GEN-LAST:event_jLabelPictureMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelPicture;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextFieldAddress;
    private javax.swing.JTextField jTextFieldCampus;
    private javax.swing.JTextField jTextFieldSchoolName;
    private javax.swing.JTextField jTextFieldSite;
    private javax.swing.JTextField jTextFieldTel;
    private javax.swing.JTextField jTextFieldTeleFax;
    private javax.swing.JTextField jTextFieldTitle;
    // End of variables declaration//GEN-END:variables

    private File pictureFile = null;
    private BufferedImage originalImage;

    private void openImage() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File selectedFile = fileChooser.getSelectedFile();
                originalImage = ImageIO.read(selectedFile);
                displayImage(originalImage);
                ImageIO.write(originalImage, "png", new File(System.getProperty("user.dir") + "/src/main/resources/reports/logo.png"));
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error loading image: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void displayImage(BufferedImage image) {
        if (image != null) {
            ImageIcon icon = new ImageIcon(image);
            jLabelPicture.setIcon(icon);
        } else {
            jLabelPicture.setIcon(null);
        }
    }
    
        private void validatePhoto() throws URISyntaxException {
        if (school.getLogo() == null) {
            File targetClassesDir = new File(ISched.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "\\images\\logo.png");
            try {
                FileInputStream fis = new FileInputStream(targetClassesDir);
                byte[] imageData = new byte[(int) targetClassesDir.length()];
                fis.read(imageData);
                school.setLogo(imageData);
            } catch (Exception e) {
                System.out.println("default of no photo is error");
            }
        }
    }

}
