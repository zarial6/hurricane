package com.hurricane.mindmap.service.impl;

import com.hurricane.mindmap.dto.TaskDto;
import com.hurricane.mindmap.repository.TaskRepository;
import com.hurricane.mindmap.model.Task;
import com.hurricane.mindmap.service.TaskService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashSet;

import java.util.Set;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public Set<Task> getMovie() {

        Set<Task> tasks = new HashSet<>();
        taskRepository.findAll();
        return tasks;

    }

    @Override
    public Mono<Task> findById(String id) {
        return taskRepository.findById(id);
    }

    @Override
    public Mono<Task> saveMovie(Task task) {
        return null;
    }

    @Override
    public Mono<Task> getById(String id) {
        return null;
    }

    @Override
    public Flux<Task> findAll() {
        return null;
    }

    @Override
    public Mono<Task> create(Mono<TaskDto> dtoMono) {
        return null;
    }
}
