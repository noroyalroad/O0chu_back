package com.example.mariate.service;

import com.example.mariate.domain.CommentDTO;
import com.example.mariate.domain.MoiveDTO;
import com.example.mariate.domain.RaingDTO;

import java.util.List;

public interface Movieservice {

   public List<MoiveDTO> getmovie();

   public List<MoiveDTO> getmovie2();

   public  List<MoiveDTO> title();
   public int update(String movieName);

   public List<MoiveDTO> detail(String movieName);

   public int addcomment (CommentDTO comment);

   public  List<CommentDTO> getcomment (long movie_id) ;

   public  int likes (int commentId);

   public  int inRaing(RaingDTO Rating);

   public  int samere(String user_email, long movie_id);

   public  int ratingup (RaingDTO rating);

   public  List<MoiveDTO> genres(String genres);

   public  List<MoiveDTO> genres2(List<String> geners);

   public List<MoiveDTO>  newmovie();

   public List<MoiveDTO> guitar(String s);

   public List<MoiveDTO> search(String s);

   public List<MoiveDTO> suggestion();

   public List<MoiveDTO> moviedetail(Long movieId);

   public List<MoiveDTO> newsuggestion(String user_email);


}
