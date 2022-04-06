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
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer likeId;

    @Column(nullable = false)
    private Integer likeAuthor;

    @ManyToOne
    @JsonIgnoreProperties({"likes"})
    private Post post;

}
