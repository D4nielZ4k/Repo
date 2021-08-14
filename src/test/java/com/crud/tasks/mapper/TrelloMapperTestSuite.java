package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TrelloMapperTestSuite {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    void mapToBoardsTest() {
        //Given
        List<TrelloListDto> listDtoList = new ArrayList<>();
        listDtoList.add(new TrelloListDto("test", "test", false));
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(new TrelloBoardDto("test", "test", listDtoList));
        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardDtos);
        //Then
        Assertions.assertEquals("test", trelloBoardDtos.get(0).getName());
        Assertions.assertEquals("test", trelloBoardDtos.get(0).getId());
        Assertions.assertEquals(1, trelloBoardDtos.size());
    }

    @Test
    void mapToBoardsDtoTest() {
        //Given
        List<TrelloList> listDtoList = new ArrayList<>();
        listDtoList.add(new TrelloList("test", "test", false));
        List<TrelloBoard> trelloBoard = new ArrayList<>();
        trelloBoard.add(new TrelloBoard("test", "test", listDtoList));
        //When
        List<TrelloBoardDto> trelloBoardDtos = trelloMapper.mapToBoardsDto(trelloBoard);
        //Then
        Assertions.assertEquals("test", trelloBoardDtos.get(0).getName());
        Assertions.assertEquals("test", trelloBoardDtos.get(0).getId());
        Assertions.assertEquals(1, trelloBoardDtos.size());

    }


    @Test
    void mapToListTest() {
        //Given
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(new TrelloListDto("test 1", "test 1", false));
        trelloListDtos.add(new TrelloListDto("test 2", "test 2", false));
        //When
        List<TrelloList> trelloLists = trelloMapper.mapToList(trelloListDtos);
        //Then
        Assertions.assertEquals("test 1", trelloLists.get(0).getName());
        Assertions.assertEquals("test 2", trelloLists.get(1).getId());
        Assertions.assertEquals(2, trelloLists.size());

    }

    @Test
    void mapToListDtoTest() {
        //Given
        List<TrelloList> trelloList = new ArrayList<>();
        trelloList.add(new TrelloList("test 1", "test 1", false));
        trelloList.add(new TrelloList("test 2", "test 2", false));
        //When
        List<TrelloListDto> trelloListDtos = trelloMapper.mapToListDto(trelloList);
        //Then
        Assertions.assertEquals("test 1", trelloListDtos.get(0).getName());
        Assertions.assertEquals("test 2", trelloListDtos.get(1).getId());
        Assertions.assertEquals(2, trelloListDtos.size());

    }

    @Test
    void mapToCardDtoTest() {
        //Given
        TrelloCard card = new TrelloCard("test", "test", "test", "test");
        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(card);
        //Then
        Assertions.assertEquals("test", trelloCardDto.getName());
        Assertions.assertEquals("test", trelloCardDto.getDescription());
        Assertions.assertEquals("test", trelloCardDto.getPos());
        Assertions.assertEquals("test", trelloCardDto.getListId());
    }

    @Test
    void mapToCardTest() {
        //Given
        TrelloCardDto cardDto = new TrelloCardDto("test", "test", "test", "test");
        //When
        TrelloCard card = trelloMapper.mapToCard(cardDto);
        //Then
        Assertions.assertEquals("test", card.getName());
        Assertions.assertEquals("test", card.getDescription());
        Assertions.assertEquals("test", card.getPos());
        Assertions.assertEquals("test", card.getListId());
    }
}
