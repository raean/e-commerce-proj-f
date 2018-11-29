import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
 
import { DashboardComponent } from './dashboard/dashboard.component';
import { PrimeComponent } from './prime/prime.component';
import { SisComponent } from './sis/sis.component'
// add other components
 
const routes: Routes = 
[
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'Dash.do', redirectTo: '/dashboard', pathMatch: 'full'}, 
  { path: 'dashboard', component: DashboardComponent }, 
  { path: 'prime', component: PrimeComponent },
  { path: 'sis', component: SisComponent }
];
 
@NgModule
({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ],
  declarations: []
})
export class AppRoutingModule {}

