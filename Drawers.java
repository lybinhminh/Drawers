import java.util.*;

public class Drawers <T1,T2>{
    List<T1> list = new ArrayList<>();
    Map<Integer, T2> map = new HashMap<>();
    public void put(T1 k , T2 v){
        int a;
        if(list.contains(k)){
            a = list.indexOf(k);
        }
        else{
            a = list.size();
            list.add(k);
        }
        map.put(a, v);
    }
    public T2 get(T1 k){
        if(list.contains(k)){
            return map.get(list.indexOf(k));
        }
        else{
            return null;
        }
    }
    public void clear(){
        list.clear();
        map.clear();
    }
    public boolean containsKey(T1 k){
        return list.contains(k);
    }
    public boolean containsValue(T2 v){
        return map.containsValue(v);
    }
    @SafeVarargs
    public final void remove(T1... keys){
        for(T1 k : keys){
            map.remove(list.indexOf(k));
        }
    }

    public void copyFrom(Drawers<T1, T2> another, boolean... replaceExists){
        for(int i = 0; i < another.list.size(); ++i){

            T1 a = another.list.get(i);
            if(replaceExists.length == 0 || (replaceExists[0] && !list.contains(a)))
            put(a, another.get(a));
        }
    }
}