package cz.upol.cmtf.cato.service;

import java.util.List;
import java.util.Optional;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.upol.cmtf.cato.entity.ClazzEntity;
import cz.upol.cmtf.cato.entity.MemberEntity;
import cz.upol.cmtf.cato.repository.ClazzRepository;
import cz.upol.cmtf.cato.repository.MemberRepository;
import cz.upol.cmtf.cato.utils.TimestampUtils;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private ClazzRepository clazzRepository;
	
	public List<MemberEntity> getMembers() {
		List<MemberEntity> members = memberRepository.findAll();
		return members;
			
	}
	
	public void addMember(MemberEntity memberEntity, Long clazz) {
		memberEntity.setCreationTimestamp(TimestampUtils.localDateTimeToTimestamp(LocalDateTime.now()));
		Optional<ClazzEntity> myClazz = clazzRepository.findById(clazz);
		ClazzEntity i = myClazz.get();
		
		
		memberEntity.setClazz(i);
		
		memberRepository.save(memberEntity);
	}

}
