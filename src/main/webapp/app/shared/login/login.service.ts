import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';

import { JhiLanguageService } from 'ng-jhipster';

import { Principal } from '../auth/principal.service';
import { AuthServerProvider } from '../auth/auth-session.service';

import { LoginInfo } from './trappist-login.model';

@Injectable()
export class LoginService {

    constructor (
        private languageService: JhiLanguageService,
        private principal: Principal,
        private authServerProvider: AuthServerProvider,
        private http: Http
    ) {}

    login (credentials, callback?) {
        let cb = callback || function() {};

        return new Promise((resolve, reject) => {
            this.authServerProvider.login(credentials).subscribe(data => {
                this.principal.identity(true).then(account => {
                    // After the login the language will be changed to
                    // the language selected by the user during his registration
                    if (account !== null) {
                        this.languageService.changeLanguage(account.langKey);
                    }
                    resolve(data);
                });
                return cb();
            }, err => {
                this.logout();
                reject(err);
                return cb(err);
            });
        });
    }

    logout () {
        this.authServerProvider.logout().subscribe();
        this.principal.authenticate(null);
    }

    getLogoUrl(): Observable<LoginInfo> {
        // console.debug('login.service.getLogoUrl()');
        return this.http.get('api/login-screen').map((res: Response) => {
            // console.debug('got response: ' + res);
            let data = res.json();
            let loginInfo = new LoginInfo();
            loginInfo.logoUrl = data.logoUrl;
            return loginInfo;
          });
    }
}
