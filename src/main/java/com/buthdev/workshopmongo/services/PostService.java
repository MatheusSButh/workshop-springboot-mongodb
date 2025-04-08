package com.buthdev.workshopmongo.services;

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

}
