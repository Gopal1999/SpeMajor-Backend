package com.example.spemajorbackend.controller;

import com.example.spemajorbackend.entity.StoragePoint;
import com.example.spemajorbackend.repository.StoragePointRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/storagepoint")
public class AdminController
{
    @Autowired
    StoragePointRepo storagePointRepo;

    @RequestMapping("/{id}/getall")
    public List<StoragePoint> getAllStoragePoints(@PathVariable Integer id)
    {
        return storagePointRepo.findByAdmin_Id(id);
    }


}
