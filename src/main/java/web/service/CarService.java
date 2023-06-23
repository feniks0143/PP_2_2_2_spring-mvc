package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarService {
    private List<Car> list;

    {
        list = new LinkedList<>();
        list.add(new Car("Audi", "1UZ-FE", 6));
        list.add(new Car("BMW", "4A-GE", 5));
        list.add(new Car("Ford", "Type F", 2));
        list.add(new Car("Honda", "1GZ-FE", 7));
        list.add(new Car("Kia", "1JZ-GTE � 2JZ-GTE", 11));
    }

    public List<Car> getCar() {
        return list;
    }

    public List<Car> getCarByNumber(int count) {
        if (count <= 0 || count >= list.size()) {
            return list;
        }

        return list.stream()
                .limit(count)
                .collect(Collectors.toList());
    }
}