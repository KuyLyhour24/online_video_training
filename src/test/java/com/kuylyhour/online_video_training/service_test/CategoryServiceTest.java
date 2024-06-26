package com.kuylyhour.online_video_training.service_test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.kuylyhour.online_video_training.dto.CourseDTO;
import com.kuylyhour.online_video_training.entity.Category;
import com.kuylyhour.online_video_training.entity.Course;
import com.kuylyhour.online_video_training.helper.ServiceHelper;
import com.kuylyhour.online_video_training.mapper.CourseMapper;
import com.kuylyhour.online_video_training.repository.CategoryRepository;
import com.kuylyhour.online_video_training.repository.CourseRepository;
import com.kuylyhour.online_video_training.service.CategoryService;
import com.kuylyhour.online_video_training.service.CourseService;
import com.kuylyhour.online_video_training.service.impl.CategoryServiceImpl;
import com.kuylyhour.online_video_training.spec.CategorySpec;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

	@Mock
	private CategoryRepository categoryRepository;
	@Mock
	private CourseRepository courseRepository;
	@Mock
	private CourseMapper courseMapper;
	@Mock
	private CourseService courseService;

	private CategoryService categoryService;

	@BeforeEach
	public void setUp() {
		categoryService = new CategoryServiceImpl(categoryRepository, courseService, courseRepository);

	}

	@Test
	public void testCreate() {
		// Given
		List<Category> categories = ServiceHelper.getCategory();
		Category category = categories.get(0);
		// When
		when(categoryRepository.save(any())).thenReturn(category);
		Category categorySave = categoryService.create(category);
		// Then

		assertEquals(1L, categorySave.getId());
	}

	@Test
	public void testGetById() {
		List<Category> categories = ServiceHelper.getCategory();
		Category category = categories.get(0);

		when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));
		Category id = categoryService.getById(1L);

		assertNotNull(id);
		assertEquals("Programming", id.getName());
	}

	@Test
	public void testGetCategory() {

		List<Category> categories = ServiceHelper.getCategory();

		when(categoryRepository.findByNameContaining(any())).thenReturn(categories);

		List<Category> category = categoryService.getCategory("p");

		assertEquals("Programming", category.get(0).getName());

	}

	@Test
	public void testDelete() {
		List<Category> categories = ServiceHelper.getCategory();
		Long id = categories.get(0).getId();
		
		when(categoryRepository.findById(id)).thenReturn(Optional.of(categories.get(0)));
		categoryService.delete(id);
		Mockito.verify(categoryRepository).deleteById(id);

	}

	@Test
	public void testUpdate() {
		List<Category> categories = ServiceHelper.getCategory();
		Category category = categories.get(0);

		when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));
		Category updateCategory = categoryService.getById(1L);
		updateCategory.setName("Programming");
		when(categoryRepository.save(any())).thenReturn(updateCategory);

		Category update = categoryService.update(category, 1L);

		assertEquals("Programming", update.getName());
	}

	@Test
	public void testGetCategroyByPage() {
		List<Category> categories = ServiceHelper.getCategory();
		when(categoryRepository.findAll(any(CategorySpec.class), any(Pageable.class)))
				.thenReturn(new PageImpl<>(categories));

		Map<String, String> params = new HashMap<>();

		Page<Category> categoryPage = categoryService.getCategoryPage(params);
		
		assertThat(categoryPage).isNotNull();
		assertEquals(3, categoryPage.getContent().size());
	}
	
	@Test
	public void testGetCourseByCategoryId() {
		List<Category> categories = ServiceHelper.getCategory();
		
		List<Course> course = ServiceHelper.getCourse();
		
		when(categoryRepository.findById(1L)).thenReturn(Optional.of(categories.get(0)));
		when(courseRepository.findCourseByCategoryId(1L)).thenReturn(course);
		
		List<Course> courseByCategoryId = categoryService.getCourseByCategoryId(1L);
		
		//assertEquals(2, courseByCategoryId.size());
		assertEquals("Java", courseByCategoryId.get(0).getName());
		assertEquals("Python", courseByCategoryId.get(1).getName());
	
	}
	
}
