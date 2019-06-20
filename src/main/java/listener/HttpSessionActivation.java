package listener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

public class HttpSessionActivation implements HttpSessionActivationListener, Serializable {
    private String id;
    private String name;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println("session passivate----------------->");
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println("session active-------------------->");
    }
}
