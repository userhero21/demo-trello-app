package com.company.demotrello.repository.project;

import com.company.demotrello.entities.comment.Comment;
import com.company.demotrello.entities.project.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> getCommentsByCard(Card card);
}
