import { Component, OnInit } from '@angular/core';
import {RobotService} from '../robot.service';
import {Robot} from '../robot';

@Component({
  selector: 'app-robot-list',
  templateUrl: './robot-list.component.html',
  styleUrls: ['./robot-list.component.css']
})

export class RobotListComponent implements OnInit {

  robots: Robot[];

  constructor(private robotService: RobotService) { }

  ngOnInit() {
    this.robotService.list()
      .then(robots => this.robots = robots.slice(1, 5))
      .catch(err => console.log(err));
  }

}
