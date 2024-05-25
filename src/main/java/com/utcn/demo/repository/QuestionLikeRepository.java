package com.utcn.demo.repository;

import com.utcn.demo.entity.QuestionLike;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionLikeRepository extends CrudRepository<QuestionLike, Long> {
}
