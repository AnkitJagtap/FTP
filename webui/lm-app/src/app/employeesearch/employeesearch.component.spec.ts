import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeesearchComponent } from './employeesearch.component';
import {EmployeeService} from '../employee.service'
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { HttpClientModule, HttpClient } from '@angular/common/http';


import { FormsModule, ReactiveFormsModule } from '@angular/forms'; // needed
import { DebugElement } from '@angular/core';
import { By } from '@angular/platform-browser';

import { Routerstub } from '../routerstub';
import { Component , NO_ERRORS_SCHEMA} from '@angular/core';
import { EmployeeServiceStub } from '../employee-service-stub';

describe('EmployeesearchComponent', () => {
  let component: EmployeesearchComponent;
  let fixture: ComponentFixture<EmployeesearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({ 
      imports: [HttpClientModule, HttpClientTestingModule],
      declarations: [ EmployeesearchComponent ], 
      providers : [{provide: EmployeeService, useClass: EmployeeServiceStub },
      
      ],
        schemas: [ NO_ERRORS_SCHEMA ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeesearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });

  it('should render title in p tag', async(() => {
    const fixture = TestBed.createComponent(EmployeesearchComponent);
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('p').textContent).toContain(' Employee Id :');
  }));

  it('should render title in legend tag', async(() => {
    const fixture = TestBed.createComponent(EmployeesearchComponent);
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('legend').textContent).toContain('Personal Details');
  }));

});
