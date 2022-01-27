import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { Routerstub } from '../routerstub';
import { ApproveDenyComponent } from './approve-deny.component';
import { HttpClientModule } from '@angular/common/http';
import {RouterTestingModule} from '@angular/router/testing';
import { RouterlinkstubDirective } from '../routerlinkstub.directive';
import { EmployeeServiceStub} from '../employee-service-stub';
import { EmployeeService } from '../employee.service';
import { By } from '@angular/platform-browser';
import {Router} from '@angular/router';
import {FormsModule} from '@angular/forms';
import { Component , NO_ERRORS_SCHEMA} from '@angular/core';
describe('ApproveDenyComponent', () => {
  let component: ApproveDenyComponent;
  let fixture: ComponentFixture<ApproveDenyComponent>;
  let linkDes: any;
  let routerLinks: any;

  beforeEach(async(() => {
    TestBed.configureTestingModule({ 
      imports : [FormsModule,RouterTestingModule,HttpClientModule],
      declarations: [ ApproveDenyComponent, RouterlinkstubDirective ],
      providers: [EmployeeService ,
        {provide: Router, useClass: Routerstub}
        ],schemas: [ NO_ERRORS_SCHEMA ]

    })
    .compileComponents();
  }));

  beforeEach(() => { 
    let store = {};
    const mockLocalStorage = {
      getItem : (key : string) : string => {
        return key in store ? store[key] : 1000;
      }, 
      setItem: (key:string, value:string) => {
        store[key]=`${value}`;
      }
    };
    spyOn(localStorage,'getItem').and.callFake(mockLocalStorage.getItem); 
    spyOn(localStorage,'setItem').and.callFake(mockLocalStorage.setItem);
    fixture = TestBed.createComponent(ApproveDenyComponent);
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
    const fixture = TestBed.createComponent(ApproveDenyComponent);
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
  expect(compiled.querySelector('h1').textContent).toContain('APPROVE OR DENY LEAVE');
  }));

  it('should render title in a p tag', async(() => {
    const fixture = TestBed.createComponent(ApproveDenyComponent);
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
  expect(compiled.querySelector('p').textContent).toContain('Emp_ID :');
  }));

  it('should render title in a label tag', async(() => {
    const fixture = TestBed.createComponent(ApproveDenyComponent);
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
  expect(compiled.querySelector('label').textContent).toContain('Manager Comments :');
  }));

})
