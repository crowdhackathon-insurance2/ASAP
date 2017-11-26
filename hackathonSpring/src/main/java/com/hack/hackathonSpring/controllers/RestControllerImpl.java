package com.hack.hackathonSpring.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hack.hackathonSpring.dao.Location;
import com.hack.hackathonSpring.dto.TestDataDto;
import com.hack.hackathonSpring.dto.TestDataSendDto;
import com.hack.hackathonSpring.wrappers.LocationWrapper;
import org.apache.commons.math3.ml.clustering.CentroidCluster;
import org.apache.commons.math3.ml.clustering.KMeansPlusPlusClusterer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class RestControllerImpl implements RestController {

    private static final Logger logger = LoggerFactory.getLogger(RestControllerImpl.class);

    @Override
    public HashMap<Long,List<TestDataSendDto>> getClusters() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        List<TestDataDto> testDataDtoList = mapper.readValue(new File("/Users/kechagiaskonstantinos/Downloads/sparkHackathon/testDataFormated.json"), new TypeReference<List<TestDataDto>>(){});
        List<Location> locationList = new ArrayList<Location>();
        for(TestDataDto temp : testDataDtoList){
            locationList.add(new Location(temp.getId(),temp.getLongtitude(),temp.getLatitude()));
        }

        List<LocationWrapper> clusterInput = new ArrayList<LocationWrapper>(locationList.size());
        for (Location location : locationList)
            clusterInput.add(new LocationWrapper(location));

        KMeansPlusPlusClusterer<LocationWrapper> clusterer = new KMeansPlusPlusClusterer<LocationWrapper>(2, 10000);
        List<CentroidCluster<LocationWrapper>> clusterResults = clusterer.cluster(clusterInput);

        HashMap<Long,List<TestDataSendDto>> listHashMap = new HashMap<Long,List<TestDataSendDto>>();
        // output the clusters
        for (int i=0; i<clusterResults.size(); i++) {
            List<TestDataSendDto> tempTestDataSendList = new ArrayList<TestDataSendDto>();
            System.out.println("Cluster " + i);
            for (LocationWrapper locationWrapper : clusterResults.get(i).getPoints()){
                System.out.println(locationWrapper.getLocation().getId());
                tempTestDataSendList.add(new TestDataSendDto(locationWrapper.getLocation().getId(),locationWrapper.getLocation().getX(),locationWrapper.getLocation().getY()));
            }
            listHashMap.put(new Long(i),tempTestDataSendList);
        }
        return listHashMap;
    }

    @Override
    public String addBenefit(String username) {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title>Ποντοι</title>\n" +
                "<style>\n" +
                ".center {\n" +
                "    padding: 70px 0;\n" +
                "    border: 3px solid green;\n" +
                "    text-align: center;\n" +
                "}" +
                "</style>" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<div class=\"center\">" +
                "<center><font size=\"10\"><u>Συνολικη Ποντοι Χρηστη:<br>- "  + username + " -</u></font></center>\n" +
                "<center><p><font size=\"8\">" + 550 + "<br><br><br>Εκπτωση στα ασφαλιστρα :<br><b>5.50$</b></p></font></center>\n" +
                "\n" +
                "</div>" +
                "</body>\n" +
                "</html>";
    }
}
