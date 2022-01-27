import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeComponent } from './employee.component';
import { EmployeeServiceStub } from '../employee-service-stub';
import {EmployeeService } from '../employee.service';

import { Router, ActivatedRoute } from '@angular/router';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { Routerstub } from '../routerstub';
import { Component , NO_ERRORS_SCHEMA} from '@angular/core';

describe('EmployeeComponent', () => {
  let component: EmployeeComponent;
  let fixture: ComponentFixture<EmployeeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({ 
      imports: [HttpClientModule,HttpClientTestingModule,RouterTestingModule],
      declarations: [ EmployeeComponent ],
      providers : [{provide: EmployeeService, useClass: EmployeeServiceStub },
        {provide: Router, useClass: Routerstub}
      ],
        schemas: [ NO_ERRORS_SCHEMA ]
        
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });

  it('should render title in a h1 tag', async(() => {
    const fixture = TestBed.createComponent(EmployeeComponent);
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('h1').textContent).toContain('Welcome to Leave Management System');
  }));

  it('should render title in a th tag', async(() => {
    const fixture = TestBed.createComponent(EmployeeComponent);
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('th').textContent).toContain('Id');
  }));

 



});
