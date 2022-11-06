package com.cloud.security.userservice.feignclients;

import com.cloud.security.userservice.model.Car;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "car-service", url = "http://localhost:8002/v1/car")
public interface CarfeingClient {

  @PostMapping()
  public Car save(@RequestBody Car car);

  @GetMapping("/byUserId/{userId}")
  List<Car> getCars(@PathVariable("userId") Integer userId);
}
