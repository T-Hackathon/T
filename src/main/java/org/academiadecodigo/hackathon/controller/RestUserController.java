package org.academiadecodigo.hackathon.controller;

import org.academiadecodigo.hackathon.converters.*;
import org.academiadecodigo.hackathon.dto.DancerDto;
import org.academiadecodigo.hackathon.dto.VideoDto;
import org.academiadecodigo.hackathon.persistence.model.Dancer;
import org.academiadecodigo.hackathon.persistence.model.Video;
import org.academiadecodigo.hackathon.service.DancerService;
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

    private DancerService dancerService;
    private DancerDtoToUser dancerDtoToUser;
    private DancerToUserDto dancerToUserDto;
    private ChallengeDtoToChallenge challengeDtoToChallenge;
    private ChallengeToChallengeDto challengeToChallengeDto;
    private VideoDtoToVideo videoDtoToVideo;
    private VideoToVideoDto videoToVideoDto;

    @Autowired
    public void setChallengeDtoToChallenge(ChallengeDtoToChallenge challengeDtoToChallenge) {
        this.challengeDtoToChallenge = challengeDtoToChallenge;
    }

    @Autowired
    public void setChallengeToChallengeDto(ChallengeToChallengeDto challengeToChallengeDto) {
        this.challengeToChallengeDto = challengeToChallengeDto;
    }

    @Autowired
    public void setVideoDtoToVideo(VideoDtoToVideo videoDtoToVideo) {
        this.videoDtoToVideo = videoDtoToVideo;
    }

    @Autowired
    public void setVideoToVideoDto(VideoToVideoDto videoToVideoDto) {
        this.videoToVideoDto = videoToVideoDto;
    }

    @Autowired
    public void setUserService(DancerService dancerService) {
        this.dancerService = dancerService;
    }


    @Autowired
    public void setUserDtoToUser(DancerDtoToUser dancerDtoToUser) {
        this.dancerDtoToUser = dancerDtoToUser;
    }


    @Autowired
    public void setUserToUserDto(DancerToUserDto dancerToUserDto) {
        this.dancerToUserDto = dancerToUserDto;
    }


    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List<DancerDto>> listUsers() {

        List<DancerDto> dancerDtos = dancerService.list().stream()
                .map(user -> dancerToUserDto.convert(user))
                .collect(Collectors.toList());

        return new ResponseEntity<>(dancerDtos, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<DancerDto> showUser(@PathVariable Integer id) {

        Dancer Dancer = dancerService.get(id);

        if (Dancer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(dancerToUserDto.convert(Dancer), HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public ResponseEntity<?> addUser(@Valid @RequestBody DancerDto dancerDto, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {

        if (bindingResult.hasErrors() || dancerDto.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Dancer savedDancer = dancerService.save(dancerDtoToUser.convert(dancerDto));

        // get help from the framework building the path for the newly created resource
        UriComponents uriComponents = uriComponentsBuilder.path("/api/User/" + savedDancer.getId()).build();

        // set headers with the created path
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }


    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<DancerDto> editUser(@Valid @RequestBody DancerDto DancerDto, BindingResult bindingResult, @PathVariable Integer id) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (DancerDto.getId() != null && !DancerDto.getId().equals(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (dancerService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        DancerDto.setId(id);

        dancerService.save(dancerDtoToUser.convert(DancerDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}/video")
    public ResponseEntity<List<Video    >> videosFromUser(@PathVariable Integer id){
        Dancer dancer = dancerService.get(id);
        List<VideoDto> toReturn = dancer.getVideos().stream()
                    .map(video -> videoToVideoDto.convert(video))
                    .collect(Collectors.toList());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/{id}/video")
    public ResponseEntity<?> saveVideo(@RequestBody VideoDto videoDto, @PathVariable Integer id){
        Dancer dancer = dancerService.get(id);
        dancer.getVideos().add(videoDtoToVideo.convert(videoDto));
        dancerService.save(dancer);

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

