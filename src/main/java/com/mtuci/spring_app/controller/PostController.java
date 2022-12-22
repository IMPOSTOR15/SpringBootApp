package com.mtuci.spring_app.controller;

import com.mtuci.spring_app.entity.Post;
import com.mtuci.spring_app.entity.User;
import com.mtuci.spring_app.service.PostService;
import com.mtuci.spring_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @RequestMapping("/post/delete/{id}")
    public String deletePost(@PathVariable int id) {
        postService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/post/add")
    public String addPost(@ModelAttribute Post post, @RequestBody MultiValueMap<String, String> formData) {
        Integer userId = Integer.parseInt(formData.get("user_id").get(0).toString());

        User postUser = userService.getOne(userId);

        post.setUser(postUser);

        postService.save(post);
        return "redirect:/";
    }

    @GetMapping("/post/edit/{id}")
    public String edit(Model model, @PathVariable int id) {
        Post targetPost = postService.getOne(id);
        model.addAttribute("post", targetPost);

        return "edit_post";

    }

    @PostMapping("/post/edit/{id}")
    public String edit(@ModelAttribute Post post, @RequestBody MultiValueMap<String, String> formData) {
        Integer userId = Integer.parseInt(formData.get("user_id").get(0).toString());

        User postUser = userService.getOne(userId);

        post.setUser(postUser);

        postService.save(post);
        return "redirect:/";
    }
}
