package org.vaadin.personal_blog.views;

import java.util.List;

import org.vaadin.personal_blog.entities.Post;
import org.vaadin.personal_blog.repository.BlogPosts;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Article;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "admin")
public class Dashboard extends VerticalLayout {
    private final List<Post> blogPosts = new BlogPosts().getPosts();

    public Dashboard() {
        // TODO: Check if the user has admin access

        Header header = new Header();
        header.addClassName("dashboard-header");

        Div headingContainer = new Div();
        H2 heading = new H2("Personal Blog");
        headingContainer.add(heading);

        Div btnContainer = new Div();
        Button newBlogBtn = new Button("+ Add");

        newBlogBtn.addClickListener(event -> UI.getCurrent().navigate("new"));
        newBlogBtn.addClassName("new-post-btn");

        btnContainer.add(newBlogBtn);
        header.add(headingContainer, btnContainer);

        if (blogPosts.isEmpty()) {
            add(header, new H3("You have no blog post. You can use the '+ Add' button to create new post"));
            return;
        }

        Main main = new Main();
        main.addClassName("main-content");

        blogPosts.forEach(p -> {
            Article blogContainer = new Article();
            blogContainer.addClassName("blog-container");

            H4 title = new H4(p.getTitle());
            Div div = new Div();
            Button editBtn = new Button("Edit");
            Button deleteBtn = new Button("Delete");

            editBtn.addClickListener(event -> UI.getCurrent().navigate("edit"));

            deleteBtn.addClickListener(event -> {
                // delete the current blog post, send notification and refresh the dashboard
                // page
            });

            div.addClassName("action-btns");
            editBtn.addClassName("edit-btn");
            deleteBtn.addClassName("delete-btn");
            div.add(editBtn, deleteBtn);

            blogContainer.add(title, div);
            main.add(blogContainer);
        });

        add(header, main);
    }
}
