package com.revature.DownToEarth.models;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @Column(nullable = false)
    private String postText;

    @Column
    private String postMedia;

    @Column(nullable = false)
    private Integer authorId;

    @Column
    @CreationTimestamp
    private Date postedOn;

    @Column
    private Integer likeCount = 0;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();


}
