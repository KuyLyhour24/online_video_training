package com.kuylyhour.online_video_training.spec;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.kuylyhour.online_video_training.entity.Category;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Data;

@Data
public class CategorySpec implements Specification<Category>{
	
	private final CategoryFilter categoryFilter;
	
	List<Predicate> predicates = new ArrayList<>();

	@Override
	@NonNull
	public Predicate toPredicate(Root<Category> category, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if(categoryFilter.getName()!=null) {
			Predicate name = cb.like(cb.upper(category.get("name")),"%"+categoryFilter.getName().toUpperCase()+"%");
			predicates.add(name);
		}
		if(categoryFilter.getId()!=null) {
			Predicate id = category.get("id").in(categoryFilter.getId());
			predicates.add(id);
		}
		
		return cb.and(predicates.toArray(Predicate[]::new));
	}

}
