package ru.anikeeva.poems.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.anikeeva.poems.dtos.RoleDTO;
import ru.anikeeva.poems.entities.Role;
import ru.anikeeva.poems.repositories.RoleRepository;
import ru.anikeeva.poems.utils.MappingUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final MappingUtils mappingUtils;

    @Autowired
    public RoleService(RoleRepository roleRepository, MappingUtils mappingUtils) {
        this.roleRepository = roleRepository;
        this.mappingUtils = mappingUtils;
    }

    public List<RoleDTO> getAllRoles() {
        return roleRepository.findAll().stream().map(mappingUtils::mapToRoleDTO).collect(Collectors.toList());
    }

    public RoleDTO getRoleById(int id) {
        return roleRepository.findById(id).map(mappingUtils::mapToRoleDTO).orElse(null);
    }

    public RoleDTO createRole(RoleDTO roleDTO) {
        Role role = mappingUtils.mapToRole(roleDTO);
        role = roleRepository.save(role);
        return mappingUtils.mapToRoleDTO(role);
    }

    public RoleDTO updateRole(int id, RoleDTO roleDTO) {
        Role role = roleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Role not found"));
        role.setName(roleDTO.getName());
        role = roleRepository.save(role);
        return mappingUtils.mapToRoleDTO(role);
    }

    public void deleteRole(int id) {
        roleRepository.deleteById(id);
    }
}
