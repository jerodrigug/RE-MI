import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
@Component({
  selector: 'app-iniciar-sesion',
  templateUrl: './iniciar-sesion.component.html',
  styleUrls: ['./iniciar-sesion.component.css']
})
export class IniciarSesionComponent implements OnInit {

  constructor(private router:Router) { }

  
  ngOnInit() {
  }

  

  redireccion(contra,email){
    if(contra != null && contra != "" && email!= null && email != ""){
      this.router.navigate(["ver"]); 
    }
    
  }
}
