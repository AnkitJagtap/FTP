import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  empId : string;
  constructor(private rt : Router) {
    this.empId=localStorage.getItem("empId");
    
   }

   dashboard() {
     this.rt.navigate(['/dashboard'])
   }

  ngOnInit() {
  }

}
