package com.cks.example.controller;

import com.cks.example.dto.CsvBean;
import com.cks.example.dto.GameCsvBean;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@RestController
@RequestMapping("csv-file-upload")
public class FileUploadController {

    @GetMapping("ping")
    public ResponseEntity<String> pong() {
        return new ResponseEntity<>("pong", HttpStatus.OK);
    }

    @SneakyThrows
    @PostMapping(value = "game", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CsvBean>> handleFileUpload(@RequestParam(name = "gameCsvFile") MultipartFile gameCsvFile) {
        List<CsvBean> gameList;

        try (Reader reader = new InputStreamReader(gameCsvFile.getInputStream())) {
            CsvToBean<CsvBean> cb = new CsvToBeanBuilder<CsvBean>(reader)
                    .withType(GameCsvBean.class)
                    .build();

            gameList = cb.parse();
        }

        return new ResponseEntity<>(gameList, HttpStatus.OK);
    }
}
