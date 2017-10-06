import 'rxjs/add/operator/switchMap';

import {Component, OnInit} from '@angular/core';
import {Robot} from '../robot';
import {RobotService} from '../robot.service';
import {Location} from '@angular/common';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {subscribeOn} from 'rxjs/operator/subscribeOn';

@Component({
  templateUrl: './robot-detail.component.html',
  styleUrls: ['./robot-detail.component.css']
})

export class RobotDetailComponent implements OnInit {

  robot: Robot;

  constructor(private robotService: RobotService,
              private route: ActivatedRoute,
              private location: Location) {
  }

  ngOnInit(): void {
    this.route.paramMap
      .switchMap((params: ParamMap) => this.robotService.getRobot(+params.get('id')))
      .subscribe(robot => {
        this.robot = robot;
        console.log(robot.name);
      });
  }

  save(): void {
    this.robotService.update(this.robot)
      .then(() => this.goBack());
  }

  goBack(): void {
    this.location.back();
  }

}
