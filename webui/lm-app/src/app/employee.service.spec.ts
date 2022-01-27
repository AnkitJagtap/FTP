import { TestBed, inject } from '@angular/core/testing';
import { HttpClient } from '@angular/common/http';
import { HttpClientStub } from './http-client-stub';
import { EmployeeService } from './employee.service';
import { EmployeeServiceStub} from './employee-service-stub';

describe('EmployeeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        {provide: EmployeeService, useClass: EmployeeServiceStub } ,
        {provide: HttpClient, useClass: HttpClientStub } 
         
      ]

    });
  });

  it('should be created', inject([EmployeeService], (service: EmployeeService) => {
    expect(service).toBeTruthy();
  }));
});
