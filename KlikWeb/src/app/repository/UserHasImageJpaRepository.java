package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import model.UsersHasImage;

@Repository
public interface UserHasImageJpaRepository extends JpaRepository<UsersHasImage, Integer>{
	
}
