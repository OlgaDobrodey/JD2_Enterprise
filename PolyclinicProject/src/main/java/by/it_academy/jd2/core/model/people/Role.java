package by.it_academy.jd2.core.model.people;

public enum Role {
    ADMIN("/views/users/userAdmin.jsp"),
    DOCTOR("/views/users/userDoctor.jsp"),
    PATIENT("/views/users/userPatient.jsp");

    private final String pathToProfile;

    Role(String pathToProfile) {
        this.pathToProfile = pathToProfile;
    }

    public String getPathToProfile() {
        return pathToProfile;
    }
}

