package com.crud.tasks.controller;

import com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.client.TrelloClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/trello")
@RequiredArgsConstructor
public class TrelloController {

    private final TrelloClient trelloClient;

    @GetMapping("getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {

        return trelloClient.getTrelloBoards();

  //    List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

  //    trelloBoards.forEach(trelloBoardDto -> {
  //        System.out.println(trelloBoardDto.getId() + " - " + trelloBoardDto.getName());
  //        System.out.println("This board contains lists: ");
  //        trelloBoardDto.getList().forEach(trelloList -> {
  //            System.out.println(trelloList.getName() + " - " + trelloList.getId() + " - " + trelloList.isClosed());
  //        });
  //    });


 //      List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards().stream()
 //              .filter(t -> t.getId().contains("kodilla"))
 //              .filter(t -> t.getName().contains("kodilla"))
 //              .collect(Collectors.toList());
//
 //      trelloBoards.forEach(trelloBoardDto -> {
 //          System.out.println(trelloBoardDto.getId() + " elooo" + trelloBoardDto.getName());
 //      });
    }

    @PostMapping("createTrelloCard")
    public CreatedTrelloCard createTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloClient.createNewCard(trelloCardDto);
    }


}
