//package com.travelguide.sims_app.Repository;
package com.cituccs.sims.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cituccs.sims.Entity.GuidepostEntity;


@Repository
public interface GuidepostRepository extends JpaRepository<GuidepostEntity, Integer>{
	GuidepostEntity findByTitle(String title);
	
	@Query(value ="SELECT * FROM tbl_guidepost ORDER BY guidepostid DESC", nativeQuery = true)
	List<GuidepostEntity> findAllGuides();
	
	@Query(value ="SELECT * FROM tbl_guidepost WHERE isdeleted=0 ORDER BY guidepostid DESC", nativeQuery = true)
	List<GuidepostEntity> findAvailabledGuides();
	
	@Query(value ="SELECT * FROM tbl_guidepost WHERE title LIKE %?1%", nativeQuery = true)
	List<GuidepostEntity> findByLikeTitle(String title);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value="UPDATE tbl_guidepost SET views = views + 1 WHERE guidepostid = :guidepostId", nativeQuery = true)
	int addViewToGuidepost(Integer guidepostId);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value="UPDATE tbl_guidepost SET isdeleted = 1 WHERE guidepostid = :guidepostId", nativeQuery = true)
	int setGuidepostDelete(Integer guidepostId);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value="UPDATE tbl_guidepost SET isdeleted = 0 WHERE guidepostid = :guidepostId", nativeQuery = true)
	int setGuidepostActive(Integer guidepostId);
}
