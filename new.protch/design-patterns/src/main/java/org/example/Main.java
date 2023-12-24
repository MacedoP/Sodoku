package org.example;

import org.example.singleton.service.CardService;
import org.example.singleton.service.DatabeseService;
import org.example.singleton.service.EmployService;
import org.example.singleton.service.PartService;

public class Main {
    public static void main(String[] args) {
        DatabeseService databeseService = new DatabeseService();
        
        CardService cardService = new CardService(databeseService);
        EmployService employService = new EmployService(databeseService);
        PartService partService = new PartService(databeseService);
    }
}