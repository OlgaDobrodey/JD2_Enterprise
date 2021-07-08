package by.it_academy.jd2.core.model;

public enum Role {
    ADMIN,
    DOCTOR,
    PATIENT;

    public static String  pathRoleUser(User user) {
        Role role = user.getRole();
        switch (role) {
            case ADMIN:
                return "/views/users/userAdmin.jsp";
            case DOCTOR:
                return "/views/users/userDoctor.jsp";
            case PATIENT:
                return "/views/users/userPatient.jsp";
            default:
                return "/views/Error.jsp";
        }
    }
}
