package by.it_academy.jd2.web.listeners;


import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

/**
 *  Listener event handlers change session class
 */

public class SessionChangeListener implements HttpSessionAttributeListener {
    /**
     * Override Mettod for  event  change add attribute session
     * @param event
     */
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("We do not have new atributs"+event.getName());
    }

    /**
     * Override metod for event change replace attribute session
     * @param event
     */

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("Replaced attribute "+event.getName());

    }
}
