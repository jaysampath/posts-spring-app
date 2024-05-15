package com.assignment.hypertest.app.PostApplication.web.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class TimeApiResponse {
    private Long unixtime;
    private String timezone;
    private String abbreviation;
    private String datetime;
    private String utcDatetime;
}
