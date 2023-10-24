package com.example.mariate.controller;

import com.example.mariate.domain.CommentDTO;
import com.example.mariate.domain.MoiveDTO;
import com.example.mariate.domain.PagingDTO;
import com.example.mariate.service.Movieservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<MoiveDTO> suggestion() {
        List<MoiveDTO> list = movieservice.suggestion();

        return list;
    }

    @GetMapping("/movie/getdetail/{movieId}")
    public List<MoiveDTO> detail(@PathVariable Long movieId) {
        List<MoiveDTO> list = movieservice.moviedetail(movieId);

        return list;

    }

    @GetMapping("/movie/newsuggestion")
    public List<MoiveDTO> newsuggestion(@RequestHeader("useremail") String user_email) {
        List<MoiveDTO> list = movieservice.newsuggestion(user_email);

        return list;
    }

    @GetMapping("/movie/withmovie/{movie_id}")
    public List<MoiveDTO> withmovie(@PathVariable Long movie_id) {
        List<MoiveDTO> list = movieservice.withmovie(movie_id);
        return list;
    }


    @PostMapping("/comment/paging")
    public List<CommentDTO> paging(@RequestBody PagingDTO page) {

        //end는 pageno * 5
        // start end -4

        int end = page.getPageNo() * 5;

        int start = end - 4;

        List<CommentDTO> list = movieservice.paging(start, end, page.getMovie_id());

        return list;


    }

    @GetMapping("/comment/{movie_id}")
    public Map<String, Object> paging2(@RequestParam("pageNo") String pageNo, @PathVariable String movie_id) {

        //end는 pageno * 5
        // start end -4

        int end = Integer.parseInt(pageNo) * 5;

        int start = end - 4;

        List<CommentDTO> list = movieservice.paging(start, end, movie_id);

        int total = movieservice.Totalcount(movie_id);

        Map<String, Object> res = new HashMap<>();

        res.put("comment", list);
        res.put("totalcout", total);


        return res;


    }

    @GetMapping("/movie/genres/{genres}")
    Map<String, Object> gerenspage(@PathVariable String genres, @RequestParam("pageNo") String pageNo){


        int end = Integer.parseInt(pageNo) * 20 ;
        int start = end - 19 ;

        System.out.println(genres);


        Map<String, Object> res = new HashMap<>();


        if (("공포 스릴러").equals(genres) || ("멜로 드라마").equals(genres)) {
            String[] genreArray = genres.split(" ");
            List<String> genreList = Arrays.asList(genreArray);
            List<MoiveDTO> list1 = movieservice.twogenrespaging(start,end,genreList);
            int count = movieservice.twogenrespagingcount(genreList) ;

            res.put("count", count);
            res.put("item", list1) ;

            return  res ;

        }

        else {
            List<MoiveDTO> list = movieservice.genrespaging(start,end,genres);
            int count = movieservice.genrespagingcount(genres) ;

            res.put("count", count);
            res.put("item", list) ;

            return  res ;


        }






    }


}
