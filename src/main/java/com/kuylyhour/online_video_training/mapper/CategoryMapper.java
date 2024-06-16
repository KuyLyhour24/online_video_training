package com.kuylyhour.online_video_training.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kuylyhour.online_video_training.dto.CategoryDTO;
import com.kuylyhour.online_video_training.entity.Category;


@Mapper
public interface CategoryMapper {
	CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
	
	Category toCategory(CategoryDTO dto);
	CategoryDTO toCategoryDTO(Category entity);

}
