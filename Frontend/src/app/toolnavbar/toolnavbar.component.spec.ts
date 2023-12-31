import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ToolnavbarComponent } from './toolnavbar.component';

describe('ToolnavbarComponent', () => {
  let component: ToolnavbarComponent;
  let fixture: ComponentFixture<ToolnavbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ToolnavbarComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ToolnavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
