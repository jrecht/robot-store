import {Injectable} from '@angular/core';
import {Headers, Http} from '@angular/http';

import 'rxjs/add/operator/toPromise';
import {Robot} from './robot';

@Injectable()
export class RobotService {

  private headers = new Headers({'Content-Type': 'application/json'});
  private robotApiUrl = 'http://localhost:8080/robot';

  constructor(private http: Http) {
  }

  getRobot(id: number): Promise<Robot> {
    const url = `${this.robotApiUrl}/${id}`;
    return this.http
      .get(url)
      .toPromise()
      .then(response => response.json() as Robot)
      .catch(this.handleError);
  }

  create(name: string, price: number): Promise<Robot> {
    return this.http
      .post(this.robotApiUrl, JSON.stringify({name: name, price: price}), {headers: this.headers})
      .toPromise()
      .then(res => res.json() as Robot)
      .catch(this.handleError);
  }

  update(robot: Robot): Promise<Robot> {
    const url = `${this.robotApiUrl}/${robot.id}`;
    return this.http
      .put(url, JSON.stringify(robot), {headers: this.headers})
      .toPromise()
      .then(() => robot)
      .catch(this.handleError);
  }

  delete(id: number): Promise<void> {
    const url = `${this.robotApiUrl}/${id}`;
    return this.http.delete(url, {headers: this.headers})
      .toPromise()
      .then(() => null)
      .catch(this.handleError);
  }

  list(): Promise<Robot[]> {
    const url = `${this.robotApiUrl}/list`;
    return this.http.get(url, {headers: this.headers})
      .toPromise()
      .then(response => response.json() as Robot[])
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

}
