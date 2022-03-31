package com.earth.DownToEarth.models;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {
    //IDs
    private Integer postId;
    private Integer likeId;
    private Integer commentId;

    //post content
    private Date timePosted;
    private String postBody;
    private Integer commentCount;
    private Integer likesCount;
    //todo images

    //comment content
    private Date timeCommented;
    private String commentBody;

    //comment fk
    private Integer c_postId_fk;
    private Integer c_userId_fk;

    //like fk
    private Integer l_postId_fk;
    private Integer l_userId_fk;
}
