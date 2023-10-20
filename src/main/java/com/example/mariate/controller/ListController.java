package com.example.mariate.controller;

import com.example.mariate.domain.MoiveDTO;
import com.example.mariate.service.Movieservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ListController {
    @Autowired
    Movieservice movieservice;

    @GetMapping("/newList")
    public List<MoiveDTO> Newmovielist() {

        List<MoiveDTO> list = movieservice.newmovie();

        return list;
    }

    //영화검색 api


    @GetMapping("/movie/search/{search}")
    public List<MoiveDTO> search(@PathVariable String search) {


        List<MoiveDTO> list = movieservice.search(search);
        return list;


    }

    @GetMapping("/movie/suggestion")
    public List<MoiveDTO> suggestion(){
        List<MoiveDTO> list = movieservice.suggestion();

        return list;
    }

    @GetMapping("/movie/getdetail/{movieId}")
    public List<MoiveDTO> detail(@PathVariable Long movieId){
        List<MoiveDTO> list = movieservice.moviedetail(movieId);

        return  list;

    }
    @GetMapping("/movie/newsuggestion")
    public List<MoiveDTO> newsuggestion(@RequestHeader("useremail") String user_email){
        List<MoiveDTO> list = movieservice.newsuggestion(user_email);

        return list;
    }
    @GetMapping("/movie/withmovie/{movie_id}")
    public List<MoiveDTO> withmovie(@PathVariable Long movie_id){
        List<MoiveDTO> list = movieservice.withmovie(movie_id);
        return list ;
    }







}
