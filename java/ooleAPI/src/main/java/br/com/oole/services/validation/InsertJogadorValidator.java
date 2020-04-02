package br.com.oole.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.oole.DAO.JogadorDAO;
import br.com.oole.dto.NewJogadorDTO;
import br.com.oole.models.Jogador;
import br.com.oole.resources.exceptions.FieldMessage;
import br.com.oole.services.validation.utils.BR;

public class InsertJogadorValidator implements ConstraintValidator<InsertJogador, NewJogadorDTO> {

	@Autowired
	private JogadorDAO dao;
	
	@Override
	public void initialize(InsertJogador ann) {
	}

	@Override
	public boolean isValid(NewJogadorDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		if (!BR.isValidCPF(objDto.getCpf())) {
			list.add(new FieldMessage("cpf", "CPF inválido"));
		}

		Jogador aux = dao.findByEmail(objDto.getEmail());
		System.out.println(aux.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		
		return list.isEmpty();
	}
}

