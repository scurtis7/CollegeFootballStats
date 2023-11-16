import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor() {
  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const headers = new HttpHeaders().set('Authorization', `Bearer 4rZ3zUkbmD+glK4b8S0TluXf9oFOKsfb3yw8fH31xdk34yobmgX4qo4iJslGmjEZ`);
    const newRequest = request.clone({ headers });
    return next.handle(newRequest);
  }

}
