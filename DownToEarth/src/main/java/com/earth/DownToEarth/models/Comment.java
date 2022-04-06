package com.earth.DownToEarth.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CommentId;

    @Column(nullable = false)
    private String commentText;

    @ManyToOne
    @JsonIgnoreProperties({"comments"})
    private Post post;
}
