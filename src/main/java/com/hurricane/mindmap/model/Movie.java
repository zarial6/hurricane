package com.hurricane.mindmap.model;


import lombok.*;

import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie extends BaseEntity {

    private String title;

}
