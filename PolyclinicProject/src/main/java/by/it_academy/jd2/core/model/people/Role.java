package by.it_academy.jd2.core.model.people;

public enum Role {
    ADMIN("users/userAdmin"),
    DOCTOR("users/userDoctor"),
    PATIENT("users/userPatient");

    private final String pathToProfile;

    Role(String pathToProfile) {
        this.pathToProfile = pathToProfile;
    }

    public String getPathToProfile() {
        return pathToProfile;
    }


}

