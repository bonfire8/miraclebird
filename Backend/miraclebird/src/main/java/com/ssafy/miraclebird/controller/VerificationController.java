package com.ssafy.miraclebird.controller;

import com.ssafy.miraclebird.dto.VerificationDto;
import com.ssafy.miraclebird.service.VerificationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/verification")
@Api("챌린지 미션 관련 REST V1")
public class VerificationController {
    private final VerificationService verificationService;

    @Autowired
    public VerificationController(VerificationService verificationService) {
        this.verificationService = verificationService;
    }

    @ApiOperation(value = "모든 챌린지인증샷의 정보를 반환한다.", response = VerificationDto.class)
    @GetMapping("/")
    public ResponseEntity<List<VerificationDto>> getVerificationALL() {
        List<VerificationDto> result = verificationService.getVerificationALL();

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @ApiOperation(value = "특정 챌린지인증샷의 정보를 반환한다.", response = VerificationDto.class)
    @GetMapping("/{verification_idx}")
    public ResponseEntity<VerificationDto> getVerificationById(@PathVariable("verification_idx") Long verificationIdx) {
        VerificationDto result = verificationService.getVerificationById(verificationIdx);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @ApiOperation(value = "특정 챌린지 인증샷을 승인한다.", response = VerificationDto.class)
    @GetMapping("/approve/{verification_idx}")
    public ResponseEntity<VerificationDto> approveVerification(@PathVariable("verification_idx") Long verificationIdx) throws Exception {
        VerificationDto result = verificationService.approveVerification(verificationIdx, 1);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @ApiOperation(value = "특정 챌린지 인증샷을 거절한다.", response = VerificationDto.class)
    @GetMapping("/decline/{verification_idx}")
    public ResponseEntity<VerificationDto> declineVerification(@PathVariable("verification_idx") Long verificationIdx) throws Exception {
        VerificationDto result = verificationService.approveVerification(verificationIdx, 2);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @ApiOperation(value = "특정 챌린지 인증샷을 삭제한다.", response = VerificationDto.class)
    @DeleteMapping("/{verification_idx}")
    public ResponseEntity deleteVerificationInfo(@PathVariable("verification_idx") Long verificationIdx, @RequestParam("user_idx") Long userIdx) throws Exception {
        try {
            verificationService.deleteVerificationInfo(verificationIdx, userIdx);
        } catch (Exception e){
            throw new RuntimeException();
        }

        return new ResponseEntity<String>("verification delete success", HttpStatus.OK);
    }
}