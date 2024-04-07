/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.isched.controller;


import com.aldrin.isched.dao.impl.UserAccountDAOImpl;
import com.aldrin.isched.gui.JFrameLogin;
import com.aldrin.isched.gui.JFrameMain;
import com.aldrin.isched.model.Role;
import com.aldrin.isched.model.UserAccount;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author ALRIN B.C.
 */
@Setter
@Getter
@ToString
public class AppController {

    JFrameMain jFrameRegister = new JFrameMain();
    JFrameLogin jFrameLogin = new JFrameLogin();

    public AppController(JFrameLogin login) {
        this.jFrameLogin = login;
        this.jFrameLogin.setVisible(true);
        this.jFrameLogin.addLoingListener(new LoginListener());
        this.jFrameLogin.addLoginKeyListener(new LoginKeyListener());

    }

    class LoginKeyListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent evt) {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                userAccessAccount();
            }
        }
    }

    class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            userAccessAccount();
        }
    }

    private void userAccessAccount() {
        UserAccountDAOImpl userDAOImpl = new UserAccountDAOImpl();
        UserAccount user = new UserAccount();
        user.setUsername(jFrameLogin.getjTextFieldUsername().getText());
        user.setPassword(jFrameLogin.getjPasswordFieldPassword().getText());
        user = userDAOImpl.loginUserAccount(user);
        if (user != null) {
            loginRole(user.getRole());
            jFrameLogin.dispose();
            jFrameRegister.getjMenuUser().setText(user.getSurname() + ", " + user.getFirstname());
            jFrameRegister.setUserAccount(user);
//            jFrameRegister.userLogin = user;
            jFrameRegister.setVisible(true);
        } else {
            jFrameLogin.getjLabelErrorMessage().setText("Please check your username and password and try again.");
            jFrameLogin.getjTextFieldUsername().putClientProperty("JComponent.outline", "error");
            jFrameLogin.getjPasswordFieldPassword().putClientProperty("JComponent.outline", "error");
        }

    }

    private void loginRole(Role r) {
        String role = r.getRole();
        switch (role) {
            case "ADMIN":
                jFrameRegister.getjMenuManage().setVisible(true);
                break;
            case "USER":
                jFrameRegister.getjMenuManage().setVisible(false);
                break;
        }
    }
}
