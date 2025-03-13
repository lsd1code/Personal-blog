package org.vaadin.personal_blog.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "new")
public class NewPost extends VerticalLayout {
    public NewPost() {
        add("Add new post");
    }
}
