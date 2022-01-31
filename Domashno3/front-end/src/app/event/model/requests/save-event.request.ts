import { Category, Contact, Location } from "../../IEvent";

export class SaveEventRequest {
  public createBy!: string;
  public isOnline!: boolean;
  public name!: string;
  public base64image!: string;
  public description!: string;
  public contact!: Contact;
  public category!: Category;
  public location!: Location;
}

