package com.assignment.hypertest.app.PostApplication.entity;


import javax.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "posts")
@Table(name = "posts", uniqueConstraints = @UniqueConstraint(columnNames = "ID"))
public class Post {

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    private String id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "contents")
    private String contents;
}
