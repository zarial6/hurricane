package com.hurricane.mindmap.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDto extends BaseDto {

    private String title;

}
