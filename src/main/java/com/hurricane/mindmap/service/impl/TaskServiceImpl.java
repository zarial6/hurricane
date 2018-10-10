package com.hurricane.mindmap.service.impl;

import com.hurricane.mindmap.dto.TaskDto;
import com.hurricane.mindmap.repository.TaskRepository;
import com.hurricane.mindmap.model.Task;
import com.hurricane.mindmap.service.TaskService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Mono<Task> update(Mono<TaskDto> dtoMono) {
        return null;
    }

    @Override
    public Mono<Void> delete(String id) {
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
