package com.hurricane.mindmap.model;


import lombok.*;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Duration;

@Document
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task extends BaseEntity {

    private String title;

    /*private Duration estimate;

    private String description;

    private String creatorId;

    private String assigneeId;*/
}
