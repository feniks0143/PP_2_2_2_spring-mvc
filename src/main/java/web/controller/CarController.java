package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import web.model.Car;
import web.service.CarService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    @ResponseBody
    public List<Car> printCar(@RequestParam(value = "count", defaultValue = "0") int count) {
        if (count == 0) {
            return carService.getCar();
        } else {
            return carService.getCarByNumber(count);
        }
    }
}

