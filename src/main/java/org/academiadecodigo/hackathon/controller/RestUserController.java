package org.academiadecodigo.hackathon.controller;

import org.academiadecodigo.hackathon.converters.UserDtoToUser;
import org.academiadecodigo.hackathon.converters.UserToUserDto;
import org.academiadecodigo.hackathon.dto.UserDto;
import org.academiadecodigo.hackathon.persistence.model.User;
import org.academiadecodigo.hackathon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class RestUserController {

    private UserService userService;
    private UserDtoToUser userDtoToUser;
    private UserToUserDto userToUserDto;


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @Autowired
    public void setUserDtoToUser(UserDtoToUser userDtoToUser) {
        this.userDtoToUser = userDtoToUser;
    }


    @Autowired
    public void setUserToUserDto(UserToUserDto userToUserDto) {
        this.userToUserDto = userToUserDto;
    }


    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List<UserDto>> listUsers() {

        List<UserDto> userDtos = userService.list().stream()
                .map(user -> userToUserDto.convert(user))
                .collect(Collectors.toList());

        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<UserDto> showUser(@PathVariable Integer id) {

        User User = userService.get(id);

        if (User == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userToUserDto.convert(User), HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public ResponseEntity<?> addUser(@Valid @RequestBody UserDto userDto, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {

        if (bindingResult.hasErrors() || userDto.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User savedUser = userService.save(userDtoToUser.convert(userDto));

        // get help from the framework building the path for the newly created resource
        UriComponents uriComponents = uriComponentsBuilder.path("/api/User/" + savedUser.getId()).build();

        // set headers with the created path
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }


    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<UserDto> editUser(@Valid @RequestBody UserDto UserDto, BindingResult bindingResult, @PathVariable Integer id) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (UserDto.getId() != null && !UserDto.getId().equals(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (userService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        UserDto.setId(id);

        userService.save(userDtoToUser.convert(UserDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }


//    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
//    public ResponseEntity<UserDto> deleteUser(@PathVariable Integer id) {
//
//        try {
//
//            UserService.delete(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//
//        } catch (AssociationExistsException e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//
//        } catch (UserNotFoundException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}

