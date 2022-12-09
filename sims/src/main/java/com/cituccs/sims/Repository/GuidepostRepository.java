//package com.travelguide.sims_app.Repository;
package com.cituccs.sims.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cituccs.sims.Entity.GuidepostEntity;


@Repository
public interface GuidepostRepository extends JpaRepository<GuidepostEntity, Integer>{
	GuidepostEntity findByTitle(String title);
	
	@Query(value ="SELECT * FROM tbl_guidepost", nativeQuery = true)
	List<GuidepostEntity> findAllGuides();
	
	@Query(value ="SELECT * FROM tbl_guidepost WHERE title LIKE %?1%", nativeQuery = true)
	List<GuidepostEntity> findByLikeTitle(String title);
}
