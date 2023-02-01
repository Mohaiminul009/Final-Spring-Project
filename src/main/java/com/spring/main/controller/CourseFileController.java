package com.spring.main.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.spring.main.dto.FileInfo;
import com.spring.main.dto.MessageDTO;
import com.spring.main.service.CourseFileService;

@RestController
@RequestMapping("/coursefile")
@CrossOrigin("*")
public class CourseFileController {

	@Autowired
	private CourseFileService courseFileService;
	
	@PostMapping("/post")
	public ResponseEntity<MessageDTO> post(MultipartFile file){
		String message = "";
		try {
			courseFileService.save(file);
			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(message));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename()
            + ". Error: " + e.getMessage();
    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageDTO(message));
		}
	}
	
	@GetMapping("/getall")
    public ResponseEntity<List<FileInfo>> getAll() {
        List<FileInfo> fileInfo = courseFileService.loadAll().map(path -> {
            String pic = MvcUriComponentsBuilder
                    .fromMethodName(CourseFileController.class, "getFile", path.getFileName().toString()).build().toString();
            String pdf = MvcUriComponentsBuilder
                    .fromMethodName(CourseFileController.class, "getFile", path.getFileName().toString()).build().toString();
            String video = MvcUriComponentsBuilder
                    .fromMethodName(CourseFileController.class, "getFile", path.getFileName().toString()).build().toString();
            return new FileInfo(pic, pdf, video);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfo);
    }
	
	@DeleteMapping("/delete/{filename:.+}")
    public ResponseEntity<MessageDTO> delete(@PathVariable String filename) {
        String message = "";

        try {
            boolean existed = courseFileService.delete(filename);

            if (existed) {
                message = "Delete the file successfully: " + filename;
                return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(message));
            }

            message = "The file does not exist!";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageDTO(message));
        } catch (Exception e) {
            message = "Could not delete the file: " + filename + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageDTO(message));
        }
    }
	
}
