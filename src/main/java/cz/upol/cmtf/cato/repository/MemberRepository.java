package cz.upol.cmtf.cato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cz.upol.cmtf.cato.entity.LessonEntity;
import cz.upol.cmtf.cato.entity.MemberEntity;

@Repository
public interface MemberRepository  extends JpaRepository<MemberEntity, Long> {
}

