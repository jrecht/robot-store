import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RobotStoreComponent } from './robot-store.component';

describe('RobotStoreComponent', () => {
  let component: RobotStoreComponent;
  let fixture: ComponentFixture<RobotStoreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RobotStoreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RobotStoreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
