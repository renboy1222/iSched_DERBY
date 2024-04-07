/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.isched.util;

import java.io.File;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Java Programming with Aldrin
 */
@Setter
@Getter
@ToString
public class TimeValidator {

    private String startTime;
    private String endTime;
    private String time;

    public TimeValidator(String time) {
        Integer hour = 0;
        Integer start = Integer.parseInt(time.substring(0, 2));
        Integer end = Integer.parseInt(time.substring(6, 8));
        String amPm = time.substring(12, 14);
        if (amPm.equals("PM")) {
            if (end < 12 && start == 12) {
                Integer eh = end + 12;
                setStartTime(String.valueOf(start) + ":" + time.substring(3, 5));
                setEndTime(String.valueOf(eh) + ":" + time.substring(9, 11));
            } else if (end < 12 && start < 12) {
                Integer sh = start + 12;
                Integer eh = end + 12;
                setStartTime(String.valueOf(sh) + ":" + time.substring(3, 5));
                setEndTime(String.valueOf(eh) + ":" + time.substring(9, 11));
            } else if (end == 12 && start < 12) {
                setStartTime(String.valueOf(start) + ":" + time.substring(3, 5));
                setEndTime(String.valueOf(end) + ":" + time.substring(9, 11));
            }
        } else {
            setStartTime(time.substring(0, 5));
            setEndTime(time.substring(6, 11));
        }
    }

    public static void main(String[] args) {
//        TimeValidator timeV = new TimeValidator("01:30-03:00 PM");
//        System.out.println("start:" + timeV.getStartTime());
//        System.out.println("end:" + timeV.getEndTime());
        String currentDirectory = System.getProperty("user.dir");
        String iconPath = currentDirectory + File.separator + "icon.png";

        File iconFile = new File(iconPath);
        System.out.println("Icon file path: " + iconFile.getAbsolutePath());

    }
}
