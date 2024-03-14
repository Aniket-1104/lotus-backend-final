package com.moneview.employeePortal.services.impl;

import com.moneview.employeePortal.domain.entities.TagsEntity;
import com.moneview.employeePortal.repositories.TagsRepository;
import com.moneview.employeePortal.services.TagsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TagsServiceImpl implements TagsService {
    private TagsRepository tagsRepository;

    public TagsServiceImpl(TagsRepository tagsRepository) {
        this.tagsRepository = tagsRepository;
    }

    @Override
    public TagsEntity createTag(TagsEntity tagsEntity) {
        return tagsRepository.save(tagsEntity);
    }

    @Override
    public List<TagsEntity> findAll() {
        return StreamSupport.stream(tagsRepository.
                                findAll().
                                spliterator(),
                        false)
                .collect(Collectors.toList());
    }

    @Override
    public List<TagsEntity> getTagsByPrefix(String prefix) {
        return StreamSupport.stream(tagsRepository.
                                findByTagNameStartingWith(prefix).
                                spliterator(),
                        false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TagsEntity> findOne(Long tagId) {
        return tagsRepository.findById(tagId);
    }
}
