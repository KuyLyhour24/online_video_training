package com.kuylyhour.online_video_training.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import com.kuylyhour.online_video_training.dto.LevelDTO;
import com.kuylyhour.online_video_training.entity.Level;
import com.kuylyhour.online_video_training.mapper.LevelMapper;
import com.kuylyhour.online_video_training.service.LevelService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/levels")
@RequiredArgsConstructor
public class LevelController {
	private final LevelService levelService;
	
	private final LevelMapper levelMapper;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody LevelDTO levelDto){
		Level level = levelMapper.toLevel(levelDto);
		level = levelService.create(level);
		return ResponseEntity.ok(levelMapper.toLevelDTO(level));
	}
	@GetMapping("{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id){
		Level level = levelService.getById(id);
		return ResponseEntity.ok(level);
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> getByName(@RequestParam("name") String name){
		List<LevelDTO> list = levelService.getByName(name).stream()
		.map(level-> levelMapper.toLevelDTO(level))
		.collect(Collectors.toList());
		return ResponseEntity.ok(list);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody LevelDTO levelDTO) {
		Level level = levelMapper.toLevel(levelDTO);
		Level update = levelService.update(level, id);
		return ResponseEntity.ok(levelMapper.toLevelDTO(update));
	}
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		levelService.delete(id);
		return ResponseEntity.ok().build();
	}
	

}
