import { Component, OnInit } from '@angular/core';
import { Comment } from 'src/app/models/Comment';
import { Post } from 'src/app/models/Post';
import { ServiceService } from 'src/app/services/service.service';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements OnInit {

  commentList : Array<Comment> = [];
  comments : Comment = <Comment>{};
  comment : Comment = <Comment>{};
  post : Post = <Post>{};

  constructor(private service : ServiceService) { }

  ngOnInit(): void {
    // this.getAllCommentsbyPostId(this.post.postId);
    this.getAllCommentsByPostId2();
    /* this.getOneComment(); */
  }

  /* getOneComment() {
    this.service.getOneComment().subscribe(responseBody => {
      this.comment = responseBody;
      console.log(responseBody);
    });
  } */

  getAllCommentsbyPostId(postId : number) {

    this.service.getOnePostById(postId).subscribe(postToComment => {
      this.post = postToComment;
      console.log(this.post)

      this.service.getAllCommentsByPostId().subscribe(responseBody => {
        this.comments = responseBody.data;
        console.log(responseBody);
      });
    })
  }

  getAllCommentsByPostId2() {
    this.service.getAllCommentsByPostId().subscribe(responseBody => {
      this.commentList = responseBody;
    });
  }

  createComment(e : any) {
    e.preventDefault();
  }

}
