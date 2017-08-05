package com.data;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional
public interface questionRepository {
public List<Questions> getQuestionAnswer();
}
