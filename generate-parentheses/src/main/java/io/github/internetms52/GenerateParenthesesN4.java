package io.github.internetms52;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParenthesesN4 {

    public List<String> generateParenthesis(int n) {
        return new ArrayList<>(generateParenthesisRecursively(n));
    }

    public Set<String> generateParenthesisRecursively(int n){
        Set<String> resultSet = new HashSet();
        if(n==1){
            resultSet = Set.of("()");
        }else if(n-1>0) {
            Set<String> reduceSet = generateParenthesisRecursively(n-1);
            for(String str:reduceSet){
                resultSet.add("()"+str);
                resultSet.add(str+"()");
                resultSet.add("("+str+")");
            }
            if(n>2){
                Set<String> reduceGroupSet = new HashSet();
                for(int i=2;i<n;i++){
                    Set<String> iSet = generateParenthesisRecursively(n-i);
                    for(int j=2;j<n;j++){
                        Set<String> jSet = generateParenthesisRecursively(n-j);
                        if(i+j==n){
                            for(String iStr:iSet){
                                for(String jStr:jSet){
                                    resultSet.add(iStr+jStr);
                                }
                            }
                        }
                    }
                }
            }
        }
        return resultSet;
    }
}
