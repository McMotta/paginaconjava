package com.example.pagina_status.interfaceService;

import com.example.pagina_status.model.CotizacionStatus;

import java.util.List;
import java.util.Optional;

public interface ICotizacionStatusService {
    public List<CotizacionStatus> listar();

    public Optional<CotizacionStatus> listId(int id);
    public int save (CotizacionStatus r);
    public void delete(int id);
}
