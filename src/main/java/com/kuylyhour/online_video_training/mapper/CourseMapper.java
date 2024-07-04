package com.kuylyhour.online_video_training.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.kuylyhour.online_video_training.dto.CourseDTO;
import com.kuylyhour.online_video_training.entity.Course;
import com.kuylyhour.online_video_training.service.CategoryService;
import com.kuylyhour.online_video_training.service.UserService;

@Mapper(componentModel = "spring", uses= {CategoryService.class, UserService.class})
public interface CourseMapper {
	
	CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);
	
	@Mapping(target = "category", source= "categoryId" )
	Course toCourse(CourseDTO courseDTO);
	@Mapping(target = "categoryId" , source = "category.id")
	CourseDTO toCourseDTO(Course course);
	
	
}
