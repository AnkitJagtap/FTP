import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { DashboardComponent } from './dashboard.component';
import { EmployeeService } from '../employee.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';


import { FormsModule, ReactiveFormsModule } from '@angular/forms'; // needed
import { DebugElement } from '@angular/core';
import { By } from '@angular/platform-browser';
import { Router, ActivatedRoute } from '@angular/router';
import { Routerstub } from '../routerstub';
import { Component , NO_ERRORS_SCHEMA} from '@angular/core';
import { EmployeeServiceStub } from '../employee-service-stub';

describe('DashboardComponent', () => {
  let component: DashboardComponent;
  let fixture: ComponentFixture<DashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DashboardComponent ], 
      imports: [HttpClientModule,HttpClientTestingModule],
      providers :[{provide: EmployeeService, useClass: EmployeeServiceStub },
        {provide: Router, useClass: Routerstub}
      ],
        schemas: [ NO_ERRORS_SCHEMA ]
    })
  
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });

  it('should render title in a h2 tag', async(() => {
    const fixture = TestBed.createComponent(DashboardComponent);
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('h2').textContent).toContain('Leave Management System!');
  }));

  it('should render title in a tag', async(() => {
    const fixture = TestBed.createComponent(DashboardComponent);
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('a').textContent).toContain(' My Details');
  }));

  
});
