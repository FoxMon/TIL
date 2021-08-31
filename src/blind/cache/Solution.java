package blind.cache;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) {
            return cities.length * 5;
        }

        int answer = 0;
        List<String> cache = new ArrayList<>();

        for(int i = 0; i < cities.length; i++) {
            String city = cities[i].toUpperCase();

            if(cache.contains(city)) {
                cache.remove(city);
                cache.add(city);
                answer++;
            } else if(cache.size() < cacheSize) {
                cache.add(city);
                answer += 5;
            } else {
                if(cacheSize > 0) {
                    cache.remove(0);
                    cache.add(city);
                }

                answer += 5;
            }
        }

        return answer;
    }
}
