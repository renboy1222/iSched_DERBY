/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.aldrin.isched.gui.dialog.au;

import com.aldrin.isched.dao.impl.SectionDAOImpl;
import com.aldrin.isched.gui.JFrameMain;
import com.aldrin.isched.model.Section;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author ALDRIN B. C.
 */
public class JDialogSectionAU extends javax.swing.JDialog {

   
    private JFrameMain jFrameMain;
    private Section section = new Section();
    static String title;
    private SectionDAOImpl sectionDAOImpl = new SectionDAOImpl();

    public JDialogSectionAU(JFrameMain jFrameMain, boolean modal) {
        super(jFrameMain, modal);
        initComponents();
        setTitle("New");
        this.title = "New";
        jButton1.setIcon(new FlatSVGIcon("svg/save.svg", 24, 24));
        jTextFieldCode.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "CODE");
        jTextFieldCode.setText(section.getCode());
        jButton1.setEnabled(false);

    }

    public JDialogSectionAU(JFrameMain jFrameMain, boolean modal, Section section, String title) {
        super(jFrameMain, modal);
        initComponents();
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(187, 187, 187));
        setTitle(title);
        this.title = title;
        this.section = section;
        jButton1.setIcon(new FlatSVGIcon("svg/edit.svg", 24, 24));
        jButton1.setText(title);
        jTextFieldCode.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "CODE");
        jTextFieldCode.setText(section.getCode());
        jButton1.setEnabled(false);
    }

    public JDialogSectionAU(JFrameMain jFrameMain, boolean modal, String title, Section section) {
        super(jFrameMain, modal);
        initComponents();
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(187, 187, 187));
        setTitle(title);
        this.section = section;
        this.title = title;
        jButton1.setIcon(new FlatSVGIcon("svg/delete.svg", 24, 24));
        jButton1.setText(title);
        jTextFieldCode.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "CODE");
        jTextFieldCode.setText(section.getCode());
        jButton1.setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldCode = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabelMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("CODE:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 80, 30));

        jTextFieldCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldCodeKeyReleased(evt);
            }
        });
        getContentPane().add(jTextFieldCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 250, 30));

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 140, 30));

        jLabelMessage.setForeground(new java.awt.Color(204, 0, 0));
        jLabelMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabelMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 330, 30));

        setSize(new java.awt.Dimension(366, 190));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (this.title.equals("New")) {
            int response = JOptionPane.showConfirmDialog(jFrameMain, "Are you sure to save " + jTextFieldCode.getText() + " ?", "Save confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                this.section.setId(null);
                this.section.setCode(jTextFieldCode.getText());
                sectionDAOImpl.addSection(section);
                this.dispose();
            }
        } else if (this.title.equals("Update")) {
            int response = JOptionPane.showConfirmDialog(jFrameMain, "Are you sure to update " + jTextFieldCode.getText() + " ?", "Save confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                this.section.setCode(jTextFieldCode.getText());
                sectionDAOImpl.updateSection(section);
                this.dispose();
            }
        } else if (this.title.equals("Delete")) {
            int response = JOptionPane.showConfirmDialog(jFrameMain, "Are you sure to delete " + jTextFieldCode.getText() + " ?", "Save confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                sectionDAOImpl.deleteSection(section);
                this.dispose();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCodeKeyReleased
        if ((sectionDAOImpl.isDuplicate(jTextFieldCode.getText()) == true)) {
            jLabelMessage.setText("Duplicate sections are not allowed!");
            jTextFieldCode.putClientProperty("JComponent.outline", "error");
            jButton1.setEnabled(false);
        } else if ((jTextFieldCode.getText().isEmpty())) {
            jLabelMessage.setText("Section is required!");
            jTextFieldCode.putClientProperty("JComponent.outline", "error");
            jButton1.setEnabled(false);
        } else {
            jTextFieldCode.putClientProperty("JComponent.outline", null);
            jButton1.setEnabled(true);
            jLabelMessage.setText("");
        }
    }//GEN-LAST:event_jTextFieldCodeKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JTextField jTextFieldCode;
    // End of variables declaration//GEN-END:variables
}
