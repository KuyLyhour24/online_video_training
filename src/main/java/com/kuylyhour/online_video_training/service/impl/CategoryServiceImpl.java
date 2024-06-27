package com.kuylyhour.online_video_training.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.kuylyhour.online_video_training.entity.Category;
import com.kuylyhour.online_video_training.entity.Course;
import com.kuylyhour.online_video_training.exception.ApiException;
import com.kuylyhour.online_video_training.exception.ResourceNotFoundException;
import com.kuylyhour.online_video_training.exception.SQLException;
import com.kuylyhour.online_video_training.repository.CategoryRepository;
import com.kuylyhour.online_video_training.repository.CourseRepository;
import com.kuylyhour.online_video_training.service.CategoryService;
import com.kuylyhour.online_video_training.service.CourseService;
import com.kuylyhour.online_video_training.service.util.PageUtil;
import com.kuylyhour.online_video_training.spec.CategoryFilter;
import com.kuylyhour.online_video_training.spec.CategorySpec;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
	
	private final CategoryRepository categoryRepository;
	private final CourseService courseService;
	private final CourseRepository courseRepository;
	

	@Override
	public Category create(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category getById(Long id) {
		return categoryRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Category", id));
	}

	@Override
	public Category update(Category category, Long id) {
		Category categoryId = getById(id);
		categoryId.setName(category.getName());
		return categoryRepository.save(categoryId);
	}

	@Override
	public List<Category> getCategory(String name) {
		return categoryRepository.findByNameContaining(name.toUpperCase());
	}

	@Override
	public void delete(Long id) {
		Course course = courseService.getById(id);
		if(course!=null){
			throw new SQLException("Category", id);
		}
		Category categoryId = getById(id);
		if(categoryId !=null) {
			categoryRepository.deleteById(id);
		}
	}

	@Override
	public Page<Category> getCategoryPage(Map<String, String> params) {
		CategoryFilter categoryFilter = new CategoryFilter();
		
		if(params.containsKey("name")) {
			String name = params.get("name");
			categoryFilter.setName(name);
		}
		if(params.containsKey("id")) {
			String id= params.get("id");
			categoryFilter.setId(Long.parseLong(id));
		}
		int pageLimit = PageUtil.DEFAULT_PAGE_LIMIT;
		if(params.containsKey(PageUtil.PAGE_LIMIT)) {
			pageLimit= Integer.parseInt(params.get(PageUtil.PAGE_LIMIT));
		}
		int pageNumber = PageUtil.DEFAULT_PAGE_NUMBER;
		if(params.containsKey(PageUtil.PAGE_NUMBER)) {
			pageNumber = Integer.parseInt(params.get(PageUtil.PAGE_NUMBER));
		}
		Specification<Category> categorySpec = new CategorySpec(categoryFilter);
		Pageable pageable= PageUtil.getPageable(pageNumber, pageLimit);
		Page<Category> page = categoryRepository.findAll(categorySpec, pageable);
		return page;
	}

	@Override
	public List<Course> getCourseByCategoryId(Long id) {
		Category category = getById(id);
		return courseRepository.findCourseByCategoryId(category.getId());
	}
}
