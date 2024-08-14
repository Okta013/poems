package ru.anikeeva.poems.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.anikeeva.poems.dtos.UserDTO;
import ru.anikeeva.poems.entities.User;
import ru.anikeeva.poems.exception.ResourceNotFoundException;
import ru.anikeeva.poems.repositories.UserRepository;
import ru.anikeeva.poems.utils.MappingUtils;

import java.util.List;
import java.util.stream.Collectors;

import static ru.anikeeva.poems.entities.ERole.ROLE_ADMIN;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final MappingUtils mappingUtils;

    @Autowired
    public UserService(UserRepository userRepository, MappingUtils mappingUtils) {
        this.userRepository = userRepository;
        this.mappingUtils = mappingUtils;
    }

    public List<UserDTO> findAllUsers() {
        return userRepository.findAll().stream().map(mappingUtils::mapToUserDTO).collect(Collectors.toList());
    }

    public UserDTO findUserById(Long id) {
        return userRepository.findById(id).map(mappingUtils::mapToUserDTO).orElse(null);
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = mappingUtils.mapToUser(userDTO);
        userRepository.save(user);
        return mappingUtils.mapToUserDTO(user);
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setFullName(userDTO.getFullName());
        user.setEmail(userDTO.getEmail());
        userRepository.save(user);
        return mappingUtils.mapToUserDTO(user);
    }

    public void deleteUser(Long userId, UserDetails userDetails) {
        User currentUser = userRepository.findByUsername(userDetails.getUsername()).orElseThrow(() -> new RuntimeException("User not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (currentUser.getRoles().stream().map(role -> role.getName()).collect(Collectors.toSet()).contains(ROLE_ADMIN)) {
            if (!user.getId().equals(currentUser.getId())) {
                user.setActive(false);
                userRepository.save(user);
            } else {
                throw new IllegalArgumentException("Administrator cannot delete themselves");
            }
        } else {
            if (user.getId().equals(currentUser.getId())) {
                user.setActive(false);
                userRepository.save(user);
            } else {
                throw new AccessDeniedException("You are not authorized to delete this user");
            }
        }
    }

    public UserDTO findUserByUsername(String username) {
        return userRepository.findByUsername(username).map(mappingUtils::mapToUserDTO).orElse(null);
    }

}
