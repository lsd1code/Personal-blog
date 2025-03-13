package org.vaadin.personal_blog.persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.vaadin.personal_blog.entities.Post;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FileStorage {
    private final ObjectMapper mapper;
    private final File filepath;

    public FileStorage() {
        mapper = new ObjectMapper();
        filepath = new File("posts.json");
    }

    public List<Post> load() {
        try {
            return mapper.readValue(filepath, new TypeReference<List<Post>>() {
            });
        } catch (Exception e) {
        }

        return new ArrayList<>();
    }

    public void save(List<Post> blogPosts) {
        try {
            mapper.writeValue(filepath, blogPosts);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
