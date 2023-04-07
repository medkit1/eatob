package cz.upol.cmtf.cato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cz.upol.cmtf.cato.entity.TweetEntity;

@Repository
public interface TweetRepository  extends JpaRepository<TweetEntity, Long> {
}
