package cz.upol.cmtf.cato.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cz.upol.cmtf.cato.entity.MemberEntity;
import cz.upol.cmtf.cato.service.MemberService;

@RestController
@RequestMapping(value="api/member/")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@CrossOrigin(origins = "*")
	@GetMapping("get/all")
	public List<MemberEntity> getMembers() {
		return memberService.getMembers();
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("add/{clazz}")
	public void add(@RequestBody MemberEntity memberEntity, @PathVariable("clazz") Long clazz) {
		memberService.addMember(memberEntity, clazz);
	}
}
