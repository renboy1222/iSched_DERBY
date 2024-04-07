/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.aldrin.isched.gui;

import com.aldrin.isched.dao.impl.CampusHeadDAOImpl;
import com.aldrin.isched.dao.impl.DayDAOImpl;
import com.aldrin.isched.dao.impl.InstructorDAOImpl;
import com.aldrin.isched.dao.impl.RoomDAOImpl;
import com.aldrin.isched.dao.impl.ScheduleDAOImpl;
import com.aldrin.isched.dao.impl.SchoolDAOImpl;
import com.aldrin.isched.dao.impl.SchoolYearDAOImpl;
import com.aldrin.isched.dao.impl.SectionDAOImpl;
import com.aldrin.isched.dao.impl.SubjectDAOImpl;
import com.aldrin.isched.dao.impl.TimeDAOImpl;
import com.aldrin.isched.gui.dialog.JDialogViewDay;
import com.aldrin.isched.gui.dialog.JDialogViewInstructor;
import com.aldrin.isched.gui.dialog.JDialogViewRoom;
import com.aldrin.isched.gui.dialog.JDialogViewSection;
import com.aldrin.isched.gui.dialog.JDialogViewSubject;
import com.aldrin.isched.gui.dialog.JDialogViewTime;
import com.aldrin.isched.model.CampusHead;
import com.aldrin.isched.model.Day;
import com.aldrin.isched.model.Instructor;
import com.aldrin.isched.model.Room;
import com.aldrin.isched.model.Schedule;
import com.aldrin.isched.model.School;
import com.aldrin.isched.model.SchoolYear;
import com.aldrin.isched.model.Section;
import com.aldrin.isched.model.Subject;
import com.aldrin.isched.model.Time;
import com.aldrin.isched.util.ComboBoxList;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author ALRIN B.C.
 */
public class JDialogClassSchedule extends javax.swing.JDialog implements ActionListener {

    private Schedule schedule = new Schedule();
    private JFrameMain jFrameRegister;
    static String title;
    private ScheduleDAOImpl scheduleDAOImpl = new ScheduleDAOImpl();
    private CampusHeadDAOImpl campusHeadDAOImpl = new CampusHeadDAOImpl();
//    private InstructorDAOImpl instructorDAOImpl = new InstructorDAOImpl();

    private Icon success = new FlatSVGIcon("svg/success.svg", 24, 24);
    private Icon error = new FlatSVGIcon("svg/error.svg", 24, 24);
    private JTextComponent editor;

    public JDialogClassSchedule(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.title = "New";
        initComponents();
        comboBoxSchoolYear();
        comboBoxSubject();

        comboBoxInstructor();
        comboBoxSection();
        comboBoxDay();
        comboBoxTime();
        comboBoxRoom();


        jComboBoxDay.addActionListener(this);
        jComboBoxTime.addActionListener(this);
        jComboBoxRoom.addActionListener(this);

        jComboBoxInstructor.addActionListener(this);
        jComboBoxSubject.addActionListener(this);
        jComboBoxSection.addActionListener(this);
        jComboBoxSchoolYear.setEnabled(false);
        jButtonSave.setEnabled(false);

        jButtonSubject.setEnabled(false);
        jButtonInstructor.setEnabled(false);
        jButtonSection.setEnabled(false);
        jButtonDay.setEnabled(false);
        jButtonTime.setEnabled(false);
        jButtonRoom.setEnabled(false);

    }

    public JDialogClassSchedule(java.awt.Frame parent, boolean modal, Schedule schedule, String title) {
        super(parent, modal);
        this.title = title;
        initComponents();
        this.schedule = schedule;
//        SCHEDULE ID", "INSTRUCTOR_ID", "SUBJECT_ID", "SECTION_ID", "DAY_ID", "TIME_ID","ROOM_ID", "SCHOOL_YEAR_ID"
        comboBoxSchoolYear();
        for (ComboBoxList a : this.schoolYearDAOImpl.getList()) {
            a.setSelectedId(schoolYearDAOImpl.getList(), String.valueOf(schedule.getSchoolYear().getId()), jComboBoxSchoolYear);
        }
        comboBoxSubject();
        for (ComboBoxList a : this.subjectDAOImpl.getList()) {
            a.setSelectedId(subjectDAOImpl.getList(), String.valueOf(schedule.getSubject().getId()), jComboBoxSubject);
        }
        comboBoxInstructor();
        for (ComboBoxList a : this.instructorDAOImpl.getList()) {
            a.setSelectedId(instructorDAOImpl.getList(), String.valueOf(schedule.getInstructor().getId()), jComboBoxInstructor);
        }
        comboBoxSection();
        for (ComboBoxList a : this.sectionDAOImpl.getList()) {
            a.setSelectedId(sectionDAOImpl.getList(), String.valueOf(schedule.getSection().getId()), jComboBoxSection);
        }
        comboBoxDay();
        for (ComboBoxList a : this.dayDAOImpl.getList()) {
            a.setSelectedId(dayDAOImpl.getList(), String.valueOf(schedule.getDay().getId()), jComboBoxDay);
        }
        comboBoxTime();
        for (ComboBoxList a : this.timeDAOImpl.getList()) {
            a.setSelectedId(timeDAOImpl.getList(), String.valueOf(schedule.getTime().getId()), jComboBoxTime);
        }
        comboBoxRoom();
        for (ComboBoxList a : this.roomDAOImpl.getList()) {
            a.setSelectedId(roomDAOImpl.getList(), String.valueOf(schedule.getRoom().getId()), jComboBoxRoom);
        }


        jComboBoxDay.addActionListener(this);
        jComboBoxTime.addActionListener(this);
        jComboBoxRoom.addActionListener(this);

        jComboBoxInstructor.addActionListener(this);
        jComboBoxSubject.addActionListener(this);
        jComboBoxSection.addActionListener(this);
        jComboBoxSchoolYear.setEnabled(false);

    }

    public JDialogClassSchedule(java.awt.Frame parent, boolean modal, String title, Schedule schedule) {
        super(parent, modal);
        this.title = title;
        initComponents();
        this.schedule = schedule;
//        SCHEDULE ID", "INSTRUCTOR_ID", "SUBJECT_ID", "SECTION_ID", "DAY_ID", "TIME_ID","ROOM_ID", "SCHOOL_YEAR_ID"
        comboBoxSchoolYear();
        for (ComboBoxList a : this.schoolYearDAOImpl.getList()) {
            a.setSelectedId(schoolYearDAOImpl.getList(), String.valueOf(schedule.getSchoolYear().getId()), jComboBoxSchoolYear);
        }
        comboBoxSubject();
        for (ComboBoxList a : this.subjectDAOImpl.getList()) {
            a.setSelectedId(subjectDAOImpl.getList(), String.valueOf(schedule.getSubject().getId()), jComboBoxSubject);
        }
        comboBoxInstructor();
        for (ComboBoxList a : this.instructorDAOImpl.getList()) {
            a.setSelectedId(instructorDAOImpl.getList(), String.valueOf(schedule.getInstructor().getId()), jComboBoxInstructor);
        }
        comboBoxSection();
        for (ComboBoxList a : this.sectionDAOImpl.getList()) {
            a.setSelectedId(sectionDAOImpl.getList(), String.valueOf(schedule.getSection().getId()), jComboBoxSection);
        }
        comboBoxDay();
        for (ComboBoxList a : this.dayDAOImpl.getList()) {
            a.setSelectedId(dayDAOImpl.getList(), String.valueOf(schedule.getDay().getId()), jComboBoxDay);
        }
        comboBoxTime();
        for (ComboBoxList a : this.timeDAOImpl.getList()) {
            a.setSelectedId(timeDAOImpl.getList(), String.valueOf(schedule.getTime().getId()), jComboBoxTime);
        }
        comboBoxRoom();
        for (ComboBoxList a : this.roomDAOImpl.getList()) {
            a.setSelectedId(roomDAOImpl.getList(), String.valueOf(schedule.getRoom().getId()), jComboBoxRoom);
        }


        jComboBoxDay.addActionListener(this);
        jComboBoxTime.addActionListener(this);
        jComboBoxRoom.addActionListener(this);

        jComboBoxInstructor.addActionListener(this);
        jComboBoxSubject.addActionListener(this);
        jComboBoxSection.addActionListener(this);

        jComboBoxSchoolYear.setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxRoom = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxSchoolYear = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxSubject = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxInstructor = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxSection = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxDay = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxTime = new javax.swing.JComboBox<>();
        jPanel11 = new javax.swing.JPanel();
        jButtonSave = new javax.swing.JButton();
        jButtonRoom = new javax.swing.JButton();
        jButtonSubject = new javax.swing.JButton();
        jButtonInstructor = new javax.swing.JButton();
        jButtonSection = new javax.swing.JButton();
        jButtonDay = new javax.swing.JButton();
        jButtonTime = new javax.swing.JButton();
        jLabelRoom = new javax.swing.JLabel();
        jLabelSubject = new javax.swing.JLabel();
        jLabelInstructor = new javax.swing.JLabel();
        jLabelSection = new javax.swing.JLabel();
        jLabelDay = new javax.swing.JLabel();
        jLabelTime = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CLASS SCHEDULE");

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel7.setPreferredSize(new java.awt.Dimension(400, 0));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("ROOM:");
        jPanel9.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 100, 29));

        jPanel9.add(jComboBoxRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 260, 280, 30));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("SCHOOL YEAR:");
        jPanel9.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, 29));

        jPanel9.add(jComboBoxSchoolYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 20, 280, 30));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("SUBJECT:");
        jPanel9.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 100, 29));

        jPanel9.add(jComboBoxSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 140, 280, 30));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("INSTRUCTOR:");
        jPanel9.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 100, 29));

        jPanel9.add(jComboBoxInstructor, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 60, 280, 30));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("SECTION:");
        jPanel9.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 100, 29));

        jPanel9.add(jComboBoxSection, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 100, 280, 30));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("DAY:");
        jPanel9.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 100, 29));

        jPanel9.add(jComboBoxDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 180, 280, 30));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("TIME:");
        jPanel9.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 100, 29));

        jPanel9.add(jComboBoxTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 220, 280, 30));

        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 10));

        jButtonSave.setIcon(new FlatSVGIcon("svg/save.svg",24,24));
        jButtonSave.setText("SAVE");
        jButtonSave.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButtonSave.setMaximumSize(new java.awt.Dimension(80, 32));
        jButtonSave.setMinimumSize(new java.awt.Dimension(80, 32));
        jButtonSave.setPreferredSize(new java.awt.Dimension(180, 32));
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });
        jPanel11.add(jButtonSave);

        jPanel9.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 490, 60));

        jButtonRoom.setIcon(new FlatSVGIcon("svg/preview.svg",24,24));
        jButtonRoom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRoom.setFocusable(false);
        jButtonRoom.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButtonRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRoomActionPerformed(evt);
            }
        });
        jPanel9.add(jButtonRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 40, 30));

        jButtonSubject.setIcon(new FlatSVGIcon("svg/preview.svg",24,24));
        jButtonSubject.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSubject.setFocusable(false);
        jButtonSubject.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButtonSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubjectActionPerformed(evt);
            }
        });
        jPanel9.add(jButtonSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 40, 30));

        jButtonInstructor.setIcon(new FlatSVGIcon("svg/preview.svg",24,24));
        jButtonInstructor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonInstructor.setFocusable(false);
        jButtonInstructor.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButtonInstructor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInstructorActionPerformed(evt);
            }
        });
        jPanel9.add(jButtonInstructor, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 40, 30));

        jButtonSection.setIcon(new FlatSVGIcon("svg/preview.svg",24,24));
        jButtonSection.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSection.setFocusable(false);
        jButtonSection.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButtonSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSectionActionPerformed(evt);
            }
        });
        jPanel9.add(jButtonSection, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 40, 30));

        jButtonDay.setIcon(new FlatSVGIcon("svg/preview.svg",24,24));
        jButtonDay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonDay.setFocusable(false);
        jButtonDay.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButtonDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDayActionPerformed(evt);
            }
        });
        jPanel9.add(jButtonDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 40, 30));

        jButtonTime.setIcon(new FlatSVGIcon("svg/preview.svg",24,24));
        jButtonTime.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonTime.setFocusable(false);
        jButtonTime.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButtonTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTimeActionPerformed(evt);
            }
        });
        jPanel9.add(jButtonTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 40, 30));
        jPanel9.add(jLabelRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 40, 30));

        jLabelSubject.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelSubject.setForeground(new java.awt.Color(204, 0, 0));
        jPanel9.add(jLabelSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 40, 30));

        jLabelInstructor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelInstructor.setForeground(new java.awt.Color(204, 0, 0));
        jPanel9.add(jLabelInstructor, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 40, 30));

        jLabelSection.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelSection.setForeground(new java.awt.Color(204, 0, 0));
        jPanel9.add(jLabelSection, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 40, 30));
        jPanel9.add(jLabelDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 40, 30));
        jPanel9.add(jLabelTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 40, 30));

        jPanel7.add(jPanel9, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel4.setPreferredSize(new java.awt.Dimension(1009, 5));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, java.awt.BorderLayout.SOUTH);

        jPanel5.setPreferredSize(new java.awt.Dimension(5, 250));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, java.awt.BorderLayout.EAST);

        jPanel6.setPreferredSize(new java.awt.Dimension(5, 250));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, java.awt.BorderLayout.WEST);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(522, 413));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        if (this.title.equals("New")) {
            int response = JOptionPane.showConfirmDialog(jFrameRegister, "Are you sure to save ?", "Save confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                this.schedule.setId(null);
                ComboBoxList syId = (ComboBoxList) this.jComboBoxSchoolYear.getSelectedItem();
                ComboBoxList subjectId = (ComboBoxList) this.jComboBoxSubject.getSelectedItem();
                ComboBoxList instructorId = (ComboBoxList) this.jComboBoxInstructor.getSelectedItem();
                ComboBoxList sectionId = (ComboBoxList) this.jComboBoxSection.getSelectedItem();
                ComboBoxList dayId = (ComboBoxList) this.jComboBoxDay.getSelectedItem();
                ComboBoxList timeId = (ComboBoxList) this.jComboBoxTime.getSelectedItem();
                ComboBoxList roomId = (ComboBoxList) this.jComboBoxRoom.getSelectedItem();
                SchoolYear schoolYear = new SchoolYear();
                Subject subject = new Subject();
                Instructor instructor = new Instructor();
                Section section = new Section();
                Day day = new Day();
                Time time = new Time();
                Room room = new Room();
                CampusHead campusHead = new CampusHead();
                schoolYear.setId(syId.getId());
                subject.setId(subjectId.getId());
                instructor.setId(instructorId.getId());
                section.setId(sectionId.getId());
                day.setId(dayId.getId());
                time.setId(timeId.getId());
                room.setId(roomId.getId());
                this.schedule.setSchoolYear(schoolYear);
                this.schedule.setSubject(subject);
                this.schedule.setInstructor(instructor);
                this.schedule.setSection(section);
                this.schedule.setDay(day);
                this.schedule.setTime(time);
                this.schedule.setRoom(room);
                Long campusHeadId = campusHeadDAOImpl.getActiveCampusHeadId();
                campusHead.setId(campusHeadId);
                School s = schoolDAOImpl.selectSchool();

                this.schedule.setSchool(s);
                this.schedule.setCampusHead(campusHead);
                this.scheduleDAOImpl.addSchedule(schedule);
                this.dispose();
            }
        } else if (this.title.equals("Update")) {
            int response = JOptionPane.showConfirmDialog(jFrameRegister, "Are you sure to update  ?", "Save confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                ComboBoxList syId = (ComboBoxList) this.jComboBoxSchoolYear.getSelectedItem();
                ComboBoxList subjectId = (ComboBoxList) this.jComboBoxSubject.getSelectedItem();
                ComboBoxList instructorId = (ComboBoxList) this.jComboBoxInstructor.getSelectedItem();
                ComboBoxList sectionId = (ComboBoxList) this.jComboBoxSection.getSelectedItem();
                ComboBoxList dayId = (ComboBoxList) this.jComboBoxDay.getSelectedItem();
                ComboBoxList timeId = (ComboBoxList) this.jComboBoxTime.getSelectedItem();
                ComboBoxList roomId = (ComboBoxList) this.jComboBoxRoom.getSelectedItem();
                SchoolYear schoolYear = new SchoolYear();
                Subject subject = new Subject();
                Instructor instructor = new Instructor();
                Section section = new Section();
                Day day = new Day();
                Time time = new Time();
                Room room = new Room();
                schoolYear.setId(syId.getId());
                subject.setId(subjectId.getId());
                instructor.setId(instructorId.getId());
                section.setId(sectionId.getId());
                day.setId(dayId.getId());
                time.setId(timeId.getId());
                room.setId(roomId.getId());
                this.schedule.setSchoolYear(schoolYear);
                this.schedule.setSubject(subject);
                this.schedule.setInstructor(instructor);
                this.schedule.setSection(section);
                this.schedule.setDay(day);
                this.schedule.setTime(time);
                this.schedule.setRoom(room);
                this.scheduleDAOImpl.updateSchedule(schedule);
                this.dispose();
            }
        } else if (this.title.equals("Delete")) {
            int response = JOptionPane.showConfirmDialog(jFrameRegister, "Are you sure to delete  ?", "Save confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                this.scheduleDAOImpl.deleteSchedule(schedule);
                this.dispose();
            }
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubjectActionPerformed
        ComboBoxList subjectId = (ComboBoxList) this.jComboBoxSubject.getSelectedItem();
        JDialogViewSubject viewSubject = new JDialogViewSubject(jFrameRegister, true, subjectId.getId());
        viewSubject.setVisible(true);
    }//GEN-LAST:event_jButtonSubjectActionPerformed

    private void jButtonInstructorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInstructorActionPerformed
        ComboBoxList instructorId = (ComboBoxList) this.jComboBoxInstructor.getSelectedItem();
        JDialogViewInstructor viewInstructor = new JDialogViewInstructor(jFrameRegister, true, instructorId.getId());
        viewInstructor.setVisible(true);
    }//GEN-LAST:event_jButtonInstructorActionPerformed

    private void jButtonSectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSectionActionPerformed
        ComboBoxList sectionId = (ComboBoxList) this.jComboBoxSection.getSelectedItem();
        JDialogViewSection viewSection = new JDialogViewSection(jFrameRegister, true, sectionId.getId());
        viewSection.setVisible(true);
    }//GEN-LAST:event_jButtonSectionActionPerformed

    private void jButtonDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDayActionPerformed
        ComboBoxList sectionId = (ComboBoxList) this.jComboBoxDay.getSelectedItem();
        JDialogViewDay viewDay = new JDialogViewDay(jFrameRegister, true, sectionId.getId());
        viewDay.setVisible(true);
    }//GEN-LAST:event_jButtonDayActionPerformed

    private void jButtonTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTimeActionPerformed
        ComboBoxList timeId = (ComboBoxList) this.jComboBoxTime.getSelectedItem();
        JDialogViewTime viewTime = new JDialogViewTime(jFrameRegister, true, timeId.getId());
        viewTime.setVisible(true);
    }//GEN-LAST:event_jButtonTimeActionPerformed

    private void jButtonRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRoomActionPerformed
        ComboBoxList roomId = (ComboBoxList) this.jComboBoxRoom.getSelectedItem();
        JDialogViewRoom viewRoom = new JDialogViewRoom(jFrameRegister, true, roomId.getId());
        viewRoom.setVisible(true);
    }//GEN-LAST:event_jButtonRoomActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDay;
    private javax.swing.JButton jButtonInstructor;
    private javax.swing.JButton jButtonRoom;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonSection;
    private javax.swing.JButton jButtonSubject;
    private javax.swing.JButton jButtonTime;
    private javax.swing.JComboBox<Object> jComboBoxDay;
    private javax.swing.JComboBox<Object> jComboBoxInstructor;
    private javax.swing.JComboBox<Object> jComboBoxRoom;
    private javax.swing.JComboBox<Object> jComboBoxSchoolYear;
    private javax.swing.JComboBox<Object> jComboBoxSection;
    private javax.swing.JComboBox<Object> jComboBoxSubject;
    private javax.swing.JComboBox<Object> jComboBoxTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelDay;
    private javax.swing.JLabel jLabelInstructor;
    private javax.swing.JLabel jLabelRoom;
    private javax.swing.JLabel jLabelSection;
    private javax.swing.JLabel jLabelSubject;
    private javax.swing.JLabel jLabelTime;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables

    private SchoolYearDAOImpl schoolYearDAOImpl = new SchoolYearDAOImpl();
    private SubjectDAOImpl subjectDAOImpl = new SubjectDAOImpl();
    private InstructorDAOImpl instructorDAOImpl = new InstructorDAOImpl();
    private SectionDAOImpl sectionDAOImpl = new SectionDAOImpl();
    private DayDAOImpl dayDAOImpl = new DayDAOImpl();
    private TimeDAOImpl timeDAOImpl = new TimeDAOImpl();
    private RoomDAOImpl roomDAOImpl = new RoomDAOImpl();
    private SchoolDAOImpl schoolDAOImpl = new SchoolDAOImpl();

    private void comboBoxSchoolYear() {
        schoolYearDAOImpl.comboBoxSchoolYear();
        jComboBoxSchoolYear.removeAllItems();
        for (ComboBoxList a : schoolYearDAOImpl.getList()) {
            this.jComboBoxSchoolYear.addItem(a);
        }
    }

    private void comboBoxSubject() {
        subjectDAOImpl.comboBoxSubject();
        jComboBoxSubject.removeAllItems();
        for (ComboBoxList a : subjectDAOImpl.getList()) {
            this.jComboBoxSubject.addItem(a);
        }
    }

    private void comboBoxInstructor() {
        instructorDAOImpl.comboBoxInstructor();
        jComboBoxInstructor.removeAllItems();
        for (ComboBoxList a : instructorDAOImpl.getList()) {
            this.jComboBoxInstructor.addItem(a);
        }
    }

    private void comboBoxSection() {
        sectionDAOImpl.comboBoxSection();
        jComboBoxSection.removeAllItems();
        for (ComboBoxList a : sectionDAOImpl.getList()) {
            this.jComboBoxSection.addItem(a);
        }
    }

    private void comboBoxDay() {
        dayDAOImpl.comboBoxDay();
        jComboBoxDay.removeAllItems();
        for (ComboBoxList a : dayDAOImpl.getList()) {
            this.jComboBoxDay.addItem(a);
        }
    }

    private void comboBoxTime() {
        timeDAOImpl.comboBoxTime();
        jComboBoxTime.removeAllItems();
        for (ComboBoxList a : timeDAOImpl.getList()) {
            this.jComboBoxTime.addItem(a);
        }
    }

    private void comboBoxRoom() {
        roomDAOImpl.comboBoxRoom();
        jComboBoxRoom.removeAllItems();
        for (ComboBoxList a : roomDAOImpl.getList()) {
            this.jComboBoxRoom.addItem(a);
        }
    }

    public DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"SCHEDULE ID", "INSTRUCTOR_ID", "SUBJECT_ID", "SECTION_ID", "DAY_ID", "TIME_ID",
        "ROOM_ID", "SCHOOL_YEAR_ID", "#", "SECTION", "SUBJECT", "INSTRUCTOR", "DAY", "TIME", "ROOM", "UNIT"}, 0) {
        public Class getColumnClass(int columnIndex) {
            if (columnIndex == 0) {
                return String.class;
            }
            switch (columnIndex) {
                case 1:
                    return Integer.class;
                case 2:
                    return String.class;
                case 3:
                    return String.class;
                case 4:
                    return String.class;
                case 5:
                    return String.class;
                case 6:
                    return String.class;
                case 7:
                    return String.class;
                default:
                    return String.class;
            }
        }

        public boolean isCellEditable(int row, int col) {
            if (col < 10) {
                return false;

            } else {
                return true;
            }
        }
    };

    private ArrayList<Schedule> scheduleList;
// " SCHEDULE.ID,INSTRUCTOR_ID,SUBJECT_ID,SECTION_ID,DAY_ID,TIME_ID,ROOM_ID,SCHOOL_YEAR_ID, 
// ,"#",  "SECTION", "SUBJECT", "INSTRUCTOR", "DAY", "TIME", "ROOM","UNITS"

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jComboBoxDay) {
            ComboBoxList syId = (ComboBoxList) this.jComboBoxSchoolYear.getSelectedItem();
            ComboBoxList dayId = (ComboBoxList) this.jComboBoxDay.getSelectedItem();
            ComboBoxList roomId = (ComboBoxList) this.jComboBoxRoom.getSelectedItem();
            //day room time
            if (scheduleDAOImpl.isConflictSchedule(dayId.getId(), roomId.getId(), jComboBoxTime.getSelectedItem().toString(), syId.getId())) {
                jComboBoxRoom.putClientProperty("JComponent.outline", "error");
                jLabelRoom.setIcon(error);
                jComboBoxDay.putClientProperty("JComponent.outline", "error");
                jLabelDay.setIcon(error);
                jComboBoxTime.putClientProperty("JComponent.outline", "error");
                jLabelTime.setIcon(error);
                jButtonSave.setEnabled(false);
                Schedule sched = scheduleDAOImpl.conflictScheduleDetails(dayId.getId(), roomId.getId(), jComboBoxTime.getSelectedItem().toString(), syId.getId());
                if (sched != null) {

                    JDialogConflictDetails conflict = new JDialogConflictDetails(jFrameRegister, true, sched);
                    conflict.setVisible(true);
                }
            } else {
                jComboBoxRoom.putClientProperty("JComponent.outline", null);
                jLabelRoom.setIcon(success);
                jComboBoxDay.putClientProperty("JComponent.outline", null);
                jLabelDay.setIcon(success);
                jComboBoxTime.putClientProperty("JComponent.outline", null);
                jLabelTime.setIcon(success);
                jButtonSave.setEnabled(true);
            }
            Integer days = scheduleDAOImpl.dayUse(dayId.getId());
            if (days > 0) {
                jButtonDay.setEnabled(true);
            } else {
                jButtonDay.setEnabled(false);
            }
        } else if (e.getSource() == jComboBoxTime) {
            ComboBoxList syId = (ComboBoxList) this.jComboBoxSchoolYear.getSelectedItem();
            ComboBoxList dayId = (ComboBoxList) this.jComboBoxDay.getSelectedItem();
            ComboBoxList roomId = (ComboBoxList) this.jComboBoxRoom.getSelectedItem();
            //day room time
            if (scheduleDAOImpl.isConflictSchedule(dayId.getId(), roomId.getId(), jComboBoxTime.getSelectedItem().toString(), syId.getId())) {
                jComboBoxRoom.putClientProperty("JComponent.outline", "error");
                jLabelRoom.setIcon(error);
                jComboBoxDay.putClientProperty("JComponent.outline", "error");
                jLabelDay.setIcon(error);
                jComboBoxTime.putClientProperty("JComponent.outline", "error");
                jLabelTime.setIcon(error);
                jButtonSave.setEnabled(false);
                Schedule sched = scheduleDAOImpl.conflictScheduleDetails(dayId.getId(), roomId.getId(), jComboBoxTime.getSelectedItem().toString(), syId.getId());
                if (sched != null) {
                    JDialogConflictDetails conflict = new JDialogConflictDetails(jFrameRegister, true, sched);
                    conflict.setVisible(true);
                }
            } else {
                jComboBoxRoom.putClientProperty("JComponent.outline", null);
                jLabelRoom.setIcon(success);
                jComboBoxDay.putClientProperty("JComponent.outline", null);
                jLabelDay.setIcon(success);
                jComboBoxTime.putClientProperty("JComponent.outline", null);
                jLabelTime.setIcon(success);
                jButtonSave.setEnabled(true);
            }
            ComboBoxList timeId = (ComboBoxList) this.jComboBoxTime.getSelectedItem();
            Integer times = scheduleDAOImpl.timeUse(timeId.getId());
            if (times > 0) {
                jButtonTime.setEnabled(true);
            } else {
                jButtonTime.setEnabled(false);
            }
        } else if (e.getSource() == jComboBoxRoom) {
            ComboBoxList syId = (ComboBoxList) this.jComboBoxSchoolYear.getSelectedItem();
            ComboBoxList dayId = (ComboBoxList) this.jComboBoxDay.getSelectedItem();
            ComboBoxList roomId = (ComboBoxList) this.jComboBoxRoom.getSelectedItem();
            //day room time
            if (scheduleDAOImpl.isConflictSchedule(dayId.getId(), roomId.getId(), jComboBoxTime.getSelectedItem().toString(), syId.getId())) {
                jComboBoxRoom.putClientProperty("JComponent.outline", "error");
                jLabelRoom.setIcon(error);
                jComboBoxDay.putClientProperty("JComponent.outline", "error");
                jLabelDay.setIcon(error);
                jComboBoxTime.putClientProperty("JComponent.outline", "error");
                jLabelTime.setIcon(error);
                jButtonSave.setEnabled(false);
                Schedule sched = scheduleDAOImpl.conflictScheduleDetails(dayId.getId(), roomId.getId(), jComboBoxTime.getSelectedItem().toString(), syId.getId());
                if (sched != null) {
                    JDialogConflictDetails conflict = new JDialogConflictDetails(jFrameRegister, true, sched);
                    conflict.setVisible(true);
                }
            } else {
                jComboBoxRoom.putClientProperty("JComponent.outline", null);
                jLabelRoom.setIcon(success);
                jComboBoxDay.putClientProperty("JComponent.outline", null);
                jLabelDay.setIcon(success);
                jComboBoxTime.putClientProperty("JComponent.outline", null);
                jLabelTime.setIcon(success);
                jButtonSave.setEnabled(true);
            }
            Integer rooms = scheduleDAOImpl.roomUse(roomId.getId());
            if (rooms > 0) {
                jButtonRoom.setEnabled(true);
            } else {
                jButtonRoom.setEnabled(false);
            }
        } else if (e.getSource() == jComboBoxInstructor) {
                ComboBoxList syId = (ComboBoxList) this.jComboBoxSchoolYear.getSelectedItem();
                ComboBoxList instructorId = (ComboBoxList) this.jComboBoxInstructor.getSelectedItem();
                Integer subjects = scheduleDAOImpl.instructorsSubject(instructorId.getId(), syId.getId());
                jLabelInstructor.setText(String.valueOf(subjects));
                if (subjects > 0) {
                    jButtonInstructor.setEnabled(true);
                } else {
                    jButtonInstructor.setEnabled(false);
                }

        } else if (e.getSource() == jComboBoxSubject) {
                ComboBoxList syId = (ComboBoxList) this.jComboBoxSchoolYear.getSelectedItem();
                ComboBoxList subjectId = (ComboBoxList) this.jComboBoxSubject.getSelectedItem();
                Integer subjects = scheduleDAOImpl.subjectsUse(subjectId.getId(), syId.getId());
                jLabelSubject.setText(String.valueOf(subjects));
                if (subjects > 0) {
                    jButtonSubject.setEnabled(true);
                } else {
                    jButtonSubject.setEnabled(false);
                }
            
        } else if (e.getSource() == jComboBoxSection) {
                ComboBoxList syId = (ComboBoxList) this.jComboBoxSchoolYear.getSelectedItem();
                ComboBoxList sectionId = (ComboBoxList) this.jComboBoxSection.getSelectedItem();
                Integer sections = scheduleDAOImpl.sectionUse(sectionId.getId(), syId.getId());
                jLabelSection.setText(String.valueOf(sections));
                if (sections > 0) {
                    jButtonSection.setEnabled(true);
                } else {
                    jButtonSection.setEnabled(false);
                }
        }

    }

}
