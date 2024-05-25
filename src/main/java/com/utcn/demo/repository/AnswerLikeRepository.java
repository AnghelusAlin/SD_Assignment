package com.utcn.demo.repository;

import com.utcn.demo.entity.AnswerLike;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerLikeRepository extends CrudRepository<AnswerLike, Long> {
}
