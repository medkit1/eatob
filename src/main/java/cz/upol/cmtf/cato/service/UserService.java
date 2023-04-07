package cz.upol.cmtf.cato.service;

import java.util.List;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.upol.cmtf.cato.dto.LoginDTO;
import cz.upol.cmtf.cato.entity.UserEntity;
import cz.upol.cmtf.cato.repository.UserRepository;
import cz.upol.cmtf.cato.utils.TimestampUtils;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<UserEntity> getUsers() {
		List<UserEntity> userss = userRepository.findAll();
		return userss;
			
	}
	
	public void addUser(UserEntity userEntity) {
		userEntity.setCreationTimestamp(TimestampUtils.localDateTimeToTimestamp(LocalDateTime.now()));
				
		userRepository.save(userEntity);
	}
	
	public UserEntity login (LoginDTO login) throws Exception {
		UserEntity user= userRepository.findByNick(login.getNick());
		
		if(user!= null && user.getNick().equals(login.getNick()) && user.getPassword().equals(login.getPassword())){
			return user;
		}
		
		throw new Exception("Unknown user");
	}
}
