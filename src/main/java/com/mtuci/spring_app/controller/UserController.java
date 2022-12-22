package com.mtuci.spring_app.controller;

import com.mtuci.spring_app.entity.Post;
import com.mtuci.spring_app.entity.Role;
import com.mtuci.spring_app.entity.User;
import com.mtuci.spring_app.service.PostService;
import com.mtuci.spring_app.service.RoleService;
import com.mtuci.spring_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String getAll(Model model) {
        List<User> userList = userService.getAll();
        model.addAttribute("userList", userList);
        model.addAttribute("userSize", userList.size());

        List<Role> roleList = roleService.getAll();
        model.addAttribute("roleList", roleList);
        model.addAttribute("roleSize", roleList.size());

        List<Post> postList = postService.getAll();
        model.addAttribute("postList", postList);
        model.addAttribute("postSize", postList.size());

        return "index";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute User user, @RequestBody MultiValueMap<String, String> formData) {
        boolean gender = formData.get("gender") != null;

        Integer roleId = Integer.parseInt(formData.get("role_id").get(0).toString());
        Role userRole = roleService.getOne(roleId);

        user.setGender(gender);
        user.setRole(userRole);

        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable int id) {
        User targetUser = userService.getOne(id);
        model.addAttribute("user", targetUser);

        List<Role> roleList = roleService.getAll();
        model.addAttribute("roleList", roleList);
        model.addAttribute("roleSize", roleList.size());

        return "edit_user";

    }

    @PostMapping("/edit/{id}")
    public String edit(@ModelAttribute User user, @RequestBody MultiValueMap<String, String> formData) {
        boolean gender = formData.get("gender") != null;

        Integer roleId = Integer.parseInt(formData.get("role_id").get(0).toString());
        Role userRole = roleService.getOne(roleId);

        user.setGender(gender);
        user.setRole(userRole);

        userService.save(user);

        return "redirect:/";

    }
}
