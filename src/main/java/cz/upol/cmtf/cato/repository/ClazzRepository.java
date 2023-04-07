package cz.upol.cmtf.cato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cz.upol.cmtf.cato.entity.ClazzEntity;

@Repository
public interface ClazzRepository extends JpaRepository<ClazzEntity, Long> {
	
	
	@Query("select u from UserEntity u where u.nick in ?1 ")
	ClazzEntity findByUser(Long userId);
}