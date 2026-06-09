import { Component, ChangeDetectionStrategy } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeroBannerComponent } from '../../components/hero-banner/hero-banner.component';
import { ClothingCategoriesComponent } from '../../components/clothing-categories/clothing-categories.component';

@Component({
  selector: 'app-home',
  imports: [ CommonModule, HeroBannerComponent, ClothingCategoriesComponent ],
  standalone: true,
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class HomeComponent {

}
