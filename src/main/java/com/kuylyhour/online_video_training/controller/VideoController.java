package com.kuylyhour.online_video_training.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kuylyhour.online_video_training.dto.SetPriceDTO;
import com.kuylyhour.online_video_training.dto.VideoDTO;
import com.kuylyhour.online_video_training.dto.VideoListDTO;
import com.kuylyhour.online_video_training.entity.Video;
import com.kuylyhour.online_video_training.entity.VideoUrl;
import com.kuylyhour.online_video_training.mapper.VideoMapper;
import com.kuylyhour.online_video_training.mapper.VideoUrlMapper;
import com.kuylyhour.online_video_training.service.VideoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("videos")
public class VideoController {
	
	private final VideoService videoService;
	private final VideoMapper videoMapper;
	private final VideoUrlMapper urlMapper;
	@PostMapping
	public ResponseEntity<?> create(@RequestBody VideoDTO videoDTO){
		Video video = videoMapper.toVideo(videoDTO);
		Video save = videoService.save(video);
		return ResponseEntity.ok(videoMapper.toVideoDTO(save));
	}
	@GetMapping("{id}")
	public ResponseEntity<?> getVideo(@PathVariable("id") Long id){
		Video video = videoService.getById(id);
		return ResponseEntity.ok(video);
	}
	@PutMapping("update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody VideoDTO videoDTO){
		Video video = videoMapper.toVideo(videoDTO);
		Video update = videoService.update(video, id);
		return ResponseEntity.ok(videoMapper.toVideoDTO(update));
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		videoService.delete(id);
		return ResponseEntity.ok().build();
	}
	@GetMapping("/url/{id}")
	public ResponseEntity<?> getVideoList(@PathVariable("id") Long id){
		List<VideoUrl> list = videoService.getUrlList(id);
		List<VideoListDTO> listDTO = list.stream().map(urlMapper::toList).toList();
		return ResponseEntity.ok(listDTO);
	}
	@PostMapping("setPrice/{id}")
	public ResponseEntity<?> setPrice(@PathVariable("id") Long id,@RequestBody SetPriceDTO priceDTO){
		videoService.setPrice(id, priceDTO.getPrice());
		return ResponseEntity.ok().build();
	}

}
