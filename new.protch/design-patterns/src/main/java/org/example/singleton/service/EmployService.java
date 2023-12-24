package org.example.singleton.service;

public class EmployService {
    private DatabeseService  databeseService;

    public EmployService(DatabeseService databeseService) {
        this.databeseService = new DatabeseService();
    }

    public EmployService() {
        databeseService = new DatabeseService();
    }
}
