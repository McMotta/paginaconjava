package com.example.pagina_status.service;

import com.example.pagina_status.interfaceService.ICotizacionStatusService;
import com.example.pagina_status.model.CotizacionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pagina_status.repository.RepositoryCotizacionStatus;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCotizacionStatus implements ICotizacionStatusService {

    @Autowired
    private RepositoryCotizacionStatus repositoryCotizacionStatus;

    @Override
    public List<CotizacionStatus> listar(){
        return (List<CotizacionStatus>) repositoryCotizacionStatus.findAll();
    }

    @Override
    public Optional<CotizacionStatus> listId(int id){
        return repositoryCotizacionStatus.findById(id);
    }

    @Override
    public int save(CotizacionStatus r){
        int res=0;
        CotizacionStatus cotizacionStatus = repositoryCotizacionStatus.save(r);
        if(!cotizacionStatus.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public void delete(int id){
        repositoryCotizacionStatus.deleteById(id);
    }
}
