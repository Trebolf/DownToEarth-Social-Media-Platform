package com.earth.DownToEarth.models;

<<<<<<< HEAD

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
=======
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

>>>>>>> 99742ad7e2cbb88404d80854f7480aa8e0031860

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
<<<<<<< HEAD
@Entity
@Table(name = "posts")
public class Post {
=======

@Entity
@Table(name="_posts")
public class Post {

>>>>>>> 99742ad7e2cbb88404d80854f7480aa8e0031860
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

<<<<<<< HEAD
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


=======
    @Column(insertable = false,
            updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date timePosted;

    @Column(nullable = false)
    private String postBody;

    @Column(insertable = false,
            columnDefinition = "INT DEFAULT 0")
    private Integer commentCount;

    @Column(insertable = false,
            columnDefinition = "INT DEFAULT 0")
    private Integer likesCount;
    //todo images

    @ManyToOne
    @JoinColumn(name="p_userId_fk",
            referencedColumnName = "userId",
            nullable = false)
    private User user;
>>>>>>> 99742ad7e2cbb88404d80854f7480aa8e0031860
}
