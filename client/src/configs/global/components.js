import BaseButton from '@/components/button/BaseButton.vue';
import BaseInput from '@/components/input/BaseInput.vue';
import BaseCarousel from '@/components/carousel/BaseCarousel.vue';
import CarouselGallery from '@/components/carousel/CarouselGallery.vue';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';

export const globalComponents = (app) => {
    app.component('b-button', BaseButton);
    app.component('b-input', BaseInput);
    app.component('b-carousel', BaseCarousel);
    app.component('carousel-gallery', CarouselGallery);
    app.component('font-awesome-icon', FontAwesomeIcon);
}