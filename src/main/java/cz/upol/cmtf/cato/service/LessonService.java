package cz.upol.cmtf.cato.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.upol.cmtf.cato.dto.LessonTweetSimpleDTO;
import cz.upol.cmtf.cato.dto.TweetSimpleDTO;
import cz.upol.cmtf.cato.entity.ClazzEntity;
import cz.upol.cmtf.cato.entity.LessonEntity;
import cz.upol.cmtf.cato.entity.TweetEntity;
import cz.upol.cmtf.cato.repository.ClazzRepository;
import cz.upol.cmtf.cato.repository.LessonRepository;
import cz.upol.cmtf.cato.utils.TimestampUtils;

@Service
public class LessonService {
	
	@Autowired
	private LessonRepository lessonRepository;
	
	@Autowired
	private ClazzRepository clazzRepository;
	
	public List<LessonEntity> getLessons() {
		List<LessonEntity> classes = lessonRepository.findAll();
		return classes;
			
	}
	
	public void addLesson(LessonEntity lessonEntity, Long clazz) {
		lessonEntity.setCreationTimestamp(TimestampUtils.localDateTimeToTimestamp(LocalDateTime.now()));
		Optional<ClazzEntity> myClazz = clazzRepository.findById(clazz);
		ClazzEntity i = myClazz.get();
		
		
		lessonEntity.setClazz(i);
		
		lessonRepository.save(lessonEntity);
	}
	
	public LessonTweetSimpleDTO getLessonById(Long lessonId) {
		Optional<LessonEntity> lesson = lessonRepository.findById(lessonId);
		LessonEntity myLesson = lesson.get();
		
		 LessonTweetSimpleDTO  lessonTweetSimpleDTO = new  LessonTweetSimpleDTO();
		 lessonTweetSimpleDTO.setLessonId(myLesson.getLessonId());
		 lessonTweetSimpleDTO.setTitle(myLesson.getTitle());
		 lessonTweetSimpleDTO.setDescription(myLesson.getDescription());
		 
		 Set<TweetSimpleDTO> tweetSimpleDTOs = new HashSet<>();
		 for(TweetEntity tweet : myLesson.getTweets()) {
			 TweetSimpleDTO tweetSimpleDTO = new TweetSimpleDTO();
			 tweetSimpleDTO.setTweetId(tweet.getTweetId());
			 tweetSimpleDTO.setText(tweet.getText());
			 tweetSimpleDTO.setUserId(tweet.getUserId());
			 tweetSimpleDTO.setNick(tweet.getNick());
			 
			 tweetSimpleDTOs.add(tweetSimpleDTO);
		 }
		 
		 List<TweetSimpleDTO> tweetSimpleDTOss = new ArrayList<>();
		 tweetSimpleDTOss.addAll(tweetSimpleDTOs);
		 
		 lessonTweetSimpleDTO.setTweets(tweetSimpleDTOss);
		 
		 return lessonTweetSimpleDTO;
	}
}
