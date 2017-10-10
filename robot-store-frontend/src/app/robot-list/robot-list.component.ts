import {Component, OnInit} from '@angular/core';
import {RobotService} from '../robot.service';
import {Robot} from '../robot';
import {Router} from '@angular/router';

@Component({
  selector: 'app-robot-list',
  templateUrl: './robot-list.component.html',
  styleUrls: ['./robot-list.component.css']
})

export class RobotListComponent implements OnInit {

  robots: Robot[] = [];

  constructor(private robotService: RobotService,
              private router: Router) { }

  ngOnInit(): void {
    this.robotService.list()
      .then(robots => this.robots = robots);
  }

  sell(robot: Robot): void {
    this.robotService.delete(robot.id)
      .then(() => this.router.navigate(['/list']));
  }

}
