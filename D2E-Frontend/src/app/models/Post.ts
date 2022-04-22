export interface Post{

    postId : number;
    timePosted : string;
    postBody : string;
    postMedia : string; //link the url
    commentCount : number;
    likesCount : number;
    user : {
        userId : number;
        email : string;
        username : string;
        password : string;
        firstname : string;
        lastname : string;
        location : string;
    }





}