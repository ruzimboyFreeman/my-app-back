package com.example.myblogback.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public abstract class BaseEntity {

    @Id
    private UUID id;

    @CreatedDate
    @Column("created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column("created_by")
    private String createdBy;

    @LastModifiedDate
    @Column("updated_at")
    private LocalDateTime updatedAt;

    @Column("updated_by")
    private String updatedBy;

    @Column("is_deleted")
    private boolean isDeleted = false;

    public BaseEntity() {
    }

    public BaseEntity(UUID id) {
        this.id = id == null ? UUID.randomUUID() : id;
    }
}
