package com.moneview.employeePortal.mappers.impl;

import com.moneview.employeePortal.domain.dto.TagsDto;
import com.moneview.employeePortal.domain.entities.TagsEntity;
import com.moneview.employeePortal.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TagsMapper implements Mapper<TagsEntity, TagsDto> {
    private ModelMapper modelMapper;

    public TagsMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @Override
    public TagsDto mapTo(TagsEntity tagsEntity) {
        return modelMapper.map(tagsEntity, TagsDto.class);
    }

    @Override
    public TagsEntity mapFrom(TagsDto tagsDto) {
        return modelMapper.map(tagsDto, TagsEntity.class);
    }
}
