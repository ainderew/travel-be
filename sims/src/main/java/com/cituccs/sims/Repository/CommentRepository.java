package com.cituccs.sims.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cituccs.sims.Entity.CommentEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer>{

	@Query(value ="SELECT * FROM tbl_comment WHERE guidepost_id = :guidepostId ORDER BY guidepost_id DESC", nativeQuery = true)
	List<CommentEntity> findGuideComments(Integer guidepostId);
	
}

