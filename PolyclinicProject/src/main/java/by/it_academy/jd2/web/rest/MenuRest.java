package by.it_academy.jd2.web.rest;

import by.it_academy.jd2.core.model.menu.Department;
import by.it_academy.jd2.core.service.api.IDepartementView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuRest {
    private IDepartementView departementView;

    public MenuRest(IDepartementView departementView) {
        this.departementView = departementView;
    }

    @PostMapping(value = "/Departments")
    protected ResponseEntity<?> createDepartament (@RequestParam (name = "nameArticle") String nameArticle,
            @RequestParam (name = "shotText") String shotText,
            @RequestParam (name = "titlePage") String titlePage,
            @RequestParam (name = "longText") String longText,
            @RequestParam (name = "linkImage") String linkImage) {
        final Department department = new Department();
        department.setNameArticle(nameArticle);
        department.setShotText(shotText);
        department.setTitlePage(titlePage);
        department.setLongText(longText);
        department.setLinkImage(linkImage);
        this.departementView.save(department);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
