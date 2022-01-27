import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import {ApplyLeaveComponent } from './applyleave.component';
import {EmployeeService} from '../employee.service'
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';

import { FormsModule, ReactiveFormsModule } from '@angular/forms'; // needed
import { DebugElement } from '@angular/core';
import { By } from '@angular/platform-browser';
import { Router, ActivatedRoute } from '@angular/router';
import { Routerstub } from '../routerstub';
import { Component , NO_ERRORS_SCHEMA} from '@angular/core';
import { EmployeeServiceStub } from '../employee-service-stub';
import { RouterlinkstubDirective } from '../routerlinkstub.directive';
describe('ApplyleaveComponent', () => {
  let component: ApplyLeaveComponent;
  let fixture: ComponentFixture<ApplyLeaveComponent>;
  let linkDes: any;
  let routerLinks: any;
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApplyLeaveComponent ], 
      imports: [HttpClientModule,HttpClientTestingModule,FormsModule],
      providers : [{provide: EmployeeService, useClass: EmployeeServiceStub },
        {provide: Router, useClass: Routerstub},
      ],
        schemas: [ NO_ERRORS_SCHEMA ]
    })
    .compileComponents();
  }));

 beforeEach(() => {
   fixture = TestBed.createComponent(ApplyLeaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    linkDes = fixture.debugElement
    .queryAll(By.directive(RouterlinkstubDirective));
     routerLinks = linkDes.map(de => de.injector.get(RouterlinkstubDirective));
   });

   it('should be created', () => {
     expect(component).toBeTruthy();
   });

 it('should render title in a h1 tag', async(() => {
   const fixture = TestBed.createComponent(ApplyLeaveComponent);
   fixture.detectChanges();
   const compiled = fixture.debugElement.nativeElement;
 expect(compiled.querySelector('h1').textContent).toContain('Apply for Leave');
 }));

 it('should render title in a label tag', async(() => {
  const fixture = TestBed.createComponent(ApplyLeaveComponent);
  fixture.detectChanges();
  const compiled = fixture.debugElement.nativeElement;
expect(compiled.querySelector('label').textContent).toContain('Start Date :');
}));

it('should render title in a option tag', async(() => {
  const fixture = TestBed.createComponent(ApplyLeaveComponent);
  fixture.detectChanges();
  const compiled = fixture.debugElement.nativeElement;
expect(compiled.querySelector('option').textContent).toContain('EL');
}));

it('should render title in a button tag', async(() => {
  const fixture = TestBed.createComponent(ApplyLeaveComponent);
  fixture.detectChanges();
  const compiled = fixture.debugElement.nativeElement;
expect(compiled.querySelector('button').textContent).toContain('Apply');
}));



}
)