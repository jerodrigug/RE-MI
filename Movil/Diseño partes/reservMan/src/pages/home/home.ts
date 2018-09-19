import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { AlertController } from 'ionic-angular';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {
  pPiano;
  pDia;
  pTiempo;

  lista:Array<any> = [];
  
  constructor(public navCtrl: NavController, public alertCtrl: AlertController) {

  }

  buscAulas(){
    if((this.pPiano!=null)&&(this.pDia!=null)&&(this.pTiempo!=null)){
      this.lista = [ // IMPORTANTE: MODIFICAR ESTA LISTA PARA QUE SOLO TENGA LONGITUD PARA DOS ELEMENTOS!
        {
          paraDia: "",
          hInicial: "12",
          hFinal: "13",
          aula: "30-102"
        },
        {
          paraDia: "",
          hInicial: "15",
          hFinal: "16",
          aula: "30-201"
        }
      ]
    } else {
      const alert = this.alertCtrl.create({
        title: '¡No tan rápido!',
        subTitle: 'Primero debes llenar todos los campos.',
        buttons: ['OK']
      });
      alert.present();
    }
  }

  aulaSelected(item: string) {
    //console.log("Selected Item", item);
      
    //this.navCtrl.setRoot(MIS_RESERVAS.PAGE, {paraDia:item.paraDia});
  }
}
