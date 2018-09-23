import { Component} from '@angular/core';

export interface Form {
  question: string;
  answers: string[];
}

@Component({
  selector: 'app-preguntas',
  templateUrl: './preguntas.component.html',
  styleUrls: ['./preguntas.component.css']
})
export class PreguntasComponent {
  preguntas : Form[] = [
    {question : 'Tipo de salón', answers : ["aula","cubículo"]},
    {question : 'Instrumento(s) necesario(s)', answers : ["Clavinova","Piano","Batería","Saxofón","violin"]},
    {question : 'Horario', answers: ["Hoy en la mañana","Hoy en la tarde","Mañana en la mañana","Mañana en la tarde"]},
    {question : 'Cantidad de horas que va a usar la persona', answers : ["una hora","dos horas"]}
  ];
 
 

  
  
 }
  
 