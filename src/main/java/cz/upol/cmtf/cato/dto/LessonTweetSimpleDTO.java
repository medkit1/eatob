package cz.upol.cmtf.cato.dto;

import java.util.List;

public class LessonTweetSimpleDTO {
	
	private Long lessonId;
	private String title;
	private String description;
	private List<TweetSimpleDTO> tweets;
	
	public Long getLessonId() {
		return lessonId;
	}
	
	public void setLessonId(Long lessonId) {
		this.lessonId = lessonId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<TweetSimpleDTO> getTweets() {
		return tweets;
	}
	
	public void setTweets(List<TweetSimpleDTO> tweets) {
		this.tweets = tweets;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
