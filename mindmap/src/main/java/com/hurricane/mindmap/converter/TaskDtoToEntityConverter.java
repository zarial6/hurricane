package com.hurricane.mindmap.converter;

import com.hurricane.mindmap.dto.TaskDto;
import com.hurricane.mindmap.model.Task;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class TaskDtoToEntityConverter implements Converter<Mono<TaskDto>, Mono<Task>> {

    @Override
    public Mono<Task> convert(Mono<TaskDto> taskDtoMono) {
        return taskDtoMono.map(taskDto -> {
            Task task = Task.builder()
                    .title(taskDto.getTitle())
                    .build();
            task.setId(task.getId());

            return task;

        });
    }

}



