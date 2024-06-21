package com.kuylyhour.online_video_training.helper;

import java.util.List;

import com.kuylyhour.online_video_training.entity.Category;

public class CategoryServiceHelper {
	
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

}
