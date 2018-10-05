import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-hacer-reservas',
  templateUrl: './hacer-reservas.component.html',
  styleUrls: ['./hacer-reservas.component.css']
})
export class HacerReservasComponent implements OnInit {

  constructor() { }

  aulas=["seleccionar","Aula con piano de cola","Aula con Clavinova","Aula con Percusión","Aula con Piano vertical","Aula con 2 Clanivovas",
  "Cubiculo con Clavinova","Cubiculo con piano vertical","Cubiculo con bateria"];

  salones=["30-302","31-202"];
  
  a = this.salones.length;

  ngOnInit() {
  }

}
