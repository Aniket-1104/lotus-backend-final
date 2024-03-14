package com.moneview.employeePortal.services;

import com.moneview.employeePortal.domain.entities.CommunityEntity;
import com.moneview.employeePortal.domain.entities.TagsEntity;

import java.util.List;
import java.util.Optional;

public interface TagsService {
    TagsEntity createTag(TagsEntity tagsEntity);

    List<TagsEntity> findAll();

    List<TagsEntity> getTagsByPrefix(String prefix);

    Optional<TagsEntity> findOne(Long tagId);

}
