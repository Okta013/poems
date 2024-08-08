package ru.anikeeva.poems.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.anikeeva.poems.dtos.UserDTO;
import ru.anikeeva.poems.entities.User;
import ru.anikeeva.poems.repositories.UserRepository;
import ru.anikeeva.poems.utils.MappingUtils;

import java.util.List;
import java.util.stream.Collectors;

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

    public UserDTO findUserById(int id) {
        return userRepository.findById(id).map(mappingUtils::mapToUserDTO).orElse(null);
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = mappingUtils.mapToUser(userDTO);
        userRepository.save(user);
        return mappingUtils.mapToUserDTO(user);
    }

    public UserDTO updateUser(int id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        user.setFullName(userDTO.getFullName());
        user.setEmail(userDTO.getEmail());
        userRepository.save(user);
        return mappingUtils.mapToUserDTO(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
