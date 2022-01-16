package com.example.loginwithvue.controller;

import com.example.loginwithvue.controller.dto.MemberRequestDto;
import com.example.loginwithvue.controller.dto.MemberResponseDto;
import com.example.loginwithvue.controller.dto.TokenDto;
import com.example.loginwithvue.controller.dto.TokenRequestDto;
import com.example.loginwithvue.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


//회원가입 / 로그인 / 재발급 을 처리하는 API
//MemberRequestDto 에는 사용자가 로그인 시도한 ID / PW String 이 존재.
//TokenRequestDto 에는 재발급을 위한 AccessToken / RefreshToken String이 존재.
@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @RequestMapping(value = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST, headers = {"Accept=application/json"})
    public ResponseEntity<MemberResponseDto> signup(@RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.ok(authService.signup(memberRequestDto));
    }

    @RequestMapping(value = "/adminSignup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST, headers = {"Accept=application/json"})
    public ResponseEntity<MemberResponseDto> adminSignup(@RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.ok(authService.adminSignup(memberRequestDto));
    }

    @RequestMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE ,headers = {"Accept=application/json"})
    public ResponseEntity<TokenDto> login(@RequestBody MemberRequestDto memberRequestDto) {
        //log.info(">> json type :: tokenDto :: {}", tokenDto);
        return ResponseEntity.ok(authService.login(memberRequestDto));
    }

    @RequestMapping(value = "/reissue", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
    }
}
