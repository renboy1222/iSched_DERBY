/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.aldrin.isched.gui.dialog.au;

import com.aldrin.isched.dao.impl.InstructorDAOImpl;
import com.aldrin.isched.gui.JFrameMain;
import com.aldrin.isched.model.Instructor;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author ALDRIN B. C.
 */
public class JDialogInstructorAU extends javax.swing.JDialog {

   
    private JFrameMain jFrameMain;
    private Instructor instructor = new Instructor();
    static String title;
    private InstructorDAOImpl instructorDAOImpl = new InstructorDAOImpl();

    public JDialogInstructorAU(JFrameMain jFrameMain, boolean modal) {
        super(jFrameMain, modal);
        initComponents();
        setTitle("New");
        this.title = "New";
        jButton1.setIcon(new FlatSVGIcon("svg/save.svg", 24, 24));
        jTextFieldInstrcuttor.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "PROFESSOR/INSTRUCTOR");
        jTextFieldInstrcuttor.setText(instructor.getInstructor());
        jButton1.setEnabled(false);

    }

    public JDialogInstructorAU(JFrameMain jFrameMain, boolean modal, Instructor instructor, String title) {
        super(jFrameMain, modal);
        initComponents();
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(187, 187, 187));
        setTitle(title);
        this.title = title;
        this.instructor = instructor;
        jButton1.setIcon(new FlatSVGIcon("svg/edit.svg", 24, 24));
        jButton1.setText(title);
        jTextFieldInstrcuttor.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "PROFESSOR/INSTRUCTOR");
        jTextFieldInstrcuttor.setText(this.instructor.getInstructor());
        jButton1.setEnabled(false);
    }

    public JDialogInstructorAU(JFrameMain jFrameMain, boolean modal, String title, Instructor instructor) {
        super(jFrameMain, modal);
        initComponents();
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(187, 187, 187));
        setTitle(title);
        this.instructor = instructor;
        this.title = title;
        jButton1.setIcon(new FlatSVGIcon("svg/delete.svg", 24, 24));
        jButton1.setText(title);
        jTextFieldInstrcuttor.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "PROFESSOR/INSTRUCTOR");
        jTextFieldInstrcuttor.setText(instructor.getInstructor());
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
        jTextFieldInstrcuttor = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabelMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("INSTRUCTOR:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 80, 30));

        jTextFieldInstrcuttor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldInstrcuttorKeyReleased(evt);
            }
        });
        getContentPane().add(jTextFieldInstrcuttor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 250, 30));

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 140, 30));

        jLabelMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabelMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 330, 30));

        setSize(new java.awt.Dimension(374, 222));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (this.title.equals("New")) {
            int response = JOptionPane.showConfirmDialog(jFrameMain, "Are you sure to save " + jTextFieldInstrcuttor.getText() + " ?", "Save confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                this.instructor.setId(null);
                this.instructor.setInstructor(jTextFieldInstrcuttor.getText());
                instructorDAOImpl.addInstructor(instructor);
                this.dispose();
            }
        } else if (this.title.equals("Update")) {
            int response = JOptionPane.showConfirmDialog(jFrameMain, "Are you sure to update " + jTextFieldInstrcuttor.getText() + " ?", "Save confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                this.instructor.setInstructor(jTextFieldInstrcuttor.getText());
                instructorDAOImpl.updateInstructor(instructor);
                this.dispose();
            }
        } else if (this.title.equals("Delete")) {
            int response = JOptionPane.showConfirmDialog(jFrameMain, "Are you sure to delete " + jTextFieldInstrcuttor.getText() + " ?", "Save confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                instructorDAOImpl.deleteInstructor(instructor);
                this.dispose();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldInstrcuttorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldInstrcuttorKeyReleased
        if ((instructorDAOImpl.isDuplicate(jTextFieldInstrcuttor.getText()) == true)) {
            jLabelMessage.setText("Duplicate days are not allowed!");
            jTextFieldInstrcuttor.putClientProperty("JComponent.outline", "error");
            jButton1.setEnabled(false);
        } else if ((jTextFieldInstrcuttor.getText().isEmpty())) {
            jLabelMessage.setText("Day is required!");
            jTextFieldInstrcuttor.putClientProperty("JComponent.outline", "error");
            jButton1.setEnabled(false);
        } else {
            jTextFieldInstrcuttor.putClientProperty("JComponent.outline", null);
            jButton1.setEnabled(true);
            jLabelMessage.setText("");
        }
    }//GEN-LAST:event_jTextFieldInstrcuttorKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JTextField jTextFieldInstrcuttor;
    // End of variables declaration//GEN-END:variables
}