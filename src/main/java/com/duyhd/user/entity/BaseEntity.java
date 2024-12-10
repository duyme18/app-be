package com.duyhd.user.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@SuperBuilder(toBuilder = true)
@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants(level = AccessLevel.PUBLIC)
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    @CreatedDate
    @CreationTimestamp
    private Instant createdAt;

    @Column(nullable = false)
    @CreatedBy
    private Long createdBy;

    @Column(nullable = false)
    @LastModifiedDate
    @UpdateTimestamp
    private Instant updatedAt;

    @Column(nullable = false)
    @LastModifiedBy
    private Long updatedBy;

}
