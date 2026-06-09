import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClothingCategoriesComponent } from './clothing-categories.component';

describe('ClothingCategoriesComponent', () => {
  let component: ClothingCategoriesComponent;
  let fixture: ComponentFixture<ClothingCategoriesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ClothingCategoriesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ClothingCategoriesComponent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
