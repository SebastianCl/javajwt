package com.javajwt.security.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.javajwt.security.repository.TodoRepository;
import com.javajwt.security.model.Todo;

@RestController
@RequestMapping("/todo")
public class TodoRestController {

	@Autowired
	private TodoRepository todoRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Todo> findAll() {
		return todoRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{todoId}")
	public Todo findOne(@PathVariable Long todoId) {
		return todoRepository.findOne(todoId);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Todo add(@RequestBody Todo todo) {
		return todoRepository.save(todo);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{todoId}")
	public Todo update(@RequestBody Todo todo) {
		return todoRepository.save(todo);
	}

	/*
	 * @RequestMapping(value = "/todo", method = { RequestMethod.POST,
	 * RequestMethod.PUT }) public ResponseEntity<?> createToDo(@RequestBody todo
	 * toDo) {
	 * 
	 * todo result = todoRepository.save(toDo); URI location =
	 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand
	 * (result.getId()).toUri(); return ResponseEntity.created(location).build(); }
	 */

	@RequestMapping(method = RequestMethod.DELETE, value = "/{todoId}")
	public void delete(@PathVariable Long todoId) {
		todoRepository.delete(todoId);
	}

}
