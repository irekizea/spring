package com.kh.sts14;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.sts14.dto.UploadFileDto;
import com.kh.sts14.dto.UploaderDto;
import com.kh.sts14.repository.UploadFileDao;
import com.kh.sts14.repository.UploaderDao;
import com.kh.sts14.service.FileService;
import com.kh.sts14.vo.FileVO;

@Controller
@RequestMapping("/upload")
public class FileUploadController {
	
	@GetMapping("/")
	public String home() {
		return "upload/home";
	}
	
	@PostMapping("/upload1")
	public String upload1(
			@RequestParam String name,
			@RequestParam MultipartFile file
			) throws IllegalStateException, IOException {
		System.out.println(file.isEmpty());
		System.out.println(name);
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		
		File dir = new File("D:/upload");
		File target = new File(dir, UUID.randomUUID().toString());
		
		dir.mkdirs();// 디렉토리 생성
		file.transferTo(target);
		
		return "redirect:./";
	}
	
	@PostMapping("/upload2")
	public String upload2 (
					@RequestParam String name,
					@RequestParam List<MultipartFile> file
					) throws IllegalStateException, IOException{
		File dir = new File("D:/upload");
		dir.mkdirs();// 디렉토리 생성
		for(MultipartFile multipartFile : file) {
			File target = new File(dir, UUID.randomUUID().toString());
			multipartFile.transferTo(target);	
		}
		return "redirect:./";
	}
	
	// 기존 방식 일반 데이터 파일 개별 수신
	// 다수일 경우 번거로움
	
	@Autowired
	private FileService fileService;
	
	@PostMapping("/upload3")
	public String upload3(@ModelAttribute FileVO vo) throws IllegalStateException, IOException {
		
		fileService.store(vo);
		return "redirect:./";
	}
	
	
	
}
