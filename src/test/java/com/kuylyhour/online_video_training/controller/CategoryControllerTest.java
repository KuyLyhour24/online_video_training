package com.kuylyhour.online_video_training.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.kuylyhour.online_video_training.entity.Category;
import com.kuylyhour.online_video_training.entity.Course;
import com.kuylyhour.online_video_training.helper.ServiceHelper;
import com.kuylyhour.online_video_training.mapper.CategoryMapper;
import com.kuylyhour.online_video_training.mapper.CourseMapper;
import com.kuylyhour.online_video_training.repository.CategoryRepository;
import com.kuylyhour.online_video_training.service.CategoryService;
import com.kuylyhour.online_video_training.service.util.PageUtil;
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CategoryControllerTest {

	@Mock
	private CategoryService categoryService;
	@Mock
	private CourseMapper courseMapper;
	

	@Spy
	@InjectMocks
	private CategoryController controller;
	
	@Mock
	private CategoryRepository categoryRepository;
	
	@BeforeEach
	public void setUp() {
		controller = new CategoryController(categoryService, courseMapper);
		
	}

	@Test 
	public void testCreateCategory() {
		List<Category> categories = ServiceHelper.getCategory();
		Category category = categories.get(0);
		
		when(categoryService.create(any())).thenReturn(category);
		ResponseEntity<?> result = controller.createCategory(CategoryMapper.INSTANCE.toCategoryDTO(category));
		
		assertEquals(HttpStatus.OK, result.getStatusCode());
		
	}
	@Test
	public void testGetById() {
		List<Category> categories = ServiceHelper.getCategory();
		Category category = categories.get(0);
		
		when(categoryService.getById(anyLong())).thenReturn(category);
		ResponseEntity<?> result = controller.getById(category.getId());
		
		assertEquals(HttpStatus.OK, result.getStatusCode());
	}
	
	@Test
	public void testGetCategory() {
		List<Category> categories = ServiceHelper.getCategory();
		Category category = categories.get(0);
		when(categoryService.getCategory("Programming")).thenReturn(categories);
		ResponseEntity<?> responseEntity = controller.getCategory(category.getName());
		
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void testDelete() {
		List<Category> categories = ServiceHelper.getCategory();
		Long id = categories.get(0).getId();
		doNothing().when(categoryService).delete(id);
		
		ResponseEntity<?> responseEntity = controller.deleteCategory(id);
		
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	@Test
	public void testUpdate() {
		List<Category> categories = ServiceHelper.getCategory();
		Category category = categories.get(0);
		
		when(categoryService.update(any(),anyLong())).thenReturn(category);
		ResponseEntity<?> entity = controller.updateCategory(1L, CategoryMapper.INSTANCE.toCategoryDTO(category));
		
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}
	@Test
	public void testGetBySpec() throws Exception{
		//Given
		List<Category> categories = ServiceHelper.getCategory();
		Pageable pageable = PageUtil.getPageable(1, 2);
		Page<Category> page = new PageImpl<>(categories, pageable, categories.size());
		//When
		when(categoryService.getCategoryPage(any())).thenReturn(page);
		ResponseEntity<?> entity = controller.getCategory(new HashMap<>());
		//Then
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}
	@Test
	public void testGetCourseByCategoryId() {
		List<Course> courses = ServiceHelper.getCourse();
		
		when(categoryService.getCourseByCategoryId(anyLong())).thenReturn(courses);
		
		ResponseEntity<?> responseEntity = controller.getCourseByCategoryId(1L);
		
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
}
