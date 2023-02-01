package com.spring.main.service;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.spring.main.entity.CourseFile;
import com.spring.main.repository.CourseFileRepository;

@Service
public class CourseFileService {

	@Autowired
	CourseFileRepository courseFileRepository;
	
	private final Path root = Paths.get("upload/");
	
	public void init() {
		try {
			Files.createDirectories(root);
		} catch (Exception e) {
			throw new RuntimeException("Could not initialize folder for upload!");
		}
		
	}
//	<<<<< save files >>>>>
	public void save(MultipartFile file) {
		try {
			Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
			
			CourseFile fileUpload = new CourseFile();
			fileUpload.setCoursePic(root + file.getOriginalFilename());
			fileUpload.setCoursePdf(root + file.getOriginalFilename());
			fileUpload.setCourseVideo(root + file.getOriginalFilename());
			courseFileRepository.save(fileUpload);
		}catch (UncheckedIOException io) {
			
			throw new RuntimeException(io.getMessage());
		} 
		catch (Exception e) {
			if (e instanceof FileAlreadyExistsException) {
				throw new RuntimeException("A file of that name already exists.");
			}
			throw new RuntimeException(e.getMessage());
		}
	}
//	<<<<< get all file >>>>>>
	public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }
	
	public boolean delete(String filename) {
        try {
            Path file = root.resolve(filename);
            return Files.deleteIfExists(file);
        } catch (IOException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }
}
