package city;

import java.util.ArrayList;
import java.util.List;

public class City {

    private String name;
    private long fullArea;
    private List<Building> buildings = new ArrayList<>();

    public City(String name, long fullArea) {
        this.name = name;
        this.fullArea = fullArea;
    }

    public String getName() {
        return name;
    }

    public long getFullArea() {
        return fullArea;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void addBuilding(Building building) {
        if (getAllBuildingsArea() + building.getArea() > fullArea) {
            throw new IllegalArgumentException("City can't be larger than " + fullArea);
        }
        buildings.add(building);
    }

    public Building findHighestBuilding() {
        Building highest = buildings.get(0);
        for (Building actual: buildings) {
            if (actual.getLevels() > highest.getLevels()) {
                highest = actual;
            }
        }
        return highest;
    }

    public List<Building> findBuildingsByStreet(String street) {
        List<Building> result = new ArrayList<>();
        for (Building actual: buildings) {
            if (street.equals(actual.getAddress().getStreet())) {
                result.add(actual);
            }
        }
        return result;
    }

    public boolean isThereBuildingWithMorePeopleThan(int numberOfPeople) {
        for (Building actual: buildings) {
            if (actual.calculateNumberOfPeopleCanFit() > numberOfPeople) {
                return true;
            }
        }
        return false;
    }

    private int getAllBuildingsArea() {
        int sum = 0;
        for (Building actual: buildings) {
            sum += actual.getArea();
        }
        return sum;
    }
}