import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {RobotService} from './robot.service';
import {RobotListComponent} from './robot-list/robot-list.component';
import {AppRoutingModule} from './app-routing/app-routing.module';
import {RobotCreationComponent} from './robot-creation/robot-creation.component';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';
import {RobotStoreComponent} from './robot-store/robot-store.component';

@NgModule({
  declarations: [
    RobotListComponent,
    RobotCreationComponent,
    RobotStoreComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpModule,
    FormsModule
  ],
  providers: [RobotService],
  bootstrap: [RobotStoreComponent]
})
export class AppModule { }
