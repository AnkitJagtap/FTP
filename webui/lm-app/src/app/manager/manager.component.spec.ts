import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerComponent } from './manager.component';
import {EmployeeService} from '../employee.service'
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { Routerstub } from '../routerstub';
import { By } from '@angular/platform-browser';
import { RouterlinkstubDirective } from '../routerlinkstub.directive';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EmployeeServiceStub } from '../employee-service-stub';
import { ActivatedRoute, Router } from '@angular/router';




describe('ManagerComponent', () => {
  let component: ManagerComponent;
  let fixture: ComponentFixture<ManagerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerComponent ],
      imports: [HttpClientModule,HttpClientTestingModule],
      providers : [ {provide: EmployeeService, useClass: EmployeeServiceStub },
        {provide: Router, useClass: Routerstub},
   
         ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create Manager Details', () => {
    expect(component).toBeTruthy();
  });

  it('should render title in a h2 tag', async(() => {
    const fixture = TestBed.createComponent(ManagerComponent);
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('h2').textContent).toContain('WELCOME CEO');
  }));


});
