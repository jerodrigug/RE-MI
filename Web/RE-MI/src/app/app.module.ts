import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { IniciarSesionComponent } from './iniciar-sesion/iniciar-sesion.component';
import { VerReservasComponent } from './ver-reservas/ver-reservas.component';

const routes: Routes = [
  { path: 'login', component: IniciarSesionComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'ver', component: VerReservasComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    IniciarSesionComponent,
    VerReservasComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
