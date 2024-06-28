package com.kuylyhour.online_video_training.helper;

import java.util.List;

import com.kuylyhour.online_video_training.entity.Category;
import com.kuylyhour.online_video_training.entity.Course;

public class ServiceHelper {
	
	private static Category category1 = Category.builder()
			.id(1L)
			.name("Programming")
			.build();
	private static Category category2 = Category.builder()
			.id(2L)
			.name("Programmer")
			.build();
	private static Category category3 = Category.builder()
			.id(3L)
			.name("Network")
			.build();
	public static List<Category> getCategory(){
		List<Category> list = List.of(category1,category2,category3);
		return list;
	}
	
	private static Course course1 = Course.builder()
			.id(1L)
			.name("Java")
			.category(category1)
			.build();
	private static Course course2 = Course.builder()
			.id(2L)
			.name("Python")
			.category(category1)
			.build();
	public static List<Course> getCourse(){
		List<Course> list = List.of(course1,course2);
		return list;
	}
	
}
