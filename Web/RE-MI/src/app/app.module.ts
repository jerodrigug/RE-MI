
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { IniciarSesionComponent } from './iniciar-sesion/iniciar-sesion.component';
import { VerReservasComponent } from './ver-reservas/ver-reservas.component';
import { HacerReservasComponent } from './hacer-reservas/hacer-reservas.component';
import { RegistrarComponent } from './registrar/registrar.component';

//ruteo de la pagina

const routes: Routes = [
  { path: 'login', component: IniciarSesionComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'ver', component: VerReservasComponent },
  { path: 'hacer', component: HacerReservasComponent},
  { path: 'ver/hacer',redirectTo: '/hacer', pathMatch: 'full'},
  { path: 'registrar', component: RegistrarComponent},
  { path: 'ver/registrar', redirectTo: '/registrar', pathMatch: 'full' }
];

@NgModule({
  declarations: [
    AppComponent,
    IniciarSesionComponent,
    VerReservasComponent,
    HacerReservasComponent,
    RegistrarComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
