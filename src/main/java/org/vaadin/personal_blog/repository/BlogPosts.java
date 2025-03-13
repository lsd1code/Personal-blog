package org.vaadin.personal_blog.repository;

import java.util.List;

import org.vaadin.personal_blog.entities.Post;

public class BlogPosts {
  private List<Post> posts = List.of(
      new Post("1", "Post 1", "This a blog post 1"),
      new Post("2", "Post 2", "This a blog post 2"),
      new Post("3", "Post 3", "This a blog post 3"),
      new Post("4", "Post 4", "This a blog post 4"),
      new Post("5", "Post 5", "This a blog post 5"),
      new Post("6", "Post 6", "This a blog post 6"));

  public List<Post> getPosts() {
    return posts;
  }
}
