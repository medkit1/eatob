package cz.upol.cmtf.cato.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cz.upol.cmtf.cato.dto.ClazzLessonSimpleDTO;
import cz.upol.cmtf.cato.dto.ClazzSimpleDTO;
import cz.upol.cmtf.cato.entity.ClazzEntity;
import cz.upol.cmtf.cato.entity.UserEntity;
import cz.upol.cmtf.cato.service.ClazzService;

@RestController
@RequestMapping(value="api/class/")
public class ClazzController {
	
	@Autowired
	private ClazzService clazzService;
	
	@CrossOrigin(origins = "*")
	@GetMapping("get/all")
	public List<ClazzEntity> getClasses() {
		return clazzService.getClazzes();
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("get/all/simple")
	public List<ClazzSimpleDTO> getClassesSimple() {
		return clazzService.getClazzesSimple();
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("get/byuser/simple/{userId}")
	public List<ClazzSimpleDTO> getClassesByUserSimple(@PathVariable("userId") Long userId) {
		return clazzService.getClazzesByUserSimple(userId);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("get/byid/simple/{classId}")
	public ClazzLessonSimpleDTO  getClazzByIdSimple(@PathVariable("classId") Long clazzId) {
		System.out.println("ahoj jseeeem tu");
		return clazzService.getClazzByIdSimple(clazzId);
	}
	
	
	
	@CrossOrigin(origins = "*")
	@PostMapping("add/{user}")
	public void add(@RequestBody ClazzEntity clazz,@PathVariable("user") Long user) {
		clazzService.addClazz(clazz, user);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("add2/{user}")
	public void add2(@RequestBody ClazzEntity clazz,@PathVariable("user") Long user) {
		clazzService.addClazz2(clazz, user);
	}

	
	@CrossOrigin(origins = "*")
	@GetMapping("get/members/{classId}")
	public  Set<UserEntity> getClassWithMembers(@PathVariable("classId") Long classId) {
		return clazzService.getClassWithMembers(classId);
	}


}
