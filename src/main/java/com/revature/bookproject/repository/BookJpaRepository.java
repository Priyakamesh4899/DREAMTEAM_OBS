package com.revature.bookproject.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.revature.bookproject.model.Books;
@Component
//@EnableJpaRepositories
public interface BookJpaRepository extends JpaRepository<Books,Long>{

	Books findByBookName(String name);

	List<Books> findAllByAuthorName(String name);
	
	List<Books> findAllByAuthorNameLike(String likePattern);

	

	

}
