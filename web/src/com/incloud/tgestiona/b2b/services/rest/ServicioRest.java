package com.incloud.tgestiona.b2b.services.rest;

import com.incloud.tgestiona.b2b.model.Distrito;
import com.incloud.tgestiona.b2b.model.oferta.Servicio;
import com.incloud.tgestiona.b2b.repository.DistritoRepository;
import com.incloud.tgestiona.b2b.repository.OfertasRepository;
import com.incloud.tgestiona.b2b.serices.ServicioService;
import com.incloud.tgestiona.b2b.service.dto.BaseBandejaResponse;
import com.incloud.tgestiona.b2b.service.dto.distritoDto;
import com.incloud.tgestiona.framework.JPACustomRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.*;

@RestController
@RequestMapping("/api/servicio")
public class ServicioRest extends JPACustomRest<Servicio, Integer> {

    private final ServicioService sServ;

    public ServicioRest(ServicioService sServ) {
        this.sServ = sServ;
    }

    @Autowired
    private DistritoRepository dRepo;

    @GetMapping("/buscardistrito")
    public List<distritoDto> buscardistrito(@RequestParam(required = false) String search, Pageable pageable) {

        List<distritoDto> res =new ArrayList<>();
        List<Object[]> distritos = dRepo.buscarDistrito(search);
        for (Object[] obj : distritos ) {
            res.add(new distritoDto((Integer)obj[0],(Integer)obj[1],(Integer)obj[2],(String) obj[3]));
        }

        return res;
    }

    @PostMapping("/guardarlista")
    public int guardarlista(@RequestBody List<Servicio> servicioslist) {
        return 0;
    }
}
