package org.example.singleton.service;

public class PartService {
    private DatabeseService databeseService;

    public PartService(DatabeseService databeseService) {
        this.databeseService = new DatabeseService();
    }

    public PartService() {
        databeseService = new DatabeseService();
    }
}
