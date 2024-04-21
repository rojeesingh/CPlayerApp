import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthServiceService } from 'src/app/services/auth-service.service';
import { User } from 'src/app/services/user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  form:FormGroup;
  newUser: User = new User();
  constructor(private fb:FormBuilder, private loginService:AuthServiceService, private router:Router) { 
    this.form = fb.group({
      FirstName:         ['', [Validators.required, Validators.maxLength(20), Validators.minLength(4)]],
      LastName:         ['', [Validators.required, Validators.maxLength(20), Validators.minLength(4)]],
      password:   ['',[Validators.required, Validators.maxLength(15)]],
      userid:  ['',[Validators.required, Validators.minLength(5)]],
      email: ['',[Validators.required, Validators.email]]

    })
  }

  ngOnInit(): void {
   
  }
 
 
  
  registerUser() {
    console.log("Register User data:", this.newUser);
    this.loginService.registerUser(this.newUser).subscribe(data => {
      console.log("User registered", data);
      this.router.navigate(['/login']);
    },
    error =>{
      alert("User Already exist");
    });
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
