package com.moneview.employeePortal.repositories;

import com.moneview.employeePortal.domain.entities.CommunityEntity;
import com.moneview.employeePortal.domain.entities.TagsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TagsRepository extends CrudRepository<TagsEntity, Long>, JpaRepository<TagsEntity, Long> {
    List<TagsEntity> findByTagNameStartingWith(String prefix);
}
