package cz.upol.cmtf.cato.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.upol.cmtf.cato.dto.ClassDto;
import cz.upol.cmtf.cato.dto.ClazzLessonSimpleDTO;
import cz.upol.cmtf.cato.dto.ClazzSimpleDTO;
import cz.upol.cmtf.cato.dto.LessonSimpleDTO;
import cz.upol.cmtf.cato.entity.ClazzEntity;
import cz.upol.cmtf.cato.entity.LessonEntity;
import cz.upol.cmtf.cato.entity.MemberEntity;
import cz.upol.cmtf.cato.entity.UserEntity;
import cz.upol.cmtf.cato.repository.ClazzRepository;
import cz.upol.cmtf.cato.repository.UserRepository;
import cz.upol.cmtf.cato.utils.TimestampUtils;

@Service
public class ClazzService {
	
	@Autowired
	private ClazzRepository clazzRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	public List<ClazzEntity> getClazzes() {
		List<ClazzEntity> clazzes = clazzRepository.findAll();
		return clazzes;
	}
	
	public List<ClazzSimpleDTO> getClazzesSimple() {
		List<ClazzEntity> clazzes = clazzRepository.findAll();
		
		List<ClazzSimpleDTO> clazzSimpleDTOs = new ArrayList<>();
		for(ClazzEntity clazz : clazzes) {
			ClazzSimpleDTO clazzSimpleDTO = new ClazzSimpleDTO();
			clazzSimpleDTO.setClazzId(clazz.getClazzId());
			clazzSimpleDTO.setTitle(clazz.getTitle());
			System.out.println(clazzSimpleDTO.getClazzId() + "  "+ clazzSimpleDTO.getTitle()); 
			clazzSimpleDTOs.add(clazzSimpleDTO);
		}
		
		return clazzSimpleDTOs;
	}
	
	public List<ClazzSimpleDTO> getClazzesByUserSimple(Long userId) {
		List<ClazzEntity> clazzes = clazzRepository.findAll();
		
		List<ClazzEntity> pickedClazzes = new ArrayList<>();
		for(ClazzEntity clazz : clazzes) {
			for(MemberEntity member : clazz.getMembers()) {
			//	if(member.getUserId() == userId) {
				if(userId.equals(member.getUserId())) {
					pickedClazzes.add(clazz);
				}
			}
			
		
		}
		
		List<ClazzSimpleDTO> clazzSimpleDTOs = new ArrayList<>();
		for(ClazzEntity clazz : pickedClazzes) {
			ClazzSimpleDTO clazzSimpleDTO = new ClazzSimpleDTO();
			clazzSimpleDTO.setClazzId(clazz.getClazzId());
			clazzSimpleDTO.setTitle(clazz.getTitle());
			System.out.println(clazzSimpleDTO.getClazzId() + "  "+ clazzSimpleDTO.getTitle());
			
			clazzSimpleDTOs.add(clazzSimpleDTO);
		}
		
		return clazzSimpleDTOs;
	}
	
	public ClazzLessonSimpleDTO getClazzByIdSimple(Long clazzId) {
		Optional<ClazzEntity> clazz = clazzRepository.findById(clazzId);
		
		ClazzEntity myClazz = clazz.get();
				
		ClazzLessonSimpleDTO clazzLessonSimpleDTO = new ClazzLessonSimpleDTO();
		clazzLessonSimpleDTO.setClazzId(myClazz.getClazzId());
		clazzLessonSimpleDTO.setTitle(myClazz.getTitle());
		clazzLessonSimpleDTO.setDescription(myClazz.getDescription());
		
		
		 Set<LessonEntity> lessonEntities = myClazz.getLessons();
		 
		List<LessonSimpleDTO> lessonSimpleDTOs = new ArrayList<>(); 
		
		for(LessonEntity lessonEntity : lessonEntities) {
			LessonSimpleDTO lessonSimpleDTO = new LessonSimpleDTO();
			lessonSimpleDTO.setLessonId(lessonEntity.getLessonId());
			lessonSimpleDTO.setTitle(lessonEntity.getTitle());
			
			
			lessonSimpleDTOs.add(lessonSimpleDTO);
		}
		clazzLessonSimpleDTO.setLessons(lessonSimpleDTOs);
		
		return clazzLessonSimpleDTO;
	}
	
	public void addClazz(ClazzEntity clazz, long user) {
		Optional<UserEntity> userr = userRepository.findById(user);
	//	clazz.setUsers(Arrays.asList(userr.get()));
		
	    clazz.setCreationTimestamp(TimestampUtils.localDateTimeToTimestamp(LocalDateTime.now()));
		clazzRepository.save(clazz);
	}
	
	public void addClazz2(ClazzEntity clazz, long user) {
		System.out.println("addClazz2, user "+ user);
		
		MemberEntity memberEntity = new MemberEntity();
		memberEntity.setUserId(user);
		memberEntity.setClazz(clazz);
		
		Set<MemberEntity> memberEntities = new HashSet<>();
		memberEntities.add(memberEntity);
		
		clazz.setMembers(memberEntities);
	    clazz.setCreationTimestamp(TimestampUtils.localDateTimeToTimestamp(LocalDateTime.now()));
	    
	    System.out.println("addClazz22, members size "+ clazz.getMembers().size());
		clazzRepository.save(clazz);
	}
	
	public Set<UserEntity> getClassWithMembers(Long classId) {
		Optional<ClazzEntity> clazz = clazzRepository.findById(classId);
		
		Set<Long> memberIds = new HashSet<>();
		
		for(MemberEntity member : clazz.get().getMembers()) {
			memberIds.add(member.getUserId());
	     }
		
		List<UserEntity> users = userRepository.findAll();
		
		Set<UserEntity> validUsers = new HashSet<>();
		
		for(UserEntity user : users) {
			for(Long memberId : memberIds) {
				if(memberId == user.getId()) {
					validUsers.add(user);
				}
			}
		}
		
		return validUsers;
	}
}
