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

import cz.upol.cmtf.cato.entity.TweetEntity;
import cz.upol.cmtf.cato.service.TweetService;

@RestController
@RequestMapping(value="api/tweet/")
public class TweetController {
	
	@Autowired
	private TweetService tweetService;
	
	@CrossOrigin(origins = "*")
	@GetMapping("get/all")
	public List<TweetEntity> getTweets() {
		return tweetService.getTweets();
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("add/{lesson}")
	public void add(@RequestBody TweetEntity tweetEntity, @PathVariable("lesson") Long lesson) {
		
		tweetService.addTweet(tweetEntity, lesson);
	}

}
