package com.cloud.security.userservice.feignclients;

import com.cloud.security.userservice.model.Bike;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "bike-service", url = "http://localhost:8003/v1/bike")
public interface BikeFeingClient {

  @PostMapping()
  public Bike save(@RequestBody Bike bike);

  @GetMapping("/byUserId/{userId}")
  List<Bike> getBikes(@PathVariable("userId") Integer userId);
}
