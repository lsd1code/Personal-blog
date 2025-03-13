package org.vaadin.personal_blog.entities;

import java.time.LocalDate;

public class Post {
  private String id;
  private String title;
  private String description;
  private LocalDate createdAt;
  private LocalDate lastEditedAt;

  public Post() {
  }

  public Post(String id, String title, String description) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.createdAt = LocalDate.now();
    this.lastEditedAt = null;
  }

  private String generateId() {
    long id = 0;

    for (int i = 0; i < 5; i++) {
      var randVal = (int) (Math.random() * 10);
      id = (id * 10) + randVal;
    }

    return String.valueOf(id);
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setId(String id) {
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

  public String getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Post [id=" + id + ", title=" + title + ", description=" + description + ", createdAt=" + createdAt
        + ", lastEditedAt="
        + lastEditedAt + "]";
  }
}
