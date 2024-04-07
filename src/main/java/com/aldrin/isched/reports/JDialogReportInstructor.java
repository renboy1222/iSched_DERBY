package com.aldrin.isched.reports;

import com.aldrin.isched.dao.impl.DBConnection;
import com.aldrin.isched.dao.impl.InstructorDAOImpl;
import com.aldrin.isched.dao.impl.ScheduleDAOImpl;
import com.aldrin.isched.dao.impl.SchoolYearDAOImpl;
import com.aldrin.isched.gui.JFrameMain;
import com.aldrin.isched.util.ComboBoxAutoFill;
import com.aldrin.isched.util.ComboBoxList;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.text.JTextComponent;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author ALRIN B.C.
 */
public class JDialogReportInstructor extends javax.swing.JDialog implements ActionListener {

    private JFrameMain jFrameMain;

    private DecimalFormat df = new DecimalFormat("##,##0.00");
    private JTextComponent editor;

    public JDialogReportInstructor(JFrameMain jFrameSariPOS, boolean modal) {
        super(jFrameSariPOS, modal);
        initComponents();
        this.jFrameMain = jFrameSariPOS;
        jPanelGrandTotal.putClientProperty(FlatClientProperties.STYLE,
                "[light]border: 0,0,0,0,shade(@background,30%),,18;" + "[dark]border: 0,0,0,0,tint(@background,30%),,8");
        setTitle("SCHEDULE REPORT");
//        comboBoxStudent();
//        editor = (JTextComponent) jComboBoxSchoolYear.getEditor().getEditorComponent();
//        editor.setDocument(new ComboBoxAutoFill(jComboBoxSchoolYear));
//        jComboBoxSchoolYear.setEditable(true);
//        jComboBoxSchoolYear.addActionListener(this);

        comboBoxSchoolYear();
        editor = (JTextComponent) jComboBoxSchoolYear.getEditor().getEditorComponent();
        editor.setDocument(new ComboBoxAutoFill(jComboBoxSchoolYear));
        jComboBoxSchoolYear.setEditable(true);
        jComboBoxSchoolYear.addActionListener(this);
        comboBoxInstructor();
        
        showReport();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel10 = new javax.swing.JPanel();
        jPanelFrameContainer = new javax.swing.JPanel();
        jPanelGrandTotal = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxSchoolYear = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxInstructor = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel31 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel10.setPreferredSize(new java.awt.Dimension(350, 80));
        jPanel10.setLayout(new java.awt.BorderLayout());

        jPanelFrameContainer.setPreferredSize(new java.awt.Dimension(260, 200));
        jPanelFrameContainer.setLayout(new java.awt.BorderLayout());

        jPanelGrandTotal.setPreferredSize(new java.awt.Dimension(260, 0));
        jPanelGrandTotal.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jDesktopPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jDesktopPane1.setOpaque(false);
        jDesktopPane1.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jDesktopPane1, java.awt.BorderLayout.CENTER);

        jPanelGrandTotal.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setPreferredSize(new java.awt.Dimension(835, 80));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setPreferredSize(new java.awt.Dimension(435, 100));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("INSTRUCTOR:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 45, 90, 30));

        jPanel3.add(jComboBoxSchoolYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 320, 30));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("SCHOOL YEAR:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 90, 30));

        jPanel3.add(jComboBoxInstructor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 45, 320, 30));

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel4.setPreferredSize(new java.awt.Dimension(10, 50));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, java.awt.BorderLayout.EAST);

        jPanelGrandTotal.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanelFrameContainer.add(jPanelGrandTotal, java.awt.BorderLayout.CENTER);

        jPanel29.setOpaque(false);
        jPanel29.setPreferredSize(new java.awt.Dimension(270, 5));

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1178, Short.MAX_VALUE)
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanelFrameContainer.add(jPanel29, java.awt.BorderLayout.NORTH);

        jPanel30.setOpaque(false);
        jPanel30.setPreferredSize(new java.awt.Dimension(270, 60));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new FlatSVGIcon("svg/print.svg",38,38));
        jButton1.setText("Print");
        jButton1.setMargin(new java.awt.Insets(2, 2, 3, 2));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel30.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 40));

        jPanelFrameContainer.add(jPanel30, java.awt.BorderLayout.SOUTH);

        jPanel31.setOpaque(false);
        jPanel31.setPreferredSize(new java.awt.Dimension(5, 0));

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE)
        );

        jPanelFrameContainer.add(jPanel31, java.awt.BorderLayout.EAST);

        jPanel32.setOpaque(false);
        jPanel32.setPreferredSize(new java.awt.Dimension(5, 0));

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE)
        );

        jPanelFrameContainer.add(jPanel32, java.awt.BorderLayout.WEST);

        jPanel10.add(jPanelFrameContainer, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel10, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1194, 651));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        autoPrint();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<Object> jComboBoxInstructor;
    private javax.swing.JComboBox<Object> jComboBoxSchoolYear;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelFrameContainer;
    private javax.swing.JPanel jPanelGrandTotal;
    // End of variables declaration//GEN-END:variables
//    private UserSales userSales = new UserSales();
//    private ArrayList<UserSales> userSalesList;
//
    private ScheduleDAOImpl studentDAOImpl = new ScheduleDAOImpl();

    public void showReport() {
        JasperPrint JPrint;
        try {
            DBConnection con = new DBConnection();
            con.getDBConn();
            String fullPath = System.getProperty("user.dir") + "/src/main/resources/reports/sched.jasper";
            Map<String, Object> param = new HashMap<String, Object>();

            ComboBoxList syId = (ComboBoxList) this.jComboBoxSchoolYear.getSelectedItem();
            param.put("SYID", syId.getId());
            JPrint = JasperFillManager.fillReport(fullPath, param, con.getCon());
            JRViewer jrv = new JRViewer(JPrint);
            jDesktopPane1.removeAll();
            jDesktopPane1.add(jrv);
            jDesktopPane1.revalidate();
        } catch (Exception ex) {
        }
    }

    public void autoPrint() {
        try {
            DBConnection con = new DBConnection();
            con.getDBConn();
            String fullPath = System.getProperty("user.dir") + "/src/main/resources/reports/sched.jasper";
            Map<String, Object> param = new HashMap<String, Object>();

            ComboBoxList syId = (ComboBoxList) this.jComboBoxSchoolYear.getSelectedItem();
            param.put("SYID", syId.getId());
            JasperPrint jp = JasperFillManager.fillReport(fullPath, param, con.getCon());
            JasperPrintManager.printReport(jp, true); // print to default printer
//            JasperExportManager.exportReportToPdfFile(jp, "C:\\Users\\admin\\Desktop\\userSales.pdf");
        } catch (Exception e) {
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == jComboBoxSchoolYear) {
                showReport();
            } else if (e.getSource() == jComboBoxSchoolYear) {
                showReport();
            }
        } catch (Exception ex) {

        }
    }

//    private void comboBoxStudent() {
//        studentDAOImpl.comboBoxStudent();
//        jComboBoxSchoolYear.removeAllItems();
//        for (ComboBoxList a : studentDAOImpl.getList()) {
//            this.jComboBoxSchoolYear.addItem(a);
//        }
//    }
    private SchoolYearDAOImpl schoolYearDAOImpl = new SchoolYearDAOImpl();
    private InstructorDAOImpl instructorDAOImpl = new InstructorDAOImpl();

    private void comboBoxSchoolYear() {
        schoolYearDAOImpl.comboBoxSchoolYear();
        jComboBoxSchoolYear.removeAllItems();
        for (ComboBoxList a : schoolYearDAOImpl.getList()) {
            this.jComboBoxSchoolYear.addItem(a);
        }
    }
    
    private void comboBoxInstructor() {
        instructorDAOImpl.comboBoxInstructor();
        jComboBoxInstructor.removeAllItems();
        for (ComboBoxList a : instructorDAOImpl.getList()) {
            this.jComboBoxInstructor.addItem(a);
        }
    }

}
