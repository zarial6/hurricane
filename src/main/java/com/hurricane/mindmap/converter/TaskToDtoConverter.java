package com.hurricane.mindmap.converter;


import com.hurricane.mindmap.dto.TaskDto;
import com.hurricane.mindmap.model.Task;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class TaskToDtoConverter implements Converter<Task, Mono<TaskDto>> {


    @Override
    public Mono<TaskDto> convert(Task task) {

        TaskDto taskDto = TaskDto.builder()
                .title(task.getTitle())
                .build();
        taskDto.setId(task.getId());

        return Mono.just(taskDto);

    }
}
