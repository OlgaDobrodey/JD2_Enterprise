package by.it_academy.jd2.web.rest;

import by.it_academy.jd2.core.model.menu.Department;
import by.it_academy.jd2.core.model.people.*;
import by.it_academy.jd2.core.service.api.people.IAddressView;
import by.it_academy.jd2.core.service.api.medical.IDepartementView;
import by.it_academy.jd2.core.service.api.people.IPassportView;
import by.it_academy.jd2.core.service.api.people.IUserView;
import by.it_academy.jd2.core.utils.Constants;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import java.io.IOException;


@RestController
public class MenuRest {
    private IDepartementView departementView;
    private IPassportView passportView;
    private IUserView userView;
    private IAddressView addressView;
    private ObjectMapper objectMapper;

    public MenuRest(IDepartementView departementView, IPassportView passportView, IUserView userView, IAddressView addressView, ObjectMapper objectMapper) {
        this.passportView = passportView;
        this.departementView = departementView;
        this.userView = userView;
        this.addressView = addressView;
        this.objectMapper = objectMapper;
    }

    @PostMapping(value = "/departments")
    protected void createDepartament(HttpServletRequest request, HttpServletResponse response, @RequestParam(name = "nameArticle") String nameArticle,
                                     @RequestParam(name = "shotText") String shotText,
                                     @RequestParam(name = "titlePage") String titlePage,
                                     @RequestParam(name = "longText") String longText,
                                     @RequestParam(name = "linkImage") String linkImage) throws ServletException, IOException {
        final Department department = new Department();
        department.setNameArticle(nameArticle);
        department.setShotText(shotText);
        department.setTitlePage(titlePage);
        department.setLongText(longText);
        department.setLinkImage(linkImage);
        this.departementView.save(department);
        request.setAttribute("department", this.departementView.findAll());
        request.getRequestDispatcher("/views/menu/departments.jsp").forward(request, response);
    }


    //    @PostMapping(value = "/address")
//    protected void createAddress(HttpServletRequest request, HttpServletResponse response,
//                                 @RequestParam(name = "city") String city,
//                                 @RequestParam(name = "street") String street,
//                                 @RequestParam(name = "house") String house,
//                                 @RequestParam(name = "flat") String flat,
//                                 @RequestParam(name = "user") String userLogin)
//            throws ServletException, IOException {
//        String addressSave = this.addressView.saveAddress(
//                city.isBlank() ? null : city,
//                street.isBlank() ? null : street,
//                house.isBlank() ? null : house,
//                flat.isBlank() ? null : flat);
//        final Address addressWithParameter = this.addressView.findAddressWithParameter(city, street, house, flat);
//        User updateUser = userView.searchUserLogin(userLogin);
//        updateUser.setAddresses(addressWithParameter);
//        userView.saveUser(updateUser);
//        request.setAttribute("MessageAddress", addressSave);
//        request.setAttribute("address", addressView.findAllAddress());
//        request.getRequestDispatcher("/views/menu/allAddress.jsp").forward(request, response);
//    }



}

