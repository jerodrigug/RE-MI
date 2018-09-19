import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';

import { AlertController } from 'ionic-angular'; //para utilizar el metodo cambExitoso

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  constructor(public navCtrl: NavController, public alerCtrl: AlertController) {

  }

  cambExi() {
    let alert = this.alerCtrl.create({
      title: 'Resultado',
      message: 'Tu contraseña ha sido cambiada exitosamente.',
      buttons: ['Ok']
    });
    alert.present()
  }

  closeSes() {
    const confirm = this.alerCtrl.create({
      title: 'Cierre de sesión',
      message: 'Estás a punto de cerrar sesión, ¿estás seguro?',
      buttons: [
        {
          text: 'Aceptar',
          handler: () => {
            //this.navCtrl.push(AQUI LA PAGINA HOME); //cierra sesión y se va a la pagina home (recuerda importar la pagina home)
            
            //console.log('Has cerrado sesión exitosamente');
          }
        },
        {
          text: 'Cancelar',
          handler: () => {
            
          }
        }
      ]
    });
    confirm.present();
  }

}
