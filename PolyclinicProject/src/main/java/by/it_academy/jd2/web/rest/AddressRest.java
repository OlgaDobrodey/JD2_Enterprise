package by.it_academy.jd2.web.rest;

import by.it_academy.jd2.core.model.people.Address;
import by.it_academy.jd2.core.model.people.Passport;
import by.it_academy.jd2.core.model.people.User;
import by.it_academy.jd2.core.service.api.medical.IDepartementView;
import by.it_academy.jd2.core.service.api.people.IAddressView;
import by.it_academy.jd2.core.service.api.people.IPassportView;
import by.it_academy.jd2.core.service.api.people.IUserView;
import by.it_academy.jd2.web.PathResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;


@RestController
public class AddressRest {
    private IDepartementView departementView;
    private IPassportView passportView;
    private IUserView userView;
    private IAddressView addressView;
    private ObjectMapper objectMapper;

    public AddressRest(IDepartementView departementView, IPassportView passportView, IUserView userView, IAddressView addressView, ObjectMapper objectMapper) {
        this.departementView = departementView;
        this.passportView = passportView;
        this.userView = userView;
        this.addressView = addressView;
        this.objectMapper = objectMapper;
    }

    @Transactional
    @PostMapping(value = "/address/{username}")
    protected ResponseEntity<?> create(HttpServletRequest request, @PathVariable("username") String username) throws IOException {
        Address address = objectMapper.readValue(request.getReader().readLine(), Address.class);
        address = addressView.saveAddress(address);
        System.out.println(username);
        User user = userView.searchUserLogin(username);
        user.setAddresses(address);
        user = userView.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/address/{id}", produces = {"application/json"})
    public ResponseEntity<?> deleteAddress(Model model, @PathVariable("id") Integer id, HttpServletResponse response, HttpServletRequest request) throws IOException {
        this.addressView.deleteAddress(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping(value = "/address/{id}", produces = {"application/json"})
    public ResponseEntity<Object> update(HttpServletRequest request, HttpServletResponse response, Model model, @PathVariable("id") Integer id) throws IOException {
        Address address = objectMapper.readValue(request.getReader().readLine(), Address.class);
        address = addressView.updateAddress(address, id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
