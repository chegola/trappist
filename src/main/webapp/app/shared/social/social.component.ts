import { Component, Input, OnInit } from '@angular/core';
import { SocialService } from './social.service';
import { CSRFService } from '../auth/csrf.service';
import { JhiLanguageService } from 'ng-jhipster';

@Component({
    selector: 'jhi-social',
    templateUrl: './social.component.html'
})
export class JhiSocialComponent implements OnInit {
    @Input() provider: string;
    label: string;
    providerSetting: string;
    providerURL: string;
    csrf: string;
    providerIcon: string;

    constructor (
        private languageService: JhiLanguageService,
        private csrfService: CSRFService,
        private socialService: SocialService
    ) {}

    ngOnInit() {
        this.languageService.setLocations(['social', 'register', 'login', 'home']);
        this.label = this.provider.charAt(0).toUpperCase() + this.provider.slice(1);
        this.providerSetting = this.socialService.getProviderSetting(this.provider);
        this.providerURL = this.socialService.getProviderURL(this.provider);
        this.csrf = this.csrfService.getCSRF();
        if (this.provider === 'facebook') {
            this.providerIcon = 'fa fa-facebook fa-3x';
        } else if (this.provider === 'google') {
            this.providerIcon = 'fa fa-google fa-3x';
        } else if (this.provider === 'twitter') {
            this.providerIcon = 'fa fa-twitter fa-3x';

        }
    }
}
