package io.github.internetms52;

public class RomanToInt {
    int[] romanNums = new int[]{1, 5, 10, 50, 100, 500, 1000};
    char[] romanWords = new char[]{'I','V','X','L','C','D','M'};

    public int romanToInt(String s) {
        char[] sCharArray = s.toCharArray();
        int prevCIdx=-1;
        int result=0;
        for(int i=sCharArray.length-1;i>=0;i--){
            if(prevCIdx<0){
                if(i==0){
                    result+= romanNums[mapIdx(sCharArray[i])];
                }else{
                    prevCIdx = mapIdx(sCharArray[i]);
                }
            }else{
                int cIdx = mapIdx(sCharArray[i]);
                if(prevCIdx>cIdx){
                    //4 or 9
                    result+=romanNums[prevCIdx] - romanNums[cIdx];
                    prevCIdx=-1;
                }else{
                    if(i==0){
                        result+=romanNums[prevCIdx] + romanNums[cIdx];
                    }else{
                        result+=romanNums[prevCIdx];
                        prevCIdx=cIdx;
                    }
                }
            }
        }
        return result;
    }

    int mapIdx(char c){
        for(int i=0;i<romanWords.length;i++){
            if(c == romanWords[i]){
                return i;
            }
        }
        return -1;
    }
}
