package by.it_academy.jd2.web.rest;


import by.it_academy.jd2.core.model.people.Passport;
import by.it_academy.jd2.core.service.api.people.IPassportView;
import by.it_academy.jd2.core.service.api.people.IUserView;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
public class PassportRest {

    private IPassportView passportView;
    private IUserView userView;
    private ObjectMapper objectMapper;


    public PassportRest(IPassportView passportView, IUserView userView, ObjectMapper objectMapper) {

        this.passportView = passportView;
        this.userView = userView;
        this.objectMapper = objectMapper;

    }

    @PostMapping(value = "/passports", produces = {"application/json"})
    protected ResponseEntity<?> createPassport(HttpServletRequest request) {
        try {
            String json = request.getReader().readLine();
            Map<String, Object> map
                    = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {
            });
            Passport passport = new Passport();
            passport = this.passportView.createPassport(passport, map, this.userView.searchUserLogin((String) map.get("users")));
            Passport passportSave = this.passportView.savePassport(passport);
        } catch (IOException | DataIntegrityViolationException | IllegalArgumentException e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Success save", HttpStatus.OK);
    }

    @DeleteMapping(value = "/passports/{id}", produces = {"application/json"})
    public ResponseEntity<?> deletePassport(Model model, @PathVariable("id") Integer id, HttpServletResponse response, HttpServletRequest request) throws IOException {
        try {
            this.passportView.deletePassport(id);
        } catch (RuntimeException e) {
            new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Delete  success", HttpStatus.OK);
    }


    @PatchMapping(value = "/passports/{id}", produces = {"application/json"})
    public ResponseEntity<?> update(HttpServletRequest request,
                                    @PathVariable("id") Integer id) throws IOException {
        try {
            String json = request.getReader().readLine();
            Map<String, Object> map = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {
            });
            Passport passport = this.passportView.createPassport(this.passportView.findPassportById(id), map, this.userView.searchUserLogin((String) map.get("users")));
            Passport passportSave = this.passportView.savePassport(passport);
        } catch (IOException | DataIntegrityViolationException | IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Success update", HttpStatus.OK);
    }
}
