package by.it_academy.jd2.core.model.menu;

import javax.persistence.*;


@Entity
@Table(name = "departments", schema = "polyclinic")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_departments")
    private Integer idDepartments;
    @Column(name = "name_article")
    private String nameArticle;
    @Column(name = "title_page")
    private String titlePage;
    @Column(name = "shot_text")
    private String shotText;
    @Column(name = "long_text")
    private String longText;
    @Column(name = "link_image")
    private String linkImage;

    public Department() {
    }

    public Integer getIdDepartments() {
        return idDepartments;
    }

    public void setIdDepartments(Integer idDepartments) {
        this.idDepartments = idDepartments;
    }

    public String getNameArticle() {
        return nameArticle;
    }

    public void setNameArticle(String nameArticle) {
        this.nameArticle = nameArticle;
    }

    public String getTitlePage() {
        return titlePage;
    }

    public void setTitlePage(String titlePage) {
        this.titlePage = titlePage;
    }

    public String getShotText() {
        return shotText;
    }

    public void setShotText(String shotText) {
        this.shotText = shotText;
    }

    public String getLongText() {
        return longText;
    }

    public void setLongText(String longText) {
        this.longText = longText;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    @Override
    public String toString() {
        return "Department{" +
                "idDepartments=" + idDepartments +
                ", nameArticle='" + nameArticle + '\'' +
                ", titlePage='" + titlePage + '\'' +
                ", shotText='" + shotText + '\'' +
                ", longText='" + longText + '\'' +
                ", linkImage='" + linkImage + '\'' +
                '}';
    }
}
