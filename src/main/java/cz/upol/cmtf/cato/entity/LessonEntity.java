package cz.upol.cmtf.cato.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "lesson")
public class LessonEntity  {
	
	@Id
	@Column(name = "lesson_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long lessonId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "CREATION_DATE", columnDefinition = "TIMESTAMP")
    private Timestamp creationTimestamp;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "fk_clazz")
    private ClazzEntity clazz;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, targetEntity = TweetEntity.class, mappedBy = "lesson", fetch = FetchType.EAGER)
	private List<TweetEntity> tweets;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Timestamp getCreationTimestamp() {
		return creationTimestamp;
	}

	public void setCreationTimestamp(Timestamp creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}
	
	public ClazzEntity getClazz() {
		return clazz;
	}

	public void setClazz(ClazzEntity clazz) {
		this.clazz = clazz;
	}

	public List<TweetEntity> getTweets() {
		return tweets;
	}

	public void setTweets(List<TweetEntity> tweets) {
		this.tweets = tweets;
	}
}
	

	
	


