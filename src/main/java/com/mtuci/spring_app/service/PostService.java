package com.mtuci.spring_app.service;

import com.mtuci.spring_app.entity.Post;
import com.mtuci.spring_app.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post getOne(Integer postId) {
        return postRepository.getReferenceById(postId);
    }

    public List<Post> getAll() {
        return postRepository.findAll();
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public void delete(int id) {
        postRepository.deleteById(id);
    }
}
