package org.vaadin.personal_blog.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "edit")
public class EditPost extends VerticalLayout {
    public EditPost() {
        add("Edit the current post");
    }
}
