package com.hurricane.mindmap.model;


import lombok.*;

import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task extends BaseEntity {

    private String title;
    private String director;
    private String year;
    private String rating;

}