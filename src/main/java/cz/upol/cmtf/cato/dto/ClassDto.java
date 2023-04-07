package cz.upol.cmtf.cato.dto;

import java.util.List;

import cz.upol.cmtf.cato.entity.LessonEntity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ClassDto {
	
	private String title;
	
	private String description;
	
	private List<LessonEntity> lessons;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<LessonEntity> getLessons() {
		return lessons;
	}

	public void setLessons(List<LessonEntity> lessons) {
		this.lessons = lessons;
	}
}
