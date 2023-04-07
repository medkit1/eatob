package cz.upol.cmtf.cato.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clazz")
public class ClazzEntity {
	
	@Id
	@Column(name = "clazz_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long clazzId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "CREATION_DATE", columnDefinition = "TIMESTAMP")
    private Timestamp creationTimestamp;
	
//	@OneToMany(targetEntity = ParticipantEntity.class, mappedBy = "class", cascade = CascadeType.ALL)
//	private Set<ParticipantEntity> participants;
	
//	@OneToMany(targetEntity = LessonEntity.class)
//	@JoinColumn(name="classId")
//	private List<LessonEntity> lessons;
	
	//@JsonManagedReference
//	@OneToMany(mappedBy="classEntity",  cascade = CascadeType.ALL) 
//	@OneToMany(mappedBy = "klass", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY) 
//	@OneToMany(  mappedBy = "klass")
//	@JoinColumn(name="fk_klass")
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, targetEntity = LessonEntity.class, mappedBy = "clazz", fetch = FetchType.EAGER)
	private Set<LessonEntity> lessons;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, targetEntity = MemberEntity.class, mappedBy = "clazz", fetch = FetchType.EAGER)
	private Set<MemberEntity> members;

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

	public Set<LessonEntity> getLessons() {
		return lessons;
	}

	public void setLessons(Set<LessonEntity> lessons) {
		this.lessons = lessons;
	}

	public Set<MemberEntity> getMembers() {
		return members;
	}

	public void setMembers(Set<MemberEntity> members) {
		this.members = members;
	}
	
//	@JsonManagedReference
//	@ManyToMany(cascade = { CascadeType.ALL })
//    @JoinTable(
 //       name = "user_clazz", 
  //      joinColumns = { @JoinColumn(name = "cla_id")}, 
   //     inverseJoinColumns = { @JoinColumn(name = "use_id") }
   // )
//	private List<UserEntity> users;
	
	

}
	


	
	



