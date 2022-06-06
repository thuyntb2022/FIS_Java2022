package DAO;

import core.model.Detective;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DetectiveDao implements IDetective{
    List<Detective> detectiveList = new ArrayList<>();
    public DetectiveDao() {}

    @Override
    public void add(Detective detective) {
        this.detectiveList.add(detective);
    }

    @Override
    public Detective get(long id) {
        Optional<Detective> opt = this.detectiveList.stream().filter(
                item -> item.getId() == id ? true : false).findFirst();

        if(opt.isPresent())
            return opt.get();
        else
            return null;
    }

    @Override
    public List<Detective> getAll() {
        return this.detectiveList;
    }

    @Override
    public Detective update(Detective updatedDetective) {
        this.detectiveList.stream().filter(detective -> detective.getId() == updatedDetective.getId())
                .forEach(detective -> {
                    detective = updatedDetective ;
                    detective.setModifiedAt(java.time.LocalDateTime.now());
                });
        return null;
    }

    @Override
    public Detective remove(long id) {
        for(Detective detective: this.detectiveList){
            if(detective.getId() == id) {
                this.detectiveList.remove(detective);
                return detective;
            }
        }
        return null;
    }
}
