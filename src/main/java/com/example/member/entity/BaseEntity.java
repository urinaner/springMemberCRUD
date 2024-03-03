package com.example.member.entity;


import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BaseEntity {

    @CreationTimestamp //생성된 시간 생성
    @Column(updatable = false) //수정시에는 관여 X
    private LocalDateTime createTime;

    @UpdateTimestamp  //업데이트 시간
    @Column(insertable = false) //입력시 관여 X
    private LocalDateTime updatedTime;
}
