package by.it_academy.jd2.core.utils;

import by.it_academy.jd2.core.model.Role;

public class ex {
    public static void main(String[] args) {
        String role = "DOCTOR";
//        final String name = Role.DOCTOR.toString();
//        System.out.println(role.equals(name));
//        System.out.println(name);
//        final Class<? extends String> aClass = Role.DOCTOR.toString().getClass();
//        System.out.println(aClass);
//        Role role1 = Role.valueOf(role);
//        switch (role1) {
//            case ADMIN:
//                System.out.println("'это админ");
//                break;
//            case DOCTOR:
//                System.out.println("doctor");
//                break;
//
//            case PATIENT:
//                System.out.println("patient");
//                break;
//            default:
//                System.out.println("неправильно заданая роль");
//                break;
//        }
        System.out.println(role.substring(0,3));


    }
}
