import { Component } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-student-sign-up-form',
  templateUrl: './student-sign-up-form.component.html',
  styleUrls: ['./student-sign-up-form.component.css']
})
export class StudentSignUpFormComponent {
  welcomeMessage = "ED-Tech";

  signUpForm : FormGroup;
  
  constructor(private titleService: Title, private http: HttpClient, private fb: FormBuilder) {

    this.signUpForm = fb.group({
      name: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required)
    });
    // setTimeout(()=>{
    //   this.welcomeMessage="Please Signup here to continue";
    // }, 2000);
  }

  ngOnInit() {
    this.titleService.setTitle("Student SignUp");
  }

  // formData: any = {};

  // onSubmit() {
  //   const url = "http://localhost:8080/student/signup";
  //   console.log(this.formData);
  //   this.http.post(url, this.formData).pipe(
  //     catchError((error: HttpErrorResponse) => {
  //       console.log("Error sending form data:", error);
  //       return throwError(error);
  //     })
  //   ).subscribe((response:any) => {
  //     console.log('Form data sent successfully:', response);
  //   });
  // }

  onSubmit(){
    console.log(this.signUpForm.value);
  }

  get email(){
    return this.signUpForm.get("email");
  }

  get name(){{
    return this.signUpForm.get("name");
  }}


  get password(){{
    return this.signUpForm.get("password");
  }}


}
