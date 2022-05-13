import {Component, OnDestroy, OnInit} from '@angular/core';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.scss']
})
export class ItemComponent implements OnInit, OnDestroy {

  constructor() { }

  ngOnInit(): void {
    console.log("onInit");
  }

  ngOnDestroy(): void {
    console.log("onDestroy");
  }

}
