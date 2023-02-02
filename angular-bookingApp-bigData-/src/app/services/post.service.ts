import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Post } from '../model/Post';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(
    private http: HttpClient
  ) { }

  loadPosts(){
     return this.http.get<Post[]>('http://localhost:9090/posts');
 }

 savePost(post: Post){
  var headers = new HttpHeaders();
  headers = headers.append('Accept', 'application/json');
  headers = headers.append('Content-Type', 'application/json');
  return this.http.post<any>('http://localhost:9090/posts',JSON.stringify(post),{headers});
 }
}



