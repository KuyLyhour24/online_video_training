package com.kuylyhour.online_video_training.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kuylyhour.online_video_training.dto.CategoryDTO;
import com.kuylyhour.online_video_training.dto.CourseDTO;
import com.kuylyhour.online_video_training.dto.PageDTO;
import com.kuylyhour.online_video_training.entity.Category;
import com.kuylyhour.online_video_training.entity.Course;
import com.kuylyhour.online_video_training.mapper.CategoryMapper;
import com.kuylyhour.online_video_training.mapper.CourseMapper;
import com.kuylyhour.online_video_training.service.CategoryService;
import com.kuylyhour.online_video_training.service.CourseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("categories")
@RequiredArgsConstructor
public class CategoryController {
	
	private final CategoryService categoryService;
	private CourseService courseService;
	private final CourseMapper courseMapper;
	
	@PostMapping
	public ResponseEntity<?> createCategory(@RequestBody CategoryDTO dto){
		Category category = CategoryMapper.INSTANCE.toCategory(dto);
		category = categoryService.create(category);
		return ResponseEntity.ok(CategoryMapper.INSTANCE.toCategoryDTO(category));
	}
	@GetMapping("{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id){
		Category category = categoryService.getById(id);
		return ResponseEntity.ok(CategoryMapper.INSTANCE.toCategoryDTO(category));
	
	}
	@GetMapping("/list")
	public ResponseEntity<?> getCategory(@RequestParam("name") String name){
		List<CategoryDTO> list = categoryService.getCategory(name).stream()
				.map(cate->CategoryMapper.INSTANCE.toCategoryDTO(cate))
				.collect(Collectors.toList());
		return ResponseEntity.ok(list);
	}
	@GetMapping
	public ResponseEntity<?> getCategory(@RequestParam Map<String, String> params){
		Page<Category> page = categoryService.getCategoryPage(params);
		PageDTO pageDTO = new PageDTO(page);
		return ResponseEntity.ok(pageDTO);
	}
	@PutMapping("{id}")
	public ResponseEntity<?> updateCategory(@PathVariable("id") Long id, @RequestBody CategoryDTO categoryDTO){
		Category category = CategoryMapper.INSTANCE.toCategory(categoryDTO);
		Category update = categoryService.update(category, id);
		return ResponseEntity.ok(CategoryMapper.INSTANCE.toCategoryDTO(update));
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable("id") Long id){
		categoryService.delete(id);
		return ResponseEntity.ok().build();
	}
	@GetMapping("course/{id}")
	public ResponseEntity<?> getCourseByCategoryId(@PathVariable("id") Long id){
		List<Course> course = categoryService.getCourseByCategoryId(id);
		List<CourseDTO> list = course.stream()
		.map(courseMapper::toCourseDTO) //Method Reference or we can use .map(model -> modelMapper.toModelDTO(model))
		.toList();
		return ResponseEntity.ok(list);
	
	}
	
	

}
