package com.hurricane.mindmap.converter;

import com.hurricane.mindmap.dto.TaskDto;
import com.hurricane.mindmap.model.Task;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TaskDtoToEntityConverter implements Converter<TaskDto, Task> {

    @Override
    public Task convert(TaskDto taskDto) {
        Task task = Task.builder()
                .title(taskDto.getTitle())
                .build();
        task.setId(task.getId());

        return task;
    }

}



