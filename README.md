# :open_book: 알고리즘
## Java

- Sort
- BinarySearch
- BackTracking
- String
- Simulation
- DFS / BFS

## :mag_right: Programmers, BaekJoon

```
천천히 공부하자...
입력형태 주의...
```

## :trident: 주의사항
- LinkedHashMap : 순서 보장
- HashMap : 순서 보장 X
- 문자열 끝 : scanner.hasNextLine() 으로 검사
- 공백문자 split : \\s"" or " " ( 버퍼 문제 발생 시 BufferedReader 조립 )
- IOException -> BufferedRedaer bufferedReader = new BufferedReader(new InputStreamReader(System.in));
- String[] input = bufferedReader.readLine().split(" ");
- 탐색 시 visited를 boolean이 아닌 int로도 활용이 가능
- 다익스트라