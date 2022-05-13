import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'angular-to-do-app';
  temp: number = 1;
  name = "Stoyan";
  showItem = false;

  public test1(param1: any, param2: number): string{
    console.log(param1);
    return 'test';
  }

  public onClick() {
    console.log("Click")
    console.log(this.name);
    this.showItem = true;
  }

  public inputEvent(event: any){
    console.log(event.target.value);
    this.name = event.target.value;
  }

  public hide(){
    this.showItem = false;
  }
}
