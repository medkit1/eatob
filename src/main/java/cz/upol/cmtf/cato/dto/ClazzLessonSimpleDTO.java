package cz.upol.cmtf.cato.dto;

import java.util.List;

public class ClazzLessonSimpleDTO {
	
	private Long clazzId;
	private String title;
	private String description;
	private List<LessonSimpleDTO> lessons;
	
	public Long getClazzId() {
		return clazzId;
	}
	
	public void setClazzId(Long clazzId) {
		this.clazzId = clazzId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<LessonSimpleDTO> getLessons() {
		return lessons;
	}
	
	public void setLessons(List<LessonSimpleDTO> lessons) {
		this.lessons = lessons;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
