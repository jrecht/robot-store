import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {RobotListComponent} from '../robot-list/robot-list.component';
import {RobotCreationComponent} from '../robot-creation/robot-creation.component';

const routes: Routes = [
  { path: '', redirectTo: '/list', pathMatch: 'full' },
  { path: 'list', component: RobotListComponent},
  { path: 'create', component: RobotCreationComponent}
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
