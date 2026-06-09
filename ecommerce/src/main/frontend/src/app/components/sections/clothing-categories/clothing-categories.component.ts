import { Component, ChangeDetectionStrategy  } from '@angular/core';
import { CategoryCardComponent } from '../../cards/category-card/category-card.component';
import { Category } from '../../../models/category.model';

@Component({
  selector: 'app-clothing-categories',
  standalone: true,
  imports: [ CategoryCardComponent ],
  templateUrl: './clothing-categories.component.html',
  styleUrl: './clothing-categories.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class ClothingCategoriesComponent {

  categories: Category[] = [
    {
      name: 'Blusas',
      image: 'assets/img/categories/blouse-category.webp',
    },
    {
      name: 'Vestidos',
      image: 'assets/img/categories/dress-category.webp',
    },
    {
      name: 'Calças',
      image: 'assets/img/categories/pants-category.webp',
    },
    {
      name: 'Camisas',
      image: 'assets/img/categories/shirt-category.webp',
    },
    {
       name: 'Shorts',
       image: 'assets/img/categories/short-category.webp',
    },
    {
       name: 'Saias',
       image: 'assets/img/categories/skirt-category.webp',
    }
  ];
}
