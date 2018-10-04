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

                TaskDto movieDto = TaskDto.builder()
                        .title(task.getTitle())
                        .director(task.getDirector())
                        .year(task.getYear())
                        .rating(task.getRating())
                        .build();
                movieDto.setId(task.getId());

                return Mono.just(movieDto);

    }
}
