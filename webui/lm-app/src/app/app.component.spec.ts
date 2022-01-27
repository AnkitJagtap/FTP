import { TestBed, async } from '@angular/core/testing';
import { Component , NO_ERRORS_SCHEMA} from '@angular/core';
import { Http } from '@angular/http';
import { MockBackend } from '@angular/http/testing';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';

import { Employee } from './employee';
import { EmployeeService } from './employee.service';
import { EmployeeServiceStub } from './employee-service-stub';

/*class MockEmployeeService {
  getEmployees(): Promise<Employee[]> {
    console.log('Mock getEmployees called');
    return Promise.resolve([new Employee(1000), new Employee(2000)]);
  }
} */

describe('AppComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent
      ],
      imports: [HttpClientModule],
      providers: [
        {provide: EmployeeService, useClass: EmployeeServiceStub }
        ],    
      schemas: [ NO_ERRORS_SCHEMA ]
    }).compileComponents();
  }));


  it('should create the app', async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  }));

  it(`should have as title 'Leave Management Application'`, async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.title).toEqual('Leave Management Application');
  }));
  
 
});
