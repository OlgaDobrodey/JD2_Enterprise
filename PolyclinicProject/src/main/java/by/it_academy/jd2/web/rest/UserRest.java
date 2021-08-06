package by.it_academy.jd2.web.rest;


import by.it_academy.jd2.core.model.people.User;
import by.it_academy.jd2.core.service.api.medical.IDepartementView;
import by.it_academy.jd2.core.service.api.medical.IDiagnosisView;
import by.it_academy.jd2.core.service.api.medical.IMedicalCardView;
import by.it_academy.jd2.core.service.api.people.IAddressView;
import by.it_academy.jd2.core.service.api.people.IPassportView;
import by.it_academy.jd2.core.service.api.people.IUserView;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserRest {
    private IDepartementView departementView;
    private IPassportView passportView;
    private IUserView userView;
    private IAddressView addressView;
    private ObjectMapper objectMapper;
    private IMedicalCardView medicalCardView;
    private IDiagnosisView diagnosisView;
    private PasswordEncoder passwordEncoder;

    public UserRest(IDepartementView departementView, IPassportView passportView, IUserView userView, IAddressView addressView, ObjectMapper objectMapper, IMedicalCardView medicalCardView, IDiagnosisView diagnosisView, PasswordEncoder passwordEncoder) {
        this.departementView = departementView;
        this.passportView = passportView;
        this.userView = userView;
        this.addressView = addressView;
        this.objectMapper = objectMapper;
        this.medicalCardView = medicalCardView;
        this.diagnosisView = diagnosisView;
        this.passwordEncoder = passwordEncoder;
    }


    @PostMapping(value = "/users", produces = {"application/json"})
    protected ResponseEntity<?> createUser(HttpServletRequest request) throws IOException {
        User user = objectMapper.readValue(request.getReader().readLine(), User.class);
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        this.userView.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @DeleteMapping(value = "/users/{username}", produces = {"application/json"})
    public ResponseEntity<?> deleteUser(@PathVariable("username") String username) {
        try {
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            String message = e.getMessage();
            if (message == null || message.isEmpty()) {
                message = "Произошла неизвестная ошибка";
            }
            return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PatchMapping(value = "/users/{id}", produces = {"application/json"})
    public ResponseEntity<?> updateUser(HttpServletRequest request, @PathVariable("id") Integer id) throws IOException {
        User user = objectMapper.readValue(request.getReader().readLine(), User.class);
        this.userView.updateUser(user, id);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}