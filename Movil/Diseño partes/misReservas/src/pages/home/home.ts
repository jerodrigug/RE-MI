import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { AlertController } from 'ionic-angular';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {
  elDia;//de reserva manual: Día de la reserva
  rsvHoraI;//de reserva manual: Hora inicial de la reserva
  rsvHoraF;//de reserva manual: Hora final de la reserva
  enAula;//de reserva manual: Aula de la reserva
  
  myReservas:Array<any> = [];

  constructor(public navCtrl: NavController, public navParams: NavParams, public alertCtrl: AlertController) {
    /*if(false){
      
      this.elDia = navParams.get('paraDia');
      this.rsvHoraI = navParams.get('hInicial');
      this.rsvHoraF = navParams.get('hFinal');
      this.enAula = navParams.get('aula');

     this.myReservas.push(this.elDia,this.rsvHoraI,this.rsvHoraF,this.enAula);
     
    }*/
    this.myReservas = [
      {
        paraDia: "Hoy en la mañana",
        hInicial: "12",
        hFinal: "13",
        aula: "30-102"
      },
      {
        paraDia: "Mañana en la tarde",
        hInicial: "15",
        hFinal: "17",
        aula: "30-205"
      }
    ]
  }

  metDesrv(item) {
    const alert = this.alertCtrl.create({
      title: '¿Cancelar reserva?',
      subTitle: 'Estás a punto de cancelar tu reserva.',
      buttons: [
        {
          text: 'Aceptar',
          handler: () => {
            for(let puntero in this.myReservas){ //visitando cada uno de las reservas contenidas en myReservas
              if(this.myReservas[puntero] == item){
                this.myReservas.splice(this.myReservas.indexOf(this.myReservas[puntero]),1);  //se eliminará la reserva en la posicion i
              }
            }
          }
        },
        {
          text: 'Cancelar',
          handler: () => {
            //No pasa nada
          }
        }
      ]
    });
    alert.present();
  }

}
