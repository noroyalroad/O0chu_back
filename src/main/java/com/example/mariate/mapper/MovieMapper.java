package com.example.mariate.mapper;

import com.example.mariate.domain.CommentDTO;
import com.example.mariate.domain.MoiveDTO;
import com.example.mariate.domain.RaingDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MovieMapper {

    public List<MoiveDTO> getlist ();

    public List<MoiveDTO> getlist2();

    public  List<MoiveDTO> title();
    public int updatecnt (String movieName);

    public List<MoiveDTO> getdetail (String movieName);

    public  int addcomment (CommentDTO comment);

    public List<CommentDTO> getcomment(long movie_id) ;

    public  int likes(int commentId);

    public  int inRating(RaingDTO Rating);

    public  List<RaingDTO> samere (String user_email, long movie_id);
    //업데이트

    public  int ratingup (RaingDTO rating);

    public  List<MoiveDTO> genres(String genres);
    public  List<MoiveDTO> gonpogenres(List<String> genres);

    public List<MoiveDTO>  guitar(String s);

    public List<MoiveDTO>  Newmovie();

    public List<MoiveDTO> moviesearch(String s);

    public List<MoiveDTO> suggestion();

    public List<MoiveDTO> moviedetail(Long movieId);


    public List<MoiveDTO> newsuggestion(String user_email);


    public  int userRating (String user_email, String  movie_id);

    public List<MoiveDTO> withmovie(Long moive_id) ;








}
