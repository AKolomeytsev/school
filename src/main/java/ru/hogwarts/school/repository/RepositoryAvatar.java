package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.model.Avatar;

public interface RepositoryAvatar extends JpaRepository<Avatar,Long> {
    void uploadAvatar(Long studentId, MultipartFile multipartFile);
    Avatar findAvatarById(Long id);
}
