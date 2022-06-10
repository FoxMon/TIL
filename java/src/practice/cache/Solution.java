package practice.cache;

import java.util.LinkedList;

public class Solution {

    public static final int CACHE_HIT = 1;
    public static final int CACHE_MISS = 5;

    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) {
            return cities.length * CACHE_MISS;
        }

        LinkedList<String> cache = new LinkedList<>();
        int answer = 0;

        for(int i = 0; i < cities.length; i++) {
            String city = cities[i].toUpperCase();

            if(cache.remove(city)) {
                cache.addFirst(city);
                answer += CACHE_HIT;
            } else {
                int currentSize = cache.size();

                if(currentSize == cacheSize){
                    cache.pollLast();
                }

                cache.addFirst(city);
                answer += CACHE_MISS;
            }
        }

        return answer;
    }
}
