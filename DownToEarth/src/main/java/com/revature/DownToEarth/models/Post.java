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

    //postText is title or entire post if there is no media attached
    @Column(nullable = false)
    private String postText;

    //postMedia could represent a link to youtube/picture
    @Column
    private String postMedia;

    @Column(nullable = false)
    private Integer authorId;

    @Column
    @CreationTimestamp
    private Date postedOn;

    //this should just make the default likeCount 0, but
    // it might override future likeCount
    @Column
    private Integer likeCount = 0;

    //all comments are attached to post as list
    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();


}
