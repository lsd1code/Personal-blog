package org.vaadin.personal_blog.views;

import java.util.List;

import org.vaadin.personal_blog.entities.Post;
import org.vaadin.personal_blog.repository.BlogPosts;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

@Route(value = "blog")
public class BlogPost extends VerticalLayout implements HasUrlParameter<String> {
    private List<Post> posts = new BlogPosts().getPosts();
    private Post blogPost = null;

    public BlogPost() {
        if (blogPost == null) {
            add(new Paragraph("Blog Post Not Found"));
            return;
        }

        Div container = new Div();

        Header blogHeader = new Header();
        H2 blogTitle = new H2(blogPost.getTitle());
        blogTitle.addClassName("blog-heading");
        blogHeader.add(blogTitle);

        Paragraph blogBody = new Paragraph(blogPost.getDescription());
        blogBody.addClassName("blog-body");

        // TODO: Add the lastEditedt date value
        Div dateContainer = new Div();
        Paragraph createdAt = new Paragraph(String.valueOf(blogPost.getCreatedAt()));
        createdAt.addClassName("date");
        dateContainer.add(createdAt);

        container.add(blogHeader, dateContainer, blogBody);
        add(container);
    }

    @Override
    public void setParameter(BeforeEvent be, String param) {
        posts
                .stream()
                .filter(p -> p.getId() == Long.parseLong(param))
                .findFirst()
                .ifPresentOrElse(p -> setBlogPost(p), null);
    }

    public void setBlogPost(Post blogPost) {
        this.blogPost = blogPost;
    }
}
