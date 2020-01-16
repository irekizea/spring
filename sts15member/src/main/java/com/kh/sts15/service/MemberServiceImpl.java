package com.kh.sts15.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.sts15.entity.FileDto;
import com.kh.sts15.entity.Member;
import com.kh.sts15.repository.MemberDao;
import com.kh.sts15.repository.PhysicalFileDao;
import com.kh.sts15.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private PhysicalFileDao physicalFileDao;
	
	
	@Override
	public void store(MemberVo vo) throws IllegalStateException, IOException {
	int no = memberDao.getSequence();
	Member member = Member.builder()
												.member_no(no)
												.member_id(vo.getMember_id())
												.member_pw(vo.getMember_pw())
												.member_nick(vo.getMember_nick())
												.build();
	memberDao.regist(member);
	
	List<FileDto> list = new ArrayList<>();
	for(MultipartFile mf : vo.getFile()) {
		list.add(FileDto.builder()
								.profile_savename(Integer.toString(no))
								.profile_uploadname(mf.getOriginalFilename())
								.member_no(no)
								.profile_size(mf.getSize())
				
							.build());
		
	}
	File dir = new File("D:/upload/filetest");
	dir.mkdirs();
	for(int i=0; i<list.size(); i++) {
		MultipartFile mf = vo.getFile().get(i);
		FileDto fileDto = list.get(i);
		
		File target = new File(dir, fileDto.getProfile_savename());
		mf.transferTo(target);
		physicalFileDao.regist(fileDto);
		
	}

	}

}
