package hu.qualysoft.minimal.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

/**
 *
 * @author zsolt
 */
public class HomePage extends WebPage {

    public HomePage() {
        String name = this.getRequest().getQueryParameters().getParameterValue("name").isEmpty()
                ? "World"
                : this.getRequest().getQueryParameters().getParameterValue("name").toString();
        add(new Label("helloMessage", "Hello " + name + "!"));
    }
}
