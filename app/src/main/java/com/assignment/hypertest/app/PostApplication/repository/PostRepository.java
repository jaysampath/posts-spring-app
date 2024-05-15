package com.assignment.hypertest.app.PostApplication.repository;

import com.assignment.hypertest.app.PostApplication.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, String> {
}
