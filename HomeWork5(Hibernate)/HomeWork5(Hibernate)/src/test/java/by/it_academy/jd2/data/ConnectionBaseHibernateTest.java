package by.it_academy.jd2.data;

import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionBaseHibernateTest {

    @Test
    void getConnectionHibernet() {
        Assert.assertTrue(ConnectionBaseHibernate.getConnectionHibernet() instanceof SessionFactory);
    }
}