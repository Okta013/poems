package ru.anikeeva.poems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.anikeeva.poems.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
