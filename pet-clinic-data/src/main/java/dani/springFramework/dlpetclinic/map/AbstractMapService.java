package dani.springFramework.dlpetclinic.map;

import dani.springFramework.dlpetclinic.model.BaseEntity;

import java.util.*;

public class AbstractMapService<T extends BaseEntity ,ID extends Long> {

protected Map<Long,T> map = new HashMap<>();

Set<T> findAll(){
    return new HashSet<>(map.values());
}

    T findById(ID id){
        return map.get(id);
    }
    T save(T object) {
    if(object!=null)
        if(object.getId() == null)
        {
            object.setId(getNextId());
        }
       return map.put(object.getId(),object);
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry->entry.getValue().equals(object) );
    }
    private Long getNextId()
    {
        Long nextId = null;
        try{
            nextId = Collections.max(map.keySet()) +1;
        }
        catch (NoSuchElementException e){
            nextId = 1L;
        }
return nextId;
    }
}
