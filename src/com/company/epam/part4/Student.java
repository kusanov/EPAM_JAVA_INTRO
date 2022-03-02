package com.company.epam.part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class Student {
    String fullName;
    String groupNumber; //т.к. номер группы может содержать буквы
    int[] assessment = new int[5];

    public Student() {
    }

    public Student(String fullName, String groupNumber, int[] assessment) {
        this.fullName = fullName;
        this.groupNumber = groupNumber;
        this.assessment = assessment;
    }

    @Override
    public String toString() {
        return "Студент: " +
                "фамилия и инициалы - '" + fullName + '\'' +
                ", номер группы - '" + groupNumber + '\'' +
                ", успеваемость: " + Arrays.toString(assessment);
    }

    public static void printExcellentStudent(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            int count = 0;
            for (int j = 0; j < students[i].assessment.length; j++) {
                if (students[i].assessment[j] == 9 || students[i].assessment[j] == 10) {
                    if (j == (students[i].assessment.length - 1)) {
                        System.out.println("Фамилия и инициалы - '" + students[i].fullName + '\'' +
                                ", номер группы - '" + students[i].groupNumber + '\'');
                    }
                    continue;
                } else {
                    break;
                }
            }
        }
    }
}
