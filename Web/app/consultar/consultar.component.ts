import { Component, OnInit } from '@angular/core';
import { Salon } from '../salon';
import { SALON } from '../salones';

@Component({
  selector: 'app-consultar',
  templateUrl: './consultar.component.html',
  styleUrls: ['./consultar.component.css']
})
export class ConsultarComponent implements OnInit {
  salones = SALON;
  selectloSalon : Salon;
  constructor() { }

  ngOnInit() {
  }

}
