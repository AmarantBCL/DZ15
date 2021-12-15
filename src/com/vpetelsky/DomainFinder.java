package com.vpetelsky;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
2*) Есть документ со списком URL:
https://drive.google.com/open?id=1wVBKKxpTKvWwuCzqY1cVXCQZYCsdCXTl

Вывести топ 10 доменов которые встречаются чаще всего.
В документе могут встречаться пустые и недопустимые строки.

Например для URL m.youtube.com/watch?v=SHH_EMeRjGA
доменом будет m.youtube.com
*/
public class DomainFinder {

    private static final String PATH = "src/com/vpetelsky/URLs.txt";
    private static final Pattern PATTERN = Pattern.compile(
            "(?:[a-z0-9](?:[a-z0-9-]{0,61}[a-z0-9])?\\.)+[a-z0-9][a-z0-9-]{0,61}[a-z0-9]"
    );

    private List<String> domainList = new ArrayList<>();

    public DomainFinder() {
        readURLFile();
    }

    private void readURLFile() {
        File file = new File(PATH);
        if (file.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    Matcher matcher = PATTERN.matcher(line.trim());
                    if (matcher.find()) {
                        domainList.add(matcher.group());
                    }
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("The file doesn't exist.");
        }
    }

    private Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<>();
        for (String name : domainList) {
            if (map.containsKey(name)) {
                int count = map.get(name) + 1;
                map.put(name, count);
            } else {
                map.put(name, 1);
            }
        }

        return map;
    }
    
    public List<Domain> getDomainList() {
        List<Domain> list = new ArrayList<>();
        Map<String, Integer> map = createMap();
        for (String key : map.keySet()) {
            list.add(new Domain(key, map.get(key)));
        }
        Collections.sort(list, (d1, d2) -> d2.getCount() - d1.getCount());

        return list;
    }
}
