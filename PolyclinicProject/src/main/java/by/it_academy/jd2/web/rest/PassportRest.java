package by.it_academy.jd2.web.rest;

import by.it_academy.jd2.core.model.people.Passport;
import by.it_academy.jd2.core.service.api.people.IPassportView;
import by.it_academy.jd2.core.service.api.people.IUserView;
import by.it_academy.jd2.web.PathResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PassportRest {

    private IPassportView passportView;
    private IUserView userView;


    public PassportRest(IPassportView passportView, IUserView userView) {

        this.passportView = passportView;
        this.userView = userView;

    }

    @PostMapping(value = "/passports", produces = {"application/json"})
    protected void createPassport(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        HashMap<String, String> result = new HashMap<>();

        try {
            String json = request.getReader().readLine();
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> map
                    = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {
            });

            Passport passport = new Passport();
            passport = this.passportView.createPassport(passport, map, this.userView.searchUserLogin((String) map.get("users")));
            Passport passportSave = this.passportView.savePassport(passport);
        } catch (IOException | DataIntegrityViolationException | IllegalArgumentException e) {
            request.getSession().setAttribute("message", e.getMessage());
        } finally {
            PathResponse.path(request, response, result, "/passports");
        }
    }

    @DeleteMapping(value = "/passports/{id}", produces = {"application/json"})
    public void deletePassport(Model model, @PathVariable("id") Integer id, HttpServletResponse response, HttpServletRequest request) throws IOException {

        this.passportView.deletePassport(id);
        HashMap<String, String> result = new HashMap<>();
        PathResponse.path(request, response, result, "/passports");
    }


    @PatchMapping(value = "/passports/{id}", produces = {"application/json"})
    public void update(HttpServletRequest request, HttpServletResponse response, Model model, @PathVariable("id") Integer id) throws IOException {

        HashMap<String, String> result = new HashMap<>();
        try {
            String json = request.getReader().readLine();
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> map
                    = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {
            });
            Passport passport = this.passportView.createPassport(this.passportView.findPassportById(id), map, this.userView.searchUserLogin((String) map.get("users")));
            Passport passportSave = this.passportView.savePassport(passport);
            result.put("message", "Success update");
        } catch (IOException | DataIntegrityViolationException | IllegalArgumentException e) {
            result.put("message", e.getMessage());
        } finally {
            PathResponse.path(request, response, result, "/passports");

        }
    }
}
