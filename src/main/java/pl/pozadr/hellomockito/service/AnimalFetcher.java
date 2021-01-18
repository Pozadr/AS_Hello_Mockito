package pl.pozadr.hellomockito.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalFetcher {

    public List<String> getDataFromRemoteApi() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List> animalsList = restTemplate.exchange("http://localhost:9090/animals", HttpMethod.GET,
                HttpEntity.EMPTY, List.class);
        return animalsList.getBody();
    }

    public List<String> getSortedData() {
        List<String> dataList = getDataFromRemoteApi();
        return dataList.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
