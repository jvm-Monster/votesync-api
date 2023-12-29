package com.vi.votesyncapi.helperclass;

import com.vi.votesyncapi.model.Student;

import java.lang.reflect.Field;

public class UpdateFieldsHelper {
    public static void updateFieldHelper(Object source,Object target){

        Class<?> clazz1 = source.getClass();//source
        Class<?> clazz2 = target.getClass();//target
        Field[] fields1 = clazz1.getDeclaredFields();//source field
        Field[] fields2 = clazz2.getDeclaredFields();//target field

        System.out.println(fields1);
        System.out.println(fields2);
        int i = 0;
        for(Field field:fields1){
            field.setAccessible(true);
            try{
                // we want to get the value of the fields1

                System.out.println(field.get(clazz1.getDeclaredField(field.getName())));
//                System.out.println(fields1[i].getName());
                i++;

            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {
        Student student = new Student();
        student.setStudentEmail("sdfsdf");
        student.setStudentId("sdf");
        student.setStudentName("aaaa");
        student.setStudentPassword("sasnv");

        Student student1 = new Student();
        student1.setStudentPassword("sannn");
        student1.setStudentName("//..");
        student1.setStudentId("aaaaasss");
        student1.setStudentEmail("anvvb");
        updateFieldHelper(student,student1);
    }
}
