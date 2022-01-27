import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { EmployeeService } from './employee.service';
import { AppComponent } from './app.component';
import { EmployeeComponent } from './employee/employee.component';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { EmployeesearchComponent } from './employeesearch/employeesearch.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ManagerComponent } from './manager/manager.component';
import { ApplyLeaveComponent } from './applyleave/applyleave.component';
import { PendingStatusComponent } from './pending-status/pending-status.component';
import { LeaveHistoryComponent } from './leave-history/leave-history.component';
import { ApproveDenyComponent } from './approve-deny/approve-deny.component';
import {CdkTableModule} from '@angular/cdk/table';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {CdkTreeModule} from '@angular/cdk/tree';
import { LayoutModule } from '@angular/cdk/layout';
import {MatInputModule,MatAutocompleteModule,
  MatBadgeModule,
  MatBottomSheetModule,
  MatButtonModule,
  MatButtonToggleModule,
  MatCardModule,
  MatCheckboxModule,
  MatChipsModule,
  MatDatepickerModule,
  MatDialogModule,
  MatDividerModule,
  MatExpansionModule,
  MatGridListModule,
  MatIconModule,
  MatListModule,
  MatMenuModule,
  MatNativeDateModule,
  MatPaginatorModule,
  MatProgressBarModule,
  MatProgressSpinnerModule,
  MatRadioModule,
  MatRippleModule,
  MatSelectModule,
  MatSidenavModule,
  MatSliderModule,
  MatSlideToggleModule,
  MatSnackBarModule,
  MatSortModule,
  MatStepperModule,
  MatTableModule,
  MatTabsModule,
  MatToolbarModule,
  MatTooltipModule,
  MatTreeModule,
  MatPaginator} from '@angular/material';


const appRoutes: Routes = [
  {path : '',redirectTo : 'home',  pathMatch:'full'},
  {path : 'login',component :LoginComponent},
  {path : 'dashboard',component :DashboardComponent,
    children : [
      {path : 'employeesearch',component :EmployeesearchComponent},
      {path : 'managerdetails',component :ManagerComponent},
      {path : 'pendingStatus',component :PendingStatusComponent},
      {path : 'leaveHistory',component :LeaveHistoryComponent},
      {path : 'applyleave',component :ApplyLeaveComponent},
      {path : '',redirectTo : 'home',  pathMatch:'full'}
  ]},
  {path : 'home', component:EmployeeComponent },
  {path : 'updateStatus',component:ApproveDenyComponent}
]
@NgModule({
  declarations: [
    AppComponent,
    EmployeeComponent,
    LoginComponent,
    EmployeesearchComponent,
    DashboardComponent,
    ManagerComponent,
    ApplyLeaveComponent,
    PendingStatusComponent,
    LeaveHistoryComponent,
    ApproveDenyComponent
  ],
  imports: [
    BrowserModule,HttpModule,FormsModule,HttpClientModule,
    BrowserAnimationsModule,MatInputModule,MatTableModule,MatPaginatorModule,MatSortModule,
    MatTabsModule,
    MatTreeModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [EmployeeService],
  bootstrap: [AppComponent],
  exports: [
    MatAutocompleteModule,
    MatBadgeModule,
    MatBottomSheetModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatCardModule,
    MatCheckboxModule,
    MatChipsModule,
    MatStepperModule,
    MatDatepickerModule,
    MatDialogModule,
    MatDividerModule,
    MatExpansionModule,
    MatGridListModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatMenuModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatProgressBarModule,
    MatProgressSpinnerModule,
    MatRadioModule,
    MatRippleModule,
    MatSelectModule,
    MatSidenavModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatSortModule,
    MatTableModule,
    MatTabsModule,
    MatToolbarModule,
    MatTooltipModule,
    MatTreeModule
  ]
})
export class AppModule { }
