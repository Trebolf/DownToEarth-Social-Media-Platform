import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/User';
import { environment } from 'src/environments/environment';
import { ServiceService } from 'src/app/services/service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  username : string = "";
  password : string = "";
  email : string = "";
  firstname : string = "";
  lastname : string = "";
  location : string = "";
  profilePic : string = "";
  users : Array<User> = [];

  file : File = <File>{};
  fileUrl : any;
  picture : boolean = false;
  picExists : boolean = true;
  constructor(private service : ServiceService, private router : Router) { }
  
  createUser(username: string, password: string, email: string, firstname: string, lastname: string, location: string, profilePic: string){
    let formData: FormData = new FormData();
    formData.append('file', this.file);
    console.log(formData);
    this.service.upload(formData).subscribe(responseBody => {
  
    this.profilePic = responseBody;
    console.log(responseBody);
    const picObj = JSON.stringify(responseBody);
    
    JSON.parse(picObj, (key,value) => {
      typeof value === 'string'
      console.log(key);
      console.log(value);

    
  
    this.service.createUser(this.username, this.password, this.email, this.firstname, this.lastname, this.location, value).subscribe(responseBody => {
      this.username="";
      this.password="";
      this.email="";
      this.firstname="";
      this.lastname="";
      this.location="";
      this.profilePic="";
      this.users.push(responseBody);
    })
})
})
    console.log({
      "username": username,
      "password": password,
      "email": email,
      "firstname": firstname,
      "lastname": lastname,
      "location": location,
      "profilePic": profilePic
    })
    this.router.navigate(['home']);
  }
  ngOnInit(): void {
  }
  addFile(e : any)
  {
      this.file = e.target.files[0];
      console.log(this.file);
      this.picExists = true;
      let reader = new FileReader();
      reader.readAsDataURL(e.target.files[0])
      reader.onload = (_e) =>
      {
        this.fileUrl = reader.result;
      }
      this.service.upload(e.target.files[0])
      console.log(e.target.files[0])
  }
}
