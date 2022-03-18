package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.model.Avatar;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.RepositoryAvatar;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

@Service
public class AvatarService {
    private final RepositoryAvatar repositoryAvatar;
    private final StudentService studentService;
    private Avatar avatar;
    @Value("${path.to.avatars.folder}")
    private String avatarsDir;

    public AvatarService(RepositoryAvatar repositoryAvatar, StudentService studentService) {
        this.repositoryAvatar = repositoryAvatar;
        this.studentService = studentService;
    }

    public void uploadAvatar(Long studentId, MultipartFile avatarFile) throws IOException {
        Student student = studentService.getStudent(studentId);
        Path filePath = Path.of(avatarsDir, student + "." + getExtensions(avatarFile.getOriginalFilename()));
        Files.createDirectories(filePath.getParent());
        Files.deleteIfExists(filePath);
        try (
                InputStream is = avatarFile.getInputStream();
                OutputStream os = Files.newOutputStream(filePath, CREATE_NEW);
                BufferedInputStream bis = new BufferedInputStream(is, 1024);
                BufferedOutputStream bos = new BufferedOutputStream(os, 1024);
        ) {
            bis.transferTo(bos);
        }
        //Avatar avatar = new Avatar();
        avatar = findAvatar(studentId);
        avatar.setStudent(student);
        avatar.setFilePath(filePath.toString());
        avatar.setFileSize(avatarFile.getSize());
        avatar.setMediaType(avatarFile.getContentType());
        avatar.setData(avatarFile.getBytes());
        repositoryAvatar.save(avatar);
    }
    private String getExtensions(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    public Avatar findAvatar(Long id){
        Long avatarId = repositoryAvatar.getIdByStudentId(id);
        if(avatarId != null){
            return repositoryAvatar.findById(avatarId).get();
        }else{
            return new Avatar();
        }
    }

    public List<Avatar> findAll(int page,int size){
        PageRequest pageRequest = PageRequest.of(page, size);
        return repositoryAvatar.findAll(pageRequest).getContent();
    }
}
