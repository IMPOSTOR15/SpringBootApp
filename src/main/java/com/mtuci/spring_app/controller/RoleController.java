package com.mtuci.spring_app.controller;

import com.mtuci.spring_app.entity.Role;
import com.mtuci.spring_app.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/role/delete/{id}")
    public String deleteRole(@PathVariable int id) {
        roleService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/role/add")
    public String addRole(@ModelAttribute Role role) {
        roleService.save(role);
        return "redirect:/";
    }

    @GetMapping("/role/edit/{id}")
    public String edit(Model model, @PathVariable int id) {
        Role targetRole = roleService.getOne(id);
        model.addAttribute("role", targetRole);

        return "edit_role";

    }

    @PostMapping("/role/edit/{id}")
    public String edit(@ModelAttribute Role role) {
        roleService.save(role);
        return "redirect:/";
    }
}
