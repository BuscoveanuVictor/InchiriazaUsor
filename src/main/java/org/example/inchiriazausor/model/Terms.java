package org.example.inchiriazausor.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "terms")
@Data
public class Terms {
    @Id
    private String id;
    private String content;
}