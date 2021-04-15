package br.edu.utfpr.pb.mercadoEmCasa.service.impl;

import br.edu.utfpr.pb.mercadoEmCasa.model.Categoria;
import br.edu.utfpr.pb.mercadoEmCasa.repository.CategoriaRepository;
import br.edu.utfpr.pb.mercadoEmCasa.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl extends CrudServiceImpl<Categoria, Long>  implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	protected JpaRepository<Categoria, Long> getRepository() {
		return categoriaRepository;
	}

}
