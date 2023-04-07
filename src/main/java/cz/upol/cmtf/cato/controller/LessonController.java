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

import cz.upol.cmtf.cato.dto.LessonTweetSimpleDTO;
import cz.upol.cmtf.cato.entity.LessonEntity;
import cz.upol.cmtf.cato.service.LessonService;

@RestController
@RequestMapping(value="api/lesson/")
public class LessonController {

	@Autowired
	private LessonService lessonService;
	
	@CrossOrigin(origins = "*")
	@GetMapping("get/all")
	public List<LessonEntity> getLessons() {
		return lessonService.getLessons();
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("add/{clazz}")
	public void add(@RequestBody LessonEntity lessonEntity, @PathVariable("clazz") Long clazz) {
		
		lessonService.addLesson(lessonEntity, clazz);
	}
	
	
	@CrossOrigin(origins = "*")
	@GetMapping("get/byid/simple/{lessonId}")
	public LessonTweetSimpleDTO getLessonById(@PathVariable("lessonId") Long lessonId) {
		return lessonService.getLessonById(lessonId);
	} 
}
