# # Game of Life 

Game of Life Java 버전입니다. 시각화는 Consol로 표현됩니다.

## Usage
>$java -jar [lib_file] [property file] [generation]
>$java -jar cgol-0.2.2.jar
>$java -jar cgol-0.2.2.jar cgol.properties
>$java -jar cgol-0.2.2.jar cgol.properties 10

설정값이 없을 때 기본 board 크기는 80*40 이며 60 generation 까지 임의 셀이 설됩니다

# cgol.properties
- init.boardSize=20,30
> Board의 크기 [세로,가로]
- init.cells=9,11|10,9|10,10|11,10|11,11
> 활성화할  셀 좌표
- init.maxGenerations=4
> 반복할 회수(세대)
