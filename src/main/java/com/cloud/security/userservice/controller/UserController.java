package com.cloud.security.userservice.controller;

import com.cloud.security.userservice.dto.UserDto;
import com.cloud.security.userservice.entity.User;
import com.cloud.security.userservice.mapper.UserMapper;
import com.cloud.security.userservice.model.Bike;
import com.cloud.security.userservice.model.Car;
import com.cloud.security.userservice.service.UserService;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/user")
public class UserController {

  private final UserService userService;

  private final UserMapper userMapper;

  public UserController(final UserService userService, final UserMapper userMapper) {
    this.userService = userService;
    this.userMapper = userMapper;
  }

  @GetMapping("/getList")
  public ResponseEntity<List<UserDto>> getListUser() {
    log.info("Llamando al metodo getListUser para buscar una lista de user");
    return ResponseEntity.ok(userMapper.toListDto(userService.getListAll()));
  }

  @GetMapping("/userId/{id}")
  public ResponseEntity<UserDto> getUserById(@PathVariable("id") Integer id) {
    log.info("Llamando al metodo getUserById para buscar un usuario por su ID");
    return ResponseEntity.ok(userMapper.toDto(userService.getUserById(id)));
  }

  @PostMapping
  public ResponseEntity<UserDto> save(@RequestBody User user) {
    log.info("Llamando al metodo save para guardar un usuario {} ", user);
    return ResponseEntity.ok(userMapper.toDto(userService.save(user)));
  }

  @GetMapping("/cars/{userId}")
  public ResponseEntity<List<Car>> getCars(@PathVariable("userId") Integer userId) {
    log.info("Llamando al metodo getCars para obtener los CARS del user {} ", userId);
    User user = userService.getUserById(userId);
    if (user == null) {
      return ResponseEntity.notFound().build();
    } else {
      return ResponseEntity.ok(userService.getCars(userId));
    }

  }

  @GetMapping("/bikes/{userId}")
  public ResponseEntity<List<Bike>> getBikes(@PathVariable("userId") Integer userId) {
    log.info("Llamando al metodo getBikes para obtener los BIKES del user {} ", userId);
    User user = userService.getUserById(userId);
    if (user == null) {
      return ResponseEntity.notFound().build();
    } else {
      return ResponseEntity.ok(userService.getBikes(userId));
    }

  }

  @PostMapping("/savecar/{userId}")
  public ResponseEntity<Car>saveCar(@PathVariable("userId") Integer userId,@RequestBody Car car){
    log.info("Llamando al metodo saveCar para  persistir un CAR con userId {} ", userId);
    return ResponseEntity.ok( userService.saveCar(userId,car));
  }

  @PostMapping("/savebike/{userId}")
  public ResponseEntity<Bike>saveBike(@PathVariable("userId") Integer userId,@RequestBody Bike bike){
    log.info("Llamando al metodo saveBike para  persistir un BIKE con userId {} ", userId);
    return ResponseEntity.ok( userService.saveBike(userId,bike));
  }

  @GetMapping("/getAll/{userId}")
    public ResponseEntity<Map<String, Object>>getAllVehicles(@PathVariable("userId") Integer userId){
    log.info("Llamando al metodo getAllVehicles para  obtener una lista BIKE y una lista de CARS con userId {} ", userId);
    return ResponseEntity.ok(userService.getUserAndVehicles(userId));
  }


}
