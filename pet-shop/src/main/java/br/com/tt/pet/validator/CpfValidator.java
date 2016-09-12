package br.com.tt.pet.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.com.tt.util.CpfUtil;

@FacesValidator
public class CpfValidator implements Validator {

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		String cpf = (String) value;
		if (!CpfUtil.validaCPF(cpf)) {

			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("CPF Inválido");
			message.setDetail("CPF Inválido");
			throw new ValidatorException(message);
		}
	}
}
