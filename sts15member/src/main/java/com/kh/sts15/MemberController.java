package com.kh.sts15;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.sts15.entity.FileDto;
import com.kh.sts15.entity.Member;
import com.kh.sts15.entity.MemberProfileDto;
import com.kh.sts15.repository.MemberDao;
import com.kh.sts15.repository.MemberProfileDao;
import com.kh.sts15.repository.PhysicalFileDao;
import com.kh.sts15.service.MemberService;
import com.kh.sts15.vo.MemberVo;

@Controller
public class MemberController {

	@Autowired
	private MemberDao memberDao;
	
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
//	@PostMapping("regist")
	public String regist(@RequestParam String member_id, String member_pw, String member_nick){
		
		Member m = new Member();
		m.setMember_id(member_id);
		m.setMember_pw(member_pw);
		m.setMember_nick(member_nick);
		memberDao.regist(m);
		
		
		return "welcome";
	}
	
	
//	@GetMapping("/regist2")
	public String regist() {
		return "regist";
	}
	
//	@GetMapping("/regist2")
	public String regist(
//									@RequestParam String member_id,
//									@RequestParam String member_pw,
//									@RequestParam String member_nick,
									@ModelAttribute Member member,
									@RequestParam MultipartFile member_profile) throws IllegalStateException, IOException {
		int member_no = memberDao.getSequence();
		member.setMember_no(member_no);
		FileDto fileDto= FileDto.builder()
									.profile_uploadname(member_profile.getOriginalFilename())
									.profile_size(member_profile.getSize())
									.member_no(member_no)
				
									.build();
		
		File directory = new File("D:/upload/filetest");
		directory.mkdirs();
		
		File file = new File(directory, String.valueOf(member_no));
		member_profile.transferTo(file);
		
		return "redirect:/";
		
	}
	
	@Autowired
	private MemberService memberService;

	@PostMapping("regist")
	public String regist2(@ModelAttribute MemberVo vo) throws IllegalStateException, IOException {
	 memberService.store(vo);
	 return "welcome";
	}
	
	
	@Autowired
	private MemberProfileDao memberProfileDao;
	
	@Autowired
	private PhysicalFileDao physicalFileDao;
	
	
	// address for downloading
	// -/downlaod1 : 과거 jsp/sevelet 방식
//	- / download2 :  spring 에서 추구 방식
	@GetMapping("/download1")
	public void download1(
			@RequestParam int profile_no,
			HttpServletResponse response) throws IOException {
		
		MemberProfileDto memberProfileDto =
				memberProfileDao.get(profile_no);
		
		byte[] data= physicalFileDao.get(memberProfileDto.getProfile_no());
		
		response.setHeader("Content-Type", "application/octet-stream; charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment; filename=\""+URLEncoder.encode(memberProfileDto.getProfile_uploadname(), "UTF-8")+"\"");
		response.setHeader("content-length", String.valueOf(memberProfileDto.getProfile_size()));
		
		
		response.getOutputStream().write(data);
		
	}
	@GetMapping("/download2")
	public ResponseEntity<ByteArrayResource> download2(@RequestParam int profile_no) throws IOException {
		//ResponseEntity
		//ByteArrayResource
		
		
		MemberProfileDto memberProfileDto =
				memberProfileDao.get(profile_no);
		
		byte[] data= physicalFileDao.get(memberProfileDto.getProfile_no());
		
		if(data == null) {
			return ResponseEntity.notFound().build();
		}
		
		//헤더 설정, 전송 스프링 방식 진행
		
		ByteArrayResource resource = new ByteArrayResource(data);
		
		return ResponseEntity.ok()
												//.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE)
												.contentType(MediaType.APPLICATION_OCTET_STREAM)
												.contentLength(memberProfileDto.getProfile_size())
												.header(HttpHeaders.CONTENT_ENCODING, "UTF-8")
//												.header(HttpHeaders.CONTENT_DISPOSITION,
//														"attachment; filename=\""+URLEncoder.encode(memberProfileDto.getProfile_uploadname(), "UTF-8")+"\"")
												.header(HttpHeaders.CONTENT_DISPOSITION, 
														makeDispositionString(memberProfileDto.getProfile_uploadname()))
												
												.body(resource);
	}
	
	private String makeDispositionString(String filename) throws UnsupportedEncodingException {
		StringBuffer buffer = new StringBuffer();
		buffer.append("attachment;");
		buffer.append("filename=");
		buffer.append("\"");
		buffer.append(URLEncoder.encode(filename, "UTF-8"));
		buffer.append("\"");
		return buffer.toString();
		
	}
	
}
