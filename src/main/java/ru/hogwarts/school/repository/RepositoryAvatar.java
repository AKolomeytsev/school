package ru.hogwarts.school.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.model.Avatar;

import java.awt.print.Pageable;
import java.util.List;

public interface RepositoryAvatar extends PagingAndSortingRepository<Avatar,Long> {
    Avatar findAvatarById(Long id);
    Avatar findAvatarByStudent(Long id);
}
