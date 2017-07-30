import { Component } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import 'rxjs/add/operator/map';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  quote: any = null;
  theta1: any = null;
  theta2: any = null;

  title = 'app works!';
  constructor(private _http: Http) {
    this.getQuote();
    this.computeLinearRegressionTwoVariables();
  }

  private getQuote() {
    return this._http.get('http://localhost:8080/json')
      .map((res: Response) => res.json())
      .subscribe(data => {
        this.quote = data.content;
        console.log(this.quote);
      });
  }

  private computeLinearRegressionTwoVariables() {
    const input = {
      'trainingSet' : [
        ['1', '0.5'],
        ['2', '1'],
        ['4', '2'],
        ['0', '0']
      ],
      'startingTheta1' : '0',
      'startingTheta2' : '0',
      'alpha' : '0.001',
      'maximumNumberOfIteration' : '20000'
    };
    return this._http.post('http://localhost:8080/api/gradientdescent/twovariables', input)
      .map((res: Response) => res.json())
      .subscribe( data => {
        this.theta1 = data.theta1;
        this.theta2 = data.theta2;
        console.log(this.theta1);
        console.log(this.theta2);
      });
  }
}
