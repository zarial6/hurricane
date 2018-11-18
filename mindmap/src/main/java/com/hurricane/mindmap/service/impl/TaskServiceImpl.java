package com.hurricane.mindmap.service.impl;

import com.hurricane.mindmap.converter.TaskDtoToEntityConverter;
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
    private final TaskDtoToEntityConverter converter;

    public TaskServiceImpl(TaskRepository taskRepository, TaskDtoToEntityConverter converter) {
        this.taskRepository = taskRepository;
        this.converter = converter;

    }

    @Override
    public Mono<Task> update(Mono<TaskDto> dtoMono) {
        return dtoMono.map(TaskDto::getId)
                .map(this::getById)
                .filterWhen(Mono::hasElement)
                .flatMap(existingTask -> converter.convert(dtoMono).flatMap(taskRepository::save));
    }

    @Override
    public Mono<Void> delete(String id) {
        return taskRepository.findById(id)
                .map(taskRepository::delete)
                .then();
    }

    @Override
    public Mono<Task> getById(String id) {
        return taskRepository.findById(id);
    }

    @Override
    public Flux<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Mono<Task> create(Mono<TaskDto> dtoMono) {
        return converter.convert(dtoMono)
                .flatMap(taskRepository::insert);
    }
}
