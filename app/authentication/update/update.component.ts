import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthServiceService } from 'src/app/services/auth-service.service';
import { User } from 'src/app/services/user';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  myGroup!:FormGroup

  form:FormGroup;

  newUser: User = new User();
  users:any = new User();
  USERID!:string;
  name: string;
  constructor(private fb:FormBuilder, private loginService:AuthServiceService, private router:Router) {
    this.USERID = loginService.getUserId()!;
    this.name = loginService.getUserId()!;


    this.form = fb.group({
      FirstName:         ['', [Validators.required, Validators.maxLength(20), Validators.minLength(4)]],
      LastName:         ['', [Validators.required, Validators.maxLength(20), Validators.minLength(4)]],
      password:   ['',[Validators.required, Validators.maxLength(15)]],
     
      email: ['',[Validators.required, Validators.email]]
    })
   }

  ngOnInit(): void {
    this.myGroup = new FormGroup({
      'firstName':new FormControl(),
      'lastName': new FormControl(),
      'email':new FormControl(),
      'password': new FormControl(),
      'userId':new FormControl()
  
      
    });

    this.loginService.getUserDetailes(this.name).subscribe((data)=>{
      console.log("Data",data);
     this.users = data!;
    })
    
  }

  UpdateUser(){
    this.loginService.updateUser(this.users,this.name).subscribe((detailes)=>{
      console.log(detailes)
      alert("updated")
      this.router.navigate(['/UserProfile']);
    })
    
  }


  get FirstName() {
    return this.form.get('FirstName');
  }
  get LastName() {
    return this.form.get('LastName');
  }

  get password(){
    return this.form.get('password');
  }


  get userid(){
    return this.form.get('userid');
  }

  get email(){
    return this.form.get('email')
  }
}
