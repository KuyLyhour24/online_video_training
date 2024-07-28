package com.kuylyhour.online_video_training.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kuylyhour.online_video_training.dto.LevelDTO;
import com.kuylyhour.online_video_training.entity.Level;
import com.kuylyhour.online_video_training.mapper.LevelMapper;
import com.kuylyhour.online_video_training.service.LevelService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("levels")
public class LevelController {

	private final LevelService service;
	private final LevelMapper levelMapper;
	
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody LevelDTO levelDTO){
		Level level = service.save(levelMapper.toLevel(levelDTO));
		return ResponseEntity.ok(levelMapper.toLevelDTO(level));
	}
	@GetMapping("{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		Level level = service.getById(id);
		return ResponseEntity.ok(level);
	}
	@PutMapping("update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id,@RequestBody LevelDTO levelDTO){
		Level level = levelMapper.toLevel(levelDTO);
		Level update = service.update(id, level);
		return ResponseEntity.ok(update);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.ok().build();
	}

}
