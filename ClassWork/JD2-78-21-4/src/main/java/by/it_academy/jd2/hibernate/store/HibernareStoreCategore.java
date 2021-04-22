package by.it_academy.jd2.hibernate.store;

import by.it_academy.jd2.core.dto.store.*;
import by.it_academy.jd2.dao.HibernateCreatorStore;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.Set;

public class HibernareStoreCategore {
    private static Session session;

    public static void main(String[] args) {
        session = HibernateCreatorStore.getInstance().openSession();
        Category categore = new Category();
        categore.setName("Cook aplicashion");
        session.beginTransaction();
        session.save(categore);
        session.getTransaction().commit();
        Category categore2 = new Category();
        categore2.setName("Bed Room");
        session.beginTransaction();
        session.save(categore);
        session.getTransaction().commit();
        Manufacture manufacture = new Manufacture(1, "Pilips", "Good");
        session.beginTransaction();
        session.save(manufacture);
        session.getTransaction().commit();
        Product product = new Product();
        product.setName("TV");
        product.setManufacture(session.load(Manufacture.class, 1));
        product.setCost(2.3);
        product.setRating(0.1);
        product.setCharacteristics("Good");
        Set<Category> categore1 = new HashSet<>();
        categore1.add(session.load(Category.class, 2));
        categore1.add(session.load(Category.class, 1));
        product.setCategores(categore1);
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();


        //saveCategory("Cook aplicashion");
        // saveCategory("Bed Room");


    }

    private static void saveCategory(String name) {
        Category category = new Category();
        category.setName(name);
        session.beginTransaction();
        session.save(category);
        session.getTransaction().commit();
    }

    private static void deleteCategory(int number) {
        session.beginTransaction();
        Category category = loadCategory(number);
        Category deleteCategory = session.get(Category.class, category.getId());
        session.delete(deleteCategory);
        session.getTransaction().commit();
    }

    private static Category loadCategory(int numver) {
        Category loadCategory = session.load(Category.class, numver);
        return loadCategory;
    }
}
