package com.hurricane.mindmap.converter;

import com.hurricane.mindmap.dto.TaskDto;
import com.hurricane.mindmap.model.Task;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class TaskDtoToEntityConverter implements Converter<Mono<TaskDto>, Mono<Task>> {

    @Override
    public Mono<Task> convert(Mono<TaskDto> movieDtoMono) {
        return movieDtoMono.map(movieDto -> {
            Task task = Task.builder()
                    .title(movieDto.getTitle())
                    .director(movieDto.getDirector())
                    .year(movieDto.getYear())
                    .rating(movieDto.getRating())
                    .build();
            task.setId(task.getId());

            return task;

        });
    }

}


