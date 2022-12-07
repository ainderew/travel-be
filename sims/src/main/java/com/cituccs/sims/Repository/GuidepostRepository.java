//package com.travelguide.sims_app.Repository;
package com.cituccs.sims.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cituccs.sims.Entity.GuidepostEntity;

@Repository
public interface GuidepostRepository extends JpaRepository<GuidepostEntity, Integer>{
	GuidepostEntity findByTitle(String title);
}
