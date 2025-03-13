package org.vaadin.personal_blog.views;

import java.util.List;

import org.vaadin.personal_blog.entities.Post;
import org.vaadin.personal_blog.repository.BlogPosts;

import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

@Route(value = "post")
public class BlogPost extends VerticalLayout implements HasUrlParameter<String> {
    private List<Post> posts = new BlogPosts().getPosts();
    private Post blogPost = null;
    private Paragraph param = new Paragraph();

    public BlogPost() {
        add(blogPost.getDescription() + " - " + blogPost.getId());
    }

    @Override
    public void setParameter(BeforeEvent be, String param) {
        posts
                .stream()
                .filter(p -> p.getId().equalsIgnoreCase(param))
                .findFirst()
                .ifPresentOrElse(p -> {
                    setBlogPost(p);
                }, null);
    }

    private void setBlogPost(Post blogPost) {
        this.blogPost = blogPost;
    }
}
