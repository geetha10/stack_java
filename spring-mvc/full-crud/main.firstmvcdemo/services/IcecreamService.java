package com.heidichen.firstmvcdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.heidichen.firstmvcdemo.models.Icecream;
import com.heidichen.firstmvcdemo.repositories.IcecreamRepository;

@Service
public class IcecreamService {

	//OPTION 1
    private final IcecreamRepository icecreamRepo;
    
    public IcecreamService(IcecreamRepository icecreamRepo) {
        this.icecreamRepo = icecreamRepo;
    }
    
    //OPTION 2
//    @Autowired
//    private IcecreamRepository icecreamRepo;
    
    
    // FindAll
    public List<Icecream> allIcecreams(){
    	return icecreamRepo.findAll();
    }
        
    // create
    public Icecream createIcecream(Icecream icecream) {
    	return icecreamRepo.save(icecream);
    }
    
    
    // ShowOne
    public Icecream findIcecream(Long id) {
    	Optional<Icecream> optionalIcecream = icecreamRepo.findById(id);
    	if(optionalIcecream.isPresent()) {
    		return optionalIcecream.get();
    	}else {
    		return null;
    	}
    }
    
    
    // updateOne --- findOne + create

    public Icecream updateIcecream(Icecream icecream) {
    	return icecreamRepo.save(icecream);
    }
    
       
    // deleteOne
	public void deleteIcecream(Long id) {
		icecreamRepo.deleteById(id);
	}
}












