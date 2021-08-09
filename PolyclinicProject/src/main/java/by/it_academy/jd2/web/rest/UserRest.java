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

    private IUserView userView;
    private ObjectMapper objectMapper;
    private PasswordEncoder passwordEncoder;

    public UserRest(IUserView userView,ObjectMapper objectMapper, PasswordEncoder passwordEncoder) {
        this.userView = userView;
        this.objectMapper = objectMapper;
        this.passwordEncoder = passwordEncoder;
    }


    @PostMapping(value = "/users", produces = {"application/json"})
    protected ResponseEntity<?> createUser(HttpServletRequest request) throws IOException {
        User user = objectMapper.readValue(request.getReader().readLine(), User.class);
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        this.userView.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PatchMapping(value = "/users/{id}", produces = {"application/json"})
    public ResponseEntity<?> updateUser(HttpServletRequest request, @PathVariable("id") Integer id) throws IOException {
        User user = objectMapper.readValue(request.getReader().readLine(), User.class);
        this.userView.updateUser(user, id);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}