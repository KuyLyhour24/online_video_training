package com.kuylyhour.online_video_training.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.kuylyhour.online_video_training.entity.Category;

public interface CategoryService {
	
	Category create(Category category);
	Category getById(Long categoryId);
	
	Category update(Category category, Long id);
	
	List<Category> getCategory(String name);
	
	Page<Category> getCategoryPage(Map<String,String> params);
	
	void delete(Long id);

}
