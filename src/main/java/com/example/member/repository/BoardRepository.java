package com.example.member.repository;

import com.example.member.entity.BaseEntity;
import com.example.member.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
}
