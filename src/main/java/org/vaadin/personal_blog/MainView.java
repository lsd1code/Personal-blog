package org.vaadin.personal_blog;

import java.util.List;

import org.vaadin.personal_blog.entities.Post;
import org.vaadin.personal_blog.repository.BlogPosts;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {
  private List<Post> posts = new BlogPosts().getPosts();
  
  public MainView() {
    Header header = new Header();
    Div div = new Div(); 
    H1 h1 = new H1("Personal Blog");
  
    posts.forEach(post -> {
      Anchor a = new Anchor();
      Div container = new Div();

      H3 title = new H3(post.getTitle());
      Paragraph description = new Paragraph(post.getDescription());
      Paragraph createdAt = new Paragraph(String.valueOf(post.getCreatedAt()));

      a.add(container);
      a.setHref("/post/" + post.getId());
      container.addClassName("blog-post");
      container.add(title, description, createdAt);
      div.add(a);
    });

    div.addClassName("posts");

    header.add(h1);
    add(header, div);
  }
}