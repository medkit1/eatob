package cz.upol.cmtf.cato.service;

import java.util.List;
import java.util.Optional;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.upol.cmtf.cato.entity.LessonEntity;
import cz.upol.cmtf.cato.entity.TweetEntity;
import cz.upol.cmtf.cato.repository.LessonRepository;
import cz.upol.cmtf.cato.repository.TweetRepository;
import cz.upol.cmtf.cato.utils.TimestampUtils;

@Service
public class TweetService {
	
	@Autowired
	private TweetRepository tweetRepository;
	
	@Autowired
	private LessonRepository lessonRepository;
	
	public List<TweetEntity> getTweets() {
		List<TweetEntity> tweets = tweetRepository.findAll();
		return tweets;
			
	}
	
	public void addTweet(TweetEntity tweetEntity, Long lesson) {
		tweetEntity.setCreationTimestamp(TimestampUtils.localDateTimeToTimestamp(LocalDateTime.now()));
		Optional<LessonEntity> myLesson = lessonRepository.findById(lesson);
		LessonEntity i = myLesson.get();
		
		tweetEntity.setLesson(i);
		
		tweetRepository.save(tweetEntity);
	}
}
