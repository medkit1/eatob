package cz.upol.cmtf.cato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cz.upol.cmtf.cato.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	@Query("select u from UserEntity u where u.nick in ?1 ")
	UserEntity findByNick(String nick);
}
