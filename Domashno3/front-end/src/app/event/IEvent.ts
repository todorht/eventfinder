export interface IEvent {
  id:number;
  name:string;
  isOnline:boolean;
  base64image: string;
  category?: Category;
  createdByUser: string;
  contact?:Contact;
  location?: Location;
  description:string;
  startAt?:Date;
  endAt?:Date;
}

export class Contact{
  contactName!:String;
  phoneNumber!:string;
  email!:string;
}

export enum Category{
  CONCERT,
  WORKSHOP,
  THEATER,
  CONFERENCE
}

export class IComment{
  commentId!:number;
  userId!:number;
  time!:Date;
  text!:string;
}

export interface Point{
  latitude: string;
  longitude: string;
}

export class Address{
  city!: string;
  country!: string;
  road!: string;
}

export class Location{
  address!: Address;
  lat!: string;
  lon!: string;
}

export class User{
  public username!: string;
  public password!: string;
}
