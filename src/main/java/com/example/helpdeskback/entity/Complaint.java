package com.example.helpdeskback.entity;

import com.example.helpdeskback.enums.Category;
import com.example.helpdeskback.enums.Status;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Complaint {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Date creationDate;
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    private Client client;

    @JsonIgnoreProperties({"complaints"})
    @ManyToOne
    private Agent agent;
}
