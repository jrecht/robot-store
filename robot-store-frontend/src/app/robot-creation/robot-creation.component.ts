import 'rxjs/add/operator/switchMap';

import {Component, OnInit} from '@angular/core';
import {RobotService} from '../robot.service';
import {Robot} from '../robot';
import {Router} from '@angular/router';

@Component({
  selector: 'app-robot-creation',
  templateUrl: './robot-creation.component.html',
  styleUrls: ['./robot-creation.component.css']
})
export class RobotCreationComponent implements OnInit {

  robot: Robot;

  constructor(
    private robotService: RobotService,
    private router: Router
  ) { }

  ngOnInit(): void {}

  add(name: string, price: number): void {
    name = name.trim();
    if (!name) { return; }
    this.robotService.create(name, price)
      .then(() =>
        this.router.navigate(['/list'])
      );
  }

}
