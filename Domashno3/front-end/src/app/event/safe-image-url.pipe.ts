import { Pipe, PipeTransform } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';

@Pipe({
  name: 'safeImageUrl'
})
export class SafeImageUrlPipe implements PipeTransform {

  constructor(private sanitizer: DomSanitizer){}

  transform(imageUrl: string) {
    return this.sanitizer.bypassSecurityTrustResourceUrl(imageUrl);
  }

}
