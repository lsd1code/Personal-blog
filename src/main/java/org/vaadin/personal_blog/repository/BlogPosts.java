package org.vaadin.personal_blog.repository;

import java.util.List;

import org.vaadin.personal_blog.entities.Post;

public class BlogPosts {
  private List<Post> posts = List.of(
    new Post("Post 1", "This a blog post 1"),
    new Post("Post 2", "This a blog post 2"),
    new Post("Post 3", "This a blog post 3"),
    new Post("Post 4", "This a blog post 4"),
    new Post("Post 5", "This a blog post 5"),
    new Post("Post 6", "This a blog post 6")
  );
  
  public List<Post> getPosts() {
    return posts;
  }
}
