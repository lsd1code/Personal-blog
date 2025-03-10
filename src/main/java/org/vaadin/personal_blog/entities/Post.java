package org.vaadin.personal_blog.entities;

import java.time.LocalDate;

public class Post {
  private long id;
  private String title;
  private String description;
  private LocalDate createdAt;
  private LocalDate lastEditedAt;

  static long blogId = 0;

  public Post() {}

  public Post(String title, String description) {
    this.id = ++blogId;
    this.title = title;
    this.description = description;
    this.createdAt = LocalDate.now();
    this.lastEditedAt = null;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setId(long id){
    this.id = id;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setLastEditedAt(LocalDate lastEditedAt) {
    this.lastEditedAt = lastEditedAt;
  }

  public void setCreatedAt(LocalDate createdAt) {
    this.createdAt = createdAt;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public LocalDate getCreatedAt() {
    return createdAt;
  }

  public LocalDate getLastEditedAt() {
    return lastEditedAt;
  }

  public long getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Post [title=" + title + ", description=" + description + ", createdAt=" + createdAt + ", lastEditedAt="
        + lastEditedAt + "]";
  }
}
