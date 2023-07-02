package com.cks.example.dto;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameCsvBean extends CsvBean {
    @CsvBindByName
    private String title;
    @CsvBindByName
    private String genre;
    @CsvBindByName
    private String developer;
    @CsvBindByName
    private String publisher;
    @CsvDate(value = "yyyy-MM-dd")
    @CsvBindByName
    private LocalDate releaseDate;
}
