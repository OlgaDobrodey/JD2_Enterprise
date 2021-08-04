package by.it_academy.jd2.web.rest;

import by.it_academy.jd2.core.model.people.Passport;
import by.it_academy.jd2.core.model.people.Role;
import by.it_academy.jd2.core.model.people.User;
import by.it_academy.jd2.core.service.api.people.IAddressView;
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
public class UserRest {
    private IPassportView passportView;
    private IUserView userView;
    private IAddressView addressView;

    public UserRest(IPassportView passportView, IUserView userView, IAddressView addressView) {
        this.passportView = passportView;
        this.userView = userView;
        this.addressView = addressView;
    }

//    @PostMapping(value = "/users",  produces = {"application/json"})
//    protected void createUser(HttpServletRequest request, HttpServletResponse response,
//                              @RequestParam(name = "login") String login,
//                              @RequestParam(name = "password") String password,
//                              @RequestParam(name = "surname") String surname,
//                              @RequestParam(name = "given_name") String given_name,
//                              @RequestParam(name = "role") String role,
//                              @RequestParam(name = "position") String position,
//                              @RequestParam(name = "phone") String phone,
//                              @RequestParam(name = "email") String email,
//                              @RequestParam(name = "info") String info)
//            throws ServletException, IOException {
//        Boolean userSaveBoolean = this.userView.saveUserResultBoolen(login, password, Role.valueOf(role), surname, given_name, email.isBlank() ? null : email, phone, info.isBlank() ? null : info, position.isBlank() ? null : position, null);
//        String userMessage;
//        if (userSaveBoolean) {
//            userMessage = "The user was successfully saved";
//        } else {
//            userMessage = "Such a user's login already exists";
//        }
//
////        String addressSave = this.addressView.saveAddress(
////                city.isBlank() ? null : city,
////                street.isBlank() ? null : street,
////                house.isBlank() ? null : house,
////                flat.isBlank() ? null : flat);
//        request.setAttribute("MessageUser", userMessage);
//        User userProfil = (User) request.getSession().getAttribute(Constants.USER);
//        if (userProfil.getRole() == Role.ADMIN) {
//            request.setAttribute("roleList", Role.values());
//        }
//        request.setAttribute("users", this.userView.getAllUsers());
////      request.setAttribute("address", addressView.findAllAddress());
//        request.getRequestDispatcher("/views/menu/allUsers.jsp").forward(request, response);
//    }
//
    @PostMapping(value = "/users", produces = {"application/json"})
    protected void createPassport(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        HashMap<String, String> result = new HashMap<>();

        try {
            String json = request.getReader().readLine();
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> map
                    = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {
            });


            User user= this.userView.createUser(map);
            User saveUser = this.userView.saveUser(user);
        } catch (IOException | DataIntegrityViolationException | IllegalArgumentException e) {
            request.getSession().setAttribute("message", e.getMessage());
        } finally {
            PathResponse.path(request, response, result, "/users");
        }
    }

    @DeleteMapping(value = "/users/{id}", produces = {"application/json"})
    public void deletePassport(Model model, @PathVariable("id") Integer id, HttpServletResponse response, HttpServletRequest request) throws IOException {

        this.passportView.deletePassport(id);
        HashMap<String, String> result = new HashMap<>();
        PathResponse.path(request, response, result, "/users");
    }


    @PatchMapping(value = "/users/{id}", produces = {"application/json"})
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
            PathResponse.path(request, response, result, "/users");

        }
    }


}
