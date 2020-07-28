package com.apple.services.cms;

import com.apple.models.cms.Role;
import com.apple.repositories.cms.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    public Role findRoleByName(String name){
        Role role = roleRepository.findRoleByRoleName(name);
        System.out.println("Did the service really give me something on first query..."+role);
        return role;
    }
}
