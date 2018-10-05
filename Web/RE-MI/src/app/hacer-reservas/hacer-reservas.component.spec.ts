import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HacerReservasComponent } from './hacer-reservas.component';

describe('HacerReservasComponent', () => {
  let component: HacerReservasComponent;
  let fixture: ComponentFixture<HacerReservasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HacerReservasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HacerReservasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
