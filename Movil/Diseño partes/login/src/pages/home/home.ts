import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { Pag1Page } from '../pag1/pag1';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  constructor(public navCtrl: NavController) {

  }
  
  goPagina2() {
    this.navCtrl.push(Pag1Page)
  }
  
}
