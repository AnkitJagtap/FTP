import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PendingStatusComponent } from './pending-status.component';
import {EmployeeService} from '../employee.service'
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { RouterlinkstubDirective } from '../routerlinkstub.directive';

import { Routerstub } from '../routerstub';
import { By } from '@angular/platform-browser';
import { EmployeeServiceStub } from '../employee-service-stub';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

describe('PendingStatusComponent', () => {
  let component: PendingStatusComponent;
  let fixture: ComponentFixture<PendingStatusComponent>;
  let linkDes: any;
  let routerLinks: any;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PendingStatusComponent ], 
      imports: [HttpClientModule,HttpClientTestingModule,RouterTestingModule],
      providers : [ 
        {provide: EmployeeService, useClass: EmployeeServiceStub },
        {provide: Router, useClass: Routerstub},
      ]
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


    fixture = TestBed.createComponent(PendingStatusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    linkDes = fixture.debugElement
    .queryAll(By.directive(RouterlinkstubDirective));
     routerLinks = linkDes.map(de => de.injector.get(RouterlinkstubDirective));
  });

  xit('should be created', () => {
    expect(component).toBeTruthy();
  });


});
