package com.buthdev.workshopmongo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buthdev.workshopmongo.domain.Post;
import com.buthdev.workshopmongo.repository.PostRepository;
import com.buthdev.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id) {
		return postRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}

	public List<Post> findByTitle(String text){
		return postRepository.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24*60*60*1000);
		return postRepository.fullSearch(text, minDate, maxDate);
	}
}
