package org.example.singleton.service;

public class CardService {
    private DatabeseService databeseService;

    public CardService(){
        databeseService = new DatabeseService();
    }
    public CardService(DatabeseService databeseService){
        databeseService = new DatabeseService();
    }

}
