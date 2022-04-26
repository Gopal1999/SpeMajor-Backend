package com.example.spemajorbackend.entity;

import java.util.ArrayList;
import java.util.List;

public class StoragePointWithRegion
{
    List<StoragePoint> list = new ArrayList<>();
    Region region = new Region();

    public List<StoragePoint> getList() {
        return list;
    }

    public void setList(List<StoragePoint> list) {
        this.list = list;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
