package com.company.books.response.category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseRestCategory {

    private List<Map<String, String>> metaData = new ArrayList<>();

    public List<Map<String, String>> getMetaData() {
        return metaData;
    }

    public void setMetaData(String type, String code, String data) {
        Map<String, String> map = new HashMap<>();
        map.put("type", type);
        map.put("code", code);
        map.put("data", data);

        metaData.add(map);
    }
}
