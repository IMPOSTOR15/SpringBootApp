package com.mtuci.spring_app.service;

import com.mtuci.spring_app.entity.Role;
import com.mtuci.spring_app.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role getOne(Integer roleId) {
        return roleRepository.getReferenceById(roleId);
    }

    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    public Role save(Role role) {
        return roleRepository.save(role);
    }

    public void delete(int id) {
        roleRepository.deleteById(id);
    }
}
