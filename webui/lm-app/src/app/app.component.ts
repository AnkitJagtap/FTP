import { Component } from '@angular/core';
import { EmployeeComponent } from './employee/employee.component';
import {EmployeeService} from './employee.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Leave Management Application';
}
